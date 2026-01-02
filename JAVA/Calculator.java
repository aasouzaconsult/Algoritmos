//
//	calculator example program
//

import java.awt.*;
import java.util.*;
import jds.Stack;
import jds.collection.Vector;
import jds.util.ButtonAdapter;

class Calculator extends Frame {
	public static void main (String [ ] args) {
		Calculator world = new Calculator();
		world.show();
	}

	public Calculator () {
			// create the high level display
		setSize(200, 300);
		setTitle("Calculator");
		Panel p = new Panel();
		p.setLayout (new GridLayout(4,4,2,2));
		add("Center", p);
		add("North", display);
			// now create the buttons
		p.add(new DigitButton(1));
		p.add(new DigitButton(2));
		p.add(new DigitButton(3));
		p.add(new OpButton('+'));
		p.add(new DigitButton(4));
		p.add(new DigitButton(5));
		p.add(new DigitButton(6));
		p.add(new OpButton('-'));
		p.add(new DigitButton(7));
		p.add(new DigitButton(8));
		p.add(new DigitButton(9));
		p.add(new OpButton('*'));
		p.add(new QuitButton());
		p.add(new DigitButton(0));
		p.add(new EnterButton());
		p.add(new OpButton('/'));
			// initialize the data stack
		pushValue (0.0);
	}

	Label display = new Label("0");
	Stack data = new Vector();

	private double dataStackTop () {
			// return top of stack as a double
		Double dtop = (Double) data.getLast ();
		data.removeLast();
		Double dtop = (Double) otop;
		return dtop.doubleValue();
	}

	private void pushValue (double d) {
			// push value on to stack and update display
		data.addLast(new Double(d));
		display.setText(String.valueOf(d));
		repaint();
	}

	private class DigitButton extends  ButtonAdapter {
		DigitButton (int v) {
			super (String.valueOf(v));
			value = v;
		}

		private int value;

		public void pressed () {
			double d = dataStackTop();
			d = d * 10 + value;
			pushValue(d);
		}
	}

	private class OpButton extends ButtonAdapter {
		OpButton (char o) {
			super (String.valueOf(o));
			op = o;
		}

		private char op;

		public void pressed () {
			double right = dataStackTop();
			if (data.isEmpty()) {
				pushValue (right);
				return;
				}
			double left = dataStackTop();
			switch (op) {
				case '+': left += right; break;
				case '-': left -= right; break;
				case '*': left *= right; break;
				case '/': left /= right; break;
			}
			pushValue(left);
		}
	}

	private class EnterButton extends ButtonAdapter {
		EnterButton() { super("E"); }

		public void pressed () { pushValue(0.0); }
	}

	private class QuitButton extends ButtonAdapter {
		QuitButton() { super("Q"); }

		public void pressed () { System.exit(0); }
	}
}
