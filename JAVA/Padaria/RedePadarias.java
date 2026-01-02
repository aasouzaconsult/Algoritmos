public class RedePadarias {
  String nome;
  Padaria[] padarias = new Padaria[10];
  int qtdPadarias = 0;
  Padaria criaPadaria(String nome) {
    padarias[qtdPadarias] = new Padaria(nome);
    qtdPadarias = qtdPadarias + 1;
    return padarias[qtdPadarias-1];
  }
}

