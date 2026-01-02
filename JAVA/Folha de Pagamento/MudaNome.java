///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaNome.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public class MudaNome extends MudaEmpregado
{
  private String novoNome;

  public MudaNome(int oID, String nome,
		  BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
    novoNome= nome;
  }

  // Efetua a alteracao especifica desta classe.
  protected void alteraEmpregado(Empregado emp)
  {
    emp.atuNome(novoNome);
  }
}
