// URLTeste.java

import java.io.*;
import java.net.*;

public class URLTeste 
{
    public static void main(String args[])
    {
        try
        {
            URL url = new URL(args[0]);
            DataInputStream dis = new DataInputStream(url.openStream());
            String line = dis.readLine();
            while (line != null)
            {
                System.out.println(line);
                line = dis.readLine();
            }
        }
        catch (IOException e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
