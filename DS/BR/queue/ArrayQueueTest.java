package queue;

public class ArrayQueueTest {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(6);
		
		for(int i = 0; i < 6; i++)
			queue.enQueue(i);
		
		System.out.println(queue);
	}
}
