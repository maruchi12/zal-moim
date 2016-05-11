package ds_ch4;

import java.util.Stack;

public class ch4_25 extends Stack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(new Integer(5));
		stack.push(new Integer(3));
		stack.push(new Integer(1));
		stack.push(new Integer(2));
		stack.push(new Integer(7));
		
		stack = stackSorter(stack);
		
		System.out.println("pop : " + stack.pop().intValue());
		System.out.println("pop : " + stack.pop().intValue());
		System.out.println("pop : " + stack.pop().intValue());
		System.out.println("pop : " + stack.pop().intValue());
		System.out.println("pop : " + stack.pop().intValue());
	}
	
	public static Stack<Integer> stackSorter(Stack<Integer> stack) {
		Stack<Integer> resStack = new Stack<Integer>();
		int stackTmp;
		
		while(!stack.isEmpty()) {
			stackTmp = stack.pop().intValue();
			while(!resStack.isEmpty() && resStack.peek().intValue() > stackTmp) {
				stack.push(resStack.pop());
			}
			resStack.push(new Integer(stackTmp));
		}
		
		return resStack;
	}
}
