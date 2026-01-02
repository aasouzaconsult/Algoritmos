//  ProcuraCaminho.java
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
// **   Arquivo:ProcuraCaminho.java                            **
// **                                                          **
// **   Rodolpho Iemini Atoji          4894631                 **
// **                                                          **
// **   Data de entrega: 27/11/2003                            **
// **************************************************************

import java.util.NoSuchElementException;
import java.io.IOException;

/**
 * Implementação do algoritmo de busca pela possibilidade de se
 * realizar determinado caminho.
 * Utiliza um fila de prioridades para determinar qual será o próximo
 * local a ser visitado.
 * 
 * @author Rodolpho Iemini Atoji
 */
public class ProcuraCaminho {
    private String[] pontos, atiradores, seguros;
    private PontoReferencia entrada, saida;
    private TabelaHash pontosReferencia;
    private FilaPrioridade fila;
    private int balas;
    
    /**
     * Executa o programa.
     * 
     * @param args Nome do arquivo a ser carregado.
     */
    public static void main (String[] args) {
        switch (args.length) {
            case 0:
                System.out.println("\nMAC122 - Princípios de Desenvolvimento" +
                                   " de Algoritmos \n" +
                                   "<BCC - IME - USP> Exercício-Programa 4:" +
                                   " Guerra em Pandópolis \n\n" +
                                   "Exemplo de uso: java ProcuraCaminho " +
                                   "caminhos.txt \n");
                break;
            default:
                ProcuraCaminho p = new ProcuraCaminho(args[0]);
                if (p.procuraCaminho())
                    System.out.println("É possível completar o caminho.");
                else
                    System.out.println("Não é possível completar o caminho.");
        }
    }
    
    /**
     * Inicializa a classe, com um determinado arquivo de entrada de 
     * dados.
     * 
     * @param arquivoEntrada Arquivo plain-text com dados de entrada.
     */
    public ProcuraCaminho(String arquivoEntrada) {
        LeituraArquivo carrega = new LeituraArquivo(arquivoEntrada);       
        pontos = carrega.devolvePontos();
        atiradores = carrega.devolveAtiradores();
        seguros = carrega.devolveSeguros();
        balas = carrega.devolveBalas();
        pontosReferencia = new TabelaHash(pontos.length);
        inicializaMapa(); 
    }
    
    /**
     * Procura pela possibilidade de haver um caminho até o ponto de
     * destino gastando-se no máximo o número de balas disponíveis.
     * Utiliza um algoritmo baseado no Bellman-Ford-Moore:
     * (1) Insere em uma fila de prioridades o ponto de partida;
     * (2) Remove o primeiro elemento da fila e determina os vizinhos;
     * (3) Enfileira os vizinhos;
     * (4) Verifica dentre os vizinhos qual é o melhor caminho;
     * (5) Repete (2)-(5) até que se analise todas as possibilidades ou se
     * chegue na saída;
     * (6) Caso tenha se chegado na saída e o número de balas gasto seja 
     * inferior ou igual ao disponível, a missão pode ser cumprida com 
     * sucesso.
     * 
     * @return Possibilidade de completar o caminho e a missão.
     */
    public boolean procuraCaminho() {
        PontoReferencia analise, analiseFilho = null; 
        PontoReferencia saidaTemp = new PontoReferencia();
        PontoReferencia[] conectados;
        fila = new FilaPrioridade(pontos.length * pontos.length);
        
        // Inicializando a fila de prioridades com a entrada do mapa.
        entrada.mudaPrioridade(0);
        entrada.marcaVisitado();
        fila.insere(entrada);
        
        // Analisando os caminhos...
        while (!fila.filaVazia()) {
            
            // Ponto para o qual se verificará os adjacentes.
            analise = (PontoReferencia)fila.remove();
            
            // Obtém-se e enfileira-se todos os pontos conectados...
            conectados = analise.pontosConectados();
            for (int i = 0; i < conectados.length; i++) {
                if (!conectados[i].localVisitado())
                    fila.insere(conectados[i]);
            }
            
            // Decisão, dentre os conectados, de qual é o melhor ponto.
            for (int j = 0; j < conectados.length; j++) {
                analiseFilho = conectados[j];
                if (!analiseFilho.localVisitado() && 
                    (analise.devolvePrioridade() + 
                     analise.devolveNumeroAtiradores()) <
                    analiseFilho.devolvePrioridade()) {
                    analiseFilho.marcaVisitado();
                    analiseFilho.mudaPrioridade(analise.devolvePrioridade() +
                                                analise.devolveNumeroAtiradores());
                    if (fila.procura(analiseFilho.devolveInfo()) != null)
                        fila.insere(analiseFilho);
                }
            }
            
            // Checando se o ponto visitado não é a saída.
            if (!analise.devolveInfo().equalsIgnoreCase("Genérico"))
                analise.marcaVisitado();     
            
            // Verificador de melhor caminho.
            if (analise.devolveInfo().equalsIgnoreCase(saida.devolveInfo()) && 
                analise.devolvePrioridade() < saidaTemp.devolvePrioridade())
                saidaTemp = analise;
        } // while
        
        System.out.println("Número de balas gastas: " +
                           saidaTemp.devolvePrioridade());
        
        if (!saidaTemp.devolveInfo().equalsIgnoreCase("Genérico") && 
            saida.devolvePrioridade() <= balas)
            return true;
        else
            return false;
    } // procuraCaminho
    
