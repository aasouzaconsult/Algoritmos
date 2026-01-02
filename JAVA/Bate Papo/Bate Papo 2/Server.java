// Fig. 17.6: Server.java
// Set up a Server that will receive packets from a
// client and send packets to a client.

// Java core packages
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class Server extends JFrame {
   private JTextArea displayArea;
   private DatagramPacket sendPacket, receivePacket;
   private DatagramSocket socket;

   // set up GUI and DatagramSocket
   public Server()
   {
      super( "Server" );

      displayArea = new JTextArea();
      getContentPane().add( new JScrollPane( displayArea ),
         BorderLayout.CENTER );
      setSize( 400, 300 );
      setVisible( true );

      // create DatagramSocket for sending and receiving packets
      try {
         socket = new DatagramSocket( 5000 );
      }

      // process problems creating DatagramSocket
      catch( SocketException socketException ) {
         socketException.printStackTrace();
         System.exit( 1 );
      }

   }  // end Server constructor

   // wait for packets to arrive, then display data and echo
   // packet to client
   public void waitForPackets()
   {
      // loop forever
      while ( true ) {

         // receive packet, display contents, echo to client
         try {

            // set up packet
            byte data[] = new byte[ 100 ];
            receivePacket =
               new DatagramPacket( data, data.length );

            // wait for packet
            socket.receive( receivePacket );
 
            // process packet
            displayPacket();

            // echo information from packet back to client
            sendPacketToClient();
         }

         // process problems manipulating packet
         catch( IOException ioException ) {
            displayArea.append( ioException.toString() + "\n" );
            ioException.printStackTrace();
         }

      }  // end while

   }  // end method waitForPackets

   // display packet contents
   private void displayPacket()
   {
      displayArea.append( "\nPacket received:" +
         "\nFrom host: " + receivePacket.getAddress() +
         "\nHost port: " + receivePacket.getPort() +
         "\nLength: " + receivePacket.getLength() +
         "\nContaining:\n\t" +
         new String( receivePacket.getData(), 0,
            receivePacket.getLength() ) );
   }

   // echo packet to client
   private void sendPacketToClient() throws IOException
   {
      displayArea.append( "\n\nEcho data to client..." );

      // create packet to send
      sendPacket = new DatagramPacket( receivePacket.getData(),
         receivePacket.getLength(), receivePacket.getAddress(),
         receivePacket.getPort() );

      // send packet
      socket.send( sendPacket );

      displayArea.append( "Packet sent\n" );
      displayArea.setCaretPosition( 
         displayArea.getText().length() );
   }

   // execute application
   public static void main( String args[] )
   {
      Server application = new Server();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );

      application.waitForPackets();
   }

}  // end class Server

/**************************************************************************
 * (C) Copyright 2002 by Deitel & Associates, Inc. and Prentice Hall.     *
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
