//  InformacaoPrioridade.java
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
// **   Arquivo:InformacaoPrioridade.java                      **
// **                                                          **
// **   Rodolpho Iemini Atoji          4894631                 **
// **                                                          **
// **   Data de entrega: 27/11/2003                            **
// **************************************************************

/**
 * Define métodos básicos que objetos a serem enfileirados em uma
 * fila de prioridade devem implementar.
 * 
 * @author Rodolpho Iemini Atoji
 */
public interface InformacaoPrioridade {
    
    /**
     * Devolve a prioridade do objeto em questão.
     * 
     * @return Prioridade do objeto.
     */
    public int devolvePrioridade();
    
    /**
     * Modifica a prioridade do objeto em questão.
     * 
     * @param novaPrioridade Nova prioridade.
     */
    public void mudaPrioridade(int novaPrioridade);
    
    /**
     * Devolve a informação String mais relevante de um objeto, para
     * fins de ordenação, reconhecimento de conteúdo e etc.
     * 
     * @return Informação principal do objeto.
     */
    public String devolveInfo();
    
} // interface InformacaoPrioridade
