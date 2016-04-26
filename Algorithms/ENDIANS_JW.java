import java.util.Scanner;

public class ENDIANS {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// unsigned int까지 고려하여 long으로 선언. java에서는 왜 unsigned를 지원하지 않나여...  
		long count = sc.nextLong();
		long number = 0;	
		
		for(int i = 0; i < count; i++) {
			number = sc.nextLong();
			System.out.println(convertEndians(number));
		}
		
		sc.close();
	}
	
	// input param : 32byte unsigned integer 
	public static long convertEndians(long originalNum) {
		long n1 = 0, n2 = 0, n3 = 0, n4 = 0;
		long convertedNum = 0;
		
		n1 = originalNum & 0xFF000000;
		n2 = originalNum & 0x00FF0000;
		n3 = originalNum & 0x0000FF00;
		n4 = originalNum & 0x000000FF;
		
		n1 >>>= 24;
		n2 >>>= 8;
		n3 <<= 8;
		n4 <<= 24;
		
		convertedNum |= n1;
		convertedNum |= n2;
		convertedNum |= n3;
		convertedNum |= n4;
		
		return convertedNum;
	}
}
