package queue;

public class LinkedQueueTest {

	public static void main(String[] args) {
		LinkedQueue linkedQueue = LinkedQueue.createQueue();
		
		for(int i = 0; i < 3; i++)
			linkedQueue.enqueue(i);
		System.out.println(linkedQueue);
		
		linkedQueue.enqueue(4);
		System.out.println(linkedQueue);
	}
}
