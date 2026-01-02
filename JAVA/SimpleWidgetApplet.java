import java.awt.*;

public class SimpleWidgetApplet extends java.applet.Applet {

	public SimpleWidgetApplet() {
		
		Button button = new Button("Click me!");
		Checkbox checkbox = new Checkbox("Tick me!");
		Choice choice = new Choice();
		Label label = new Label("This just displays some text.");
		List list = new List();
		Scrollbar scrollbar = new Scrollbar();

		choice.add("Item 1");
		choice.add("Item 2");
		choice.add("Item 3");
		
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");

		add(button);
		add(checkbox);
		add(choice);
		add(label);
		add(list);
		add(scrollbar);
		
	}
	
}