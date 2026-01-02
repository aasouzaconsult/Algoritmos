import java.awt.*;
import java.io.*;
import jds.Map;
import jds.collection.MapAdapter;
import jds.collection.LinkedList;
import jds.util.ButtonAdapter;

class AddressBook extends Frame {
	public static void main (String [ ] args) {
		AddressBook world = new AddressBook();
		world.show();
	}

	public AddressBook () {
			// set window characteristics
		setSize(400, 200);
		setTitle("Address Book");
			// create our GUI
		add("North", keyBox);
		add("Center", valueBox);
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(4,1));
		add("East", buttonPanel);
		buttonPanel.add(new FindButton());
		buttonPanel.add(new EnterButton());
		buttonPanel.add(new SaveButton());
		buttonPanel.add(new QuitButton());
			// initialize the database
		try {
			FileInputStream fs = new FileInputStream("addresses");
			ObjectInputStream fi = new ObjectInputStream(fs);
			database = (Map) fi.readObject();
		} catch(IOException e) { 
			// do nothing 
		} catch (ClassNotFoundException e) { 
			System.out.println("got file conversion error"+ e); 
		}
	}

	private TextField keyBox = new TextField();
	private TextArea valueBox = new TextArea();
	private Map database = new MapAdapter(new LinkedList());

	private class FindButton extends ButtonAdapter {
		public FindButton () { super("Find"); }
		public void pressed () {
			String key = keyBox.getText();
			if (database.containsKey(key))
				valueBox.setText((String) database.get(key));
			else
				valueBox.setText("no entry");
		}
	}

	private class EnterButton extends ButtonAdapter {
		public EnterButton () { super("Enter"); }
		public void pressed () { 
			database.set(keyBox.getText(), valueBox.getText()); 
			keyBox.setText("");
		}
	}

	private class SaveButton extends ButtonAdapter {
		public SaveButton () { super("Save"); }
		public void pressed () {
			try {
				FileOutputStream fs = 
					new FileOutputStream("addresses");
				ObjectOutputStream fo = 
					new ObjectOutputStream(fs);
				fo.writeObject(database);
			} catch (IOException e) { System.err.println("got IO Error " + e); }
		}
	}

	private class QuitButton extends ButtonAdapter {
		public QuitButton () { super("Quit"); }
		public void pressed () { System.exit(0); }
	}
}

