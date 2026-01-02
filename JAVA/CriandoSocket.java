// CriandoSocket.java

import java.net.*;
import java.io.*;

public class CriandoSocket
{
    public static void main(String args[])
    {
        String host;
        int porta;
        host = args[0];
        porta = Integer.parseInt(args[1]);
        try
        {
            Socket s = new Socket(host, porta);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("teste\n");
            while (true)
            {
                String msg = dis.readLine();
                if (msg == null)
                    break;
                System.out.println(msg);             
            }
        }
        catch (IOException e)
        {
            System.out.println("Erro: " + e );
        }
    }
}

