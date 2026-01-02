class ClassificacaoLancamento extends Classificacao {
  int getCódigoDePreço() {
    return Fita.LANÇAMENTO;
  }

  double getValorDoAluguel(int diasAlugada) {
    return diasAlugada * 3;
  }

  int getPontosDeAlugadorFrequente(int diasAlugadas) {
    return (diasAlugadas > 1) ? 2 : 1;
  }
}
