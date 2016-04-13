package ds;

public class SLL {

	SLLNode headNode = null;

	// TODO
	// isEmtpy() method 구현
	
	// return length of SLL
	public int getSLLSize() {
		int length = 0;
		SLLNode currNode = this.headNode;
		
		while(currNode != null) {			
			length++;
			currNode = currNode.getNext();
		}
		
		return length;		
	}
	
	// print data of list
	public void printSLL() {
		SLLNode currNode = this.headNode;
		
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

	// Initialize SLL with HeadNode
	void initSLL(SLLNode headNode) {
		
		if(headNode == null){
			System.out.println("headNode is null");
			
		} else {
			System.out.println("SLL is initialized successfully with headNode (data : " + headNode.getData() + ")");
			this.headNode = headNode;			
		}
		
		return;
	}
	
	// Insert a node
	void insertToSLL(SLLNode nodeToInsert, int position) {
		// if list is empty
		if(this.headNode == null) {
			this.headNode = nodeToInsert;
			return;
		}	
		
		int size = getSLLSize();
		if(position > size + 1 || position < 1) {
			System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
		}
		
		if(position == 1) {		// when add new node at first location
			nodeToInsert.setNext(this.headNode);
			this.headNode = nodeToInsert;
		} else {
			SLLNode previousNode = this.headNode;
			int location = 1;

			// find previous node
			while(location < position - 1) {
				previousNode = previousNode.getNext();
				location++;
			}
			nodeToInsert.setNext(previousNode.getNext());
			previousNode.setNext(nodeToInsert);
		}		
	}
	
	// Delete a node
	void deleteNodeFromSLL(int position) {
		int size = getSLLSize();
		if(position > size || position < 1) {
			System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size));
		}
		
		if(position == 1) {		// Delete first node
			SLLNode currNode = this.headNode.getNext();
			this.headNode.setData(0);
			this.headNode.setNext(null);			
			this.headNode = currNode;			
		} else {
			SLLNode prevNode = headNode;
			int location = 1;
			while(location < position - 1) {
				prevNode = prevNode.getNext();
				location++;
			}
			SLLNode currNode = prevNode.getNext();
			prevNode.setNext(currNode.getNext());
			currNode = null;			
		}				
	}
	
	// Delete whole list
	void deleteSLL() {
		SLLNode tempNode;		
		
		while(this.headNode != null) {
			tempNode = headNode.getNext();
			this.headNode = tempNode;
		}	
		
		
// 교재와 같이 하면 삭제가 안되다! Node와  list 분리 후 재 확인		
//		SLLNode tempNode, iterator = headNode;		
//		
//		while(iterator != null) {
//			tempNode = iterator.getNext();
//			iterator = null;
//			iterator = tempNode;
//		}				
		
	}
	
}





















/*
 public class SLL {
	private int data;
	private SLL next;
	
	public SLL(int data) {
		this.data = data;
		this.next = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data; 
	}
	
	public void setNext(SLL next) {
		this.next = next;
	}
	
	public SLL getNext() {
		return next;
	}
	
	// return length of SLL
	public int getSLLSize(SLL headNode) {
		int length = 0;
		SLL currNode = headNode;
		
		while(currNode != null) {
			// temporary debug print
			//System.out.print(currNode.getData() + " ");
			
			length++;
			currNode = currNode.getNext();
		}
		
		//System.out.println(" ");
		
		return length;		
	}
	
	// print data of list
	public void printSLL(SLL headNode) {
		SLL currNode = headNode;
		
		if(headNode == null){
			System.out.println("SLL list is empty");
			
			return;
		}			
		
		while(currNode != null) {
			System.out.print(currNode.getData() + " ");
			currNode = currNode.getNext();
		}
		
		System.out.println(" ");
	}
	
	// Insert a node
	SLL insertToSLL(SLL headNode, SLL nodeToInsert, int position) {
		// if list is empty
		if(headNode == null)
			return nodeToInsert;
		
		int size = getSLLSize(headNode);
		if(position > size + 1 || position < 1) {
			System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
		}
		
		if(position == 1) {		// when add new node at first location
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		} else {
			SLL previousNode = headNode;
			int location = 1;

			// find previous node
			while(location < position - 1) {
				previousNode = previousNode.getNext();
				location++;
			}
			nodeToInsert.setNext(previousNode.getNext());
			previousNode.setNext(nodeToInsert);
		}
		
		return headNode;		
	}
	
	// Delete a node
	SLL deleteNodeFromSLL(SLL headNode, int position) {
		int size = getSLLSize(headNode);
		if(position > size || position < 1) {
			System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size));
		}
		
		if(position == 1) {
			SLL currNode = headNode.getNext();
			headNode = null;
			return currNode;	
		} else {
			SLL prevNode = headNode;
			int location = 1;
			while(location < position - 1) {
				prevNode = prevNode.getNext();
				location++;
			}
			SLL currNode = prevNode.getNext();
			prevNode.setNext(currNode.getNext());
			currNode = null;
			
		}
		return headNode;		
	}
	
	// Delete whole list
	void deleteSLL(SLL headNode) {
		SLL tempNode;		
		
		while(headNode != null) {
			tempNode = headNode.getNext();
			headNode = null;
			headNode = tempNode;
		}	
		
		
// 교재와 같이 하면 삭제가 안되다! Node와  list 분리 후 재 확인		
//		SLLNode tempNode, iterator = headNode;		
//		
//		while(iterator != null) {
//			tempNode = iterator.getNext();
//			iterator = null;
//			iterator = tempNode;
//		}				
		
	}
	
}
 
 */
