public class Fita implements Alugavel {
  public static final int NORMAL = 0;
  public static final int LANÇAMENTO = 1;
  public static final int INFANTIL = 2;

  private String título;
  private Classificacao classificação;

  public Fita(String título, int códigoDePreço) {
    this.título = título;
    setCódigoDePreço(códigoDePreço);
  }

  public String getTítulo() {
    return título;
  }

  public int getCódigoDePreço() {
    return classificação.getCódigoDePreço();
  }

  public void setCódigoDePreço(int códigoDePreço) {
    switch(códigoDePreço) {
    case NORMAL:
      classificação = new ClassificacaoNormal();
      break;
    case LANÇAMENTO:
      classificação = new ClassificacaoLancamento();
      break;
    case INFANTIL:
      classificação = new ClassificacaoInfantil();
      break;
    }
  }
  public double getValorDoAluguel(int diasAlugada) {
    return classificação.getValorDoAluguel(diasAlugada);
  }
  public int getPontosDeAlugadorFrequente(int diasAlugada) {
    return classificação.getPontosDeAlugadorFrequente(diasAlugada);
  }
}

