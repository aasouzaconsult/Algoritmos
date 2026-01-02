///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: Comissionado.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////
import java.util.Vector;

public class Comissionado extends CategoriaSalarial
{
  private int valorComissao;
  private Vector relatoriosVenda;

  public Comissionado(int valor)
  {
    valorComissao= valor;
    relatoriosVenda= new Vector();
  }
}
