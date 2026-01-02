import java.util.*;

public class Stack {
	// Implement a stack using an array
	public static final int SIZE = 999;
	int[] stack;
	int top;

	public Stack() {
		//Constructor
		this.stack = new int[SIZE];
		this.top = -1;
	}

	public boolean empty() {
		if (this.top == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean push(int value) {
		if (this.is_full()) {
			return false;
		}		
		this.top += 1;
		this.stack[this.top] = value;
		return true;
	}

	public void pop() {		
		this.stack[this.top] = 0;
		this.top -= 1;
	}

	public int top() {
		return this.stack[this.top];
	}

	public boolean is_full() {
		if (this.top == SIZE) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Stack s1 = new Stack();
		if (s1.empty()) {
			System.out.println("Stack is empty.");	
		}
		s1.push(1);
		s1.push(2);
		s1.push(3);
		System.out.println(s1.top());
		s1.pop();
		System.out.println(s1.top());
	}
}