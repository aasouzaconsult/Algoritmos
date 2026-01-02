/*
 * TransactionProcessor.java
 *
 * Created on 3 de Junho de 2004, 11:41
 */

/**
 *
 * @author  claudemir
 */

// Programa de Processamento de transacoes que usa RandomAccessFiles.
// Esse programa le um arquivo de acesso aleatorio sequencialmente,
// atualiza registros ja gravados no arquivo, cria novo
// registro para ser colocado no arquivo e exclui dados
// ja existente no arquivo.
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class TransactionProcessor extends JFrame  {   
   private JDesktopPane desktop;
   private JButton open, updateRecord, newRecord, deleteRecord;
   private JInternalFrame mainDialog;
   private UpdateDialog updateDialog;
   private NewDialog newDialog;
   private DeleteDialog deleteDialog;
   private RandomAccessFile file;  
   private Record record1;  
   
   public TransactionProcessor()
   {
      super( "Transaction Processor" );

      desktop = new JDesktopPane();
      
      mainDialog = new JInternalFrame();
      updateRecord = new JButton( "Update Record" );
      updateRecord.setEnabled( false );
      updateRecord.addActionListener( 
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               mainDialog.setVisible( false );
               updateDialog.setVisible( true );              
            }
         }
      );
      
      deleteRecord = new JButton( "Delete Record" );
      deleteRecord.setEnabled( false );
      deleteRecord.addActionListener( 
         new ActionListener() {            
            public void actionPerformed( ActionEvent e )
            {
               mainDialog.setVisible( false );
               deleteDialog.setVisible( true );              
            }
         }
      );

      newRecord = new JButton( "New Record" );
      newRecord.setEnabled( false );
      newRecord.addActionListener( 
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               mainDialog.setVisible( false );
               newDialog.setVisible( true );              
            }
         }
      );

      open = new JButton( "New/Open File" );
      open.addActionListener( 
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               open.setEnabled( false );
               openFile();
               ActionListener l = new ActionListener() {
                  public void actionPerformed( ActionEvent e )
                               
                  {
                     mainDialog.setVisible( true );              
                  }
               };       
               updateDialog = new UpdateDialog( file, l );
               desktop.add( updateDialog );
               updateRecord.setEnabled( true );
               
               deleteDialog = new DeleteDialog( file, l );  
               desktop.add ( deleteDialog );
               deleteRecord.setEnabled( true );
               
               newDialog = new NewDialog( file, l );
               desktop.add( newDialog );
               newRecord.setEnabled( true );
               
            }
         }
      );

      Container c = mainDialog.getContentPane();
      c.setLayout( new GridLayout( 2, 2 ) );
      c.add( updateRecord );
      c.add( newRecord );
      c.add( deleteRecord );
      c.add( open );

      setSize( 400, 250  );
      mainDialog.setSize( 300, 80 );
      desktop.add( mainDialog, BorderLayout.CENTER );      
      getContentPane().add( desktop );
      addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               if ( file != null )
                  closeFile();

               System.exit( 0 );
            }
         }
      );
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
            file = new RandomAccessFile( fileName, "rw" );
            updateRecord.setEnabled( true );
            newRecord.setEnabled( true );
            deleteRecord.setEnabled( true );
            open.setEnabled( false );
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
         file.close();
         System.exit( 0 );
      }
      catch( IOException ex ) {
         JOptionPane.showMessageDialog( this,
            "Error closing file",
            "Error", JOptionPane.ERROR_MESSAGE );
         System.exit( 1 );
      }
   }
  
   public static void main( String args[] )
   { 
      new TransactionProcessor();
   }
}

class UpdateDialog extends JInternalFrame {
   private RandomAccessFile file;  
   private BankUI userInterface;
   private JButton cancel, save;
   private JTextField account;

