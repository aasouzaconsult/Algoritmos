// Vamos efetuar a gravação no arquivo "computador.arq".

import java.io.*;
public class Gravaobjeto {
public static void main(String args[]) {
Computador c1 = new Computador();
c1.nome = "Pentium 4"; 
c1.velocidade = "1,5 GigaHertz";
c1.memoria = "256 MegaBytes"; 
c1.revendedor = "Novo Pc";
try {
FileOutputStream f = new FileOutputStream ("computador.txt");
ObjectOutputStream s = new ObjectOutputStream(f);
s.writeObject(c1); 
s.flush();
System.out.println("Gravacao realizada com sucesso!");
}
catch (Exception e) 
{ System.out.println(e); }
}
}

