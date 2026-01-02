///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: Horista.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////
import java.util.Vector;

public class Horista extends CategoriaSalarial
{
  private int valorHora;
  private Vector cartoesPonto;

  public Horista(int valor)
  {
    valorHora= valor;
    cartoesPonto= new Vector();
  }
}
