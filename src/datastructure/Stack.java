package datastructure;
import java.util.Random;

public class Stack {
	
	public static final int MAX_SIZE = 15;
	private int top;
	private int size;
	private int[] stack;
	
	
	// Constructor
	public Stack() {
		this.top = -1;
		this.size = MAX_SIZE;
		this.stack = new int[MAX_SIZE];
	}
	public Stack(int size) {
		this.top = size - 1;
		this.size = size;
		this.stack = new int[size];
		
		Random random = new Random();
		boolean[] used = new boolean[15];
		
		for (int i = this.top; i >= 0; i--) {
			int x;
			do {
				x = random.nextInt(15);
			}
			while (used[x]);
			
			stack[i] = x;
			used[x] = true;
		}
	}

	
	// Helper functions
	public boolean isEmpty() {
		return this.top == -1;
	}
	
	
	public boolean isFull() {
		return this.top == this.size - 1;
	}
	
	
	public void push(int x) {
		this.stack[++this.top] = x; 
	}
	
	
	public int peek() {
		return this.stack[this.top];
	}
	
	
	public void print() {
		for (int i = 0; i <= this.top; i++) {
			System.out.println(this.stack[i]);
		}
	}
	
	
	// Insert, Sort, Find, Delete
	public void insert() {
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}
		
		Random random = new Random();
		boolean used[] = new boolean[15];
		
		// Iterate through every element in stack, marked as used in used array
		for (int i = this.top; i >= 0; i--) {
			used[this.stack[i]] = true;
		}
		
		// Generate a random number that is not already in the stack
		int x = random.nextInt(15);
		while (used[x]) {
			x = random.nextInt(15);
		}
			
		this.stack[++this.top] = x;
	}

	
	public void sort() {
		Stack tempStack = new Stack();
		
		while (!this.isEmpty()) {
			int temp = this.delete();
			while (!tempStack.isEmpty() && tempStack.peek() > temp) {
				this.push(tempStack.delete());
			}
			tempStack.push(temp);
		}
		
		while (!tempStack.isEmpty()) {
			this.push(tempStack.delete());
		}
	}

	
	public boolean find(int x) {
		if (isEmpty()) {
			System.out.println("Item not found");
			return false;
		}
		
		for (int i = this.top; i >= 0; i--) {
			if (this.stack[i] == x) {
				System.out.println("Item found at index " + i);
				return true;
			}
		}
		System.out.println("Item not found");
		return false;
	}

	
	public int delete() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		return this.stack[this.top--];
	}
	
	
	// Test
	public static void main (String[] args) {
		Stack test = new Stack(15);
		test.print();
		System.out.println();
		test.delete();
		test.delete();
		test.print();
		System.out.println();
		test.insert();
		test.print();
		System.out.println();
		test.sort();
		test.print();
		test.find(12);
	}
}
