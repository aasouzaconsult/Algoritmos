///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaEndereco.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public class MudaEndereco extends MudaEmpregado
{
  private String novoEndereco;

  public MudaEndereco(int oID, String endereco,
		      BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
    novoEndereco= endereco;
  }

  // Efetua a alteracao especifica desta classe.
  protected void alteraEmpregado(Empregado emp)
  {
    emp.atuEndereco(novoEndereco);
  }
}
