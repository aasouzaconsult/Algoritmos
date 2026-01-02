import java.awt.*;
import java.awt.event.*;

public class ThreePagesApplet extends java.applet.Applet implements MouseListener {

	Button page1Button;
	Label page2Label;
	TextArea page3Text;
	Button page3Top;
	Button page3Bottom;
	CardLayout layout;
	
	public void init() {
		setLayout(layout = new CardLayout());
		
		add(page1Button = new Button("Button page"), "page1Button");
		page1Button.addMouseListener(this);
		
		add(page2Label = new Label("Label page"), "page2Label");
		page2Label.addMouseListener(this);
		
		Panel panel = new Panel();
		panel.setLayout(new BorderLayout());
		
		panel.add(page3Text = new TextArea("Composite page"));
		page3Text.addMouseListener(this);
		
		panel.add(page3Top = new Button("Top button"), "North");
		page3Top.addMouseListener(this);
		
		panel.add(page3Bottom = new Button("Bottom button"), "South");
		page3Bottom.addMouseListener(this);
		
		add(panel, "panel");
	}
	
	public void mouseClicked(MouseEvent e) {
		layout.next(this);
	}
	
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	
}