package queue;

public class DynCircularQueueTest {

	public static void main(String[] args) {
		DynCircularQueue dynCircularQueue = DynCircularQueue.createDynCircularQueue(3);
		//DynCircularQueue dynCircularQueue = new DynCircularQueue();
		
		for(int i = 0; i < 3; i++)
			dynCircularQueue.enqueue(i);
		System.out.println(dynCircularQueue);
		
		dynCircularQueue.enqueue(4);
		System.out.println(dynCircularQueue);
	}
}
