package ds;

public class DLL {
	private DLLNode headNode = null;
	private DLLNode tailNode = null;
	private int length = 0;
	
	public DLLNode getHeadNode() {
		if(this.headNode == null) {
			System.out.println("DLL is empty");	
			return null;
		}
		
		return this.headNode;
	}
	
	public DLLNode getTailNode() {
		if(this.headNode == null) {
			System.out.println("DLL is empty");	
			return null;
		}
		
		return this.tailNode;
	}
	
	public int getDLLSize() {
		return length;
	}
	
	// print data of list
	public void printDLL() {
		DLLNode currNode = this.headNode;
		
		if(this.headNode == null){			
			System.out.println("DLL is empty");			
			return;
		}			
		
		while(currNode != null) {
			System.out.print("-> " + currNode.getData());
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
		else
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
	
	// ch3-2
	public DLLNode findNodeFromTail(int position) {
		DLLNode currNode = this.tailNode;
		int count = 1;
		int size = getDLLSize();
		
		if(this.headNode == null) {
			System.out.println("empty list");
			return null;
		}
		
		if(position > size || position < 1) {
			System.out.println("position value is invalid");
			return null;
		}
		
		while(count < position) {
			currNode = currNode.getPrev();
			count++;			
		}
		
		return currNode;
	}
	
	// ch3-4
	public DLLNode findNodeFromHead(int position) {
		DLLNode currNode = this.headNode;
		int count = 1;
		int size = getDLLSize();
		
		if(this.headNode == null) {
			System.out.println("empty list");
			return null;
		}
		
		if(position > size || position < 1) {
			System.out.println("position value is invalid");
			return null;
		}
		
		// n번째 node를 찾기 위한 시간 복잡도 O(n)
		while(count < position) {
			currNode = currNode.getNext();
			count++;			
		}
		
		return currNode;
		
	}
	
	// ch3-5
	public DLLNode findNodeFromTail2(int position) {
		DLLNode currNode = this.headNode;
		DLLNode tempNode = this.headNode;
		int count = 0; 
		
		if(this.headNode == null) {
			System.out.println("empty list");
			return null;
		}
		
		while(tempNode != null) {
			count++;
			
			if(count > position) 
				currNode = currNode.getNext();
			
			tempNode = tempNode.getNext();
		}
		
		if(currNode != null)
			return currNode;
		else
			return null; 		
	}
	
	
	// ch3-5
	// 교재 코드 이상함.. 일단 아래대로 하면 compile error가 남
	// 조건문도 이상함.. 
//	public DLLNode findNodeFromTail2(int position) {
//		DLLNode currNode;
//		DLLNode tempNode;
//		int count = 0;
//		int size = getDLLSize();
//		
//		if(this.headNode == null) {
//			System.out.println("empty list");
//			return null;
//		}
//		
//		for(tempNode = this.headNode; tempNode != null; ) {
//			count++;
//			if(position - count == 0)
//				currNode = this.headNode;
//			else if(position - count > 0) 
//				currNode = currNode.getNext();
//			
//			tempNode = tempNode.getNext();
//		}
//				
//		if(currNode != null)
//			return currNode;
//		return null;			
//	}
	
	// ch3-7
	// loop list를 만들기 위한 임시 method
	// ch3-7 테스트 외엔 사용을 금한다
	public void buildLoop(DLLNode loopNode) {
		
		if(this.headNode == null) {
			System.out.println("empty list");
			return;
		}
		
		this.tailNode.setNext(loopNode);		
	}
	
}
