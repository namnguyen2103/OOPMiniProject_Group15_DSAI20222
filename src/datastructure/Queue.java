package datastructure;

import java.util.Scanner;

public class Queue {
	// A class to represent a queue
	private int[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue
 
    // Constructor to initialize a queue
    public Queue(int size)
    {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    // Utility function to dequeue the front element
    public int delete()
    {
        // check for queue underflow
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
 
        int x = arr[front];
 
        System.out.println("Removing " + x);
 
        front = (front + 1) % capacity;
        count--;
 
        return x;
    }
    
    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to add to the queue: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

     // check for queue overflow
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(-1);
        }
 
        System.out.println("Inserting " + number);
 
        rear = (rear + 1) % capacity;
        arr[rear] = number;
        count++;
    }

 
    // Utility function to return the front element of the queue
    public int front()
    {
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return arr[front];
    }
    
    // Utility function to return the front element of the queue
    public int rear()
    {
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return arr[rear];
    }
 
    // Utility function to return the size of the queue
    public int size() {
        return count;
    }
 
    // Utility function to check if the queue is empty or not
    public boolean isEmpty() {
        return (size() == 0);
    }
 
    // Utility function to check if the queue is full or not
    public boolean isFull() {
        return (size() == capacity);
    }    
	 
	// Testing
	public static void main (String[] args)
    {
        // create a queue of capacity 5
        Queue q = new Queue(5);
 
        q.insert();
        q.insert();
        q.insert();
         
        System.out.println("The front element is " + q.front());
        System.out.println("The rear element is " + q.rear());
        q.delete();
        System.out.println("The front element is " + q.front());
        System.out.println("The rear element is " + q.rear());
 
        System.out.println("The queue size is " + q.size());
 
        q.delete();
        System.out.println("The front element is " + q.front());
        System.out.println("The rear element is " + q.rear());
        q.delete();
 
        if (q.isEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }
    } 
}
