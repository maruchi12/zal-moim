package ds;

/* ch3-1 */

public class DLLStack {
	private DLLNode headNode = null;
	private DLLNode tailNode = null;	// 사실 stack에서는 필요없다. Pop/push를 tail에서 한다면 모를까
	private int size = 0;
	
	public int getStackSize() {
		return this.size;
	}
	
	public void push(DLLNode newNode) {
		
		// Insert data at top
		DLLInsertAtFirst(newNode);	
	}
	
	public DLLNode pop() {
		
		// Pop data at top
		return DLLDeleteAtFirst();		
	}
	
	public DLLNode top() {
		if(headNode == null) {
			System.out.println("stack is empty");
			return null;
		} 
		
		return headNode; 
	}
	
	public boolean isEmtpy() {
		if(headNode == null)
			return true;
		else
			return false;
	}
	
	// Insert node at first location
	public void DLLInsertAtFirst(DLLNode newNode) {
		if(newNode == null) {
			System.out.println("newNode is null");
			return;
		}
		
		if(this.headNode == null) {		// empty list
			this.headNode = newNode;
			this.tailNode = newNode;			
		} else {
			newNode.setNext(this.headNode);
			newNode.setPrev(null);
			this.headNode.setPrev(newNode);
			
			// update headNode
			this.headNode = newNode;
		}
		
		this.size++;
	}
	
	// Delete head node. stack에서는 삭제 시 data node를 return 해줘야한다
	public DLLNode DLLDeleteAtFirst() {

		if(this.headNode == null) {
			System.out.println("empty stack. Pop is not executed");
			return null;
		}

		DLLNode firstNode = this.headNode;
		this.headNode = firstNode.getNext();
		if(this.headNode == null)	// if all node is deleted 
			this.tailNode = null;
		else
			this.headNode.setPrev(null);
		//firstNode = null; 

		this.size--;
		
		return firstNode;
	}
	
	// print data of list
	public void printDLLStack() {
		DLLNode currNode = this.headNode;
		
		if(this.headNode == null){			
			System.out.println("SLL is empty");			
			return;
		}			
		
		while(currNode != null) {
			System.out.print("-> " + currNode.getData());
			currNode = currNode.getNext();
		}
		
		System.out.println(" ");
	}	
}
