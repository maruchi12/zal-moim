package ds;
import java.util.*;

public class ch3_3 {
	
	private final static int LIST_SIZE = 10;

	public static void main(String[] args) {

		Hashtable<Integer, DLLNode> ht = new Hashtable<Integer, DLLNode>();
		DLL list = new DLL();
		DLLNode headNode;
		DLLNode currNode;
		int size = 0;
		int n;
		
		// build DLL with random data
		for(int i = 0; i < LIST_SIZE; i++) {			
			list.DLLInsertAtFirst(new DLLNode((int)(Math.random() * 50)));			
		}					
		list.printDLL();
		headNode = list.getHeadNode();
		
		// build Hash table -> list size�� m�̶� �� ��, O(m) �������⵵
		currNode = headNode;
		
		// Hash table�� �����ϴ� O(m) �ð����⵵
		for(int i = 0; i < list.getDLLSize(); i++) {
			ht.put(i+1, currNode);
			currNode = currNode.getNext();			
		}
		
		size = ht.size();
		System.out.println("hashtable size : " + size);
		
		// �ڿ��� n ��° node ã��
		n = 3;
		System.out.println(n + " ��° node : " + ht.get(size - n + 1).getData());
		
		n = 7;
		System.out.println(n + " ��° node : " + ht.get(size - n + 1).getData());
	}
}
