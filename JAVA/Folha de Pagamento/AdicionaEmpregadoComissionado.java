///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: AdicionaEmpregadoComissionado.java
// Descricao: Classe que implementa a insercao de um funcionario 
//            comissionado.
//            Esta classe apenas fornece implementacoes para os metodos
//            'leCategoriaSalarial' e 'leAgendaPagamento', utilizando
//            a implementacao da classe base abstrata.
//
///////////////////////////////////////////////////////////////////////////

public class AdicionaEmpregadoComissionado extends AdicionaEmpregado
{
  private int valorComissao;

  public AdicionaEmpregadoComissionado(String umNome, String umEndereco,
				       int valor,
				       BaseFolhaPagamento baseDeDados)
  {
    super(umNome, umEndereco, baseDeDados);
    valorComissao= valor;
  }

  // Implementacao dos metodos relevantes a este tipo de transacao
  protected CategoriaSalarial leCategoriaSalarial()
  {
    return new Comissionado(valorComissao);
  }

  protected AgendaPagamento leAgendaPagamento()
  {
    return new Quinzenal();
  }
}


