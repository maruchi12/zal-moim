package queue;

public class DynCircularQueue extends CircularQueue {

	public DynCircularQueue(int size) {
		super(size);
	}

	public static DynCircularQueue createDynCircularQueue(int size) {
		return new DynCircularQueue(size);
	}
	
	private void resizeQueue() {
		System.out.println("Queue is full. resize it!");
		
		capacity *= 2;
		int[] newArray = new int[capacity];
		System.arraycopy(array, 0, newArray, 0, array.length);
		
		array = newArray;
	}
	
	public void enqueue(int data) {
		if(isFull())
			resizeQueue();

		rear = (rear + 1) % capacity;
		array[rear] = data;
		if(front == -1)
			front = rear;
	}
}
