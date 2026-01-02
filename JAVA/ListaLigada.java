//  ListaLigada.java
//  Copyright (C) 2003 Rodolpho Iemini Atoji

//  This program is free software; you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation; either version 2 of the License, or
//  (at your option) any later version.

//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.

//  You should have received a copy of the GNU General Public License
//  along with this program; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

// **************************************************************
// **   MAC122 - Princípios de Desenvolvimento de Algoritmos   **
// **   IME-USP - Segundo Semestre de 2003                     **
// **   Turma 45 - Professor Carlos Eduardo Ferreira           **
// **                                                          **
// **   Exercício-Programa 4 -- Guerra em Pandópolis           **
// **   Arquivo:ListaLigada.java                               **
// **                                                          **
// **   Rodolpho Iemini Atoji          4894631                 **
// **                                                          **
// **   Data de entrega: 27/11/2003                            **
// **************************************************************

/**
 * Implementação de uma "lista ligada" composta de objetos do tipo 'Celula'.
 * Cada objeto do tipo 'Celula' pode guardar como informação qualquer tipo
 * de objeto.
 * Na inserção ordenada, caso a lista tenha diferentes tipos de objetos,
 * pode-se ter problemas.
 * 
 * @author Rodolpho Iemini Atoji
 * @version 0.7.1
 */
public class ListaLigada implements Cloneable {
    
    /**
     * Referências para a primeira e última célula da lista.
     */
    private Celula inicio;
    private Celula fim;
    
    /**
     * Inicializa os atributos de classe.
     */
    public ListaLigada() {
        inicio = null;
        fim = null;
    }
    
    /**
     * Clonador de lista ligada.
     * 
     * @return Lista ligada.
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    /**
     * Indica se a lista está ou não vazia.
     */
    public boolean listaVazia() {
        return (inicio == null);
    }
    
    /**
     * Devolve referência para primeira célula.
     * 
     * @return Referência para primeira célula da lista ligada.
     */
    public Celula devolveInicio() {
        return inicio;
    }
    
    /** 
     * Devolve referência para a última célula.
     * 
     * @return Referência para última célula da lista ligada.
     */
    public Celula devolveFinal() {
        return fim;
    }
    
    /**
     * "Limpa" a lista ligada.
     */
    public void limpaLista() {
        inicio = null;
        fim = null;
    }
    
    /**
     * Insere uma célula no início da lista, mudando a sua referência de
     * "próxima célula" para a célula inicial anterior.
     * 
     * @param cel Objeto a ser inserido no início da lista.
     */
    public void insereNoInicio(Celula cel) {
        if (listaVazia()) {
            inicio = cel;
            fim = inicio;
        }
        else {
            Celula inicioTemp = inicio;
            inicio = cel;
            inicio.mudaProxima(inicioTemp);;
        }
    }
    
    /**
     * Insere uma célula no final da lista, mudando a referência de
     * "próxima célula" da agora penúltima célula para a última.
     * 
     * @param cel Objeto a ser inserido no final da lista.
     */
    public void insereNoFinal(Celula cel) {
        if (listaVazia()) {
            inicio = cel;
            fim = inicio;
            cel.mudaProxima(null);
        }
        else {
            Celula nova = cel;
            cel.mudaProxima(null);
            fim.mudaProxima(nova);
            fim = nova;        
        }
    }
    
    /**
     * Insere ordenadamente uma célula contendo uma String.
     * 
     * @param cel Célula com a informação.
     */
    public void insereOrdenado(Celula cel) {
        if (listaVazia())
            insereNoInicio(cel);
        else if (contaElementos() == 1) {
            String infoCel = cel.devolveInfo();
            String infoInicio = inicio.devolveInfo();
            if (infoCel.compareToIgnoreCase(infoInicio) < 0)
                insereNoInicio(cel);
            else
                insereNoFinal(cel);
        }
        else {
            Celula antes = null;
            Celula atual = inicio;
            Celula prox = inicio.devolveProxima();
            String infoCel = cel.devolveInfo();
            String infoAtual = atual.devolveInfo();
            int comparacaoAtual = infoCel.compareToIgnoreCase(infoAtual);
            if (comparacaoAtual <= 0)
                insereNoInicio(cel);
            else {
                do {
                    antes = atual;
                    atual = prox;
                    prox = atual.devolveProxima();
                    infoAtual = atual.devolveInfo();
                    comparacaoAtual = infoCel.compareToIgnoreCase(infoAtual);
                } while (comparacaoAtual > 0 && prox != null);
                if (comparacaoAtual < 0) {
                    antes.mudaProxima(cel);
                    cel.mudaProxima(atual);
                }
                else
                    insereNoFinal(cel);
            }
        } 
    } // insereStringOrdem
    
