package ds_ch4;

import java.util.Stack;

public class ch4_4 extends Stack {

	public static void main(String[] args) {

		String ex1 = "123*+5-";	
		String ex2 = "45+7-";
		String ex3 = "12+4*5-";
		
		System.out.print("expression(" + ex1 + ") \t-> " + ch4_4.calculatePostfix(ex1));		
		System.out.print("\nexpression(" + ex2 + ") \t-> " + ch4_4.calculatePostfix(ex2));
		System.out.print("\nexpression(" + ex3 + ") \t-> " + ch4_4.calculatePostfix(ex3));
		
	}
	
	public static int calculatePostfix(String expression) {
		Stack<Integer> stack = new Stack<Integer>();
		char token;
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		for(int i = 0; i < expression.length(); i++) {
			token = expression.charAt(i);
			
			// operand와 operator의 구분은?
			// 일단 사칙연산 operator에 대해서만 구현
			// TODO: 나머지 연산자에 대한 구분  
			if(token == '+' || token == '-' || token == '*' || token == '/') {
					
				num2 = stack.pop().intValue();
				num1 = stack.pop().intValue();
				
				//System.out.println("token : " + token + " num2 : " + num2 + " num1 : " + num1);
				
				switch(token) {
					case '+':
					{
						result = num1 + num2;
						break;
					}
					case '-':
					{
						result = num1 - num2;
						break;
					}
					case '*':
					{
						result = num1 * num2;
						break;
					}
					case '/':
					{
						result = num1 / num2;
						break;
					}						
				}
				
				stack.push(new Integer(result));
				//System.out.println("push result : " + result);
			} 
			else {
				// push if token is operand
				
				// char값을 -> integer로 고대로 쓰고 싶을때는?
				// char -> String 변환 과정을 거쳐야 하나? char 값 고대로를 integer로 못 변경하나?
				String str = String.valueOf(token);				
				stack.push(new Integer(Integer.valueOf(str)));
				//System.out.println("push : " + token);
			}
		}
		
		return stack.pop().intValue();

	}
}
