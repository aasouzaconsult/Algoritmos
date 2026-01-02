///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: MudaCategoriaHorista.java
// Descricao: 
//
///////////////////////////////////////////////////////////////////////////

public class MudaCategoriaHorista extends MudaCategoria
{
  private int valorHora;

  public MudaCategoriaHorista(int oID, int valor,
			      BaseFolhaPagamento baseDeDados)
  {
    super(oID, baseDeDados);
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