   public UpdateDialog( RandomAccessFile f, ActionListener l )
   {
      super( "Update Record" );

      file = f;
      userInterface = new BankUI( 5 );

      cancel = userInterface.getDoTask();
      cancel.setText( "Cancel" );
      cancel.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               setVisible( false );
               userInterface.clearFields();     
            }
         }
      );
      cancel.addActionListener( l );
  
      save = userInterface.getDoTask2();
      save.setText( "Save Changes" );
      save.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               addRecord( getRecord() );
               setVisible( false );  
               userInterface.clearFields();            
            }
         }      
      );
      save.addActionListener( l );

      JTextField transaction = 
         userInterface.getFields()[ BankUI.TRANSACTION ];
      transaction.addActionListener(
           new ActionListener() {
              public void actionPerformed( ActionEvent e )
              {
                 try {
                    Record record1 = getRecord();
                    double change = Double.parseDouble( 
                             userInterface.getFieldValues()
                             [ BankUI.TRANSACTION ] );
                    String[] values = {
                        String.valueOf( record1.getAccount() ),
                        record1.getFirstName(),
                        record1.getLastName(),
                        String.valueOf( record1.getBalance()
                                        + change ),
                        "Charge(+) or payment (-)" };

                     userInterface.setFieldValues( values );
                 }
                 catch ( NumberFormatException nfe ) {
                    JOptionPane.showMessageDialog( new JFrame(),
                       "Invalid Transaction",
                       "Invalid Number Format",
                       JOptionPane.ERROR_MESSAGE );
                 }
              }
           }
      );

      account = userInterface.getFields()[ BankUI.ACCOUNT ];
      account.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               Record record1 = getRecord();

               if ( record1.getAccount() != 0 )  {
                  String values[] = {
                     String.valueOf( record1.getAccount() ),
                     record1.getFirstName(),
                     record1.getLastName(),
                     String.valueOf( record1.getBalance() ),
                     "Charge(+) or payment (-)" };
                     userInterface.setFieldValues( values ); 
                  }       
               }
            }
      );
      getContentPane().add( userInterface,
                            BorderLayout.CENTER );
      setSize( 300, 175 );
      setVisible( false );
   }

   private Record getRecord() 
   {
      Record record1 = new Record();

      try {
         int accountNumber = Integer.parseInt(
                                     account.getText() );

         if ( accountNumber < 1 || accountNumber > 100 ) {
            JOptionPane.showMessageDialog( this,
                 "Account Does Not Exist",
                 "Error", JOptionPane.ERROR_MESSAGE );
            return( record );
         }

         file.seek( ( accountNumber - 1 ) * Record.size() );
         record.read( file );
      
         if ( record.getAccount() == 0 )
            JOptionPane.showMessageDialog( this,
               "Account Does Not Exist",
               "Error", JOptionPane.ERROR_MESSAGE ); 
      }
      catch ( NumberFormatException nfe ) {
         JOptionPane.showMessageDialog( this,
            "Invalid Account",
            "Invalid Number Format",
            JOptionPane.ERROR_MESSAGE );
      }
      catch ( IOException io ) {
         JOptionPane.showMessageDialog( this,
            "Error Reading File",
            "Error", JOptionPane.ERROR_MESSAGE );
      }

      return record;
   }

   public void addRecord( Record record1 )
   {
      try {
         int accountNumber = record.getAccount();

         file.seek( ( accountNumber - 1 ) * Record.size() );             
         String[] values = userInterface.getFieldValues();                           
         record.write( file );
      }
      catch ( IOException io ) {
         JOptionPane.showMessageDialog( this,
            "Error Writing To File",
            "Error", JOptionPane.ERROR_MESSAGE );
      }
      catch ( NumberFormatException nfe ) {
         JOptionPane.showMessageDialog( this,
         "Bad Balance",
         "Invalid Number Format",
         JOptionPane.ERROR_MESSAGE );
      }
   }
}

class NewDialog extends JInternalFrame  {
   private RandomAccessFile file;  
   private BankUI userInterface;
   private JButton cancel, save;
   private JTextField account;

