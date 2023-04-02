#!/usr/bin/env python
# -*- coding: utf-8 -*-

class Estado():
    """
        Representa um estado dentro de uma árvore de estados para resolver o problema de
        atravessar missionários e canibais para a outra margem do rio.
        Um estado contém a quantinade de missionários à esquerda do rio (missionarios_esq),
        a quantidade de missionarios à direita do rio (missionarios_dir), a quantidade de
        canibais à esquerda do rio (canibais_esq), a quantidade de canibais a direita do
        rio (canibais_dir), o lado do rio (lado_rio), seu pai (pai) e seus filhos (filhos).
        Um estado pode ser válido ou não, assim como pode ser a solução do problema ou não.
    """

    def __init__(self, missionarios_esq, missionarios_dir, canibais_esq, canibais_dir, lado_rio):
        """
            Inicializa um estado com as informações de quantidade de missionários e canibais de
            cada lado do rio, além da informação de em que lado do rio está o barco.
        """
        self.missionarios_esq = missionarios_esq
        self.missionarios_dir = missionarios_dir
        self.canibais_esq = canibais_esq
        self.canibais_dir = canibais_dir
        self.lado_rio = lado_rio
        self.pai = None
        self.filhos = []

    def __str__(self):
        """
            Define a representação em string de um estado.
        """
        return 'Missionarios: {}\t| Missionarios: {}\nCanibais: {}\t| Canibais: {}'.format(
            self.missionarios_esq, self.missionarios_dir, self.canibais_esq, self.canibais_dir
        )

    def estado_valido(self):
        """
            Verifica se o estado é válido, ou seja, não possue mais canibais que missionários
            em nenhum lado do rio.
        """
        # Não se pode gerar estados onde o número de canibais ou missionários em qualquer lado
        # do rio seja negativo
        if ((self.missionarios_esq < 0) or (self.missionarios_dir < 0)
            or (self.canibais_esq < 0) or (self.canibais_dir < 0)):
            return False
        # Verifica se em ambas as margens do rio o número de missionários não é inferior ao número
        # de canibais. Lembrando que caso não hajam missionários em um dos lados, não é necessário
        # verificar o número de canibais nele.
        return ((self.missionarios_esq == 0 or self.missionarios_esq >= self.canibais_esq) and
                (self.missionarios_dir == 0 or self.missionarios_dir >= self.canibais_dir))


    def estado_final(self):
        """
            Verifica se o estado é um estado final, ou seja, é uma das possíveis soluções do
            problema.
        """
        # Um estado é um estado final se todos os missionários e canibais atravessaram o rio
        resultado_esq = self.missionarios_esq == self.canibais_esq == 0
        resultado_dir = self.missionarios_dir == self.canibais_dir == 3
        return resultado_esq and resultado_dir

    def gerar_filhos(self):
        """
            Gera todos os possíveis filhos de um estado, se este for um estado válido e não
            for um estado final.
        """
        # Encontra o novo lado do rio
        novo_lado_rio = 'dir' if self.lado_rio == 'esq' else 'esq'
        # Gera a lista de possíveis movimentos
        movimentos = [
            {'missionarios': 2, 'canibais': 0},
            {'missionarios': 1, 'canibais': 0},
            {'missionarios': 1, 'canibais': 1},
            {'missionarios': 0, 'canibais': 1},
            {'missionarios': 0, 'canibais': 2},
        ]
        # Gera todos os possíveis estados e armazena apenas os válidos na lista de filhos
        # do estado atual
        for movimento in movimentos:
            if self.lado_rio == 'esq':
                # Se o barco estiver a esquerda do rio, os missionários e canibais saem da
                # margem esquerda do rio e vão para a direita
                missionarios_esq = self.missionarios_esq - movimento['missionarios']
                missionarios_dir = self.missionarios_dir + movimento['missionarios']
                canibais_esq = self.canibais_esq - movimento['canibais']
                canibais_dir = self.canibais_dir + movimento['canibais']
            else:
                # Caso contrário, os missionários e canibais saem da margem direita do rio
                # e vão para a esquerda
                missionarios_dir = self.missionarios_dir - movimento['missionarios']
                missionarios_esq = self.missionarios_esq + movimento['missionarios']
                canibais_dir = self.canibais_dir - movimento['canibais']
                canibais_esq = self.canibais_esq + movimento['canibais']
            # Cria o estado do filho e caso este seja válido, o adiciona à lista de filhos do pai
            filho = Estado(missionarios_esq, missionarios_dir, canibais_esq,
                           canibais_dir, novo_lado_rio)
            filho.pai = self
            if filho.estado_valido():
                self.filhos.append(filho)


class Missionarios_Canibais():
    """
        Resolve o problema dos missionários e canibais, gerando para isso uma árvore de estados.
    """

    def __init__(self):
        """
            Inicializa uma instância do problema com uma raiz pré-definida e ainda sem solução.
        """
        # Insere a raiz na fila de execução, que será utilizada para fazer uma busca em largura
        self.fila_execucao = [Estado(3, 0, 3, 0, 'esq')]
        self.solucao = None

    def gerar_solucao(self):
        """
            Encontra a solução gerando uma árvore de estados a ser percorrida com o algoritmo de
            busca em largura, que utiliza uma fila em sua execução.
        """
        # Realiza a busca em largura em busca da solução
        for elemento in self.fila_execucao:
            if elemento.estado_final():
                # Se a solução foi encontrada, o caminho que compõe a solução é gerado realizando
                # o caminho de volta até a raiz da árvore de estados e então encerra a busca
                self.solucao = [elemento]
                while elemento.pai:
                    self.solucao.insert(0, elemento.pai)
                    elemento = elemento.pai
                break;
            # Caso o elemento não seja a solução, gera seus filhos e os adiciona na fila de execução
            elemento.gerar_filhos()
            self.fila_execucao.extend(elemento.filhos)


def main():
    # Instancia o problema e gera sua solução
    problema = Missionarios_Canibais()
    problema.gerar_solucao()
    # Exibe a solução em tela, separando cada passo
    for estado in problema.solucao:
        print estado
        print 34 * '-'

if __name__ == '__main__':
    main()