import java.awt.*;
import jds.collection.Vector;
import jds.util.ButtonAdapter;

class Memory extends Frame {
	static public void main (String [ ] args) 
		{ Memory world = new Memory(); world.show(); }

	Memory () {
			// Frame initialization
		setSize(400, 120); setTitle("Memory Game");
			// application initialization
		add("North", scorebox);
		add("Center", text);
		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 4));
		p.add(new ResetButton());
		p.add(new OkButton());
		p.add(new DoneButton());
		p.add(new QuitButton());
		add("South", p);
	}

	private Label scorebox = new Label("score = 0:");
	private TextField text = new TextField("Press Reset to begin");
	private int score = 0;
	private int size = 2;
	private Vector answers = new Vector();

	private void makeGuess() {
		answers.setSize(0);
		String line = "";
		for (int i = 0; i < size; i++) {
			int d = (int) (10 * Math.random());
			line = line + d;
			answers.addLast(new Character(Character.forDigit(d, 10)));
		}
		text.setText(line);
	}

	private class ResetButton extends ButtonAdapter {
		ResetButton () { super("Reset"); }
		public void pressed () { 
			size = 2;
			score = 0;
			makeGuess();
			scorebox.setText("score = 0: Press OK to proceed");
		}
	}

	private class OkButton extends ButtonAdapter {
		OkButton () { super("OK"); }
		public void pressed () {
			text.setText("");
			scorebox.setText("Enter Numbers, Press Done When Finished");
		}
	}

	private class DoneButton extends ButtonAdapter {
		DoneButton () { super("Done"); }
		public void pressed () { 
			String line = text.getText();
			if (line.length() != answers.size()) 
				{ failed(); return; }
			for (int i = 0; i < line.length(); i++) {
				if (! answers.elementAt(i).equals(
					new Character(line.charAt(i)))) {
						failed();
						return;
					}
			}
			score = score + 1;
			scorebox.setText("score = " + score + 
				": Next level. Press OK to proceed");
			size = size + 1;
			makeGuess();
		}

		private void failed() {
			scorebox.setText("sorry, you failed: score = " + score);
			text.setText("Press Reset to try again");
		}
	}

	private class QuitButton extends ButtonAdapter {
		QuitButton () { super("Quit"); }
		public void pressed () { System.exit(0); }
	}
}

