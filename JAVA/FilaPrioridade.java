//  FilaPrioridade.java
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
// **   Arquivo:FilaPrioridade.java                            **
// **                                                          **
// **   Rodolpho Iemini Atoji          4894631                 **
// **                                                          **
// **   Data de entrega: 27/11/2003                            **
// **************************************************************

import java.util.NoSuchElementException;

/**
 * Implementação de uma fila de prioridade.
 * Objetos a serem enfileirados devem implementar InformacaoPrioridade.
 * A prioridade é dada inversamente, quanto menor o valor de 
 * devolvePrioridade(), maior será a prioridade do objeto em questão.
 * 
 * @see InformacaoPrioridade
 * @author Rodolpho Iemini Atoji
 */
public class FilaPrioridade {
    private int numElementos;
    private InformacaoPrioridade[] heap;
    
    /**
     * Constrói uma nova fila de prioridade com o tamanho especificado.
     * 
     * @param tamanho Tamanho da fila de prioridade.
     */
    public FilaPrioridade(int tamanho) {
        numElementos = 0;
        heap = new InformacaoPrioridade[tamanho];
    }
    
    /**
     * Indicador de fila vazia.
     * 
     * @return Indicador de fila vazia.
     */
    public boolean filaVazia() {
        return numElementos == 0;
    }
    
    /**
     * Indicador de tamanho da fila.
     * 
     * @return Tamanho da fila.
     */
    public int devolveTamanho() {
        return numElementos;
    }
    
    /**
     * Insere um elemento na fila, sob a forma de heap.
     * 
     * @param elemento Elemento a ser inserido.
     */
    public void insere(InformacaoPrioridade elemento) {
        int pai;
        int filho = numElementos++;
        while (filho > 0 && 
               (heap[pai = (filho - 1) / 2].devolvePrioridade() >
                elemento.devolvePrioridade())) {
            heap[filho] = heap[pai];
            filho = pai;
        }
        heap[filho] = elemento;    
    }
    
    /**
     * Remove e devolve o elemento de maior prioridade da fila.
     * 
     * @return Elemento de maior prioridade.
     */
    public InformacaoPrioridade remove() {
        if (numElementos == 0)
            throw new NoSuchElementException();
        InformacaoPrioridade removido = heap[0];
        InformacaoPrioridade ultimo = heap[--numElementos];
        int filho;
        int pai = 0;
        while ((filho = (2 * pai) + 1) < numElementos) {
            if (filho + 1 < numElementos &&
                (heap[filho].devolvePrioridade() > 
                 heap[filho + 1].devolvePrioridade()))
                filho++;
            if (ultimo.devolvePrioridade() > heap[filho].devolvePrioridade()) {
                heap[pai] = heap[filho];
                pai = filho;
            } else
                break;                
        }
        heap[pai] = ultimo;
        return removido;
    }
    
    /**
     * Procura um elemento e o devolve.
     * 
     * @param elemento Nome do elemento a ser procurado.
     * @return Elemento procurado.
     */
    public InformacaoPrioridade procura(String elemento) {
        for (int i = 0; i < heap.length; i++) {
            if (heap[i] != null) {
                if (heap[i].devolveInfo().equalsIgnoreCase(elemento))
                    return heap[i];
            }
        }
        return null;
    }
    
    /**
     * Imprime uma representação linear do heap.
     */
    public void imprimeHeap() {
        if (filaVazia())
            return;
        for (int j = numElementos, i = 0; j > 0; j--, i++)
            System.out.print(heap[i].devolveInfo() +" ");
        System.out.println();
    }
    
} // class FilaPrioridade
