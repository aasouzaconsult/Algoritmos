///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: AdicionaEmpregadoMensalista.java
// Descricao: Classe que implementa a insercao de um funcionario mensalista.
//            Esta classe apenas fornece implementacoes para os metodos
//            'leCategoriaSalarial' e 'leAgendaPagamento', utilizando
//            a implementacao da classe base abstrata.
//
///////////////////////////////////////////////////////////////////////////

public class AdicionaEmpregadoMensalista extends AdicionaEmpregado
{
  private int salario;

  public AdicionaEmpregadoMensalista(String umNome, String umEndereco,
				     int umSalario,
				     BaseFolhaPagamento baseDeDados)
  {
    super(umNome, umEndereco, baseDeDados);
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


