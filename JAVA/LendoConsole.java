// LendoConsole.java

import java.io.*;

public class LendoConsole
{
    public static void main(String args[])
    {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int v1, v2, soma;
        try
        {
            System.out.print("Digite o primeiro valor: ");
            v1 = Integer.parseInt(br.readLine());
            System.out.print("Digite o segundo valor: ");
            v2 = Integer.parseInt(br.readLine());
            soma = v1 + v2;
            System.out.println("Soma dos valores: " + soma);   
        }
        catch (IOException e)
        {
            System.out.println("Erro de entrada: " + e);
        }
    }
}
