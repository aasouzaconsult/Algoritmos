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
// Fig. 12.14: ListTest.java
// Selecting colors from a JList.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListTest extends JFrame {
   private JList colorList;
   private Container c;
 
   private String colorNames[] =
	  { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green",
		"Light Gray", "Magenta", "Orange", "Pink", "Red",
		"White", "Yellow" };

   private Color colors[] =
	  { Color.black, Color.blue, Color.cyan, Color.darkGray,
		Color.gray, Color.green, Color.lightGray,
		Color.magenta, Color.orange, Color.pink, Color.red,
		Color.white, Color.yellow };

   public ListTest()
   {
	  super( "List Test" );

	  c = getContentPane();
	  c.setLayout( new FlowLayout() );

	  // create a list with the items in the colorNames array
	  colorList = new JList( colorNames );
	  colorList.setVisibleRowCount( 5 );
      
	  // do not allow multiple selections
	  colorList.setSelectionMode(
		 ListSelectionModel.SINGLE_SELECTION );

	  // add a JScrollPane containing the JList
	  // to the content pane
	  c.add( new JScrollPane( colorList ) );

	  // set up event handler
	  colorList.addListSelectionListener(
		 new ListSelectionListener() {
			public void valueChanged( ListSelectionEvent e )  
			{
			   c.setBackground(
				  colors[ colorList.getSelectedIndex() ] );
			}
		 }
	  );

	  setSize( 350, 150 );
	  show();
   }

   public static void main( String args[] )
   { 
	  ListTest app = new ListTest();

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