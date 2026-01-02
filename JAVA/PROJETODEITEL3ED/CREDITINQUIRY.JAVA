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
// Fig. 17.7: CreditInquiry.java
// This program reads a file sequentially and displays the
// contents in a text area based on the type of account the
// user requests (credit balance, debit balance or
// zero balance).
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
//import com.deitel.jhtp3.ch17.BankAccountRecord;

public class CreditInquiry extends JFrame {  
   private JTextArea recordDisplay;
   private JButton open, done, credit, debit, zero;
   private JPanel buttonPanel;         
   // Quando queremos ler ou gravar um objeto inteiro em um arquivo, as classes
   // ObjectInputStream e ObjectUotputStream que implementam respectivamente as 
   // interfaces ObjectInput e ObjectOutput,sao utilizadas para esse proposito.  
   private ObjectInputStream input; 
   private FileInputStream fileInput;
   private File fileName;
   private String accountType;

   public CreditInquiry()
   {
	  super( "Credit Inquiry Program" );

	  Container c = getContentPane();
	  c.setLayout( new BorderLayout() );      
	  buttonPanel = new JPanel();
      
	  open = new JButton( "Open File" );
	  open.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   openFile( true );
			}
		 }
	  );
	  buttonPanel.add( open );

	  credit = new JButton( "Credit balances" );
	  credit.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   accountType = e.getActionCommand();
			   readRecords();
			}
		 }
	  );
	  buttonPanel.add( credit );

	  debit = new JButton( "Debit balances" );
	  debit.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   accountType = e.getActionCommand();
			   readRecords();
			}
		 }
	  );
	  buttonPanel.add( debit );

	  zero = new JButton( "Zero balances" );
	  zero.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   accountType = e.getActionCommand();
			   readRecords();
			}
		 }
	  );
	  buttonPanel.add( zero );

	  done = new JButton( "Done" );
	  buttonPanel.add( done );
	  done.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   if ( fileInput != null )     
				  closeFile();

			   System.exit( 0 );
			}
		 }
	  );

	  recordDisplay = new JTextArea();
	  JScrollPane scroller = new JScrollPane( recordDisplay );      
	  c.add( scroller, BorderLayout.CENTER );
	  c.add( buttonPanel, BorderLayout.SOUTH );

	  credit.setEnabled( false );
	  debit.setEnabled( false );
	  zero.setEnabled( false );

	  pack();
	  setSize( 600, 250 );
	  show();
   }

   private void openFile( boolean firstTime )
   {
	  if ( firstTime ) {
		 JFileChooser fileChooser = new JFileChooser();

		 fileChooser.setFileSelectionMode(
			JFileChooser.FILES_ONLY );
		 int result = fileChooser.showOpenDialog( this );

		 // user clicked Cancel button on dialog
		 if ( result == JFileChooser.CANCEL_OPTION )
			return;

		 fileName = fileChooser.getSelectedFile();
	  }

	  if ( fileName == null ||
		   fileName.getName().equals( "" ) )
		 JOptionPane.showMessageDialog( this,
			"Invalid File Name",
			"Invalid File Name",
			JOptionPane.ERROR_MESSAGE );
	  else {
		 // Open the file
		 try {
			// close file from previous operation
			if ( input != null )  
			   input.close();   

			fileInput = new FileInputStream( fileName );
			input = new ObjectInputStream( fileInput );
			open.setEnabled( false );
			credit.setEnabled( true );
			debit.setEnabled( true );
			zero.setEnabled( true );
		 }
		 catch ( IOException e ) {
			JOptionPane.showMessageDialog( this,
			   "File does not exist",
			   "Invalid File Name",
			   JOptionPane.ERROR_MESSAGE );
		 }      
	  }
   }
  
   private void closeFile()
   {
	  try {
		 input.close();
	  }
	  catch ( IOException ioe ) {
		 JOptionPane.showMessageDialog( this,
			"Error closing file",
			"Error", JOptionPane.ERROR_MESSAGE );
		 System.exit( 1 );
	  }
   }

   private void readRecords()
   {      
	  BankAccountRecord record;
	  DecimalFormat twoDigits = new DecimalFormat( "0.00" );
	  openFile( false );

	  try {   
		 recordDisplay.setText( "The accounts are:\n" );

		 // input the values from the file
		 while ( true ) {
			record =
			   ( BankAccountRecord ) input.readObject();

			if ( shouldDisplay( record.getBalance() ) )
			   recordDisplay.append( record.getAccount() +
				  "\t" + record.getFirstName() + "\t" +                  
				  record.getLastName() + "\t" +
				  twoDigits.format( record.getBalance() ) +
				  "\n" );
		 }            
	  }
	  catch ( EOFException eof ) {
		 closeFile();
	  }
	  catch ( ClassNotFoundException cnfex ) {
		 JOptionPane.showMessageDialog( this,
			"Unable to create object",
			"Class Not Found", JOptionPane.ERROR_MESSAGE );
	  }
	  catch ( IOException e ) {
		 JOptionPane.showMessageDialog( this,
			"Error reading from file",
			"Error", JOptionPane.ERROR_MESSAGE );
	  }
   }

   private boolean shouldDisplay( double balance )
   {
	  if ( accountType.equals( "Credit balances" ) &&
		   balance < 0 )
		 return true;
	  else if ( accountType.equals( "Debit balances" ) &&
				balance > 0 )
		 return true;
	  else if ( accountType.equals( "Zero balances" ) &&
				balance == 0 )
		 return true;

	  return false;
   }
   
   public static void main( String args[] )
   {
	  final CreditInquiry app = new CreditInquiry();

	  app.addWindowListener(
		 new WindowAdapter() {
			public void windowClosing( WindowEvent e )
			{
			   app.closeFile();
			   System.exit( 0 );
			}
		 }
	  );
   }
}
