package ds_ch4;

public class DynArrayStack {
	private int top;
	private int capacity;
	private int[] array;
	
	public DynArrayStack() {
		capacity = 1;
		array = new int[capacity];
		top = -1;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isStackFull() {
		return (top == capacity - 1);
	}
	
	public void push(int data) {
		if(isStackFull())
			doubleStack();
		
		array[++top] = data;
	}
	
	private void doubleStack() {
		int newArray[] = new int[capacity * 2];
		System.arraycopy(array, 0, newArray, 0, capacity);
		capacity = capacity * 2;
		array = newArray;
		
		System.out.println("Stack capacity is doubled");
	}
	
	public int pop() {
		if(isEmpty()){
			System.out.println("Stack overflow");
			return -1;
		}
		else
			return (array[top--]);
	}
	
	public void deleteStack() {
		top = -1;
	}
	
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return; 
		}
		
		for(int i = 0; i <= top; i++) {
			System.out.print(" -> " + array[i]);
		}
		System.out.println("");
	}
}
