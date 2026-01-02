import p1.aplic.banco;
/**
 * Classe de conta bancária simples.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class ContaSimples1 {
  // atributos
  private String  nome;
  private String  cpf;
  private int     número;
  private double  saldo;

  // construtor

  /**
   * Cria uma conta a partir de um nome e cpf de pessoa física, e um número de conta.
   * @param nome O nome do titular da conta.
   * @param cpf O CPF do titular da conta.
   * @param número O número da conta.
   */
  public ContaSimples1(String nome, String cpf, int número) {
    this.nome = nome;
    this.cpf = cpf;
    this.número = número;
    saldo = 0.0;
  }

  // métodos
  /**
   * Recupera o número da conta.
   * @return O número da conta.
   */
  public int getnúmero() {
    return número;
  }

  /**
   * Recupera o nome do titular da conta.
   * @return O nome do titular da conta.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Recupera o CPF do titular da conta.
   * @return O CPF do titular da conta.
   */
  public String getCPF() {
    return cpf;
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
    return "número " + número
            + ", nome " + nome
            + ", saldo " + saldo;
  }
}
