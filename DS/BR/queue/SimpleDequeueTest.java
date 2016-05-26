package queue;

public class SimpleDequeueTest {

	public static void main(String[] args) {
		SimpleDequeue simpleDeq = SimpleDequeue.createQueue();
		
		simpleDeq.removeFirst();
		simpleDeq.addLast(10);
		simpleDeq.addFirst(1);
		simpleDeq.addLast(20);
		simpleDeq.addFirst(2);
		simpleDeq.addFirst(3);
		System.out.println(simpleDeq);
		
		simpleDeq.removeFirst();
		System.out.println(simpleDeq);
		
		simpleDeq.addFirst(4);
		System.out.println(simpleDeq);
		
		simpleDeq.removeLast();
		simpleDeq.removeLast();
		System.out.println(simpleDeq);
		
		simpleDeq.removeFirst();
		simpleDeq.removeLast();
		simpleDeq.removeFirst();
		System.out.println(simpleDeq);
		
		simpleDeq.removeFirst();
	}
}
