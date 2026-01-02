public class Aluguel {
  private Alugavel fita;
  private int diasAlugada;

  public Aluguel(Alugavel fita, int diasAlugada) {
    this.fita = fita;
    this.diasAlugada = diasAlugada;
  }

  public Alugavel getFita() {
    return fita;
  }

  public int getDiasAlugada() {
    return diasAlugada;
  }

  double getValorDoAluguel() {
    return fita.getValorDoAluguel(diasAlugada);
  }

  int getPontosDeAlugadorFrequente() {
    return fita.getPontosDeAlugadorFrequente(diasAlugada);
  }
}

