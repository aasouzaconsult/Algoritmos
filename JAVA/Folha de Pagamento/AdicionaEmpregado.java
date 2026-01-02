///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: AdicionaEmpregado.java
// Descricao: Classe abstrata que implementa a parte principal da 
//            funcionalidade da transacao de insercao de novo 
//            empregado. Depende de classes derivadas para completar
//            alguns campos do registro do empregado.
//
///////////////////////////////////////////////////////////////////////////

public abstract class AdicionaEmpregado extends Transacao
{
  private String nome;
  private String endereco;
  private BaseFolhaPagamento empregados;
  
  public AdicionaEmpregado(String umNome, String umEndereco,
			   BaseFolhaPagamento baseDeDados)
  {
    nome= umNome;
    endereco= umEndereco;
    empregados= baseDeDados;
  }

  // Metodos para determinar que tipo de empregado e' este.
  // Dois destes métodos possuem implementacoes padrao representando
  // praticas comuns na empresa.
  protected MetodoPagamento leMetodoPagamento()
  {
    return new PagamentoEspecie();
  }
  protected Afiliacao leAfiliacao()
  {
    return new NaoAfiliado();
  }
  protected abstract CategoriaSalarial leCategoriaSalarial();
  protected abstract AgendaPagamento leAgendaPagamento();

  // Implementacao da transacao. Os dados do novo empregado sao 
  // preenchidos de acordo com os metodos acima, possivelmente 
  // redefinidos em subclasses, sendo o registro armazenado
  // na base de dados.
  public void execute()
  {
    Empregado novoEmpregado= 
      new Empregado(nome, endereco, leMetodoPagamento(), 
		    leCategoriaSalarial(), leAgendaPagamento(), 
		    leAfiliacao());
    empregados.adicionaEmpregado(novoEmpregado);
  }
}
