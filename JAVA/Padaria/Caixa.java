public class Caixa {
  float dinheiro = 0; // inicializacao

  float vende(Produto x) {
    dinheiro = dinheiro + x.preco;
    return x.preco;
  }
  public static void main(String[] args) {
    Produto p = new Produto("Tapioca", 2);
    Produto p2 = new Produto("Pão Doce", 0.2f);
    Caixa c = new Caixa();
    float valorVenda = c.vende(p);
    System.out.println("O valor da venda foi "+valorVenda);
    System.out.println("O $ em caixa é "+c.dinheiro);
    float valorVenda2 = c.vende(p2);
    System.out.println("O valor da venda foi "+valorVenda2);
    System.out.println("O $ em caixa é "+c.dinheiro);
    for (int i = 0 ; i < 20; i++) {
      c.vende(p); // vende uma tapioca
      System.out.println("O $ em caixa é "+c.dinheiro);
    }
  }
}
