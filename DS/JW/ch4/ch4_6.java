package ds_ch4;

import java.util.Stack;

// ch4-6, ch4-7 
public class ch4_6 extends Stack {

	private Stack<Integer> mainStack;
	private Stack<Integer> minStack;
	public final static int INVALID_VALUE = 0xffff;
	
	public ch4_6() {
		mainStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int data) {
		int top;
		
		mainStack.push(new Integer(data));
		
		if(!minStack.isEmpty()) {
			top = minStack.peek().intValue();
			
			if(data < top) 
				minStack.push(new Integer(data));
			else
				minStack.push(new Integer(top));
		} 
		else {
			minStack.push(new Integer(data));
		}
	}
	
	// ch4-7
	public void enhancedPush(int data) {
		
		mainStack.push(new Integer(data));
		
		// minStack�� empty stack �̰ų� data�� minStack�� top���� �۰ų� ���� ���� push�Ѵ� 
		if(minStack.isEmpty() || data <= minStack.peek().intValue()) {
			minStack.push(new Integer(data));
		}
	}
	
	public int popFromMain() {
		int data = INVALID_VALUE;
		int min = INVALID_VALUE;
		
		if(mainStack.isEmpty()) {
			System.out.println("Stack is empty");
			
			return data;
		}
				
		min = minStack.pop().intValue();
		data = mainStack.pop().intValue();
		
		System.out.println("min : " + min + " data : " + data);
		
		return data;
	}
	
	// ch4-7
	public int enhancedPop() {
		int data = INVALID_VALUE;
		
		if(mainStack.isEmpty()) {
			System.out.println("Stack is empty");
			
			return data;
		}
		
		data = mainStack.pop().intValue();
		
		// minStack�� top�� mainStack�� top�� ���� ��쿡�� minStack���� pop �Ѵ�
		// mainStack�� empty�� �ƴҰ�� minStack�� empty�� �ƴ�
		if(data == minStack.peek().intValue()) {
			//System.out.println("data == top of minStack");
			minStack.pop();
		}
		
		return data;		
	}
	
//	�������̵�!!!	
//	public int pop() {
//		int data = INVALID_VALUE;
//		int min = INVALID_VALUE;
//		
//		if(mainStack.isEmpty()) {
//			System.out.println("Stack is empty");
//			
//			return data;
//		}
//				
//		min = minStack.pop().intValue();
//		data = mainStack.pop().intValue();
//		
//		System.out.println("min : " + min + " data : " + data);
//		
//		return data;
//	}
	
	public int getMinimum() {
		int min = INVALID_VALUE;
		
		if(!minStack.isEmpty()) {			
			min = minStack.peek().intValue();
		}
		
		return min;
	}
	
	public int top() {
		if(mainStack.isEmpty()) {
			System.out.println("Stack is empty");
			
			return INVALID_VALUE;
		}
		
		return mainStack.peek().intValue();
	}
	
	public boolean isEmpty() {
		return mainStack.isEmpty();
	}
}
