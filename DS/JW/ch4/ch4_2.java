package ds_ch4;

import java.util.EmptyStackException;
import java.util.Stack;

public class ch4_2 extends Stack {

	public static void main(String[] args) {

		String ex1 = "A+B";
		String ex2 = "A+B-C";
		String ex3 = "(A+B)*C-D";
		
		try{
			System.out.print("infix : " + ex1 + " -> postfix : ");
			ch4_2.convertInfixToPostfix(ex1);
			
		} catch(EmptyStackException e) {
			System.out.print("EmptyStackException occured!");
		}
		
		
		
	}

	public static void convertInfixToPostfix(String expression) {
		Stack<Character> stack = new Stack<Character>(); 
		char ch;
		char token;
		
		//System.out.println(expression);
		
		for(int i = 0; i < expression.length(); i++) {
			ch = expression.charAt(i);
			System.out.print(ch);
			
			if((65 <= ch && ch <= 90) || (97 <= ch && ch <= 122)) {		// A~Z, a~z
				System.out.print(ch);
			} 
			else if(ch == ')') {	
					
				while(!stack.isEmpty()) {
					token = stack.pop().charValue();
					
					if(token == '(') {
						break;
					} 
					else {
						System.out.print(token);
					}
				}
			} 
			else {
				
				if(ch == '(') {
					// none
				} 
				else {
					
					token = stack.peek().charValue();
					
					if(token == '(') {
						// none
					} 
					else {	// ch와 token 우선순위 비교. 우선순위는 일단 사칙연산만 +, -, *, /
						// token의 우선순위가 낮은경우 다음으로. 우선순위 낮다 -> 먼저 연산한다
						if(getPriorityOfOperator(token) < getPriorityOfOperator(ch)) {
							token = stack.pop().charValue();
							System.out.print(token);
						}						
					}
				}
				stack.push(Character.valueOf(ch));
			}
			
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().charValue());
		}
	}
	
	private static int getPriorityOfOperator(char operator) {
		int priority = 100;
		
		switch(operator) {
			case '+':
			case '-':
			{
				priority = 0;
				break;
			}
			case '*':
			case '/':
			{
				priority = 1;
				break;
			}
			default:
				priority = 100;
				break;
		}
		
		return priority;		
	}
	
}
