/*
 * Pessoa.java
 *
 * Created on 17 de Maio de 2004, 08:26
 */

package Projetocpj;

//import java.io.*;
// modo de exibri como regra de negocio e nomenclatura


/**
 * ler os dados que estao dentro do JTextField
 * @author  claudemir
 */
public class Pessoa
{
    
  private String NomeCompleto;
  private String CodigoAluno;      
  private String DataNascimento;
  private String NomePai;
  private String NomeMae;  
 
        
    public Pessoa() 
    {
        
        NomeCompleto = null; // por padrao de nomenclatura - organizacao
        CodigoAluno = null;
        DataNascimento = null;
        NomePai = null;
        NomeMae = null;
        
    }
    
    public void setNomeCompleto(String Value) // direcionando o valor do campo NomeCompleto
    {
        this.NomeCompleto = Value; // referencia ao objeto NomeCompleto
     
    }
    
    
    public String getNomeCompleto() // recebendo /get/ o tipo do valor do parametro
    {
        return this.NomeCompleto; // retorna o valor/tipo do NomeCompleto
        
    }
    
    public void setCodigoAluno(String value)
    {
        
         this.CodigoAluno = value;
    }
    
    public String getCodigoAluno()
    {
        return this.CodigoAluno;
    }
    
    
    public void setDataNascimento(String value)
    {
        
        this.DataNascimento = value;
    }
    
    
    public String getDataNascimento()
    {
        return this.DataNascimento;
        
    }

    public void setNomePai(String value)
    {
        
        this.NomePai = value;
    }
    
    public String getNomePai()
    {
        
        return this.NomePai;
    }
    
    
    public void setNomeMae(String value)
    {
        
        this.NomeMae = value;
    }
    
    public String getNomeMae()
    {
        
        return this.NomeMae;
    }

}







    
    
    
