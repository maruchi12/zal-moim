package ds;

public class DLL {
	private DLLNode headNode = null;
	private DLLNode tailNode = null;
	private int length = 0;
	
	public int getDLLSize() {
		return length;
	}
	
	// print data of list
	public void printDLL() {
		DLLNode currNode = this.headNode;
		
		if(this.headNode == null){			
			System.out.println("SLL is empty");			
			return;
		}			
		
		while(currNode != null) {
			System.out.print(currNode.getData() + " ");
			currNode = currNode.getNext();
		}
		
		System.out.println(" ");
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
		
		this.length++;
	}
	
	// Insert node at last location
	public void DLLInsertAtLast(DLLNode newNode) {
		if(newNode == null) {
			System.out.println("newNode is null");
			return;
		}
		
		if(this.tailNode == null) {		// empty list
			this.headNode = newNode;
			this.tailNode = newNode;	
		} else {
			newNode.setNext(null);
			newNode.setPrev(this.tailNode);
			this.tailNode.setNext(newNode);
			
			// update tailNode
			this.tailNode = newNode;
		}
		
		this.length++;
	}
	
	// Insert node
	public void DLLInsert(DLLNode newNode, int position) {
		if(newNode == null) {
			System.out.println("newNode is null");
			return;
		}
		
		if(this.headNode == null) {		// empty list
			this.headNode = newNode;
			this.tailNode = newNode;		
		}
		
		int size = getDLLSize();
		if(position > size + 1 || position < 1) {
			System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
			return;
		}
		
		if(position == 1) {
			DLLInsertAtFirst(newNode);
		} else {
			DLLNode prevNode = this.headNode;
			DLLNode currNode = null;
			int count = 1;
			
			while(count < position -1) {
				prevNode = prevNode.getNext();
				count++;				
			}
			currNode = prevNode.getNext();
			
			if(currNode == null) {		// previous node가 마지막 node
				DLLInsertAtLast(newNode);
			} else {	// 삽입할 위치가 리스트 중간
				newNode.setNext(currNode);
				currNode.setPrev(newNode);
				prevNode.setNext(newNode);
				newNode.setPrev(prevNode);
				
				this.length++;
			}
		}
	}
	
	// Delete head node
	public void DLLDeleteAtFirst() {
		
		if(this.headNode == null) {
			System.out.println("empty list. Delete is not executed");
			return;
		}
		
		DLLNode firstNode = this.headNode;
		this.headNode = firstNode.getNext();
		if(this.headNode == null)	// if all node is deleted 
			this.tailNode = null;
		this.headNode.setPrev(null);
		firstNode = null; 
		
		this.length--;
	}
	
	// Delete tail node
	public void DLLDeleteAtLast() {
		
		if(this.headNode == null) {
			System.out.println("empty list. Delete is not executed");
			return;
		}
		
		DLLNode lastNode = this.tailNode;
		
		this.tailNode = this.tailNode.getPrev();
		if(this.tailNode == null) // if all node is deleted 
			this.headNode = null;
		lastNode.setPrev(null);
		lastNode = null;
		this.tailNode.setNext(null);
		
		this.length--;
	}
	
	// Delete Node
	public void DLLDeleteNode(int position) {
		
		int size = getDLLSize();
		
		if(this.headNode == null) {
			System.out.println("empty list. Delete is not executed");
			return;
		}
		
		if(position > size || position < 1) {
			System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size));
			return;
		}
		
		if(position == 1) {
			DLLDeleteAtFirst();			
		} else {
			DLLNode prevNode = this.headNode;
			DLLNode currNode;
			DLLNode nextNode;
			int count = 1;
			
			while(count < position -1) {
				prevNode = prevNode.getNext();
				count++;
			}
			currNode = prevNode.getNext();
			nextNode = currNode.getNext();
			
			if(nextNode == null) {		// delete last node
				DLLDeleteAtLast(); 
			} else {	//  삽입할 node가 중간에 위치
				prevNode.setNext(nextNode);
				nextNode.setPrev(prevNode);
				currNode.setNext(null);
				currNode.setPrev(null);
				currNode = null;
				
				this.length--;				
			}			
		}
	}
	
	public void DLLDeleteAll() {
		
		DLLNode tempNode;
		
		if(this.headNode == null) {
			System.out.println("empty list. Delete is not executed");
			return;
		}
		
		while(this.headNode != null) {
			tempNode = this.headNode.getNext();
			this.headNode.setNext(null);
			this.headNode.setPrev(null);
			this.headNode = tempNode;
			
			this.length--;
		}
		
		this.tailNode = null;
	}
}
