import java.util.*;

public class Cliente {
  private String nome;
  private Collection fitasAlugadas = new Vector();

  public Cliente(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void adicionaAluguel(Aluguel aluguel) {
    fitasAlugadas.add(aluguel);
  }

  public String extrato() {
    final String fimDeLinha = System.getProperty("line.separator");
    Iterator alugueis = fitasAlugadas.iterator();
    String resultado = "Registro de Alugueis de " + getNome() + fimDeLinha;
    while(alugueis.hasNext()) {
      Aluguel cada = (Aluguel)alugueis.next();

      // mostra valores para este aluguel
      resultado += "\t" + cada.getFita().getTítulo() + "\t" +
                   cada.getValorDoAluguel() + fimDeLinha;
    } // while
    // adiciona rodapé
    resultado += "Valor total devido: " + getValorTotal() + fimDeLinha;
    resultado += "Voce acumulou " + getPontosTotaisDeAlugadorFrequente() +
              " pontos de alugador frequente";
    return resultado;
  }

  private double getValorTotal() {
    double valorTotal = 0.0;
    Iterator alugueis = fitasAlugadas.iterator();
    while(alugueis.hasNext()) {
      Aluguel cada = (Aluguel)alugueis.next();
      valorTotal += cada.getValorDoAluguel();
    }
    return valorTotal;    
  }

  private int getPontosTotaisDeAlugadorFrequente() {
    int pontos = 0;
    Iterator alugueis = fitasAlugadas.iterator();
    while(alugueis.hasNext()) {
      Aluguel cada = (Aluguel)alugueis.next();
      pontos += cada.getPontosDeAlugadorFrequente();
    }
    return pontos;
  }
}

