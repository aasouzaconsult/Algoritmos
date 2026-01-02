import java.awt.*;
import jds.util.BinaryNode;
import jds.Stack;
import jds.collection.LinkedList;

class PaintTree extends EulerTour {

	public PaintTree (Graphics pg, BinaryNode nd) {
		g = pg;
		traverse(nd, new LinkedList());
	}

	private Graphics g;
	private int x = 50;
	private int y = 50;

	public Object beforeLeft (BinaryNode nd, Object info) {
		Stack stk = (Stack) info;
		stk.addLast (new Point(x, y));
		y += 35;
		return info;
	}

	public Object inBetween (BinaryNode nd, Object info) {
		Stack stk = (Stack) info;
		Point myPos;
		if (nd.leftChild != null) {
			Point childPos = (Point) stk.getLast();
			stk.removeLast();
			myPos = (Point) stk.getLast();
			stk.removeLast();
			x += 10;
			myPos.x = x;
			g.drawLine(myPos.x, myPos.y+10, childPos.x, childPos.y);
		} else {
			myPos = (Point) stk.getLast();
			stk.removeLast();
		}
		g.drawString(nd.value.toString(), myPos.x-5, myPos.y+12);
		stk.addLast(myPos);
		x += 10;
		y = myPos.y + 35;
		return stk;
	}

	public Object afterRight (BinaryNode nd, Object info) {
		Stack stk = (Stack) info;
		if (nd.rightChild != null) {
			Point childPos = (Point) stk.getLast();
			stk.removeLast();
			Point myPos = (Point) stk.getLast();
			stk.removeLast();
			g.drawLine(myPos.x, myPos.y+10, childPos.x, childPos.y);
			stk.addLast(myPos);
		}
		return stk;
	}
}
