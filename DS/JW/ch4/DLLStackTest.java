package ds_ch4;

public class DLLStackTest {

	public static void main(String[] args) {
		DLLStack stack = new DLLStack();
		DLLNode top;
		
		stack.push(new DLLNode(0));
		stack.printDLLStack();
		stack.push(new DLLNode(2));
		stack.printDLLStack();
		stack.push(new DLLNode(4));
		stack.printDLLStack();
		
		top = stack.top();
		System.out.println("top : " + top.getData());
		System.out.println("empty? " + stack.isEmtpy());
		
		stack.pop();
		stack.printDLLStack();
		stack.pop();
		stack.printDLLStack();
		stack.pop();
		stack.printDLLStack();
		
		System.out.println("empty? " + stack.isEmtpy());
	}
}
