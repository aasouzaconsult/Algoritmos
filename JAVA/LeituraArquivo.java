//  LeituraArquivo.java
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
// **   Arquivo:LeituraArquivo.java                            **
// **                                                          **
// **   Rodolpho Iemini Atoji          4894631                 **
// **                                                          **
// **   Data de entrega: 27/11/2003                            **
// **************************************************************

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Carrega o arquivo com os dados a serem processados e cria os objetos
 * necessários para a execução da classe ProcuraCaminho.
 * 
 * @author Rodolpho Iemini Atoji
 */
public class LeituraArquivo {
    private BufferedReader leitor;
    private String[] pontos, atiradores, seguros;
    private int balas;
    
    /**
     * Instancia a classe para um determinado arquivo a ser carregado.
     * 
     * @param arquivo Arquivo a ser carregado.
     */
    public LeituraArquivo(String arquivo) {
        pontos = null;
        atiradores = null;
        seguros = null;
        balas = 0;
        try {
            leitor = new BufferedReader(new FileReader(arquivo));
        }
        catch (IOException erro) {
            System.out.println("Arquivo não encontrado ou você não tem " +
                               "permissões para abrir \no arquivo.");
            System.exit(0);
        }
        try {
            carregaPontos();
            carregaAtiradores();
            carregaSeguros();
        }
        catch (IOException erro) {
            System.out.println("Problemas ao carregar arquivo.");
        }
    }
    
    /**
     * Carrega os pontos de referência, sendo dois-a-dois caminhos
     * seguros.
     */
    private void carregaPontos() throws IOException {
        try {
            int entradas = Integer.parseInt(leitor.readLine());
            String[] pontosCarregados;
            String[] pontosTemp = new String[2 * entradas];
            for (int i = 0; i < entradas; i++) {
                pontosCarregados = leitor.readLine().split(" ");
                pontosTemp[2 * i] = pontosCarregados[0];
                pontosTemp[2 * i + 1] = pontosCarregados[1];
            }
            pontos = pontosTemp;
        }
        catch (NumberFormatException numero) {
            System.out.println("Erro de sintaxe no arquivo de entrada. \n" +
                               "Problema ao carregar pontos de referência.");
            System.exit(0);
        }
    }
    
    /**
     * Carrega pontos de referência onde há atiradores.
     */
    private void carregaAtiradores() throws IOException {
        try {
            int entradas = Integer.parseInt(leitor.readLine());
            String[] atiradoresCarregados;
            String[] atiradoresTemp = new String[entradas];
            for (int i = 0; i < entradas; i++) {
                atiradoresTemp[i] = leitor.readLine();
            }
            atiradores = atiradoresTemp;
        }
        catch (NumberFormatException numero) {
            System.out.println("Erro de sintaxe no arquivo de entrada. \n" +
                               "Problema ao carregar atiradores.");
            System.exit(0);
        }
    }
    
    /**
     * Carrega entrada e saída seguras.
     */
    private void carregaSeguros() throws IOException {
        try {
            balas = Integer.parseInt(leitor.readLine());
            seguros =  new String[2];
            seguros[0] = leitor.readLine();
            seguros[1] = leitor.readLine();
        }
        catch (NumberFormatException numero) {
            System.out.println("Erro de sintaxe no arquivo de entrada. \n" +
                               "Problema ao carregar pontos seguros.");
            System.exit(0);
        }
    }
    
    /**
     * Devolve array com pontos de referência.
     * 
     * @return Array com pontos de referência.
     */
    public String[] devolvePontos() {
        return pontos;
    }
    
    /**
     * Devolve array com pontos onde há atiradores.
     * 
     * @return Array com pontos onde há atiradores.
     */
    public String[] devolveAtiradores() {
        return atiradores;
    }
    
    /**
     * Devolve array com pontos de entrada e saída seguros.
     * 
     * @return Array com pontos de entrada e saída seguros.
     */
    public String[] devolveSeguros() {
        return seguros;
    }
    
    /**
     * Devolve número de balas.
     * 
     * @return Número de balas.
     */
    public int devolveBalas() {
        return balas;
    }
    
} // class LeituraArquivo
