package ds;
import java.util.*;

public class ch3_7_9 {
	private final static int LIST_SIZE = 10;

	public static void main(String[] args) {
		DLL list = new DLL();
		DLLNode loopNode;
		
		// build DLL with random data
		for(int i = 0; i < LIST_SIZE; i++) {			
			list.DLLInsertAtFirst(new DLLNode((int)(Math.random() * 50)));			
		}					
		list.printDLL();
		
		// loop가 있는 list 만들기
		loopNode = list.findNodeFromHead(4);
		list.buildLoop(loopNode);
		
		System.out.println("Does this list have loop ? " + ch3_7_9.isListIncludeLoop(list));		
		System.out.println("Does this list have loop ? " + ch3_7_9.isListIncludeLoopByFloyd(list));
	}
	
	// ch3-7
	public static boolean isListIncludeLoop(DLL list) {
		Hashtable<DLLNode, Integer> ht = new Hashtable<DLLNode, Integer>();
		DLLNode currNode;
		boolean isLoopList = false;
		int index = 1;
		
		// create hash table 
		currNode = list.getHeadNode();
		//for(int i = 0; i < LIST_SIZE; i++) {
		while(currNode != null) {
			
			if(ht.containsKey(currNode)) {		// if current node is already exist in hash table, it means this list include loop.
				isLoopList = true;
				break;
			}			
			
			ht.put(currNode, index);
			currNode = currNode.getNext();
			index++; 
		}		
		return isLoopList;
	}
	
	// ch3-9
	public static boolean isListIncludeLoopByFloyd(DLL list) {
		DLLNode slowNode = list.getHeadNode();
		DLLNode fastNode = list.getHeadNode();
		
		while(slowNode != null && fastNode != null) {
			fastNode = fastNode.getNext();			
			if(fastNode == slowNode)
				return true;
			
			if(fastNode == null)
				return false;
			
			fastNode = fastNode.getNext();
			if(fastNode == slowNode)
				return true;
			
			slowNode = slowNode.getNext();
		}
		return false;
	}

}
