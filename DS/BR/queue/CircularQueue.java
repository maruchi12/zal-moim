package queue;

import java.util.NoSuchElementException;

public class CircularQueue implements Queue {
	protected int front;
	protected int rear;
	protected int capacity;
	protected int [] array;
	public static final int DEFAULT_CAPACITY = 6; //+
	
	public CircularQueue() {
		this.front = -1;
		this.rear = -1;
		this.capacity = DEFAULT_CAPACITY;
		this.array = new int[capacity];
	}
	
	public CircularQueue(int size) {
		this.capacity = size;
		this.front = -1;
		this.rear = -1;
		this.array = new int[size];
	}
	
	public static CircularQueue createQueue(int size) {
		return new CircularQueue(size);
	}
	
	public boolean isEmpty() {
		//return (front == -1);
		return front == rear; //-+
	}
	
	public boolean isFull() {
		if(rear == -1 && front == -1)
			return false;
		
		return ((rear + 1) % capacity == front);
	}
	
	public int getQueueSize() {
		
		if(isEmpty()) //+
			return 0;
		
		if(isFull()) //+
			return capacity;
		
		return (capacity - front + rear + 1) % capacity;
	}
	
	public void enqueue(int data) {
		if(isFull()) {
			try {
				throw new NoSuchElementException("!Queue Overflow!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			rear = (rear + 1) % capacity;
			array[rear] = data;
			if(front == -1) {
				front = rear;
			}
		}
	}
	
	public int dequeue() {
		int data = 0;
		if(isEmpty()) {
			try {
				throw new NoSuchElementException("!Queue Empty!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			data = array[front];
			//if(front == rear) {
				//front = rear - 1;
			//} else {
				front = front + 1 % capacity;	
			//}
		}
		
		return data;
	
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public String toString() {
		String s = "";
		
		s += "front: " + front + ", rear: " + rear;
		s += ", queue size: " + getQueueSize() + "\n";
		
		int count = getQueueSize();
		int i = front;
		
		if(count != 0) {
			s += "[ ";
			while(count > 0) {
				s += array[i % capacity] + " ";
				i++;
				count--;
			}
			
			s+="]\n";
		}
		
		return s;
	}
}
