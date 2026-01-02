/*
 * Created on 24/05/2004
 *
 * Este exemplo tem como objetivo apresentar ao aluno  alguns componentes do 
 * GridBagLayout 
 * 
 * */

/**
 * @author claudemir
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
// Fig. 13.17: GridBagDemo.java
// Demonstrating GridBagLayout.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridBagDemo extends JFrame { 
   private Container container;
   private GridBagLayout gbLayout;
   private GridBagConstraints gbConstraints; 
    
   public GridBagDemo()
   {
	  super( "Demonstrando GridBagLayout" );

	  container = getContentPane();
	  gbLayout = new GridBagLayout();
	  container.setLayout( gbLayout );   

	  //  instancia as limitacoes do  gridbag 
	  gbConstraints = new GridBagConstraints();

	  JTextArea ta = new JTextArea( "TextArea1", 5, 10 );
	  JTextArea tx = new JTextArea( "TextArea2", 2, 2 );
	  String names[] = { "Claudemir", "Nilon", "LuciElder","Alexandre","PauloCesar","MarcosAugusto" };
	  JComboBox cb = new JComboBox( names );
	  JTextField tf = new JTextField( "TextField" );
	  JButton b1 = new JButton( "Botao 1" );
	  JButton b2 = new JButton( "Botao 2" );
	  JButton b3 = new JButton( "Botao 3" );

	  // area de texto
	  // weightx e weighty sao ambos 0: o default
	  // anchor para todos os componentes CENTER: o default
	  gbConstraints.fill = GridBagConstraints.BOTH;
	  addComponent( ta, 0, 0, 1, 3 );    
       
	  // button b1
	  // weightx and weighty sao ambos 0: o default
	  gbConstraints.fill = GridBagConstraints.HORIZONTAL;
	  addComponent( b1, 0, 1, 2, 1 );
      
	  // combo box
	  // weightx and weighty sao ambos 0: o default
	  // fill eh HORIZONTAL
	  addComponent( cb, 2, 1, 2, 1 );             

	  // button b2
	  gbConstraints.weightx = 1000;  // pode crescer na largura (can grow wider)
	  gbConstraints.weighty = 1;     // pode crescer na altura (can grow taller)
	  gbConstraints.fill = GridBagConstraints.BOTH;
	  addComponent( b2, 1, 1, 1, 1 );
       
	  // button b3
	  // fill eh BOTH
	  gbConstraints.weightx = 0;
	  gbConstraints.weighty = 0;    
	  addComponent( b3, 1, 2, 1, 1 );
       
	  // textfield
	  // weightx and weighty sao ambos 0: o default
	  addComponent( tf, 3, 0, 2, 1 );

	  // textarea
	  // weightx and weighty sao ambos 0: o default
	  addComponent( tx, 3, 2, 1, 1 );

	  setSize( 300, 150 );
	  show();
   }

   // addComponent eh definido pelo programador 
   private void addComponent( Component c,
	  int row, int column, int width, int height )
   {
	  // configura gridx and gridy 
	  gbConstraints.gridx = column;
	  gbConstraints.gridy = row;

	  // configura gridwidth and gridheight
	  gbConstraints.gridwidth = width;   
	  gbConstraints.gridheight = height;

	  // configura constraints
	  gbLayout.setConstraints( c, gbConstraints );  
	  container.add( c );      // adiciona os componentes (add component) 
   }

   public static void main( String args[] )
   {
	  GridBagDemo app = new GridBagDemo();

	  app.addWindowListener(
		 new WindowAdapter() {
			public void windowClosing( WindowEvent e )
			{
			   System.exit( 0 );
			}
		 }
	  );
   }
}
