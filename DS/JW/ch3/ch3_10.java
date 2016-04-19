package ds;

public class ch3_10 {

	private final static int LIST_SIZE = 10;

	public static void main(String[] args) {
		DLL list = new DLL();
		DLLNode loopNode;
		
		// build DLL with random data
		for(int i = 0; i < LIST_SIZE; i++) {			
			list.DLLInsertAtFirst(new DLLNode((int)(Math.random() * 50)));			
		}					
		list.printDLL();
		
		// 달팽이 list 만들기
		loopNode = list.getHeadNode();
		list.buildLoop(loopNode);
		
		System.out.println("Is this list a snail list ? " + ch3_10.isSnailList(list.getHeadNode()));
	}

	// ch3-10
	public static boolean isSnailList(DLLNode headNode) {
		DLLNode currNode = headNode;
		boolean isSnail = false;
		
		while(currNode != null) {
			
			if(currNode.getNext() == headNode) {
				isSnail = true;
				break;
			}
			
			currNode = currNode.getNext();	
		}
		
		return isSnail;
	}
}
