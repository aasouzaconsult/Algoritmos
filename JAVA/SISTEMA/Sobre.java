import javax.swing.*;
import java.awt.*;

public class Sobre extends JInternalFrame{
	private ImageIcon icone;
	private Container container;
	private JPanel painel;
	
	
	Sobre() {
		
		super("Sobre o Sistema", false, true, false, true);	
		
		//Adiciona o icone a  janela
		icone = new ImageIcon("SuperJava.gif");
		icone.setImage(icone.getImage().getScaledInstance(30, 18, 500));
		setFrameIcon(icone);
	
		container = getContentPane();
		container.setLayout(new BorderLayout(10, 10));  	
		        
        
		setSize(490, 150);
		setVisible(true);
		setOpaque(true);
		setResizable(false);

	}
}
