import jds.Bag;
import jds.Sorted;
import jds.FindMin;
import jds.SortAlgorithm;
import jds.Indexed;
import jds.util.BinaryNode;
import jds.util.Comparator;
import jds.util.DefaultComparator;
import jds.util.InorderTreeTraversal;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import jds.util.IntegerCompare;


/**
 * RemoveTree - set kept in a balanced binary search tree;
 * for use with book
 * <a href="http://www.cs.orst.edu/~budd/books/jds/">Data Structures in Java, 
 * A Visual and Explorational Approach</a>
 * by <a href="http://www.cs.orst.edu/~budd">Timothy A Budd</a>, 
 * published by <a href="http://www.awl.com">Addison-Wesley</a>, 1999.
 *
 * @author Timothy A. Budd
 * @version 1.1 September 1999
 * @see Collection
 */

public class RemoveTree implements Bag, Sorted, FindMin, SortAlgorithm {
	/**
	 * initialize newly created Remove tree
	 *
	 * @param t comparator object used to order elements
	 */
	public RemoveTree (Comparator t) { test = t; }

	/**
	 * initialize newly created Remove tree
	 *
	 */
	public RemoveTree () { test = (Comparator) new DefaultComparator(); }

	private Comparator test;
	private RemoveNode root = new RemoveSentinel();
	private int elementCount;
	
	/**
	 * Determines whether the collection is empty
	 *
	 * @return true if the collection is empty
	 */
	public boolean isEmpty () { return root.isEmpty(); }

	/**
	 * Determines number of elements in collection
	 *
	 * @return number of elements in collection as integer
	 */
	public int size () { return elementCount; }

	/**
	 * Yields enumerator for collection
	 *
	 * @return an <code>Enumeration</code> that will yield the elements of the collection
	 * @see java.util.Enumeration
	 */
	public Enumeration elements () { return new InorderTreeTraversal(root); }


	/**
	 * see if collection contains value
	 *
	 * @param val element to be tested
	 * @return true if collection contains value
	 */
	public boolean containsElement (Object val) { return root.contains(val); }

	/**
	 * find element that will test equal to value
	 *
	 * @param value element to be tested
	 * @return first value that is <code>equals</code> to argument
	 * @exception java.util.NoSuchElementException no matching value
	 */
	public Object findElement (Object val) { return root.find(val); }

	/**
	 * add a new value to the collection
	 *
	 * @param value element to be inserted into collection
	 */
	public synchronized void addElement (Object val) 
		{ root = root.add(val); elementCount++; }

	/**
	 * remove a new value from the collection
	 *
	 * @param value element to be removed from collection
	 * @exception java.util.NoSuchElementException no matching value
	 */
	public synchronized void removeElement (Object val) 
		{ root = root.remove(val); elementCount--; }

	public Object getFirst () { return root.getFirst(); }

	public void removeFirst () 
		{ root = root.removeFirst(); elementCount--; }

		// the SortAlgorithm interface
	/**
	 * rearrange collection into asending order
	 *
	 * @param data the values to be ordered
	 */
	public void sort (Indexed data) {
		RemoveTree t = new RemoveTree(test);
		int n = data.size();
				// copy them in
		for (int i = 0; i < n; i++)
			t.addElement(data.elementAt(i));
				// copy them out
		Enumeration e = t.elements();
		int i = 0;
		while (e.hasMoreElements())
			data.setElementAt(e.nextElement(), i++);
	}

	private class RemoveNode extends BinaryNode {
		RemoveNode (Object v) { super(v); }
		protected int height = 0;

		private RemoveNode left() { return (RemoveNode) leftChild; }
		private RemoveNode right() { return (RemoveNode) rightChild; }

		public RemoveNode add (Object newElement) {
			if (test.compare(newElement, value) < 0)
				leftChild = left().add(newElement);
			else
				rightChild = right().add(newElement);
			return setHeight();
		}

		public boolean contains (Object newElement) {
			int testResult = test.compare(newElement, value);
			if (testResult == 0) return true;
			if (testResult < 0)
				return left().contains(newElement);
			return right().contains(newElement);
		}

		public Object find (Object newElement) {
			int testResult = test.compare(newElement, value);
			if (testResult == 0) return value;
			if (testResult < 0)
				return left().find(newElement);
			return right().find(newElement);
		}

		public Object getFirst () {
			if (leftChild.isEmpty()) return value;
			return left().getFirst();
		}

		public RemoveNode removeFirst () {
			if (leftChild.isEmpty()) return right();
			leftChild = left().removeFirst();
			return setHeight();
		}

		public Object getLast () {
			if (rightChild.isEmpty()) return value;
			return right().getLast();
		}

		public RemoveNode removeLast () {
			if (rightChild.isEmpty()) return left();
			rightChild = right().removeLast();
			return setHeight();
		}

		public RemoveNode remove (Object oldElement) {
			int testResult = test.compare(oldElement, value);
			if (testResult == 0) { // found element to remove
				if (right().isEmpty())
					return left();
				value = right().getFirst();
				rightChild = right().removeFirst();
			} else if (testResult < 0)
				leftChild = left().remove(oldElement);
			else
				rightChild = right().remove(oldElement);
			return setHeight();
		}

		private RemoveNode setHeight() {
			int lh = left().height;
			int rh = right().height;
			height = 1 + ((lh < rh)?rh:lh);
			int nbf = rh - lh; // balance factor
			if (nbf < -1) {
				Object currentValue = value;
				value = left().getLast();
				leftChild = left().removeLast();
				return add(currentValue);
			} else if (nbf > 1) {
				Object currentValue = value;
				value = right().getFirst();
				rightChild = right().removeFirst();
				return add(currentValue);
			}
			return this;
		}


		public String toString() {
			return "(" + leftChild.toString() + " " +
				value.toString() + ":" + height + " " +
				rightChild.toString() + ")";
		}
	}

	public String toString() { return root.toString(); }

	private class RemoveSentinel extends RemoveNode {
		RemoveSentinel () { super(null); height = -1; }
		public boolean isEmpty () { return true; }
		public int count () { return 0; }
		public String toString () { return ""; }

		public RemoveNode add (Object newElement) { 
			RemoveNode newNode = new RemoveNode(newElement); 
			newNode.leftChild = this;
			newNode.rightChild = this;
			return newNode;
			}

		public boolean contains (Object newElement) { return false; }

		public Object find (Object newElement) {
			throw new NoSuchElementException(newElement.toString());
		}

		public RemoveNode remove (Object oldElement) {
			throw new NoSuchElementException(oldElement.toString());
		}

		public Object getFirst () {
			throw new NoSuchElementException();
		}

		public RemoveNode removeFirst () {
			throw new NoSuchElementException();
		}
	}

	public static void main (String [ ] args) {
		// test procedure for RemoveTrees
		RemoveTree t = new RemoveTree(new IntegerCompare());
		t.addElement(new Integer(75));
		System.out.println("tree is " + t);
		t.addElement(new Integer(21));
		System.out.println("tree is " + t);
		t.addElement(new Integer(54));
		System.out.println("tree is " + t);
		t.addElement(new Integer(83));
		System.out.println("tree is " + t);
		t.addElement(new Integer(68));
		System.out.println("tree is " + t);
		t.addElement(new Integer(30));
		System.out.println("tree is " + t);
		t.addElement(new Integer(82));
		System.out.println("tree is " + t);
		t.addElement(new Integer(89));
		System.out.println("tree is " + t);
		t.addElement(new Integer(55));
		System.out.println("tree is " + t);
		t.addElement(new Integer(80));
		System.out.println("tree is " + t);
	}
}
