package queue;

import java.util.NoSuchElementException;

public class LinkedQueue  implements Queue {
	private Node frontNode;
	private Node rearNode;
	private LinkedQueue() {
		this.frontNode = null;
		this.rearNode = null;
	}
	 
	public static LinkedQueue createQueue() {
		return new LinkedQueue();
	}

	public boolean isEmpty() {
		return frontNode == null;
	}

	public void enqueue(int data) {
		Node newNode = new Node(data);
		if(rearNode != null) {
			rearNode.setNext(newNode);
		}
	}

	public int dequeue() {
		int data = 0;
		if(isEmpty()) {
			throw new NoSuchElementException("!Queue Empty!");
		} else {
			data = frontNode.getData();
			frontNode = frontNode.getNext();
		}
		
		return data;
	}
}
