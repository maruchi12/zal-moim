package queue;

/**
 * Protocols for double-ended queues. (stack + queue)
 */
public interface Dequeue {
	/**
	 * Inserts data at the front of this deque.
	 */	
	void addFirst(int data);
	
	/**
	 * Inserts data at the end of this deque.
	 */	
	void addLast(int data);
	
	/**
	 * Retrieves and removes data at the front of this deque.
	 */
	int removeFirst();
	
	/**
	 * Retrieves and removes data at the end of this deque.
	 */	
	int removeLast();
	
	/**
	 * Test if the queue is logically empty.
	 */
	boolean isEmpty();
}
