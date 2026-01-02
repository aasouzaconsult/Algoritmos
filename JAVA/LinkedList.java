import java.util.*;
import Node;

public class LinkedList {
	public LinkedList(int data) {
		Node first = new Node(data);		
	}

	public empty() {
		if (this.first.next == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insert(int data, Node pos) {
		Node temp = new Node(data);
		temp.next = pos.next;
		pos.next = temp;
	}

	public void delete(Node pos) {
		//Deletes the node after the node referenced by pos
		pos.next = pos.next.next;
	}

	public void print() {
		boolean isEmpty = true;

		while (this.first.next != null) {			
			System.out.println(this.first.data);
			this.first = this.first.next;
			isEmpty = false;
		}
		if (this.first.next == null) {
			if (isEmpty) {
				System.out.println("List is empty.");
			} else {
				System.out.println(this.first.data);
			}			
		}
	}

	public static int main(String[] args) {
		LinkedList list1 = new LinkedList(1);
		list1.print();
		list1.insert(2, LinkedList.first);
		list1.print();
	}
}