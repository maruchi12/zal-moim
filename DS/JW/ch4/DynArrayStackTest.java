package ds_ch4;

public class DynArrayStackTest {

	private static int INIT_STACK_SIZE = 5;
	
	public static void main(String[] args) {

		DynArrayStack stack = new DynArrayStack();
		
		/* push */
		for(int i = 0; i < INIT_STACK_SIZE; i++) {
			stack.push((int)(Math.random() * 50));
			stack.printStack();
		}		
		//stack.printStack();
		
		/* pop */		
		System.out.println("pop : " + stack.pop());
		stack.printStack();
		System.out.println("pop : " + stack.pop());
		stack.printStack();
		System.out.println("pop : " + stack.pop());
		stack.printStack();
	}
}
