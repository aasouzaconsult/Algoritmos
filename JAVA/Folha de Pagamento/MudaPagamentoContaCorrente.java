///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaPagamentoContaCorrente.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public class MudaPagamentoContaCorrente extends MudaMetodoPagamento
{
  public MudaPagamentoContaCorrente(int oID, BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
  }

  protected MetodoPagamento leMetodoPagamento()
  {
    return new PagamentoContaCorrente();
  }
}
