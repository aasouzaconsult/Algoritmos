///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: Empregado.java
// Descricao: Classe que representa um empregado da empresa. Guarda 
//            informações relativas ao metodo de pagamento, categoria
//            salaria e afiliacao em sindicato.
//
///////////////////////////////////////////////////////////////////////////

public class Empregado
{
  private int id;
  private String nome;
  private String endereco;
  private MetodoPagamento oMetodoPagamento;
  private CategoriaSalarial aCategoriaSalarial;
  private AgendaPagamento aAgendaPagamento;
  private Afiliacao aAfiliacao;

  public Empregado(String umNome, String umEndereco,
		   MetodoPagamento mtdPag, CategoriaSalarial catSal,
		   AgendaPagamento agdPag, Afiliacao afil)
  {
    id= -1; // Empregado ainda nao cadastrado no banco de dados
    nome= umNome;
    endereco= umEndereco;
    oMetodoPagamento= mtdPag;
    aCategoriaSalarial= catSal;
    aAgendaPagamento= agdPag;
    aAfiliacao= afil;
  }

  // Metodos para alterar os dados de um empregado
  public void atuID(int umaID)
  {
    id= umaID;
  }

  public void atuNome(String novoNome)
  {
    nome= novoNome;
  }

  public void atuEndereco(String novoEndereco)
  {
    endereco= novoEndereco;
  }

  public void atuMetodoPagamento(MetodoPagamento novoMetodo)
  {
    oMetodoPagamento= novoMetodo;
  }

  public void atuCategoriaSalarial(CategoriaSalarial novaCategoria)
  {
    aCategoriaSalarial= novaCategoria;
  }

  public void atuAgendaPagamento(AgendaPagamento novaAgenda)
  {
    aAgendaPagamento= novaAgenda;
  }

  public void atuAfiliacao(Afiliacao novaAfiliacao)
  {
    aAfiliacao= novaAfiliacao;
  }
}
