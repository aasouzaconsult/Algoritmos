import java.awt.*;

public class TextComponentApplet extends java.applet.Applet {

	TextField textfield = new TextField("This is a TextField");
	TextArea textarea = new TextArea("This is a TextArea\nThis is the second line.");
	
	public void init() {
		
		add(textfield);
		add(textarea);
		
	}
	
}