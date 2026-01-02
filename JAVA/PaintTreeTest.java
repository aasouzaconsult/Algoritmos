import java.awt.*;
import jds.util.BinaryNode;

class PaintTreeTest extends Frame {
	public static void main (String [ ] args) {
		PaintTreeTest world = new PaintTreeTest();
		world.show();
	}

	public PaintTreeTest () {
		setSize(250, 250);
		setTitle("Tree Painting Program");
			// build a tree
		BinaryNode a = new BinaryNode(new Integer(3));
		BinaryNode b = new BinaryNode(new Integer(4));;
		BinaryNode c = new BinaryNode(new Character('+'));
		BinaryNode h = new BinaryNode(new Integer(8));
		BinaryNode j = new BinaryNode(new Integer(9));
		BinaryNode k = new BinaryNode(new Character('-'));
		k.leftChild = h;
		k.rightChild = j;
		c.leftChild = a;
		c.rightChild = k;
		BinaryNode d = new BinaryNode(new Integer(5));
		BinaryNode e = new BinaryNode(new Character('*'));
		e.leftChild = c;
		e.rightChild = d;
		BinaryNode f = new BinaryNode(new Integer(7));
		BinaryNode g = new BinaryNode(new Character('+'));
		g.leftChild = f;
		g.rightChild = e;
		root = g;
	}

	BinaryNode root;

	public void paint (Graphics g) {
		new PaintTree(g, root);
	}
}
