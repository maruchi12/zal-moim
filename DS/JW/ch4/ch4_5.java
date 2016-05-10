package ds_ch4;

import java.util.Stack;

// TODO: Need to optimize
public class ch4_5 extends Stack {

	public static void main(String[] args) {

		String ex1 = "3+8-2+4";	
		
		System.out.println("expression(" + ex1 + ") \t-> " + ch4_5.calculateInfix(ex1));
	}
	
	// TODO: 괄호 처리 '()'
	public static int calculateInfix(String expression) {
		Stack<Integer> operandStack = new Stack<Integer>();
		Stack<Character> operatorStack = new Stack<Character>();
		char token;
		char tokenFromStack;
		int num1, num2, result = 0;
		
		for(int i = expression.length() - 1; i >= 0; i--) {
			token = expression.charAt(i);
			//System.out.println("token : " + token);
			
			// operand, operator 구분
			// 더 좋은 로직이 있는지 고민 필요
			// 일단 operator로 사칙연산만 고려
			if(token == '+' || token == '-' || token == '*' || token == '/') {
				
				// isEmpty가 아닐때만?
				if(!operatorStack.isEmpty()){
					tokenFromStack = operatorStack.peek().charValue();
				}
				else {
					tokenFromStack = '\0';
				}
				
				
				if(operatorStack.isEmpty() || getPriorityOfOperator(token) >= getPriorityOfOperator(tokenFromStack)) {
					//operatorStack.push(new Character(token));
				} 
				else if(!operatorStack.isEmpty() && getPriorityOfOperator(token) < getPriorityOfOperator(tokenFromStack)) {
					num1 = operandStack.pop().intValue();
					num2 = operandStack.pop().intValue();
					
					tokenFromStack = operatorStack.pop().charValue();
					
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
					
					operandStack.push(new Integer(result));
					//System.out.println("push operand : " + result);
				}
				
				operatorStack.push(new Character(token));
				//System.out.println("push operator : " + token);
				
			} 
			else {				
				// char -> string -> integer 안 거치는 방법?
				String str = String.valueOf(token);				
				operandStack.push(new Integer(Integer.valueOf(str)));
				//System.out.println("push operand : " + Integer.valueOf(str));
			}
		}
		
		while(!operatorStack.isEmpty()) {
			num1 = operandStack.pop().intValue();
			num2 = operandStack.pop().intValue();
			
			token = operatorStack.pop().charValue();
			
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
			
			operandStack.push(new Integer(result));
			//System.out.println("push operand : " + result);
		}
		
		return operandStack.pop().intValue();
	}

	private static int getPriorityOfOperator(char operator) {
		int priority = -1;
		
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
				priority = -1;
				break;
		}
		
		return priority;		
	}
	
}
