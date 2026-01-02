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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Compras extends JFrame {
	private JList compreList, adicionaList;
	private JButton adicione;
	private String compreNames[ ] = 
			{ "Abacaxi", "Banana", "Goiaba", "Manga", "Melao", "Melancia", "Maca",
    		  "Pera", "Uva", "Laranja", "Tamarindo", "Abacate", "Mamao", "Uva Verde" , "Limao"  };
	
	public Compras()
	{
		super ( "Compras Fim de Semana" );
		
		Container c = getContentPane();
		c.setLayout ( new FlowLayout () );
		
		compreList = new JList ( compreNames );
		compreList.setVisibleRowCount( 5 );
		compreList.setFixedCellHeight  ( 15 );
		compreList.setSelectionMode(
			ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
		c.add ( new JScrollPane ( compreList ) );
		
		// cria o botao Comprar
		adicione = new JButton ( "Adiciona >>>" );
		adicione.addActionListener (
			new ActionListener() {
				public void actionPerformed ( ActionEvent e )
			{
				// coloca valores selecionados no adicionaList
				adicionaList.setListData (
		           compreList.getSelectedValues() );
    	    }
      }
  );
 c.add ( adicione );
 
 adicionaList = new JList();
 adicionaList.setVisibleRowCount( 5 );
 adicionaList.setFixedCellWidth ( 100 );
 adicionaList.setFixedCellHeight ( 15 );
 adicionaList.setSelectionMode (
 	ListSelectionModel.SINGLE_INTERVAL_SELECTION );
 c.add ( new JScrollPane ( adicionaList) );
 
 setSize ( 340, 300 );
 show();
 }
 
 public static void main ( String args[] )
 {
 	Compras app = new Compras();
 	
 	app.addWindowListener(
 		new WindowAdapter () {
 			public void windowClosing ( WindowEvent e )
 			{
 				System.exit( 1 );
 			}
 		}
 	); 
 }

}
