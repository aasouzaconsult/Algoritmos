class ClassificacaoInfantil extends Classificacao {
  int getCódigoDePreço() {
    return Fita.INFANTIL;
  }

  double getValorDoAluguel(int diasAlugada) {
    double valorDoAluguel = 1.5;
    if(diasAlugada > 3) {
      valorDoAluguel += (diasAlugada - 3) * 1.5;
    }
    return valorDoAluguel;
  }
}