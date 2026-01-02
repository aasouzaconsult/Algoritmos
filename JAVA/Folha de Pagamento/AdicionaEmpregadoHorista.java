///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: AdicionaEmpregadoHorista.java
// Descricao: Classe que implementa a insercao de um funcionario horista.
//            Esta classe apenas fornece implementacoes para os metodos
//            'leCategoriaSalarial' e 'leAgendaPagamento', utilizando
//            a implementacao da classe base abstrata.
//
///////////////////////////////////////////////////////////////////////////

public class AdicionaEmpregadoHorista extends AdicionaEmpregado
{
  private int valorHora;

  public AdicionaEmpregadoHorista(String umNome, String umEndereco,
				  int valor,
				  BaseFolhaPagamento baseDeDados)
  {
    super(umNome, umEndereco, baseDeDados);
    valorHora= valor;
  }

  // Implementacao dos metodos relevantes a este tipo de transacao
  protected CategoriaSalarial leCategoriaSalarial()
  {
    return new Horista(valorHora);
  }

  protected AgendaPagamento leAgendaPagamento()
  {
    return new Semanal();
  }
}


