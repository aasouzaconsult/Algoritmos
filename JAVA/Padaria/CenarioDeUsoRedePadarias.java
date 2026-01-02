public class CenarioDeUsoRedePadarias {
  public static void main(String[] args) {
    RedePadarias pg = new RedePadarias();
    pg.nome = "Pao Gostoso";
    Padaria p1 = pg.criaPadaria("Av. Hermes da Fonseca");
    Padaria p2 = pg.criaPadaria("Av. Roberto Freire");
    Secao p1_s1 = p1.criaSecao("Paes");
    Secao p1_s2 = p1.criaSecao("Frios");
    Secao p2_s3 = p2.criaSecao("Paes");
    Secao p2_s4 = p2.criaSecao("Revistas");
    Produto paoFrances = p1_s1.criaProduto("Pao Frances", 1);
    Produto paoFrances2 = p2_s3.criaProduto("Pao Frances", 2);
    Produto istoEh = p2_s4.criaProduto("Isto É", 6);
    Produto paoDoce = p2_s3.criaProduto("Pao Doce", 1);
    p2.vende(istoEh);
    p2.vende(paoFrances2);
    p2.vende(paoFrances2);
    p2.vende(paoFrances2);
    p1.vende(paoFrances);
    p2.vende(paoDoce);
  }
} 
