package queue;

public class CircularQueueTest {

	public static void main(String[] args) {
		CircularQueue arrayQueue = new CircularQueue();
		
		for(int i = 0; i < arrayQueue.getCapacity(); i++)
			arrayQueue.enqueue(i);
		System.out.println(arrayQueue);
		
		arrayQueue.enqueue(6); 	// overflow
		
		arrayQueue.dequeue();
		System.out.println(arrayQueue);
		
		arrayQueue.dequeue();
		System.out.println(arrayQueue);
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		System.out.println(arrayQueue);
		arrayQueue.dequeue(); 	// underflow	
	}
}
