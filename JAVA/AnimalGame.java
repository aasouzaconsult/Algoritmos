import java.io.*;
import jds.util.BinaryNode;

class AnimalGame {
	public static void main (String [ ] args) { 
		System.out.println("Lets play guess the animal");
		new AnimalGame().play(); 
	}

	private BinaryNode root = new BinaryNode("Cat");
	private BufferedReader din = new BufferedReader(
		new InputStreamReader(System.in));

	public void play () {
		BinaryNode current = root;
		while (current != null) {
				// if node has children it is a question
			if (current.leftChild != null) {
				System.out.println(current.value);
				if (answer())
					current = current.leftChild;
				else
					current = current.rightChild;
			} else { // no children, it is an answer
				System.out.println("I know.  Is it a " + 
					current.value + "?");
				if (answer())
					System.out.println("I won");
				else // time to learn something
					learnNewAnimal (current);
				current = null;
			}
		}
		System.out.println("Try again?");
		if (answer()) play();
	}

	private boolean answer () { // read yes, no answer
		String line;
		try {
			line = din.readLine();
		} catch (IOException e) { line = " "; }
		char c = line.charAt(0);
		if ((c == 'y') || (c == 'Y')) return true;
		if ((c == 'n') || (c == 'N')) return false;
		System.out.println("Please answer yes or no");
		return answer();
	}

	private void learnNewAnimal (BinaryNode current) {
		String currentAnimal = (String) current.value;
		System.out.println("What is your animal?");
		try {
			String newAnimal = din.readLine();
			System.out.println("what is a yes/no question that " +
			"I can use to tell a " + currentAnimal + " from a " +
			newAnimal);
			String question = din.readLine();
			BinaryNode node1 = new BinaryNode(currentAnimal);
			BinaryNode node2 = new BinaryNode(newAnimal);
			System.out.println("For a " + newAnimal + 
				" is the answer yes or no?");
			current.value = question;
			if (answer()) {
				current.leftChild = node2;
				current.rightChild = node1;
			} else {
				current.leftChild = node1;
				current.rightChild = node2;
			}
		} catch (IOException e) { } // no nothing
	}
}
