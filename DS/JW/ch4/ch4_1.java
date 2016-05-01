package ds_ch4;

import java.util.Stack;

public class ch4_1 extends Stack {

	public static void main(String[] args) {
		
		String ex1 = "(A+B)+(C+D)";
		String ex2 = "((A+B)+(C-D)";
		String ex3 = "((A+B)+[C+D])";
		String ex4 = "((A+B)+[C-D]}";
		
		System.out.println("result of expression   " + ex1 + "  : " + ch4_1.isBracketPaired(ex1) + "\n");
		System.out.println("result of expression   " + ex2 + "  : " + ch4_1.isBracketPaired(ex2) + "\n");
		System.out.println("result of expression   " + ex3 + "  : " + ch4_1.isBracketPaired(ex3) + "\n");
		System.out.println("result of expression   " + ex4 + "  : " + ch4_1.isBracketPaired(ex4) + "\n");
	}
	
	public static boolean isBracketPaired(String expression) {
		Stack<Character> stack = new Stack<Character>();
		char ch;
		char bracket;
		boolean result = true;
		
		for(int i = 0; i < expression.length(); i++) {
			ch = expression.charAt(i);
			
			if(ch == '(' || ch == '{' || ch == '[') {
				stack.push(new Character(ch));
				System.out.println("push " + ch);
			} 
			else if(ch == ')' || ch == '}' || ch == ']') {				
				
				if(stack.isEmpty()) {
					System.out.println("Stack is empty. bracket of expression is not paired");
					result = false;
					break; 
				}
				
				bracket = stack.pop();
				System.out.println("pop " + ch);
				if(ch == ')') {
					if(bracket != '(') {
						result = false;
						break;
					}
				} else if(ch == '}') {
					if(bracket != '{') {
						result = false;
						break;
					}
				} else if(ch == ']') {
					if(bracket != '[') {
						result = false;
						break;
					}
				}

			}			
		}
		
		if(!stack.isEmpty())
			result = false;		
		
		return result;
	}	
}
