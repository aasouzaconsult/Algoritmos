/*
 * Created on 05/05/2004
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
// Fig. 12.10: ButtonTest.java
// Creating JButtons.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest extends JFrame {
   private JButton plainButton, fancyButton;

   public ButtonTest()
   {
	  super( "Testing Buttons" );

	  Container c = getContentPane();
	  c.setLayout( new FlowLayout() );

	  // create buttons
	  plainButton = new JButton( "Plain Button" );
	  c.add( plainButton );

	  Icon bug1 = new ImageIcon( "bug1.gif" );
	  Icon bug2 = new ImageIcon( "bug2.gif" );
	  fancyButton = new JButton( "Fancy Button", bug1 );
	  fancyButton.setRolloverIcon( bug2 );
	  c.add( fancyButton );

	  // create an instance of inner class ButtonHandler
	  // to use for button event handling 
	  ButtonHandler handler = new ButtonHandler();
	  fancyButton.addActionListener( handler );
	  plainButton.addActionListener( handler );

	  setSize( 275, 100 );
	  show();
   }

   public static void main( String args[] )
   { 
	  ButtonTest app = new ButtonTest();

	  app.addWindowListener(
		 new WindowAdapter() {
			public void windowClosing( WindowEvent e )
			{
			   System.exit( 0 );
			}
		 }
	  );
   }

   // inner class for button event handling
   private class ButtonHandler implements ActionListener {
	  public void actionPerformed( ActionEvent e )
	  {
		 JOptionPane.showMessageDialog( null,
			"Voce Precionou: " + e.getActionCommand() );
	  }
   }
}