    /** 
     * Devolve a penúltima célula da lista.
     * 
     * @return Referência para última célula da lista.
     */
    public Celula devolvePenultimaCelula() {
        if ((listaVazia()) || (inicio.devolveProxima() == null))
            return null;
        else {
            Celula ant = inicio;
            Celula prox = ant.devolveProxima();
            boolean penultimo = false;
            while (!penultimo) {
                if (prox.devolveProxima() == null)
                    penultimo = true;
                else {
                    ant = prox;
                    prox = ant.devolveProxima();
                }
            }
            return ant;
        }
    }
    
    /**
     * Retira uma célula do início da lista.
     * 
     * @return Extrai uma célula do começo da lista.
     */
    public Celula retiraComeco() {
        if (listaVazia())
            return null;
        else {
            Celula retirada = inicio;
            inicio = inicio.devolveProxima();
            return retirada;
        }
    }
    
    /** 
     * Retira um célula do final da lista, atualizando a referência de
     * "próxima célula da célula anterior para 'null'.
     * 
     * @return extrai uma célula do final da lista.
     */
    public Celula retiraFinal() {
        if (listaVazia())
            return null;
        else if (inicio.devolveProxima() == null) {
            Celula inicioTemp = inicio;
            inicio = null;
            fim = null;
            return inicioTemp;
        }
        else {
            Celula penultima = devolvePenultimaCelula();
            Celula fimTemp = fim;
            penultima.mudaProxima (null);
            fim = penultima;
            return fimTemp;
        }
    }
    
    /**
     * Retira uma célula do meio da lista, cuja informação confira com a
     * que se deseja remover.
     * Remove apenas a primeira célula com a ocorrência desejada.
     * 
     * @param info Informação para exclusão.
     */
    public boolean removeCelula(String info) {
        boolean validador = false;
        if (listaVazia())
            return false;
        else if (contaElementos() == 1) {
            if (inicio.devolveInfo().equalsIgnoreCase(info)) {
                limpaLista();
                return true;
            }
            else
                return false;
        }
        Celula anterior = inicio;
        if (anterior.devolveInfo().equalsIgnoreCase(info)) {
            retiraComeco();
            return true;
        }
        Celula atual = anterior.devolveProxima();
        while (!validador && atual != null) {
            if (atual.devolveInfo().equalsIgnoreCase(info)) {
                anterior.mudaProxima(atual.devolveProxima());
                validador = true;
            }
            else {
                anterior = atual;
                atual = anterior.devolveProxima();
            }
        }
        return validador;
    } // removeCelula
    
    /**
     * Procura uma Celula com determinado conteúdo na lista ligada.
     */
    public Celula procuraCelula(String info) {
        if (listaVazia())
            return null;
        Celula atual = inicio;
        long numElementos = contaElementos();
        for (int i = 0; i < numElementos; i++) {
            if (atual.devolveInfo().equalsIgnoreCase(info))
                return atual;
            atual = atual.devolveProxima();
        }
        return null;
    }
    
    /**
     * Joga para a saída padrão o conteúdo de cada uma das células da
     * lista, na ordem em que se encontram.
     */
    public void imprimeLista() {
        if (listaVazia())
            System.out.println ("A lista está vazia.");
        else {
            boolean fimDaLista = false;
            Celula at = inicio;
            while (!fimDaLista) {
                System.out.println(at.devolveInfo());
                if (at.devolveProxima() == null)
                    fimDaLista = true;
                else
                    at = at.devolveProxima();
            }
        }
    }
    
    /**
     * Conta o número de elementos da lista ligada.
     * 
     * @return Número de elementos da lista ligada.
     */
    public long contaElementos() {
        long numElementos = 1;
        if (listaVazia())
            return 0;
        else if (inicio.devolveProxima() == null)
            return numElementos;
        else {
            Celula ant = inicio;
            while (ant.devolveProxima() != null) {
                ant = ant.devolveProxima();
                numElementos++;
            }
        }
        return numElementos;
    }
    
}// class ListaLigada
