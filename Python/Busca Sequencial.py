# Busca Sequencial
# http://www.viniciusviana.com/desenvolvimento/busca-sequencial-em-python-java/

'''A busca sequencial é uma busca clássica e geralmente é o primeiro algoritmo de busca apresentado aos estudantes de programação. 
   Uma das vantagens da busca sequencial é que ela pode ser implementada para buscar qualquer estrutura de dados e os dados não 
precisam estar sequencialmente ordenados.
   Caso você tenha dificuldade em entender o funcionamento da busca sequencial, imagine que você tem uma pilha de provas e você 
precisa descobrir sua nota na prova, mas as provas estão bagunçadas, geralmente para você ver sua nota, você iria olhando 
sequencialmente prova por prova até achar a sua prova. Com o algoritmo é a mesma coisa, varremos um vetor (array) de elementos e 
comparamos se o elemento é o mesmo que procuramos, realizamos tal tarefa até o final do vetor.'''

def busca_sequencial(lista, busca):
    for i in lista:
        if i == int(busca):
            return True
    return False


while True:
    valor_ini = raw_input("Qual o valor inicial do vetor:")
    valor_fin = raw_input("Qual o valor final do vetor:")
    numeros = range(int(valor_ini), int(valor_fin) + 1)  # aqui definimos nossa lista de valores
    valor_busca = raw_input("Qual o valor que você quer buscar no vetor:")
    if busca_sequencial(numeros, valor_busca):
        print ("O valor", valor_busca, " foi encontrado.")
    else:
        print ("O valor", valor_busca, " não foi encontrado.")