import jds.util.BinaryNode;
import jds.Stack;
import jds.collection.LinkedList;

class PrintExpression extends EulerTour {
	public Object beforeLeft (Object v, Object result) 
		{ System.out.print("("); return null; }
	public Object inBetween (Object v, Object result)
		{ System.out.print(v); return null; }
	public Object afterRight (Object v, Object result) 
		{ System.out.print(")"); return null; }
}

class StrExpression extends EulerTour {

	public Object beforeLeft (Object v, Object result) {
		String res = (String) result;
		return res + "(";
	}

	public Object inBetween (Object val, Object result)  {
		String res = (String) result;
		return res + val;
	}
		
	public Object afterRight (Object v, Object result)  {
		String res = (String) result;
		return result + ")";
	}
}

class EvalExpression extends EulerTour {
	public Object afterRight (Object val, Object result) {
		Stack stk = (Stack) result;
		if (val instanceof Integer)
			stk.addLast(val); 
		else { // must be an operation
			Character Operation = (Character) val;
			char c = Operation.charValue();
			Integer right = (Integer) stk.getLast();
			stk.removeLast();
			Integer left = (Integer) stk.getLast();
			int newValue = 0;
			if (c == '+') newValue = left.intValue() + right.intValue();
			if (c == '*') newValue = left.intValue() * right.intValue();
			stk.addLast(new Integer(newValue));
		}
		return result;
	}
}

class EulerTest {
	public static void main (String [ ] args) {
		BinaryNode a = new BinaryNode(new Integer(3));
		BinaryNode b = new BinaryNode(new Integer(4));;
		BinaryNode c = new BinaryNode(new Character('+'));;
		c.leftChild = a;
		c.rightChild = b;
		BinaryNode d = new BinaryNode(new Integer(5));
		BinaryNode e = new BinaryNode(new Character('*'));
		e.leftChild = c;
		e.rightChild = d;
		BinaryNode f = new BinaryNode(new Integer(7));
		BinaryNode g = new BinaryNode(new Character('+'));
		g.leftChild = f;
		g.rightChild = e;

		EulerTour strPrinter = new PrintExpression();
		strPrinter.traverse(g, null); System.out.println(" ");
		EulerTour strMaker = new StrExpression();
		System.out.println(strMaker.traverse(g, ""));
		EulerTour evaler = new EvalExpression();
		Stack stk = (Stack) evaler.traverse(g, new LinkedList());
		System.out.println("value is " + stk.getLast());
	}
}

