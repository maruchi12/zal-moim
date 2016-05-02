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
			
			// operand�� operator�� ������?
			// �ϴ� ��Ģ���� operator�� ���ؼ��� ����
			// TODO: ������ �����ڿ� ���� ����  
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
				
				// char���� -> integer�� ���� ���� ��������?
				// char -> String ��ȯ ������ ���ľ� �ϳ�? char �� ���θ� integer�� �� �����ϳ�?
				String str = String.valueOf(token);				
				stack.push(new Integer(Integer.valueOf(str)));
				//System.out.println("push : " + token);
			}
		}
		
		return stack.pop().intValue();

	}
}
