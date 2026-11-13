<div align="center">

# 🧩 Algoritmos e Estruturas de Dados
### Entender o problema. Construir a solução. Analisar o resultado.

**Uma coleção para estudar programação, comparar abordagens e desenvolver raciocínio computacional.**

**Java · Python · PHP · Machine Learning com Python e R**

[Explore a coleção](#explore-a-coleção) · [Catálogo por assunto](#catálogo-por-assunto) · [Trilha de estudo](#trilha-de-estudo-sugerida) · [Como executar](#como-explorar-e-executar) · [Livros e curso](#livros-artigos-e-curso)

</div>

---

## O que é um algoritmo?

Um **algoritmo** é uma sequência finita de instruções bem definidas para resolver um problema ou realizar uma tarefa.

Estudar algoritmos envolve mais do que chegar a uma saída: é compreender **por que uma solução funciona**, quais entradas ela aceita e como seu consumo de tempo e memória cresce com o tamanho do problema.

Este repositório reúne códigos auxiliares, exercícios e materiais de diferentes épocas para apoiar esse aprendizado — dos fundamentos da programação a estruturas de dados, grafos e aplicações de aprendizado de máquina.

## Explore a coleção

| Área | Conteúdo | Acesso |
| --- | --- | --- |
| **Java** | Algoritmos, estruturas de dados, orientação a objetos, interfaces gráficas e exemplos de integração com banco de dados. | [Abrir JAVA](JAVA/) |
| **Python** | Busca, ordenação, árvores, grafos, programação dinâmica, manipulação de strings e exercícios. | [Abrir Python](Python/) |
| **PHP** | Algoritmos, recursão, estruturas de dados, orientação a objetos e problemas de programação. | [Abrir PHP](PHP/) |
| **Machine Learning** | Scripts, notebooks, bases de exemplo e estudos em Python e R. | [Abrir Machine Learning](Machine%20Learning/) |

**Escolha por objetivo:** para praticar uma estrutura ou técnica, consulte o catálogo abaixo. Para estudar uma linguagem, comece pela pasta correspondente. Para explorar dados e modelos, siga para Machine Learning.

## Catálogo por assunto

Os links apontam para exemplos e pastas existentes. A seleção serve como porta de entrada; há outras implementações e variações na coleção.

### 🔢 Ordenação e busca

| Tema | Exemplos para explorar |
| --- | --- |
| **Bubble Sort** | [Python](Python/bubble_sort.py) · [PHP](PHP/bubble_sort.php) |
| **Insertion Sort** | [Python](Python/insertion_sort.py) |
| **Selection Sort** | [Python](Python/selection_sort.py) · [PHP](PHP/selection_sort.php) |
| **Merge Sort** | [Python](Python/merge_sort.py) · [PHP](PHP/merge_sort.php) |
| **Quick Sort** | [Python](Python/quicksort.py) · [PHP](PHP/quick_sort.php) |
| **Counting e Radix Sort** | [Counting Sort em Python](Python/sort/counting_sort/) · [Radix Sort em Python](Python/radixsort.py) |
| **Busca binária** | [Java](JAVA/BinarySearch.java) · [Python](Python/BinarySearch.py) |
| **Busca sequencial** | [Python](Python/Busca%20Sequencial.py) |

Para ampliar a comparação: [ordenação em Python](Python/sort/) e [ordenação em PHP](PHP/sorting/).

### 🌳 Estruturas de dados

| Tema | Exemplos para explorar |
| --- | --- |
| **Listas encadeadas** | [Python](Python/data_structures/lists/) · [PHP](PHP/linked_lists/) |
| **Pilhas e filas** | [Python](Python/stack_queues/) · [PHP](PHP/stacks_and_queues/) |
| **Árvores** | [Árvores em Python](Python/data_structures/trees/) · [Árvore binária em Java](JAVA/BinaryTree.java) |
| **Heaps** | [Python](Python/data_structures/heaps/) · [Heap máximo em Java](JAVA/BinaryMaxHeap.java) |
| **Tabelas hash** | [Python](Python/data_structures/hashes/) |
| **Representação de grafos** | [Python](Python/data_structures/graphs/) · [Lista de adjacência em Java](JAVA/AdjacencyList.java) |

### 🕸️ Grafos e caminhos

| Tema | Exemplos para explorar |
| --- | --- |
| **Busca em largura — BFS** | [Python](Python/breadth_first_search.py) |
| **Busca em profundidade — DFS** | [Python](Python/depth_first_search.py) |
| **Caminhos mínimos — Dijkstra** | [Python](Python/dijkstra.py) |
| **Árvore geradora mínima — Kruskal** | [Python](Python/kruskal.py) |
| **Árvore geradora mínima — Prim** | [Python](Python/prim.py) |
| **Ordenação topológica** | [Python](Python/topological_sort.py) |

Ao comparar algoritmos de grafos, confira as hipóteses: grafo dirigido ou não dirigido, existência de pesos e restrições sobre os valores das arestas.

### 🧠 Recursão, programação dinâmica e resolução de problemas

| Tema | Exemplos para explorar |
| --- | --- |
| **Fibonacci** | [Programação dinâmica em Python](Python/dynamic_programming/fibonacci.py) |
| **Problema da mochila — Knapsack** | [Python](Python/knapsack.py) |
| **Subsequência comum — LCS** | [Python](Python/lcs.py) · [PHP](PHP/longest_common_subsequence.php) |
| **Corte de barras** | [Python](Python/dynamic_programming/rod_cutting.py) |
| **Distância de edição** | [Python](Python/dynamic_programming/edit_distance.py) |
| **Torre de Hanói** | [Python](Python/tower_of_hanoi.py) · [PHP](PHP/tower_of_hanoi.php) |
| **Oito rainhas** | [PHP](PHP/eight_queens.php) |

### 🔤 Strings, números e codificação

| Tema | Exemplos para explorar |
| --- | --- |
| **Busca de padrões — Rabin-Karp** | [Python](Python/rabin_karp_search.py) |
| **Codificação de Huffman** | [Python](Python/huffman_code.py) |
| **Anagramas** | [Python](Python/is_anagram.py) |
| **Primalidade** | [Python](Python/is_prime.py) |
| **Máximo divisor comum — Euclides** | [Java](JAVA/Alg.%20de%20Euclides/MDC.java) |
| **Multiplicação de matrizes** | [Python](Python/matrix_multiplication.py) |

## 🤖 Dados e Machine Learning

A pasta [Machine Learning](Machine%20Learning/) reúne uma frente complementar aos algoritmos clássicos:

| Conteúdo | Onde explorar |
| --- | --- |
| **Notebooks e scripts Python** | [Machine Learning/Python](Machine%20Learning/Python/) |
| **Exemplos em R** | [Machine Learning/R](Machine%20Learning/R/) |
| **Bases para os estudos** | [Machine Learning/Data](Machine%20Learning/Data/) |
| **Visão geral do material** | [README de Machine Learning](Machine%20Learning/README.md) |
| **Minimax e jogo da velha** | [Projeto e documentação](Machine%20Learning/Python/Algoritmo%20Minimax%20-%20Jogo%20da%20Velha/README.md) |

As dependências e os caminhos de dados variam entre exemplos. Leia as importações e a documentação de cada estudo antes de executá-lo.

[Leitura: o que é Machine Learning?](https://medium.com/blog-do-zouza/o-que-%C3%A9-machine-learning-5e7e98453985)

## Trilha de estudo sugerida

| Etapa | Foque em | Prática sugerida |
| --- | --- | --- |
| **1. Fundamentos** | Variáveis, decisões, laços e funções. | Explique a entrada e a saída de um programa curto. |
| **2. Coleções e strings** | Listas, arrays, índices e manipulação de texto. | Teste entradas vazias, repetidas e com um único elemento. |
| **3. Busca e ordenação** | Pré-condições, comparações e movimentações. | Compare duas soluções para a mesma entrada. |
| **4. Estruturas de dados** | Pilhas, filas, listas, árvores e hashes. | Observe como cada estrutura representa e altera seus dados. |
| **5. Grafos** | Vértices, arestas, percursos e caminhos. | Desenhe um grafo pequeno e acompanhe a execução. |
| **6. Estratégias** | Recursão, divisão e conquista e programação dinâmica. | Identifique subproblemas e trabalho repetido. |
| **7. Aplicações em dados** | Preparação, modelos e avaliação. | Explore um estudo de Machine Learning e suas limitações. |

A trilha é uma sugestão de navegação, não uma ordem obrigatória dos arquivos.

## Como explorar e executar

### 1. Obtenha os materiais

Você pode navegar pelos arquivos no GitHub, baixar um exemplo ou clonar o repositório:

```bash
git clone https://github.com/aasouzaconsult/Algoritmos.git
cd Algoritmos
```

### 2. Confira o contexto do arquivo

A coleção reúne exemplos independentes, não uma aplicação única. Antes de executar:

- Verifique a versão da linguagem, as importações e os arquivos auxiliares.
- Confira se há um ponto de entrada ou se o arquivo apenas define classes e funções.
- Leia os comentários, exemplos de uso e créditos.
- Identifique caminhos de dados, entradas esperadas e dependências externas.

**Python:** existem arquivos com sintaxe de Python 2, como `print valor` e `xrange`. Eles precisam de revisão para uso com Python 3; não basta trocar o comando de execução. Confirme também divisões inteiras, imports e APIs de bibliotecas.

**Java:** há classes auxiliares, exemplos gráficos e arquivos com dependências entre si. Confira a correspondência entre nome da classe e arquivo, os pacotes e a codificação. Projetos com Swing/AWT exigem interface gráfica.

**PHP:** alguns exemplos são scripts de terminal; outros fazem parte de conjuntos de classes. Verifique inclusões e versão antes de executar.

### 3. Comece com um exemplo pequeno

**PHP — Bubble Sort**, a partir da raiz do repositório:

```bash
php PHP/bubble_sort.php
```

Esse arquivo inclui duas listas de entrada e imprime os resultados da ordenação.

**Java — algoritmo de Euclides**, com JDK instalado:

```bash
cd "JAVA/Alg. de Euclides"
javac MDC.java
java MDC 48 18
```

Para essa entrada, o resultado esperado é **6**.

Os comandos acima se baseiam nos arquivos consultados. A coleção completa não foi executada ou validada nesta revisão do README.

## Como estudar uma implementação

Use estas perguntas para transformar a leitura do código em aprendizado:

1. **Qual problema resolve?** Identifique entrada, saída e pré-condições.
2. **Por que funciona?** Acompanhe as variáveis e os estados intermediários.
3. **Quais casos exigem atenção?** Explore ausência do elemento, valores repetidos, limites e entradas vazias.
4. **Quanto custa?** Analise tempo e memória em função do tamanho da entrada.
5. **Que alternativa existe?** Compare clareza, restrições e desempenho com outra abordagem.

A complexidade depende da implementação e do caso analisado. Por exemplo, uma versão de Bubble Sort que encerra ao não realizar trocas pode ter comportamento diferente de uma versão que sempre percorre todos os passos.

## Livros, artigos e curso

| Recurso | Para que consultar |
| --- | --- |
| [**O que é Algoritmo? — artigo**](https://blogdozouza.wordpress.com/2019/05/31/o-que-e-algoritmo/) | Introdução ao conceito e ao raciocínio algorítmico. |
| [**Algoritmos — Teoria e Prática**](https://www.amazon.com.br/Algoritmos-Teoria-Pr%C3%A1tica-Thomas-Cormen/dp/8535236996) | Projeto e análise de algoritmos. |
| [**Código Limpo**](https://www.amazon.com.br/C%C3%B3digo-limpo-Robert-C-Martin/dp/8576082675/) | Legibilidade e organização do código. |
| [**O Codificador Limpo**](https://www.amazon.com.br/codificador-limpo-conduta-programadores-profissionais/dp/8576086476/) | Práticas e postura profissional. |
| [**Curso introdutório de algoritmos — Curso em Vídeo**](https://www.youtube.com/watch?v=8mei6uVttho&list=PLHz_AreHm4dmSj0MHol_aoNYCSGFqvfXV) | Apoio aos primeiros passos. |

Para consultar a linguagem: [Python](https://docs.python.org/3/tutorial/) · [Java](https://dev.java/learn/) · [PHP](https://www.php.net/manual/pt_BR/).

## Contribuições e créditos

Encontrou um erro, uma oportunidade de explicar melhor um algoritmo ou uma incompatibilidade? Abra uma **issue** ou envie um **pull request** com o caminho do arquivo e uma descrição objetiva.

Ao propor uma alteração, informe a versão da linguagem e inclua uma entrada com o resultado esperado. Preserve as referências e os créditos existentes nos códigos e diferencie uma correção de uma nova implementação.

---

**Alex Souza — liderança em dados e professor**

[Portfólio](https://omestredosdados.com.br/portfolio) · [Telegram — Mestre dos Dados](https://t.me/mestredosdados) · [YouTube](https://www.youtube.com/@alexsouzamsc) · [Blog](https://medium.com/blog-do-zouza) · [LinkedIn](https://www.linkedin.com/in/alex-souza/) · [Instagram](https://www.instagram.com/alexsouzamsc/)
