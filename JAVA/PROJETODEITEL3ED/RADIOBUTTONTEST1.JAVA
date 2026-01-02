/*
 * Created on 14/05/2004
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
// Fig. 12.12: RadioButtonTest.java
// Creating radio buttons using ButtonGroup and JRadioButton.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonTest1 extends JFrame {
   private JTextField t;
   private Font plainFont, boldFont,
				italicFont, boldItalicFont;
   private JRadioButton plain, bold, italic, boldItalic;
   private ButtonGroup radioGroup;

   public RadioButtonTest1()
   {
	  super( "RadioButton Test" );

	  Container c = getContentPane();
	  c.setLayout( new FlowLayout() );

	  t = new JTextField( "Programando em Java SUN", 45 );
	  c.add( t ); 

	  // Criando radio buttons
	  plain = new JRadioButton( "Plain", true );
	  c.add( plain );
	  bold = new JRadioButton( "Bold", false);
	  c.add( bold );
	  italic = new JRadioButton( "Italic", false );
	  c.add( italic );
	  boldItalic = new JRadioButton( "Bold/Italic", false );
	  c.add( boldItalic );

	  // registrando os  eventos
	  RadioButtonHandler handler = new RadioButtonHandler();
	  plain.addItemListener( handler );
	  bold.addItemListener( handler );
	  italic.addItemListener( handler );
	  boldItalic.addItemListener( handler );

	  // criando o relacionamento logico entre JRadioButtons
	  radioGroup = new ButtonGroup();
	  radioGroup.add( plain );
	  radioGroup.add( bold );
	  radioGroup.add( italic );
	  radioGroup.add( boldItalic );

	  plainFont = new Font( "TimesRoman", Font.PLAIN, 14 );
	  boldFont = new Font( "TimesRoman", Font.BOLD, 14 );
	  italicFont = new Font( "TimesRoman", Font.ITALIC, 14 );
	  boldItalicFont =
		 new Font( "TimesRoman", Font.BOLD + Font.ITALIC, 14 );
	  t.setFont( plainFont );

	  setSize( 300, 100 );
	  show();
   }

   public static void main( String args[] )
   {
	  RadioButtonTest app = new RadioButtonTest();

	  app.addWindowListener(
		 new WindowAdapter() {
			public void windowClosing( WindowEvent e )
			{
			   System.exit( 0 );
			}
		 }
	  );
   }

   private class RadioButtonHandler implements ItemListener {
	  public void itemStateChanged( ItemEvent e )
	  {
		 if ( e.getSource() == plain ) 
			t.setFont( plainFont );
		 else if ( e.getSource() == bold ) 
			t.setFont( boldFont );
		 else if ( e.getSource() == italic ) 
			t.setFont( italicFont );
		 else if ( e.getSource() == boldItalic ) 
			t.setFont( boldItalicFont );

		 t.repaint();
	  }
   }
}
