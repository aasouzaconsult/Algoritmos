// ALO MUNDO C/ GUI

import java.awt.*;
import javax.swing.*;

public class Cap08Ex01 extends JComponent {
	
	public static void main (String args[]) {
	JFrame f = new JFrame("Alo Mundo.");
	f.setSize(300,200);
	f.getContentPane().add(new Cap08Ex01());
	f.setVisible(true);
	}

public void paintComponent(Graphics g) {
	g.drawString("Alo Mundo!",100,85);
	}
}