public class Secao {
  String nome;
  Produto[] produtos;
  int qtdProdutos = 0;
  Secao(String nome) {
    this.nome = nome;
    produtos = new Produto[20];
  }
  Produto criaProduto(String nome, int preco) {
    produtos[qtdProdutos] = new Produto(nome, preco);
    qtdProdutos++;
    return produtos[qtdProdutos-1]; 
  }
}

