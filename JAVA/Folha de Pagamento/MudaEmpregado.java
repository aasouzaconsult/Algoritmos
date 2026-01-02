///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaEmpregado.java
// Descricao: Classe abstrata que implementa parte da funcionalidade
//            de uma alteracao no registro de um funcionario. Esta 
//            classe acha o registro do funcionario em questao e
//            delega a alteracao a uma de sua subclasses.
//
///////////////////////////////////////////////////////////////////////////

public abstract class MudaEmpregado extends Transacao
{
  private int id;
  private BaseFolhaPagamento empregados;

  public MudaEmpregado(int oID, BaseFolhaPagamento baseDeDados)
  {
    id= oID;
    empregados= baseDeDados;
  }

  // Metodo que deve ser implementado para fazer alteracoes especificas.
  protected abstract void alteraEmpregado(Empregado emp);

  public void execute()
  {
    Empregado emp= empregados.leEmpregado(id);
    alteraEmpregado(emp);
  }
}
