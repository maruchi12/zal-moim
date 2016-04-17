package ds;

public class DLLNode {
	private int data;
	private DLLNode next;
	private DLLNode previous;
	
	public DLLNode(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data; 
	}
	
	public void setNext(DLLNode next) {
		this.next = next;
	}
	
	public DLLNode getNext() {
		return this.next;
	}
	
	public void setPrev(DLLNode previous) {
		this.previous = previous;
	}
	
	public DLLNode getPrev() {
		return this.previous;
	}
}
