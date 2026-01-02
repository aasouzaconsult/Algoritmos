class ClassificacaoNormal extends Classificacao {
  int getCódigoDePreço() {
    return Fita.NORMAL;
  }

  double getValorDoAluguel(int diasAlugada) {
    double valorDoAluguel = 2;
    if(diasAlugada > 2) {
      valorDoAluguel += (diasAlugada - 2) * 1.5;
    }
    return valorDoAluguel;
  }
}
