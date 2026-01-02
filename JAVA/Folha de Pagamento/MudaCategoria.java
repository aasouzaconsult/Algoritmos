///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaCategoria.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public abstract class MudaCategoria extends MudaEmpregado
{
  public MudaCategoria(int oID, BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
  }

  // Metodos para determinar a nova categoria e agenda de pagamento.
  // Devem ser definidos em subclasses especificas para cada categoria.
  protected abstract CategoriaSalarial leCategoriaSalarial();
  protected abstract AgendaPagamento leAgendaPagamento();

  // Efetua a alteracao especifica desta classe.
  protected void alteraEmpregado(Empregado emp)
  {
    emp.atuCategoriaSalarial(leCategoriaSalarial());
    emp.atuAgendaPagamento(leAgendaPagamento());
  }
}
