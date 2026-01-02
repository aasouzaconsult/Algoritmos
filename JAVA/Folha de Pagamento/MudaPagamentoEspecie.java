///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaPagamentoEspecie.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public class MudaPagamentoEspecie extends MudaMetodoPagamento
{
  public MudaPagamentoEspecie(int oID, BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
  }

  protected MetodoPagamento leMetodoPagamento()
  {
    return new PagamentoEspecie();
  }
}
