package queue;

public class ArrayQueue {
	private int front;
	private int rear;
	private int capacity;
	private int [] array;
	
	ArrayQueue() {
		capacity = 1;
		front = -1;
		rear = -1;
		array = new int[1];
	}
	
	ArrayQueue(int size) {
		capacity = size;
		front = -1;
		rear = -1;
		array = new int[size];
	}
	
	public static ArrayQueue createQueue(int size) {
		return new ArrayQueue(size);
	}
	
	public boolean isEmpty() {
		return (front == -1);
	}
	
	public boolean isFull() {
		return ((rear + 1) % capacity == front);
	}
	
	public  int getQueueSize() {
		return (capacity - front + rear + 1) % capacity;
	}
	
	public void enQueue(int data) {
		if(isFull()) {
			try {
				throw new Exception("Queue Overflow");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			rear = (rear + 1) % capacity;
			array[rear] = data;
			if(front == -1) {
				front = rear;
			}
		}
	}
	
	public void deQueue() {
		int data = 0;
		if(isEmpty()) {
			try {
				throw new Exception(" Queue Empty");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			data = array[front];
			if(front == rear) {
				front = rear - 1;
			} else {
				front = front + 1 % capacity;	
			}
		}
	
	}
	
	public String toString() {
		String s = "";
		for(int i : array)
			s = s + " " + array[i];
		
		return s;
	}
}
