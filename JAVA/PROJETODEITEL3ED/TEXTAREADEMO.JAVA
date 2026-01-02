/*
 * Created on 07/05/2004
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextAreaDemo extends JFrame {
	private JTextArea a1, a2;
	private JButton copiar;
	
	public TextAreaDemo()
	{
		super ("Testando a Area");
		
		Box b = Box.createHorizontalBox();
		
		String s = "Esta eh uma demonstracao de String to\n" +
		                 "ilustra a copia do texto descrito to\n" +
		                 "passando de uma area a outra\n";
		                 
		a1 = new JTextArea ( s, 10, 15 );
		b.add( new JScrollPane( a1  ) );
		
		copiar = new JButton ( "Copia >>>" );
		copiar.addActionListener (
			new ActionListener() {
				public void actionPerformed ( ActionEvent e )
				{
					a2.setText ( a1.getSelectedText() );
				}
			}
		);
		b.add ( copiar );
		
		a2 = new JTextArea ( 10, 15 );
		a2.setEditable ( false );
		b.add ( new JScrollPane ( a2 ) );
		
		Container c = getContentPane ();
		c.add( b ); // Caixa colocada na BoderLayout.CENTER
		setSize ( 450, 200 );
		show ();
	}
	
	public static void main(String args[])
	{
		TextAreaDemo app = new TextAreaDemo ();
		
		app.addWindowListener (
			new WindowAdapter () {
				public void windowClosing ( WindowEvent e) 
				{
					System.exit ( 1 );
				}
			}
		); 
	}	
}

