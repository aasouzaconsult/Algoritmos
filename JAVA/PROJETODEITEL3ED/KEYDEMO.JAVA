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
// Fig. 12.22: KeyDemo.java
// Demonstrating keystroke events.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyDemo extends JFrame implements KeyListener {
   private String line1 = "", line2 = "";
   private String line3 = "";
   private JTextArea textArea;

   public KeyDemo()
   {
	  super( "Demonstrating Keystroke Events" );

	  textArea = new JTextArea( 10, 15 );
	  textArea.setText( "Press any key on the keyboard..." );
	  textArea.setEnabled( false );

	  // allow frame to process Key events
	  addKeyListener( this );

	  getContentPane().add( textArea );  

	  setSize( 350, 100 );
	  show();
   }

   public void keyPressed( KeyEvent e )
   {
	  line1 = "Key pressed: " +
			   e.getKeyText( e.getKeyCode() );
	  setLines2and3( e );
   }

   public void keyReleased( KeyEvent e )
   {
	  line1 = "Key released: " +
			   e.getKeyText( e.getKeyCode() );
	  setLines2and3( e );
   }

   public void keyTyped( KeyEvent e )
   {
	  line1 = "Key typed: " + e.getKeyChar();
	  setLines2and3( e );
   }

   private void setLines2and3( KeyEvent e )
   {
	  line2 = "This key is " +
			  ( e.isActionKey() ? "" : "not " ) +
			  "an action key";

	  String temp = 
		 e.getKeyModifiersText( e.getModifiers() );

	  line3 = "Modifier keys pressed: " +
			  ( temp.equals( "" ) ? "none" : temp );

	  textArea.setText(
		 line1 + "\n" + line2 + "\n" + line3 + "\n" );
   }

   public static void main( String args[] )
   {
	  KeyDemo app = new KeyDemo();

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
