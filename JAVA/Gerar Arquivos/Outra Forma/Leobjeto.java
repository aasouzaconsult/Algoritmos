//Terceiro: Agora vamos efetuar a leitura do arquivo "computador.arq"

import java.io.*;
public class Leobjeto {
public static void main(String args[]) {
try {
   FileInputStream f = new FileInputStream("computador.arq");
   ObjectInputStream s = new ObjectInputStream(f);
   Computador x = (Computador)s.readObject();
   if (x.nome=="Pentium 4") {
      System.out.println("OK");
    }
}
catch (Exception e) 
  { 
     System.out.println(e);
  }

}
}

