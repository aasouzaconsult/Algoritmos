// ClienteMultiThread.java

import java.net.*;
import java.io.*;

public class ClienteMultiThread
{
    public static void main(String args[])
    {
        String host;
        int porta;
        InputStream istream = System.in;
        DataInputStream distream = new DataInputStream(istream);
        host = args[0];
        porta = Integer.parseInt(args[1]);
        try
        {
            Socket s = new Socket(host, porta);
            PrintStream ps = new PrintStream(s.getOutputStream());         
            new MostraDados(s).start();
            while (true)
            {
                ps.println(distream.readLine());
            }
        }
        catch (IOException e)
        {
            System.out.println("Erro: " + e );
        }
    }
}

class MostraDados extends Thread
{
    Socket s;

    public MostraDados(Socket s)
    {
        this.s = s;
    }

    public void run()
    {
        try
        {
            DataInputStream dis = new DataInputStream(s.getInputStream());
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
            System.out.println("Erro: " + e);
        }
    }
}

