/**
 * Classe de conta bancária simples.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

import p1.aplic.geral.*;

public class ContaSimples2 {
  // atributos
  private int        número;
  private Pessoa     titular;
  private double     saldo;

  // construtores
  /**
   * Cria uma conta a partir de uma pessoa e número de conta.
   * @param titular O titular da conta.
   * @param número O número da conta.
   */
  public ContaSimples2(Pessoa titular, int número) {
    this.número = número;
    this.titular = titular;
    saldo = 0.0;
  }

  /**
   * Cria uma conta a partir de um nome e cpf de pessoa física, e um número de conta.
   * @param nome O nome do titular da conta.
   * @param cpf O CPF do titular da conta.
   * @param número O número da conta.
   */
  // há sobrecarga do método construtor
  public ContaSimples2(String nome, String cpf, int número) {
    // aninhamento de método construtor
    this(new Pessoa(nome, cpf), número);
  }

  /**
   * Recupera o número da conta.
   * @return O número da conta.
   */
  public int getNúmero() {
    return número;
  }

  /**
   * Recupera o titular da conta.
   * @return O titular da conta.
   */
  public Pessoa getTitular() {
    return titular;
  }

  /**
   * Recupera o nome do titular da conta.
   * @return O nome do titular da conta.
   */
  /* feito para ajudar os principiantes escondendo a classe Pessoa no inicio */
  public String getNome() {
    // aninhamento de método
    return titular.getNome();
  }

  /**
   * Recupera o CPF do titular da conta.
   * @return O CPF do titular da conta.
   */
  /* feito para ajudar os principiantes escondendo a classe Pessoa no inicio */
  public String getCPF() {
    return titular.getCPF();
  }

  /**
   * Recupera o saldo da conta.
   * @return O saldo da conta.
   */
  public double getSaldo() {
    return saldo;
  }

  /**
   * Efetua um depósito numa conta.
   * @param valor O valor a depositar.
   */
  public void depositar(double valor) {
    // credita a conta
    saldo += valor;
  }

  /**
   * Efetua sacada na conta.
   * @param valor O valor a sacar.
   * @return O sucesso ou não da operação.
   */
  public boolean sacar(double valor) {
    // debita a conta
    if(saldo - valor >= 0) {
      saldo -= valor;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Transforma os dados da conta em um String.
   * @return O string com os dados da conta.
   */
  public String toString() {
    return "numero " + número
            + ", nome " + getNome()
            + ", saldo " + saldo;
  }
}
