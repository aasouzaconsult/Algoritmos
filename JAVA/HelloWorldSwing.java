// www.guj.com.br
import javax.swing.*;

public class HelloWorldSwing
{
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Hello");
		JLabel label = new JLabel("Hello, Swing World");
		frame.getContentPane().add(label);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

