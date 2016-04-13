package ds;

public class SLLNode {
	private int data;
	private SLLNode next;
	
	public SLLNode(int data) {
		this.data = data;
		this.next = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data; 
	}
	
	public void setNext(SLLNode next) {
		this.next = next;
	}
	
	public SLLNode getNext() {
		return next;
	}
}
