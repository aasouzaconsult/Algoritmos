import java.util.*;
import java.util.LinkedList;

public class QueueLinkedList {
	//Implement a queue using a linked list
	private LinkedList queue;

	public QueueLinkedList() {
		queue = new LinkedList();
	}

	public boolean empty() {
		if(this.queue.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void enqueue(int value) {
		this.queue.addLast(value);
	}

	public void dequeue() {
		this.queue.removeFirst();
	}

	public Object front() {
		return this.queue.getFirst();
	}

	public void print() {
		for(int i = 0; i < this.queue.size(); i++) {
			System.out.print(this.queue.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueLinkedList q1 = new QueueLinkedList();
		if (q1.empty()) {
			System.out.println("Queue is empty.");
		}
		q1.enqueue(1);
		q1.enqueue(2);
		q1.enqueue(3);
		q1.print();
		q1.dequeue();
		q1.print();
	}
}