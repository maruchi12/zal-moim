package queue;

/**
 * Protocols for queues.
 */
public interface Queue {
	/**
	 * Insert a new item into the queue.
	 */
	void enqueue(int data);
	
	/**
	 * Return and remove the least recently inserted item from the queue.
	 */
	int dequeue();
	
	/**
	 * Test if the queue is logically empty.
	 */
	boolean isEmpty();
	
	/**
	 * Test if the queue is logically full.
	 */
	boolean isFull();
}
