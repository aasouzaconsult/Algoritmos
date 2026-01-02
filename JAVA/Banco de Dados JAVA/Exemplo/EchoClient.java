import java.io.*;
import java.net.*;

public class EchoClient {

   public static void main(String[] args) throws IOException {
      Socket echoSocket = null;
      PrintWriter out = null;
      BufferedReader in = null;

      try {
         echoSocket = new Socket("127.0.0.1", 4445);
         out = new PrintWriter(echoSocket.getOutputStream(), true);
         in = new BufferedReader(
                     new InputStreamReader(echoSocket.getInputStream()));
      } catch (UnknownHostException e) {
         System.err.println("Host desconhecido");
         System.exit(1);
      } catch (IOException e) {
         System.err.println("Nao foi possivel estabeler uma conexao.");
         System.exit(1);
      }

       for(int vc=0; vc<args.length; vc++) {
          out.println(args[vc]);
          System.out.println("echo: " + in.readLine());
       }

       out.close();
       in.close();
       echoSocket.close();
   }
}
