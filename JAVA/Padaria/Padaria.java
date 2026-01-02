public class Padaria {
  String nome;
  Secao[] secoes;
  int qtdSecoes = 0;
  Caixa caixa;
  Padaria(String nome) {
    secoes = new Secao[5];
    caixa = new Caixa();
  }
  Secao criaSecao(String nome) {
    secoes[qtdSecoes] = new Secao(nome);
    qtdSecoes = qtdSecoes + 1;
    return secoes[qtdSecoes-1];
  }
  float vende(Produto p) {
    return caixa.vende(p);
  }
}

