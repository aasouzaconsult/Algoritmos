public abstract class Classificacao {
  abstract int getCódigoDePreço();
  abstract double getValorDoAluguel(int diasAlugada);

  int getPontosDeAlugadorFrequente(int diasAlugadas) {
    return 1;
  }
}

