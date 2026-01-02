/*
 * Created on 06/05/2004
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
// Fig. 12.24: FlowLayoutDemo.java
// Demonstrating FlowLayout alignments.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlowLayoutDemo extends JFrame {
   private JButton left, center, right;
   private Container c;
   private FlowLayout layout;
   
   public FlowLayoutDemo()
   {
	  super( "FlowLayout Demo" );

	  layout = new FlowLayout();

	  c = getContentPane();
	  c.setLayout( layout );

	  left = new JButton( "Esquerda" );
	  left.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   layout.setAlignment( FlowLayout.LEFT );

			   // re-align attached components
			   layout.layoutContainer( c );
			}
		 }
	  );
	  c.add( left );

	  center = new JButton( "Centro" );
	  center.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   layout.setAlignment( FlowLayout.CENTER );

			   // re-align attached components
			   layout.layoutContainer( c );  
			}
		 }
	  );
	  c.add( center );

	  right = new JButton( "Direita" );
	  right.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   layout.setAlignment( FlowLayout.RIGHT );

			   // re-align attached components
			   layout.layoutContainer( c );  
			}
		 }
	  );
	  c.add( right );

	  setSize( 300, 75 );
	  show();
   }

   public static void main( String args[] )
   { 
	  FlowLayoutDemo app = new FlowLayoutDemo();

	  app.addWindowListener(
		 new WindowAdapter() {
			public void windowClosing( WindowEvent e )
			{
			   System.exit( 1 );
			}
		 }
	  );
   }
}