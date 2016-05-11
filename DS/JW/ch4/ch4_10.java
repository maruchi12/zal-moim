package ds_ch4;

import java.util.Stack;

public class ch4_10 extends Stack {

	public static void main(String[] args) {

		String ex1 = "abXba";
		String ex2 = "aaabbbXbbbaaa";
		String ex3 = "aabbbXbbbaaa";
		String ex4 = "aaabbbXbbbaa";
				
		System.out.println("String(" + ex1 + ")\t\t -> palindrome : " + ch4_10.isPalindromeByStack(ex1));
		System.out.println("String(" + ex2 + ")\t\t -> palindrome : " + ch4_10.isPalindromeByStack(ex2));
		System.out.println("String(" + ex3 + ")\t\t -> palindrome : " + ch4_10.isPalindromeByStack(ex3));
		System.out.println("String(" + ex4 + ")\t\t -> palindrome : " + ch4_10.isPalindromeByStack(ex4));

	}
	
	public static boolean isPalindromeByStack(String str) {
		Stack<Character> stack = new Stack<Character>();
		boolean result = true;
		char ch, stackCh;
		int index = 0;
		
		// X를 만날때까지 stack에 push
		while(str.charAt(index) != 'X') {			
			stack.push(new Character(str.charAt(index)));
			index++;			
		}
		
		index++;
		
		// stack이 빌 때까지 pop. pop한 data와 X 다음의 문자를 순차대로 비교해서 틀리면 false return
		//while(!stack.isEmpty()) {
		while(index < str.length()) {
			if(stack.isEmpty()) {		// X 앞단의 문자열 길이가 짧음. 회문 X
				System.out.println("String still has characters but stack is empty");
				result = false;
				break;
			}
			
			ch = str.charAt(index);
			stackCh = stack.pop().charValue();
			
			//System.out.println("ch : " + ch + ", stackCh : " + stackCh);
			if(ch != stackCh) {
				result = false;
				break;
			}
			
			index++;
		}
		
		if(!stack.isEmpty()) {		// X 뒷단의 문자열 길이가 짧음. 회문 X
			System.out.println("String is end but stack still has characters");
			result = false;			
		}
		
		return result;
	}

}
