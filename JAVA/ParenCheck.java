import java.io.*;
import jds.Stack;
import jds.collection.Vector;

public class ParenCheck {
	public static void main (String [ ] args) {
		try {
			ParenCheck world = new ParenCheck(System.in);
		} catch (IOException e) {
			System.out.println("Received IO Exception " + e);
		}
	}

	public ParenCheck (InputStream in) throws IOException {
		int i = in.read();
		while (i != -1) {
			if (i == '(') push(')');
			else if (i == '{') push('}');
			else if (i == ')') check(')');
			else if (i == '}') check('}');
			i = in.read();
		}
		if (stk.isEmpty())
			System.out.println("Parenthesis Balance");
		else reportError();
	}

	Stack stk = new Vector();

	private void push (char c) { stk.addLast(new Character(c)); }

	private void check (char c) {
		if (stk.isEmpty())
			reportError();
		Character s = (Character) stk.getLast();
		stk.removeLast();
		if (c != s.charValue())
			reportError();
	}

	private void reportError() {
		System.out.println("Parenthesis do not Balance");
		System.exit(1);
	}
}
