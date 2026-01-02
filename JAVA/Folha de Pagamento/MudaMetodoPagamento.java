///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaMetodoPagamento.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public abstract class MudaMetodoPagamento extends MudaEmpregado
{
  public MudaMetodoPagamento(int oID, BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
  }

  // Metodo para determinar o novo metodo de pagamento. Deve ser definido 
  // em subclasses especificas para cada metodo de pagamento.
  protected abstract MetodoPagamento leMetodoPagamento();

  // Efetua a alteracao especifica desta classe.
  protected void alteraEmpregado(Empregado emp)
  {
    emp.atuMetodoPagamento(leMetodoPagamento());
  }
}
