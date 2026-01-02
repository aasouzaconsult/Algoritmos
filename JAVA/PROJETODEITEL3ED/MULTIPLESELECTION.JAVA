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
// Fig. 12.15: MultipleSelection.java
// Copying items from one List to another.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultipleSelection extends JFrame {
   private JList colorList, copyList;
   private JButton copy;
   private String colorNames[] =
	  { "Black", "Blue", "Cyan", "Dark Gray", "Gray", 
		"Green", "Light Gray", "Magenta", "Orange", "Pink",
		"Red", "White", "Yellow" };

   public MultipleSelection()
   {
	  super( "Multiple Selection Lists" );

	  Container c = getContentPane();
	  c.setLayout( new FlowLayout() );

	  colorList = new JList( colorNames );
	  colorList.setVisibleRowCount( 5 );
	  colorList.setFixedCellHeight( 15 );
	  colorList.setSelectionMode(
		 ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
	  c.add( new JScrollPane( colorList ) );

	  // create copy button
	  copy = new JButton( "Copy >>>" );
	  copy.addActionListener(
		 new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			   // place selected values in copyList
			   copyList.setListData(
				  colorList.getSelectedValues() );
			}
		 }
	  );
	  c.add( copy );

	  copyList = new JList( );
	  copyList.setVisibleRowCount( 5 );
	  copyList.setFixedCellWidth( 100 );
	  copyList.setFixedCellHeight( 15 );
	  copyList.setSelectionMode(
		 ListSelectionModel.SINGLE_INTERVAL_SELECTION );
	  c.add( new JScrollPane( copyList ) );

	  setSize( 300, 120 );
	  show();
   }

   public static void main( String args[] )
   { 
	  MultipleSelection app = new MultipleSelection();

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
