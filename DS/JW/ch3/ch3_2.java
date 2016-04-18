package ds;

// DLL, DLLNode class�� ����Ѵ�
// DLL���� Tailnode�� Ȱ���ؼ� �ڿ������� n ��° node�� ã�� ��� O(n)���� ã�� �� �ִ�
// ���� tail node�� ����ϱ� ���ؼ��� O(1) ��� �������⵵�� �䱸

public class ch3_2 {

	public static void main(String[] args) {

		DLL list = new DLL();
		DLLNode node;

		// build DLL with random data
		for(int i = 0; i < 10; i++) {			
			list.DLLInsertAtFirst(new DLLNode((int)(Math.random() * 50)));			
		}					
		list.printDLL();
		
		System.out.println("������ " + 3 + "��° node : " + list.findNodeFromTail(3).getData());
		System.out.println("������ " + 5 + "��° node : " + list.findNodeFromTail(5).getData());
		System.out.println("������ " + 10 + "��° node : " + list.findNodeFromTail(10).getData());
		//System.out.println("������ " + 11 + "��° node : " + list.findNodeFromTail(11).getData());
	}	
}