   public NewDialog( RandomAccessFile f, ActionListener l )
   {
      super( "New Record" );

      file = f;
      userInterface = new BankUI();

      cancel = userInterface.getDoTask();
      cancel.setText( "Cancel" );
      cancel.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e ) 
            {
              setVisible( false ); 
              userInterface.clearFields();
            }  
         } 
      );
      cancel.addActionListener( l );

      account = userInterface.getFields()[ BankUI.ACCOUNT ];
      save = userInterface.getDoTask2();
      save.setText( "Save Changes" );
      save.addActionListener(
           new ActionListener() {
              public void actionPerformed( ActionEvent e ) 
              {
                 addRecord( getRecord() );
                 setVisible( false ); 
                 userInterface.clearFields(); 
              }  
           }
      );
      save.addActionListener( l );

      getContentPane().add( userInterface,
                            BorderLayout.CENTER );
      setSize( 300, 150 );
      setVisible( false );
   }

   private Record getRecord() 
   {
      Record record = new Record();

      try {
         int accountNumber = Integer.parseInt(
                                     account.getText() );

         if ( accountNumber < 1 || accountNumber > 100 ) {
            JOptionPane.showMessageDialog( this,
               "Account Does Not Exist",
               "Error", JOptionPane.ERROR_MESSAGE );
            return record;
         }

         file.seek( ( accountNumber - 1 ) * Record.size() );
         record.read( file );
      }
      catch ( NumberFormatException nfe ) {
         JOptionPane.showMessageDialog( this,
            "Account Does Not Exist",
            "Invalid Number Format",
            JOptionPane.ERROR_MESSAGE );
      }
      catch ( IOException io ) {
         JOptionPane.showMessageDialog( this,
            "Error Reading File",
            "Error", JOptionPane.ERROR_MESSAGE );
       }

       return record;
   }

   public void addRecord( Record record )
   {
      int accountNumber = 0;
      String[] fields = userInterface.getFieldValues();
      
      if ( record.getAccount() != 0 ) {
         JOptionPane.showMessageDialog( this,
            "Record Already Exists",
            "Error", JOptionPane.ERROR_MESSAGE );
         return;
      }

      // output the values to the file
      try {
         accountNumber =
            Integer.parseInt( fields[ BankUI.ACCOUNT ] );
         record.setAccount( accountNumber  );
         record.setFirstName( fields[ BankUI.FIRST ] );
         record.setLastName( fields[ BankUI.LAST ] );
         record.setBalance( Double.parseDouble(
                            fields[ BankUI.BALANCE ] ) );
         file.seek( ( accountNumber - 1 ) * Record.size() );
         record.write( file );
      } 
      catch ( NumberFormatException nfe ) {
         JOptionPane.showMessageDialog( this,
            "Invalid Balance",
            "Invalid Number Format", 
            JOptionPane.ERROR_MESSAGE );
      }
      catch ( IOException io ) {
         JOptionPane.showMessageDialog( this,
            "Error Writing To File",
            "Error", JOptionPane.ERROR_MESSAGE );
      }
   }
}


class DeleteDialog extends JInternalFrame {
   private RandomAccessFile file;  // file for output
   private BankUI userInterface;
   private JButton cancel, delete;
   private JTextField account;

   public DeleteDialog( RandomAccessFile f, ActionListener l )
   {
      super( "Delete Record" );

      file = f;
      userInterface = new BankUI( 1 );

      cancel = userInterface.getDoTask();
      cancel.setText( "Cancel" );
      cancel.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e ) 
            {
               setVisible( false );   
            }   
         }
      );
      cancel.addActionListener( l );
  
      delete = userInterface.getDoTask2();
      delete.setText( "Delete Record" );
      delete.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
              addRecord( getRecord() );      
              setVisible( false );  
              userInterface.clearFields();  
            }  
         }      
      );
      delete.addActionListener( l );

      account = userInterface.getFields()[ BankUI.ACCOUNT ];
      account.addActionListener( 
         new ActionListener() {
            public void actionPerformed( ActionEvent e )  
            {
               Record record = getRecord(); 
            }   
         }
      );
      getContentPane().add( userInterface,
                            BorderLayout.CENTER );

      setSize( 300, 100 );
      setVisible( false );
   }

   private Record getRecord() 
   {
      Record record = new Record();

      try {
         int accountNumber = Integer.parseInt(
                                     account.getText() );
         if ( accountNumber < 1 || accountNumber > 100 ) {
            JOptionPane.showMessageDialog( this,
               "Account Does Not Exist",
               "Error", JOptionPane.ERROR_MESSAGE );
            return( record );
         }

         file.seek( ( accountNumber - 1 ) * Record.size() );
         record.read( file );
      
         if ( record.getAccount() == 0 )
            JOptionPane.showMessageDialog( this,
               "Account Does Not Exist",
               "Error", JOptionPane.ERROR_MESSAGE );
      }
      catch ( NumberFormatException nfe ) {
         JOptionPane.showMessageDialog( this,
            "Account Does Not Exist",
            "Invalid Number Format",
            JOptionPane.ERROR_MESSAGE );
      }
      catch ( IOException io ) {
        JOptionPane.showMessageDialog( this,
           "Error Reading File",
           "Error", JOptionPane.ERROR_MESSAGE );
      }

      return record;
   }

   public void addRecord( Record record1 )
   {
      if ( record.getAccount() == 0 )
         return;

      try {

         int accountNumber = record.getAccount();

         file.seek( ( accountNumber - 1 ) * Record.size() );
         record.setAccount( 0 );
         record.write( file );
      }
      catch ( IOException io ) {
         JOptionPane.showMessageDialog( this,
            "Error Writing To File",
            "Error", JOptionPane.ERROR_MESSAGE );
      }
   }
}