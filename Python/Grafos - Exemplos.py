graph = {'A': set(['B', 'C']),
         'B': set(['A', 'D', 'E']),
         'C': set(['A', 'F']),
         'D': set(['B']),
         'E': set(['B', 'F']),
         'F': set(['C', 'E'])}

# A implementação abaixo usa a estrutura de dados da pilha para construir e retornar um conjunto de vértices acessíveis 
# dentro do componente relacionado aos assuntos. Usando a sobrecarga do operador de subtração do Python para remover itens 
# de um conjunto, podemos adicionar apenas os vértices adjacentes não visitados.		 
def dfs(graph, start):
    visited, stack = set(), [start]
    while stack:
        vertex = stack.pop()
        if vertex not in visited:
            visited.add(vertex)
            stack.extend(graph[vertex] - visited)
    return visited

dfs(graph, 'A') # {'E', 'D', 'F', 'A', 'C', 'B'}

#A segunda implementação fornece a mesma funcionalidade que a primeira, no entanto, desta vez, estamos usando a forma 
#recursiva mais sucinta. Devido a um Python comum obtido com valores de parâmetro padrão sendo criados apenas uma vez, 
#somos obrigados a criar um novo conjunto visitado em cada invocação do usuário. Outro detalhe do idioma Python é que 
#as variáveis ​​de função são passadas por referência, resultando no conjunto mutable visitado que não precisa ser reatribuído 
#em cada chamada recursiva.
def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()
    visited.add(start)
    for next in graph[start] - visited:
        dfs(graph, next, visited)
    return visited

dfs(graph, 'C') # {'E', 'D', 'F', 'A', 'C', 'B'}

#Caminhos
#Podemos ajustar as duas implementações anteriores para retornar todos os caminhos possíveis entre um vértice de início e objetivo. 
#A implementação abaixo usa a estrutura de dados da pilha novamente para resolver o problema de forma iterativa, rende cada caminho 
#possível quando localizamos o objetivo. O uso de um gerador permite ao usuário apenas calcular a quantidade desejada de caminhos 
#alternativos
def dfs_paths(graph, start, goal):
    stack = [(start, [start])]
    while stack:
        (vertex, path) = stack.pop()
        for next in graph[vertex] - set(path):
            if next == goal:
                yield path + [next]
            else:
                stack.append((next, path + [next]))

list(dfs_paths(graph, 'A', 'F')) # [['A', 'C', 'F'], ['A', 'B', 'E', 'F']]

#A implementação abaixo usa a abordagem recursiva chamando a adição de "rendimento de PEP380 " para retornar os caminhos localizados 
#invocados. Infelizmente, a versão de Pygments instalada no servidor neste momento não inclui a combinação de palavras-chave atualizadas.
def dfs_paths(graph, start, goal, path=None):
    if path is None:
        path = [start]
    if start == goal:
        yield path
    for next in graph[start] - set(path):
        yield from dfs_paths(graph, next, goal, path + [next])

list(dfs_paths(graph, 'C', 'F')) # [['C', 'F'], ['C', 'A', 'B', 'E', 'F']]

#Breath-First Search
####################
#Um algoritmo alternativo chamado Breath-First search nos fornece a capacidade de retornar os mesmos resultados que o DFS, mas com a 
#garantia adicional para retornar primeiro o caminho mais curto. Este algoritmo é um pouco mais complicado de implementar de forma 
#recursiva, em vez disso, usando a estrutura de dados da fila, como tal, só documentarei a abordagem iterativa. As ações realizadas 
#por cada vértice explorado são as mesmas que a implementação em profundidade, no entanto, a substituição da pilha por uma fila 
#explorará a amplitude de uma profundidade de vértice antes de seguir em frente. Esse comportamento garante que o primeiro caminho 
#localizado seja um dos caminhos mais curtos presentes, com base no número de bordas sendo o fator de custo.

#Componente Conectado
#Semelhante à implementação iterativa do DFS, a única alteração necessária é remover o próximo item desde o início da estrutura da lista, 
#em vez das últimas pilhas.

def bfs(graph, start):
    visited, queue = set(), [start]
    while queue:
        vertex = queue.pop(0)
        if vertex not in visited:
            visited.add(vertex)
            queue.extend(graph[vertex] - visited)
    return visited

bfs(graph, 'A') # {'B', 'C', 'A', 'F', 'D', 'E'}

#Caminhos
#Esta implementação pode novamente ser alterada ligeiramente para, em vez disso, retornar todos os caminhos possíveis entre dois vértices, 
#sendo o primeiro de um dos caminhos mais curtos.
def bfs_paths(graph, start, goal):
    queue = [(start, [start])]
    while queue:
        (vertex, path) = queue.pop(0)
        for next in graph[vertex] - set(path):
            if next == goal:
                yield path + [next]
            else:
                queue.append((next, path + [next]))

list(bfs_paths(graph, 'A', 'F')) # [['A', 'C', 'F'], ['A', 'B', 'E', 'F']]

#Sabendo que o caminho mais curto será retornado primeiro do método do gerador de caminho BFS, podemos criar um método útil que simplesmente 
#retorna o caminho mais curto encontrado ou 'Nenhum' se nenhum caminho existir. À medida que estamos usando um gerador, isso em teoria deve 
#fornecer resultados de desempenho semelhantes, como apenas sair e retornar o primeiro caminho correspondente na implementação do BFS.
def shortest_path(graph, start, goal):
    try:
        return next(bfs_paths(graph, start, goal))
    except StopIteration:
        return None

shortest_path(graph, 'A', 'F') # ['A', 'C', 'F']


# Links
# http://eddmann.com/posts/depth-first-search-and-breadth-first-search-in-python/
# http://prorum.com/index.php/2414/implementar-extrair-informacoes-conectividade-aciclicidade
