///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaCategoriaMensalista.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public class MudaCategoriaMensalista extends MudaCategoria
{
  private int salario;

  public MudaCategoriaMensalista(int oID, int umSalario,
				 BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
    salario= umSalario;
  }

  // Implementacao dos metodos relevantes a este tipo de transacao
  protected CategoriaSalarial leCategoriaSalarial()
  {
    return new Mensalista(salario);
  }

  protected AgendaPagamento leAgendaPagamento()
  {
    return new Mensal();
  }
}
