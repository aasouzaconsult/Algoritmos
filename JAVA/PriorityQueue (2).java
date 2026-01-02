public class PriorityQueue {
	// Implementation of a priority queue using an array
	public static final int SIZE = 99;
	int[] queue;
	int pos;

	public PriorityQueue() {
		queue = new int[SIZE];
		pos = -1;
	}

	public int insert(int priority) {
		if (pos == SIZE-1) {
			return -1;
		} else {
			pos += 1;
			queue[pos] = priority;			
		}
		return priority;
	}

	public int deleteTopPriority() {
		int temp = queue[0];
		int index = 0;		
		for(int i = 1; i <= pos; i++) {
			if (queue[i] > temp) {
				temp = queue[i];
				index = i;				
			}
		}
		while(index != pos) {
			queue[index] = queue[index+1];
			index++;
		}
		pos--;
		return temp;
	}

	public void print() {
		for(int i =0 ; i <= pos; i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PriorityQueue q1 = new PriorityQueue();
		q1.insert(57);
		q1.insert(32);
		q1.insert(100);
		q1.insert(56);
		q1.insert(44);
		q1.print();
		q1.deleteTopPriority();
		q1.print();
		q1.deleteTopPriority();
		q1.print();
		q1.insert(37);
		q1.print();
		q1.deleteTopPriority();
		q1.print();
	}
}