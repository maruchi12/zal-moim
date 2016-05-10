package ds_ch4;

public class ch4_8 {

	public static void main(String[] args) {

		String ex1 = "abXba";
		String ex2 = "aaabbbXbbbaaa";
		String ex3 = "aabbbXbbbaaa";
				
		System.out.println("String(" + ex1 + ")\t\t -> palindrome : " + ch4_8.isPalindrome(ex1));
		System.out.println("String(" + ex2 + ")\t\t -> palindrome : " + ch4_8.isPalindrome(ex2));
		System.out.println("String(" + ex3 + ")\t\t -> palindrome : " + ch4_8.isPalindrome(ex3));

	}
	
	public static boolean isPalindrome(String str) {
		boolean result = true;
		int start = 0;
		int end = str.length() - 1;
		
		while(str.charAt(start) != 'X' && str.charAt(end) != 'X') {
			
			if(str.charAt(start) != str.charAt(end)) {
				//System.out.println("This string is not palindrome");
				result = false;
				break;
			}
			
			start++;
			end--;			
		}
		
		return result;
	}

}
