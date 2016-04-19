package ds;

public class ch3_5 {

	private final static int LIST_SIZE = 10;

	public static void main(String[] args) {
	
		DLL list = new DLL();
		int size = 0;
		int n = 0;
	
		// build DLL with random data
		for(int i = 0; i < LIST_SIZE; i++) {			
			list.DLLInsertAtFirst(new DLLNode((int)(Math.random() * 50)));			
		}					
		list.printDLL();
		size = list.getDLLSize();
	
		
		
		
		
		// 뒤에서 n 번째 node 찾기
		n = 3;		
		System.out.println(n + " 번째 node : " + list.findNodeFromTail2(n).getData());
		
		n = 7;
		System.out.println(n + " 번째 node : " + list.findNodeFromTail2(n).getData());
	}

}
