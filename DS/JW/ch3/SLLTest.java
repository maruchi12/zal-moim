package ds;

public class SLLTest {

	public static void main(String[] args) {

		SLL list = new SLL();
		SLLNode headNode = null;

		// Initialize SLL with HeadNode
		headNode = new SLLNode(0);
		list.initSLL(headNode);
		
		// Insert node to SLL		
		System.out.println("\nBuild SLL");
		for(int i = 0; i < 5; i++) {			
			list.insertToSLL(new SLLNode((int)(Math.random() * 50)), i + 2);			
		}
		
		list.printSLL();
		System.out.println("length of list : " + list.getSLLSize());
		
		// Delete node from SLL
		System.out.println("\nDelete a Node");
		list.deleteNodeFromSLL(3);
		list.printSLL();
		
		list.deleteNodeFromSLL(1);
		list.printSLL();
		
		// Delete all node			
		System.out.println("\nDelete All");
		list.deleteSLL();
		list.printSLL();
	}
}
