package queue;

public class DynArrayQueue extends ArrayQueue{
	private int front;
	private int rear;
	private int capacity;
	private int[] array;
	
	private DynArrayQueue() {
		super();
	}
	
	public static DynArrayQueue createDynArrayQueue() {
		return new DynArrayQueue();
	}
	
	private void resizeQueue() {
		int initCapacity = capacity;
		capacity *= 2;
		
		int[] oldArray = array;
		array = new int[this.capacity];
		
		for(int i : array)
			array[i] = oldArray[i];
		
		if(rear < front) {
			for(int i = 0; i < front; i++) {
				array[i + initCapacity] = this.array[i];
				array[i] = 0;
			}
			rear = rear + initCapacity;
		}
	}
	
	public void enQueue(int data) {
		if(isFull()) {
			resizeQueue();
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
}
