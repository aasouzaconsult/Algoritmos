///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaPagamentoCorreio.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public class MudaPagamentoCorreio extends MudaMetodoPagamento
{
  public MudaPagamentoCorreio(int oID, BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
  }

  protected MetodoPagamento leMetodoPagamento()
  {
    return new PagamentoCorreio();
  }
}
