import java.awt.*;
import java.awt.Graphics;
import java.util.*;
import java.text.DateFormat;
import java.awt.event.*;
import MessageBox;

public class Thread2 extends Frame implements ActionListener,Runnable, WindowListener
{

 	 Scrollbar scrollbar1;
 	 Scrollbar scrollbar2;
	 Button btnOk;
   Label lbTitulo;
	 Panel pnSaida;			
	 MessageBox mensagem; 

	Thread threadSb1,threadSb2;

	Thread2 () {
	
		super ("Utilização de threads");	
		setLayout(null);
		setSize(400,300);
        	setBackground(Color.gray);

		pnSaida = new Panel();
		pnSaida.setBounds(20,20,330,40);
		pnSaida.setBackground(Color.yellow);
		add(pnSaida);	

		lbTitulo = new Label("Corrida dos Scrollbars");
		lbTitulo.setBounds(170,25,200,40);
		pnSaida.add(lbTitulo);

		scrollbar1 = new Scrollbar(Scrollbar.HORIZONTAL,1,1,1,100);
		scrollbar1.setBounds(50,120,300,20);
		add(scrollbar1);

		scrollbar2 = new Scrollbar(Scrollbar.HORIZONTAL,1,1,1,100);
		scrollbar2.setBounds(50,150,300,20);
		add(scrollbar2);

		btnOk = new Button("Início !");
		btnOk.setBounds(250,190,120,40);
		add(btnOk);
		
		btnOk.addActionListener(this);
		addWindowListener(this);

		threadSb1 = new Thread(this, "Sb1");
		threadSb2 = new Thread(this, "Sb2");
        	}

	public void run()
	{

	

  	 while (threadSb1 == Thread.currentThread()) {
		scrollbar1.setValue(scrollbar1.getValue() + 2);
		try
		{
			if(scrollbar1.getValue() > 98){
    	 		 mensagem = new MessageBox("Vencedor Scrollbar1!!");			
		 	 mensagem.setVisible(true);
			 threadSb2.stop();
		         threadSb1.stop();	

			}
			
		Thread.sleep((int)(Math.random()*1000));
		}
		catch (InterruptedException  e) {}
	}			


  	 while (threadSb2 == Thread.currentThread()) {
		scrollbar2.setValue(scrollbar2.getValue() + 2);
		try
		{
			if(scrollbar2.getValue() > 98){
    	 		 mensagem = new MessageBox("Vencedor Scrollbar2!!");			
		 	 mensagem.setVisible(true);
			 threadSb1.stop();
			 threadSb2.stop();
			}
	
		Thread.sleep((int)(Math.random()*1000));
		}
		catch (InterruptedException  e) {}				
	 }
	}

	public void actionPerformed(ActionEvent e)
        {
         if (e.getSource() == btnOk)
            {
	       threadSb1.start();	
	       threadSb2.start();

	    }
	}

//Metodos do WindowListener
	public void windowActivated(WindowEvent e)
	{
	// Comentario
	}

	public void windowDeactivated(WindowEvent e)
	{
	// Comentario
	}

	public void windowClosing(WindowEvent e)
	{
        System.exit(0);
	}

	public void windowClosed(WindowEvent e)
        {
        //Comentario
	}

	public void windowOpened(WindowEvent e)
	{
	// Comentario
	}

	public void windowIconified(WindowEvent e)
	{
	// Comentario
	}

	public void windowDeiconified(WindowEvent e)
	{
	// Comentario
	}
	public static void main (String args[]) {

		Thread2 teste = new Thread2();
		teste.setVisible(true);

	}
}