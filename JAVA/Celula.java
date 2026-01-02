//  Celula.java
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
// **   Arquivo:Celula.java                                    **
// **                                                          **
// **   Rodolpho Iemini Atoji          4894631                 **
// **                                                          **
// **   Data de entrega: 27/11/2003                            **
// **************************************************************

/**
 * A 'Celula' é o elemento fundamental da "lista ligada".
 * Cada 'Celula' possui uma referência para a próxima da lista e pode
 * conter informação na forma de um objeto de tipo qualquer.
 * 
 * @author Rodolpho Iemini Atoji
 * @version 0.3
 */
public class Celula implements InformacaoPrincipal, Cloneable {
    
    /**
     * Conteúdos de uma célula pertencente a uma lista ligada.
     * informacao: qualquer objeto que se deseje armazenar numa célula
     * proxima:    referência para o próximo objeto 'Celula' da lista ligada
     */
    private InformacaoPrincipal informacao;
    private Celula proxima;
    
    /**
     * Construtor de um só argumento, apontando para referência nula.
     * 
     * @param info Objeto para inicializar a célula.
     */
    public Celula(InformacaoPrincipal info) {
        this(info, null);
    }
    
    /**
     * Construtor-padrão: cria objeto com informação e aponta para a
     * próxima célula da lista ligada.
     * 
     * @param info Objeto para inicializar a célula.
     * @param prox Referência para a próxima célula.
     */
    public Celula(InformacaoPrincipal info, Celula prox) {
        this.informacao = info;
        this.proxima = prox;
    }
    
    /**
     * Devolve a informação principal do conteúdo da Celula.
     * Para tanto, o conteúdo da Celula deve implementar InformacaoPrincipal
     * 
     * @see InformacaoPrincipal
     * @return Informação principal.
     */
    public String devolveInfo() {
        String info = informacao.devolveInfo();
        return info;
    }
    
    /**
     * Clonador de Células.
     * 
     * @return Clone de Celula.
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    /**
     * Devolve o conteúdo de uma célula.
     * 
     * @return Conteúdo da célula.
     */
    public InformacaoPrincipal devolveInformacao() {
        return informacao;
    }
    
    /**
     * Devolve a referência para a próxima célula.
     * 
     * @return Referência para a próxima célula.
     */
    public Celula devolveProxima() {
        return proxima;
    }
    
    /**
     * Muda a referência para a próxima célula.
     * 
     * @param prox Referência para a próxima célula.
     */
    public void mudaProxima(Celula prox) {
        this.proxima = prox;
    }
    
    /**
     * Cálculo de número para utilização em tabelas de hash.
     * 
     * @return Valor de hash.
     */
    public int devolveCodigoHash() {
        int codigoHash = informacao.devolveCodigoHash();
        return codigoHash;
    }
    
}// class Celula
