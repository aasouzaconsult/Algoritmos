///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaCategoriaComissionado.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public class MudaCategoriaComissionado extends MudaCategoria
{
  private int valorComissao;

  public MudaCategoriaComissionado(int oID, int valor,
				   BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
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
