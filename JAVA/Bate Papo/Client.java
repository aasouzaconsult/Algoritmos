// Fig. 21.4: Client.java
// Set up a Client that will read information sent
// from a Server and display the information.
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame {
   private JTextField enter;
   private JTextArea display;
   ObjectOutputStream output;
   ObjectInputStream input;
   String message = "";

   public Client()
   {
      super( "Cliente" );

      Container c = getContentPane();

      enter = new JTextField();
      enter.setEnabled( false );
      enter.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               sendData( e.getActionCommand() );
            }
         }
      );
      c.add( enter, BorderLayout.NORTH );

      display = new JTextArea();
      c.add( new JScrollPane( display ),
             BorderLayout.CENTER );

      setSize( 300, 150 );
      show();
   }

   public void runClient() 
   {
      Socket client;

      try {
         // Step 1: Create a Socket to make connection.
         display.setText( "Attempting connection\n" );
         client = new Socket( 
            InetAddress.getByName( "127.0.0.1" ), 5000 );

         display.append( "Connected to: " +
            client.getInetAddress().getHostName() );

         // Step 2: Get the input and output streams.
         output = new ObjectOutputStream(
                      client.getOutputStream() );
         output.flush();
         input = new ObjectInputStream(
                     client.getInputStream() );
         display.append( "\nGot I/O streams\n" );

         // Step 3: Process connection.
         enter.setEnabled( true );

         do {
            try {
               message = (String) input.readObject();
               display.append( "\n" + message );
               display.setCaretPosition(
                  display.getText().length() );
            }
            catch ( ClassNotFoundException cnfex ) {
               display.append(
                  "\nUnknown object type received" );
            }
         } while ( !message.equals( "SERVIDOR>>> TERMINATE" ) );

         // Step 4: Close connection.
         display.append( "Closing connection.\n" );
         output.close();
         input.close();
         client.close();
      }
      catch ( EOFException eof ) {
         System.out.println( "Server terminated connection" );
      }
      catch ( IOException e ) {
         e.printStackTrace();
      }
   }

   private void sendData( String s )
   {
      try {
         message = s;
         output.writeObject( "CLIENTE>>> " + s );
         output.flush();
         display.append( "\nCLIENTE>>>" + s );
      }
      catch ( IOException cnfex ) {
         display.append(
            "\nError writing object" );
      }
   }

   public static void main( String args[] )
   {
      Client app = new Client();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );

      app.runClient();
   }
}

/**************************************************************************
 * (C) Copyright 1999 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
