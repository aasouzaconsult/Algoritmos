/*
 * Created on 17/05/2004
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
// Fig. 17.4: CreateSequentialFile.java
// Demonstrando saida de objeto com a classe  ObjectOutputStream.
// Os objetos sao gravados sequencialmente em um arquivo
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreateSequentialFile extends JFrame {

   private ObjectOutputStream output;
   private BankUI userInterface;
   private JButton enter, open;

   public CreateSequentialFile()
   {
	  super( "Creating a Sequential File of Objects" );

	  getContentPane().setLayout( new BorderLayout() );
	  userInterface = new BankUI();
      
	  enter = userInterface.getDoTask();
	  enter.setText( "Enter" );
	  enter.setEnabled( false );  // disable button to start
	  enter.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   addRecord();
			}
		 }
	  );

	  addWindowListener(
		 new WindowAdapter() {
			public void windowClosing( WindowEvent e )
			{
			   if ( output != null ) {
				  addRecord();
				  closeFile();
			   }
			   else
				  System.exit( 0 );
			}
		 }
	  );
	  open = userInterface.getDoTask2();

	  open.setText( "Save As" );
	  open.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   openFile();
			}
		 }
	  );
	  getContentPane().add( userInterface, BorderLayout.CENTER );

	  setSize( 350, 200 );
	  show();
   }

   private void openFile()
   {
	  JFileChooser fileChooser = new JFileChooser();
	  fileChooser.setFileSelectionMode(
		 JFileChooser.FILES_ONLY );
      
	  int result = fileChooser.showSaveDialog( this );

	  // O usuario clicou no botao Cancel do dialogo
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
		 // Abre o arquivo
		 try {
			output = new ObjectOutputStream(
						new FileOutputStream( fileName ) );
			open.setEnabled( false );
			enter.setEnabled( true );
		 }
		 catch ( IOException e ) {
			JOptionPane.showMessageDialog( this,
			   "Error Opening File", "Error",
			   JOptionPane.ERROR_MESSAGE );
		 }      
	  }
   }

   private void closeFile() 
   {
	  try {
		 output.close();
		 System.exit( 0 );
	  }
	  catch( IOException ex ) {
		 JOptionPane.showMessageDialog( this,
			"Error closing file",
			"Error", JOptionPane.ERROR_MESSAGE );
		 System.exit( 1 );
	  }
   }

   public void addRecord()
   {
	  int accountNumber = 0;
	  BankAccountRecord record;
	  String fieldValues[] = userInterface.getFieldValues();
     
	  // Se o valor do campo account nao estiver vazio
	  if ( ! fieldValues[ 0 ].equals( "" ) ) {
		 // envia a saida dos valores para o arquivo
		 try {
			accountNumber =
			   Integer.parseInt( fieldValues[ 0 ] );

			if ( accountNumber > 0 ) {
			   record = new BankAccountRecord(
				  accountNumber, fieldValues[ 1 ],
				  fieldValues[ 2 ],
				  Double.parseDouble( fieldValues[ 3 ] ) );
			   output.writeObject( record );
			   output.flush();
			}

			// limpa os  TextFields
			userInterface.clearFields();
		 }
		 catch ( NumberFormatException nfe ) {
			JOptionPane.showMessageDialog( this,
			   "Bad account number or balance",
			   "Invalid Number Format",
			   JOptionPane.ERROR_MESSAGE );
		 }
		 catch ( IOException io ) {
			closeFile();
		 }
	  }
   }

   public static void main( String args[] )
   {
	  new CreateSequentialFile();
   }
}
