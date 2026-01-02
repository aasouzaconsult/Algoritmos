/*
 * HelloJava.java
 *
 * Created on 28 de Setembro de 2004, 08:13
 */

/**
 *
 * @author  claudemir
 */
public class HelloJava {
    private static Mensagem nome; // atributo "nome" é do tipo Mensagem
    
    public static void main(String []args) { // este método é chamado pelo interpretador
         nome = new Mensagem(); //cria objeto
        
        if(args.length > 0){ // há args de linha de comando ?
            nome.msg = args[0];// se houver, copie para msg
          }
        else{
            nome.msg = "Usuário"; // copie palavra "Usuário"
          }
        
        String texto = nome ler.Nome();
        System.out.println("Bem vindo ao Mundo Java, "+texto+"!");
        
    }
        
}
