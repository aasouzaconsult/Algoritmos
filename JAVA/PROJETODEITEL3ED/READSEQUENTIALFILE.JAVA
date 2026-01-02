/*
 * Created on 19/05/2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author claudemir
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
// Fig. 17.6: ReadSequentialFile.java
// This program reads a file of objects sequentially
// and displays each record.
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import com.deitel.jhtp3.ch17.*;

public class ReadSequentialFile extends JFrame {
   private ObjectInputStream input;
   private BankUI userInterface;
   private JButton nextRecord, open;

   // Constructor -- initialize the Frame 
   public ReadSequentialFile()
   {
	  super( "Reading a Sequential File of Objects" );

	  getContentPane().setLayout( new BorderLayout() );
	  userInterface = new BankUI();
	  nextRecord = userInterface.getDoTask();
	  nextRecord.setText( "Next Record" );
	  nextRecord.setEnabled( false );  
 
	  nextRecord.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{               
			   readRecord();
			}
		 }
	  );
 
	  addWindowListener(
		 new WindowAdapter() {
			public void windowClosing( WindowEvent e )
			{
			   if ( input != null )
				  closeFile();

			   System.exit( 0 );
			}
		 }
	  ); 
	  open = userInterface.getDoTask2();

	  open.setText( "Open File" );
	  open.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   openFile();
			}
		 }
	  );
      
	  getContentPane().add( userInterface, BorderLayout.CENTER );
	  pack();
	  setSize( 300, 200 );
	  show();
   }

   private void openFile()
   {
	  JFileChooser fileChooser = new JFileChooser();

	  fileChooser.setFileSelectionMode(
		 JFileChooser.FILES_ONLY );
	  int result = fileChooser.showOpenDialog( this );
 
	  // user clicked Cancel button on dialog
	  if ( result == JFileChooser.CANCEL_OPTION )
		 return;

	  File fileName = fileChooser.getSelectedFile();
 
	  if ( fileName == null ||
		   fileName.getName().equals( "" ) )
		 JOptionPane.showMessageDialog( this,
			"Invalid File Name",
			"Invalid File Name",
			JOptionPane.ERROR_MESSAGE );
	  else {
		 // Open the file
		 try {
			input = new ObjectInputStream(
						new FileInputStream( fileName ) );
			open.setEnabled( false );
			nextRecord.setEnabled( true );
		 }
		 catch ( IOException e ) {
			JOptionPane.showMessageDialog( this,
			   "Error Opening File", "Error",
			   JOptionPane.ERROR_MESSAGE );
		 }      
	  }
   }

   public void readRecord()
   {
	  BankAccountRecord record;

	  // input the values from the file
	  try {
		 record = ( BankAccountRecord ) input.readObject();
		 String values[] = {
			String.valueOf( record.getAccount() ),
			record.getFirstName(),
			record.getLastName(),
			String.valueOf( record.getBalance() ) };
		 userInterface.setFieldValues( values );
	  }
	  catch ( EOFException eofex ) {
		 nextRecord.setEnabled( false );
		 JOptionPane.showMessageDialog( this,
			"No more records in file",
			"End of File", JOptionPane.ERROR_MESSAGE );
	  }
	  catch ( ClassNotFoundException cnfex ) {
		 JOptionPane.showMessageDialog( this,
			"Unable to create object",
			"Class Not Found", JOptionPane.ERROR_MESSAGE );
	  }
	  catch ( IOException ioex ) {
		 JOptionPane.showMessageDialog( this,
			"Error during read from file",
			"Read Error", JOptionPane.ERROR_MESSAGE );
	  }
   }

   private void closeFile()
   {
	  try {
		 input.close();
		 System.exit( 0 );
	  }
	  catch ( IOException e ) {
		 JOptionPane.showMessageDialog( this,
			"Error closing file",
			"Error", JOptionPane.ERROR_MESSAGE );
		 System.exit( 1 );
	  }
   }

   public static void main( String args[] )
   {
	  new ReadSequentialFile();
   }
}
