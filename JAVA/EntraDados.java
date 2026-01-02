import java.io.*; 

class EntraDados 
{ 
   public static void main (String args[]) 
   { 
       byte vetortexto[] = new byte[200]; //declaração de um vetor de bytes 

             int byteslidos = 0; 

          System.out.println("Escreva algo:"); 

          try 

          { 

                  byteslidos = System.in.read(vetortexto); 

                  System.out.print("Voce escreveu:"); 

                  System.out.write(vetortexto,0,byteslidos); 

          } 

          catch (IOException e) 

          { 

                   // Alguma ação de recuperação da falha 

          }      

    }    

} 