    /**
     * Inicializa o mapa da cidade, cada ponto, exceto a entrada,
     * terá custo "infinito".
     */
    private void inicializaMapa() {
        Celula capsula1 = null;
        Celula capsula2;
        PontoReferencia ponto1, ponto2;
        boolean existe = false;
        
        // Percorrendo o vetor de trechos seguros de ruas.
        for (int i = 0; i < pontos.length; i++) { /* (3) */
            
            // Verifica se o ponto de referência já foi instanciado.
            if (pontosReferencia.procuraElemento(pontos[i]) != null) {
                ponto1 = (PontoReferencia)pontosReferencia.
                    procuraElemento(pontos[i]).devolveInformacao();
                existe = true;
            } else {              
                // Se não, cria um novo ponto.
                ponto1 = new PontoReferencia(pontos[i]);
                if (temAtirador(pontos[i]))
                    ponto1.incrementaAtiradores();
                capsula1 = new Celula(ponto1);
                existe = false;
            }
            
            // Procurando caminhos conectados a um ponto sendo instanciado.
            for (int j = 0; j < pontos.length - 1; j++) { /* (I) */
                
                // Registros adjacentes são pontos de conexão.
                if (j % 2 == 0 && 
                    pontos[j].equalsIgnoreCase(ponto1.devolveInfo())) { /* (2) */
                    
                    // Vê se o ponto de conexão já existe.
                    if (pontosReferencia.procuraElemento(pontos[j + 1]) == null && 
                        ponto1.procuraCaminho(pontos[j + 1]) == null) {
                        ponto2 = new PontoReferencia(pontos[j + 1]);
                        if (temAtirador(pontos[j + 1]))
                            ponto2.incrementaAtiradores();
                        capsula2 = new Celula(ponto2);
                        ponto1.adicionaCaminho(ponto2);
                        ponto2.adicionaCaminho(ponto1);
                        pontosReferencia.insereElemento(capsula2);
                    } else { /* (2) */
                        
                        // Se já existir, é só conectar.
                        if (ponto1.procuraCaminho(pontos[j + 1]) == null) {
                            capsula2 = 
                                pontosReferencia.procuraElemento(pontos[j + 1]);
                            ponto1.adicionaCaminho
                                ((PontoReferencia)capsula2.devolveInformacao());
                            ponto2 = (PontoReferencia)pontosReferencia.
                                procuraElemento(pontos[j + 1]).devolveInformacao();
                            ponto2.adicionaCaminho(ponto1);
                        }
                    } // else (2)
                } // if (2) 
            } // for (1)
            
            // Finalmente... Insere no hash.
            if (!existe)
                pontosReferencia.insereElemento(capsula1); 
        } // for (3)
        
        // Define entrada e saída do mapa.
        entrada = (PontoReferencia)
            pontosReferencia.procuraElemento(seguros[0]).devolveInformacao();
        if (entrada == null) {
            System.out.println("Mapa sem entrada segura!");
        } else {
            entrada.mudaPrioridade(0);
            entrada.marcaVisitado();
        }
        saida = (PontoReferencia)
            pontosReferencia.procuraElemento(seguros[1]).devolveInformacao();
        if (saida == null)
            System.out.println("Mapa sem saída segura!");
    } // inicializaMapa
    
    /**
     * Informa se no ponto de referência há um atirador.
     * 
     * @param nomePonto Nome do ponto a ser verificado.
     */
    private boolean temAtirador(String nomePonto) {
        for (int i = 0; i < atiradores.length; i++) {
            if (atiradores[i].equalsIgnoreCase(nomePonto))
                return true;
        }
        return false;
    }
    
} // class ProcuraCaminho
