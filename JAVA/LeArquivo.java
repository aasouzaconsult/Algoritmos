// LeArquivo.java

import java.io.*;

public class LeArquivo
{
    public static void main(String args[])
    {
        try
        {
            FileInputStream file = new FileInputStream(args[0]);
            int cont = 0;
            int input;
            while (true)
            {
                input = file.read();
                if (input == -1)
                    break;
                System.out.print((char)input);
                cont++;
            }
            file.close();
            System.out.println("\nBytes lidos: " + cont);
        }
        catch (IOException e)
        {
            System.out.println("Erro" + e.toString());
        }
    }
}
