package queue;

import java.util.NoSuchElementException;

public class SimpleDequeue implements Dequeue {
	private DLLNode front;
	private DLLNode rear;
	
	private SimpleDequeue() {
		this.front = null;
		this.rear = null;
	}
	
	public static SimpleDequeue createQueue() {
		return new SimpleDequeue();
	}
	
	@Override
	public boolean isEmpty() {
		if(front == null)
			return true;
		
		return false;
	}
	
	@Override
	public void addFirst(int data) {
		DLLNode node = new DLLNode(data);
		
		if(isEmpty()) {
			front = node;
			rear = node;
		} else {
			node.setNext(front);
			front.setPrev(node);
			front = node;
		}
	}

	@Override
	public void addLast(int data) {
		DLLNode node = new DLLNode(data);
		
		if(isEmpty()) {
			front = node;
			rear = node;
		} else {
			node.setPrev(rear);
			rear.setNext(node);
			rear = node;
		}
	}

	@Override
	public int removeFirst() {
		if(isEmpty()){
			try {
				throw new NoSuchElementException("!Queue Empty!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return -1;
		}
		else {
			int data = front.getData();
			front = front.getNext();
			if(front != null) // consider the last element
				front.setPrev(null);
			return data;
		}
	}

	@Override
	public int removeLast() {
		if(isEmpty()){
			try {
				throw new NoSuchElementException("!Queue Empty!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return -1;
		}
		else {
			int data = rear.getData();
			rear = rear.getPrev();
			if(rear != null)
				rear.setNext(null);
			return data;
		}
	}

	@Override
	public String toString() {
		String s = "SimpleDequeue>> [(rear) ";
		
		DLLNode current = rear;
		
		if(front == null && rear == null)
			s += "No elments in queue!! ";
		else {
			while(current != null) {
				s += current.getData() + " ";
				current = current.getPrev();
			}
		}
		s +="(front)]";
				
		return s;
	}
}
