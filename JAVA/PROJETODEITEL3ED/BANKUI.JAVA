/*
 * Created on 12/05/2004
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
// Fig. 17.4: BankUI.java
// Uma GUI reutilizavel para os exemplos de contas bancarias
// package com.deitel.jhtp3.ch17;
import java.awt.*;
import javax.swing.*;

public class BankUI extends JPanel {
   protected final static String names[] = { "Account number",
	  "First name", "Last name", "Balance", 
	  "Transaction Amount" };
   protected JLabel labels[];
   protected JTextField fields[];
   protected JButton doTask, doTask2;
   protected JPanel innerPanelCenter, innerPanelSouth;
   protected int size = 4;
   public static final int ACCOUNT = 0, FIRST = 1, LAST = 2,
			   BALANCE = 3, TRANSACTION = 4;                           

   public BankUI()
   {
	  this( 4 );
   }

   public BankUI( int mySize )
   {
	  size = mySize;
	  labels = new JLabel[ size ];
	  fields = new JTextField[ size ];

	  for ( int i = 0; i < labels.length; i++ )
		 labels[ i ] = new JLabel( names[ i ] );
            
	  for ( int i = 0; i < fields.length; i++ )
		 fields[ i ] = new JTextField();

	  innerPanelCenter = new JPanel();
	  innerPanelCenter.setLayout( new GridLayout( size, 2 ) );

	  for ( int i = 0; i < size; i++ ) {
		 innerPanelCenter.add( labels[ i ] );
		 innerPanelCenter.add( fields[ i ] );
	  }
      
	  doTask = new JButton();
	  doTask2 = new JButton(); 
	  innerPanelSouth = new JPanel();      
	  innerPanelSouth.add( doTask2 );
	  innerPanelSouth.add( doTask );

	  setLayout( new BorderLayout() );
	  add( innerPanelCenter, BorderLayout.CENTER );
	  add( innerPanelSouth, BorderLayout.SOUTH );
	  validate();
   }

   public JButton getDoTask() { return doTask; }

   public JButton getDoTask2() { return doTask2; }

   public JTextField[] getFields() { return fields; }

   public void clearFields()
   {
	  for ( int i = 0; i < size; i++ )
		 fields[ i ].setText( "" );
   }

   public void setFieldValues( String s[] )
	  throws IllegalArgumentException
   {
	  if ( s.length != size )
		 throw new IllegalArgumentException( "There must be "
			+ size + " Strings in the array" );

	  for ( int i = 0; i < size; i++ )
		 fields[ i ].setText( s[ i ] );
   }

   public String[] getFieldValues()
   { 
	  String values[] = new String[ size ];

	  for ( int i = 0; i < size; i++ ) 
		 values[ i ] = fields[ i ].getText();

	  return values;
   }
}

