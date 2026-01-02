//  PontoReferencia.java
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
// **   Arquivo:PontoReferencia.java                           **
// **                                                          **
// **   Rodolpho Iemini Atoji          4894631                 **
// **                                                          **
// **   Data de entrega: 27/11/2003                            **
// **************************************************************

/**
 * Representa, num mapa, um ponto de referência a ser visitado.
 * 
 * @author Rodolpho Iemini Atoji
 */
public class PontoReferencia 
    implements InformacaoPrincipal, InformacaoPrioridade, Cloneable {
    
    private final String nomePonto;
    private final TabelaHash hash;
    private boolean visitado;
    private int numeroConexoes, custo, atiradores;
    private final int INFINITO = 9999999;
    private PontoReferencia anterior;
    
    /**
     * Constrói um objeto-padrão desta classe.
     * Tamanho padrão do array de hash: 11 posições.
     */
    public PontoReferencia() {
        nomePonto = "Genérico";
        hash = new TabelaHash(11);
        visitado = false;
        numeroConexoes = 0;
        custo = INFINITO;
        atiradores = 0;
        anterior = null;
    }
    
    /**
     * Constrói um objeto, definindo o nome do ponto de referência.
     * Tamanho padrão do array de hash: 11 posições.
     * 
     * @param nome Nome do ponto de referência.
     */
    public PontoReferencia(String nome) {
        nomePonto = nome;
        hash = new TabelaHash(11);
        visitado = false;
        numeroConexoes = 0;
        custo = INFINITO;
        atiradores = 0;
        anterior = null;
    }
    
    /**
     * Constrói um objeto, sendo possível definir tamanho do hash,
     * nome do ponto de referência e custo.
     * 
     * @param tamanhoHash Tamnho da tabela de hash para o ponto de referência.
     * @param nome Nome do ponto de referência.
     * @param custo Custo para o ponto.
     */
    public PontoReferencia(int tamanhoHash, String nome, int custo) {
        nomePonto = nome;
        hash = new TabelaHash(tamanhoHash);
        visitado = false;
        numeroConexoes = 0;
        if (custo < INFINITO)
            this.custo = custo;
        else
            custo = INFINITO;
        atiradores = 0;
        anterior = null;
    }
    
    /**
     * Produz um clone deste tipo de objeto.
     * 
     * @return Clone.
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    /**
     * Adiciona uma ligação (caminho) ao ponto de referência.
     * 
     * @param outroPonto Ponto a ser referenciado.
     */
    public void adicionaCaminho(PontoReferencia outroPonto) {
        Celula pontoEncapsulado = new Celula(outroPonto);
        hash.insereElemento(pontoEncapsulado);
        numeroConexoes++;
    }
    
    /**
     * Verifica a existência de determinada conexão a este ponto.
     * 
     * @param caminho Nome do ponto de referência a ser procurado.
     * @return Ponto conectado.
     */
    public Celula procuraCaminho(String caminho) {
        return hash.procuraElemento(caminho);
    }
    
    /**
     * Informa o número de pontos conectados a este ponto.
     * 
     * @return Número de pontos ao qual o ponto está conectado.
     */
    public int numeroPontos() {
        return numeroConexoes;
    }
    
    /**
     * Marca o local como visitado.
     */
    public void marcaVisitado() {
        visitado = true;
    }
    
    /**
     * Marca o local como não visitado.
     */
    public void marcaNaoVisitado() {
        visitado = false;
    }
    
    /**
     * Responde se já foi visitado ou não.
     * 
     * @return Flag indicando se o local já foi visitado.
     */
    public boolean localVisitado() {
        return visitado;
    }
    
    /**
     * Determina se um ponto com dado nome está conectado a este ponto.
     * Caso esteja, devolve a referência para o mesmo.
     * 
     * @param nome Nome do ponto de referência a ser procurado.
     */
    public Celula verificaConexao(String nome) {
        Celula ponto = hash.procuraElemento(nome);
        return ponto;
    }
    
    /**
     * Constrói um array com referências para todos os pontos conectados 
     * a este ponto.
     */
    public PontoReferencia[] pontosConectados() {
        PontoReferencia[] arrayPontos = new PontoReferencia[numeroConexoes];
        Celula temp;
        int j = 0;
        for (int i = 0; i < hash.tamanho; i++) {
            temp = hash.elementoNaPosicao(i);
            while (temp != null) {             
                arrayPontos[j] = (PontoReferencia)temp.devolveInformacao();
                temp = temp.devolveProxima();
                j++;
            }
        }
        return arrayPontos;
    }
    
    /**
     * Devolve a prioridade do objeto em questão.
     * 
     * @return Prioridade do objeto.
     */
    public int devolvePrioridade() {
        return custo;
    }
    
    /**
     * Modifica a prioridade do objeto em questão.
     * 
     * @param novaPrioridade Nova prioridade.
     */
    public void mudaPrioridade(int novaPrioridade) {
        if (novaPrioridade < INFINITO)
            custo = novaPrioridade;
        else
            custo = INFINITO;
    }
    
    /**
     * Incrementa o número de atiradores nesta posição.
     */
    public void incrementaAtiradores() {
        atiradores++;
    }
    
    /**
     * Número de atiradores.
     * 
     * @return Número de atiradores neste ponto.
     */
    public int devolveNumeroAtiradores() {
        return atiradores;
    }
    
    /**
     * Inclui uma referência para o ponto anterior em um caminho percorrido
     * qualquer.
     * 
     * @param anterior Objeto do caminho anterior ao ponto em questão.
     */
    public void mudaAnterior(PontoReferencia anterior) {
        this.anterior = anterior;
    }
    
    /**
     * Exibe o ponto de referência anterior, em um caminho qualquer.
     * 
     * @return Ponto de referência anterior.
     */
    public PontoReferencia devolveAnterior() {
        return anterior;
    }
    
    /**
     * Devolve a informação String mais relevante de um objeto, para
     * fins de ordenação, reconhecimento de conteúdo e etc.
     * 
     * @return Informação principal do objeto.
     */
    public String devolveInfo() {
        return nomePonto;
    }
    
    /**
     * Cálculo de número para utilização em tabelas de hash.
     * 
     * @return Valor de hash.
     */
    public int devolveCodigoHash() {
        String pontoTemp = nomePonto.toUpperCase();
        int soma = 0;
        int valorCaractere = 0;
        for (int i = 0; i < pontoTemp.length(); i++) {
            valorCaractere = pontoTemp.charAt(i);
            soma += valorCaractere;
        }
        return soma;
    }
    
    
} // class PontoDeReferencia
