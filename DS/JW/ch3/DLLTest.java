package ds;

public class DLLTest {

	public static void main(String[] args) {

		DLL list = new DLL();

		// Insert at first location		
		System.out.println("Insert at first location");
		list.DLLInsertAtFirst(new DLLNode(1));
		list.DLLInsertAtFirst(new DLLNode(2));
		list.DLLInsertAtFirst(new DLLNode(5));		
		list.printDLL();
		
		// Insert at last location	
		System.out.println("Insert at last location");
		list.DLLInsertAtLast(new DLLNode(10));
		list.DLLInsertAtLast(new DLLNode(20));
		list.DLLInsertAtLast(new DLLNode(30));
		list.printDLL();
		
		// Insert node with position
		System.out.println("Insert node with position");
		list.DLLInsert(new DLLNode(100),  1);
		list.DLLInsert(new DLLNode(200),  8);
		list.DLLInsert(new DLLNode(300),  3);
		
		
		
		list.printDLL();
		
		
		
		
		
		
		
		
		System.out.println("size of list : " + list.getDLLSize());
		
		
		
	}

}
