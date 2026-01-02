//  TabelaHash.java
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
// **   Arquivo:TabelaHash.java                                **
// **                                                          **
// **   Rodolpho Iemini Atoji          4894631                 **
// **                                                          **
// **   Data de entrega: 27/11/2003                            **
// **************************************************************

/**
 * Implementação de uma tabela de hash, com função de hash simples e usual:
 * H (Código de Hash) = (Código de Hash) % (Tamanho do Array).
 * 
 * @author Rodolpho Iemini Atoji
 * @version 0.3.2
 */
public class TabelaHash implements Cloneable {
    private ListaLigada[] tabela;
    public final int tamanho;
    
    /**
     * Define uma tabela de hash de tamanho fixo.
     * Por prudência, sempre utilizar aqui tamanhos primos a fim de se obter uma
     * distribuição mais uniforme dos dados pela tabela de hash.
     * O array de acesso direto é inicializado com objetos 'ListaLigada' a fim
     * de se evitar exceções de NullPointer.
     * 
     * @param t Tamanho da tabela de hash.
     * @see ListaLigada
     */
    public TabelaHash(int t) {
        tamanho = t;
        tabela = new ListaLigada[tamanho];
        for (int i = 0; i < tabela.length; i++)
            tabela[i] = new ListaLigada();
    }
    
    /**
     * Clona a tabela de hash.
     * 
     * @return Tabela de hash clonada.
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    /**
     * Insere um objeto na tabela de hash.
     * O valor para hashing é fornecido pelo objeto em questão.
     * 
     * @param e Objeto a ser inserido.
     */
    public void insereElemento(Celula e) {
        int codigoHash = e.devolveInformacao().devolveCodigoHash();
        int i = codigoHash % tamanho;
        tabela[i].insereOrdenado(e);
    }
    
    /**
     * Realiza uma busca na tabela de hash, com base na informação
     * principal da Celula.
     * 
     * @param info Informação a ser buscada.
     * @return Objeto com as características procuradas.
     */
    public Celula procuraElemento(String info) {
        if (info == null)
            return null;
        Celula atual;
        int i = devolveCodigoHash(info.toUpperCase()) % tamanho;
        int tamanhoTemp = 0;
        if (!tabela[i].listaVazia()) {
            atual = tabela[i].devolveInicio();
            tamanhoTemp = (int)tabela[i].contaElementos();
            for (int j = 0; j < tamanhoTemp; j++) {
                if (atual.devolveInfo().equalsIgnoreCase(info))
                    return atual;
                atual = atual.devolveProxima();
            }
        }      
        return null;
    }
    
    /**
     * Remove um elemento da tabela de hash.
     * 
     * @param elemento Elemento a ser removido.
     */
    public boolean removeElemento(Celula elemento) {
        if (elemento == null)
            return false;
        int pos = elemento.devolveInformacao().devolveCodigoHash() % tamanho;
        boolean removido = tabela[pos].removeCelula(elemento.devolveInfo());
        if (removido)
            return true;
        return false;
    }
    
    /**
     * Devolve a primeira Celula da tabela de hash.
     * 
     * @return Primeira Celula da tabela de hash.
     */
    public Celula devolvePrimeiraCelula() {
        for (int i = 0; i < tabela.length; i++) {
            if (!tabela[i].listaVazia()) {
                return tabela[i].devolveInicio();
            }
        }
        return null;
    }
    
    /**
     * Devolve a primeira Celula de determinada posição da tabela de hash.
     * 
     * @param posicao Posição do array de hash a ser pesquisada.
     * @return Primeira Celula da posição.
     */
    public Celula elementoNaPosicao(int posicao) {
        if (posicao >= tabela.length)
            return null;
        Celula inicio = tabela[posicao].devolveInicio();
        return inicio;
    }
    
    /**
     * Recupera um código de hashing para um atributo significante de um
     * objeto.
     */
    public int devolveCodigoHash(String info) {
        int soma = 0;
        int valorCaractere = 0;
        for (int i = 0; i < info.length(); i++) {
            valorCaractere = info.charAt(i);
            soma += valorCaractere;
        }
        return soma;
    } 
    
    /**
     * Imprime a tabela de hash, mostrando a distribuição de dados.
     */
    public void imprimeTabelaHash() {
        Celula atual;
        for (int i = 0; i < tabela.length; i++) {
            System.out.print(i +") ");
            if (!tabela[i].listaVazia()) {
                atual = tabela[i].devolveInicio();
                while (atual != null) {
                    System.out.print(atual.devolveInfo());
                    atual = atual.devolveProxima();
                    if (atual != null)
                        System.out.print (" -> ");
                }
            }
            System.out.println();
        }
    }
    
} // class TabelaHash
