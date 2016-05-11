package ds_ch4;

import java.util.Stack;

public class ch4_11 extends Stack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(new Integer(1));
		stack.push(new Integer(2));
		stack.push(new Integer(3));
		stack.push(new Integer(4));
		stack.push(new Integer(5));
		
		reverseStack(stack);
		
		System.out.println("pop : " + stack.pop().intValue());
		System.out.println("pop : " + stack.pop().intValue());
		System.out.println("pop : " + stack.pop().intValue());
		System.out.println("pop : " + stack.pop().intValue());
		System.out.println("pop : " + stack.pop().intValue());
		
	}
 
	public static void reverseStack(Stack<Integer> stack) {
		int temp;
		
		if(stack.isEmpty())
			return;
		
		temp = stack.pop().intValue();
		reverseStack(stack);
		insertAtBottom(stack, temp);
	}
	
	private static void insertAtBottom(Stack<Integer> stack, int data) {
		if(stack.isEmpty()) {
			stack.push(new Integer(data));
			return;
		}
		
		int temp = stack.pop().intValue();
		insertAtBottom(stack, data);
		stack.push(new Integer(temp));
	}
}
