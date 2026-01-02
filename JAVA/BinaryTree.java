import java.util.*;

class BinaryNode {
	public int data;
	public BinaryNode leftChild;
	public BinaryNode rightChild;
	public BinaryNode parent;

	public BinaryNode(int value) {
		this.data = value;
	}
}

public class BinaryTree {
	public BinaryNode root;

	public BinaryTree(int rootValue) {
		root = new BinaryNode(rootValue);
		root.parent = null;
	}

	public void addNode(BinaryNode node, int value) {
		if (node.data > value) { //leftChild
			if (node.leftChild != null) {
				addNode(node.leftChild, value);
			} else {				
				BinaryNode newNode = new BinaryNode(value);
				node.leftChild = newNode;
				newNode.parent = node;
				System.out.println("Added " + value + " as a left child of " + node.data);
			}
		} else { // rightChild
			if (node.rightChild != null) {
				addNode(node.rightChild, value);
			} else {
				BinaryNode newNode = new BinaryNode(value);
				node.rightChild = newNode;
				newNode.parent = node;
				System.out.println("Added " + value + " as a right child of " + node.data);
			}
		}
	}

	public BinaryNode replace(BinaryNode root, BinaryNode ref) {
		// This Algorithm takes care of the case in which the node to delete has zeno or one children.
		// Deletes the node referenced by ref from a binary search tree with root root.
		// The node referenced by ref has 0 children or exactly 1 child. We assume that each node N in the 
		// tree has a parent field, N.parent. If N is the root, N.parent is null. 
		// Returns the root of the tree that results from deleting the node		
		BinaryNode child;

		if (ref.leftChild == null) {
			child = ref.rightChild; //set child as right child
		} else {
			child = ref.leftChild; // set child as left child
		}
		if (ref == root) { //ref is the root
			if (child != null) {
				root = child; // child is the new root
			}
			return child;
		}
		if(ref.parent.leftChild == ref) { // ref is left child
			ref.parent.leftChild = child; //replace ref with its left child
			if (child == null) { // replaced with end node?
				System.out.println(ref.parent.leftChild + " has replaced " + ref.data);
			} else {
				System.out.println(ref.parent.leftChild.data + " has replaced " + ref.data);
			}
		} else { //ref is right child
			ref.parent.rightChild = child; //replace ref with its right child
			if( child == null) { // replaced with end node?
				System.out.println(ref.parent.rightChild + " has replaced " + ref.data);	
			} else {
				System.out.println(ref.parent.rightChild.data + " has replaced " + ref.data);
			}
		}
		if (child != null) {
			child.parent = ref.parent; // set new child's parent link to its previous grandparent
		}
		return root;
	}

	public BinaryNode delete(BinaryNode root, BinaryNode ref) {
		// This algoirthm deletes the node referenced by ref from a binary search tree with root.
		// We assume that each node N in the tree has a parent field, N.parent. If N is the root, N.parent is null.
		// The algorithm returns the root of the tree that results from deleting the node.

		// if 0 or 1 children, use replace()
		if(ref.leftChild == null || ref.rightChild == null) {
			return replace(root, ref);
		}
		// find node succ containing a minimum data item in ref's right subtree
		BinaryNode succ = ref.rightChild;
		while (succ.leftChild != null)
			succ = succ.leftChild;
		// move succ to ref, thus deleting ref
		System.out.println(succ.data + " has replaced " + ref.data);
		ref.data = succ.data;
		System.out.println(succ.data + " has been deleted.");	
		return replace(root, succ);
	}

	public BinaryNode find(BinaryNode node, int value) {
		// Finds the node that contains the value and returns a reference to the node.
		// Returns null if value does not exist in the tree.				
		if (node == null) return null;
		if (node.data == value) {
			return node;
		} else {
			BinaryNode left = find(node.leftChild, value);
			BinaryNode right = find(node.rightChild, value);
			if (left != null) {
				return left;
			}else {
				return right;
			}	
		}
	}
	public void preorder(BinaryNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.leftChild); // traverse left subtree
			preorder(node.rightChild); // traverse right subtree
		}
	}

	public void inorder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inorder(node.leftChild);
		System.out.print(node.data + " ");
		inorder(node.rightChild);
	}

	public void postorder(BinaryNode node) {
		if (node == null) {
			return;
		}
		postorder(node.leftChild);
		postorder(node.rightChild);
		System.out.print(node.data + " ");
	}

	public int countNodes(BinaryNode node) {
		// Returns the number of nodes in the binary tree with root.
		if (node == null) {
			return 0;
		}
		int count = 1;
		count = count + countNodes(node.leftChild); // add in nodes in left subtree
		count = count + countNodes(node.rightChild); // add in nodes in right subtree
		return count;
	}

	public int countTerminalNodes(BinaryNode node) {
		// Counts the number of terminal nodes in the binary tree starting with node and return the integer value
		int count = 0;
		if (node != null) {
			if (node.leftChild == null && node.rightChild == null) {
				count += 1;
			}
			count += countTerminalNodes(node.leftChild) + countTerminalNodes(node.rightChild);
		}
		return count;
	}

	public void swap(BinaryNode node) {
		// Swaps the left and right child of every node starting from node
		if(node != null) {
			if (node.leftChild != null || node.rightChild != null) {
				BinaryNode temp;
				temp = node.leftChild;
				node.leftChild = node.rightChild;
				node.rightChild = temp;
				swap(node.leftChild);
				swap(node.rightChild);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(5);
		tree.addNode(tree.root, 3);
		tree.addNode(tree.root, 4);
		tree.addNode(tree.root, 9);
		tree.addNode(tree.root, 7);
		tree.addNode(tree.root, 6);
		tree.addNode(tree.root, 8);
		tree.preorder(tree.root);
		//tree.swap(tree.root);
		//System.out.println();
		//tree.preorder(tree.root);
		System.out.println();
		System.out.println("Total number of nodes: " + tree.countNodes(tree.root));
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		System.out.println();
		System.out.println(tree.countTerminalNodes(tree.root));
		if (tree.find(tree.root, 3) != null) {
			System.out.println("Node found.");
		} else {
			System.out.println("Node NOT found.");
		}
		BinaryNode newRoot = tree.replace(tree.root, tree.find(tree.root, 4));
		BinaryNode newRoot2 = tree.replace(tree.root, tree.find(tree.root, 7));
		System.out.println(tree.countTerminalNodes(tree.root));
	}
}
