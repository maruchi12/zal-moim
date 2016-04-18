package ds;

// DLL, DLLNode class를 사용한다
// DLL에서 Tailnode를 활용해서 뒤에서부터 n 번째 node를 찾을 경우 O(n)으로 찾을 수 있다
// 또한 tail node를 사용하기 위해서는 O(1) 상수 공간복잡도를 요구

public class ch3_2 {

	public static void main(String[] args) {

		DLL list = new DLL();
		DLLNode node;

		// build DLL with random data
		for(int i = 0; i < 10; i++) {			
			list.DLLInsertAtFirst(new DLLNode((int)(Math.random() * 50)));			
		}					
		list.printDLL();
		
		System.out.println("끝에서 " + 3 + "번째 node : " + list.findNodeFromTail(3).getData());
		System.out.println("끝에서 " + 5 + "번째 node : " + list.findNodeFromTail(5).getData());
		System.out.println("끝에서 " + 10 + "번째 node : " + list.findNodeFromTail(10).getData());
		//System.out.println("끝에서 " + 11 + "번째 node : " + list.findNodeFromTail(11).getData());
	}	
}
