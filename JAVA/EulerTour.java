import jds.util.BinaryNode;

public class EulerTour {
	public final Object traverse (BinaryNode n, Object info) {
		info = beforeLeft(n, info);
		if (n.leftChild != null)
			info = traverse(n.leftChild, info);
		info = inBetween(n, info);
		if (n.rightChild != null)
			info = traverse(n.rightChild, info);
		info = afterRight(n, info);
		return info;
	}

	public Object beforeLeft (BinaryNode nd, Object info) 
		{ return info; }

	public Object inBetween (BinaryNode nd, Object info) 
		{ return info; }

	public Object afterRight (BinaryNode nd, Object info) 
		{ return info; }
}
