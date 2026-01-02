import java.net.*;
import java.io.*;

public class Server
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket server = new ServerSocket(2525);
            Socket s = server.accept(); // espera um cliente
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("\n\n\nCurso de Java\n\n\n");
            ps.flush();
        }
        catch (IOException ioe)
        {
            System.out.println("Erro: " + ioe);
        }
    }
}
