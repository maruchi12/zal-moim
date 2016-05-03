package ds_ch4;

public class ch4_6_test {

	public static void main(String[] args) {

		ch4_6 stack = new ch4_6();
		
		stack.push(2);
		stack.push(6);
		stack.push(4);
		stack.push(1);
		stack.push(5);
		
		System.out.println("getMinimum : " + stack.getMinimum());
		System.out.println("top : " + stack.top());
		System.out.println("isEmpty : " + stack.isEmpty());
		
		System.out.println("pop : " + stack.popFromMain());
		System.out.println("pop : " + stack.popFromMain());
		System.out.println("pop : " + stack.popFromMain());
		System.out.println("pop : " + stack.popFromMain());
		//System.out.println("pop : " + stack.pop());
		
		
		
	}

}
