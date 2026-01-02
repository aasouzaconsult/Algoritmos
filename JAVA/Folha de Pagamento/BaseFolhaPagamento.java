///////////////////////////////////////////////////////////////////////////
//
// Projeto: Folha de Pagamento
// Arquivo: BaseFolhaPagamento.java
// Descricao: Classe que o banco de dados onde os dados sobre os 
//            empregados sao armazenados. 
//
///////////////////////////////////////////////////////////////////////////
import java.util.Hashtable;
import java.util.Enumeration;

public class BaseFolhaPagamento
{
  private int proximoID; // Usado para gerar ids de empregados novos
  private Hashtable empregados; // Lista de empregados, indexada por id
  private Hashtable ids; // Lista de ids de empregados, indexada por idSind

  public BaseFolhaPagamento()
  {
    proximoID= 1;
    empregados= new Hashtable();
    ids= new Hashtable();
  }

  // Metodo que acrescenta um empregado a base de dados. E' gerado um id
  // ainda nao usado para este empregado. 
  public void adicionaEmpregado(Empregado novoEmpregado)
  {
    novoEmpregado.atuID(proximoID);
    empregados.put(new Integer(proximoID), novoEmpregado);
    proximoID++;
  }

  // Metodo que retorna o registro de um empregado dado o seu id
  public Empregado leEmpregado(int id)
  {
    return (Empregado)empregados.get(new Integer(id));
  }

  // Metodo que retorna uma lista de todos os empregados. Esta lista
  // pode ser percorrida sequencialmente.
  public Enumeration leEmpregados()
  {
    return empregados.elements();
  }
}
