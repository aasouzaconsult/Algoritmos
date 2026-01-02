public class Queue {
	//Implement a queue using an array
	int[] queue;
	int front, rear;
	public final static int SIZE = 999;
	public Queue() {
		this.queue = new int[SIZE];
		this.front = -1;
		this.rear = -1;
	}

	public boolean empty() {
		if (this.front == -1 && this.front == this.rear) {
			return true;
		} else {
			return false;
		}
	}

	public void enqueue(int value) {
		if (this.empty()) {
			this.front = 0;
			this.rear = 0;
		} else {
			this.rear += 1;
			if (this.rear == SIZE) {
				this.rear = 0;
			}
		}
		this.queue[this.rear] = value;
	}

	public void dequeue() {
		if (this.front == this.rear) {
			this.front = -1;
			this.rear = -1;
		} else {
			this.front += 1;
			if(this.front == SIZE) {
				this.front = 0;
			}
		}
	}

	public int front() {
		return this.front;
	}

	public static void main(String[] args) {
		Queue q1 = new Queue();
		if (q1.empty()) {
			System.out.println("Queue is empty.");
		}
		q1.enqueue(1);
		q1.enqueue(2);
		q1.enqueue(3);
		System.out.println(q1.front());
		q1.dequeue();
		System.out.println(q1.front());
	}
}