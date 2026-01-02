// Fig. 16.22: FileTest.java
// Demonstrating the File class.

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Java extension packages
import javax.swing.*;

public class FileTest extends JFrame
   implements ActionListener {

   private JTextField enterField;
   private JTextArea outputArea;
   
   // set up GUI
   public FileTest()
   {
      super( "Testing class File" );

      enterField = new JTextField(
         "Enter file or directory name here" );
      enterField.addActionListener( this );
      outputArea = new JTextArea();

      ScrollPane scrollPane = new ScrollPane();
      scrollPane.add( outputArea );

      Container container = getContentPane();
      container.add( enterField, BorderLayout.NORTH );
      container.add( scrollPane, BorderLayout.CENTER );

      setSize( 400, 400 );
      show();
   }

   // display information about file user specifies
   public void actionPerformed( ActionEvent actionEvent )
   {
      File name = new File( actionEvent.getActionCommand() );

      // if name exists, output information about it
      if ( name.exists() ) {
         outputArea.setText(
            name.getName() + " exists\n" +
            ( name.isFile() ? 
               "is a file\n" : "is not a file\n" ) +
            ( name.isDirectory() ? 
               "is a directory\n" : "is not a directory\n" ) +
            ( name.isAbsolute() ? "is absolute path\n" : 
               "is not absolute path\n" ) +
            "Last modified: " + name.lastModified() +
            "\nLength: " + name.length() +
            "\nPath: " + name.getPath() +
            "\nAbsolute path: " + name.getAbsolutePath() +
            "\nParent: " + name.getParent() );
         
         // output information if name is a file
         if ( name.isFile() ) {

            // append contents of file to outputArea
            try {
               BufferedReader input = new BufferedReader(
                  new FileReader( name ) );
               StringBuffer buffer = new StringBuffer();
               String text;
               outputArea.append( "\n\n" );
   
               while ( ( text = input.readLine() ) != null ) 
                  buffer.append( text + "\n" );
   
               outputArea.append( buffer.toString() );
            }

            // process file processing problems
            catch( IOException ioException ) {
               JOptionPane.showMessageDialog( this,
                  "FILE ERROR",
                  "FILE ERROR", JOptionPane.ERROR_MESSAGE );
            }
         }

         // output directory listing
         else if ( name.isDirectory() ) {
            String directory[] = name.list();
   
            outputArea.append( "\n\nDirectory contents:\n");
   
            for ( int i = 0; i < directory.length; i++ )
               outputArea.append( directory[ i ] + "\n" );
         }
      }

      // not file or directory, output error message
      else {
         JOptionPane.showMessageDialog( this,
            actionEvent.getActionCommand() + " Does Not Exist",
            "ERROR", JOptionPane.ERROR_MESSAGE );
      }       

   }  // end method actionPerformed

   // execute application
   public static void main( String args[] )
   {
      FileTest application = new FileTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class FileTest

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
