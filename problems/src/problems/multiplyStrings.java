package problems;

public class multiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "654154154151454545415415454"; 
	    String str2 = "63516561563156316545145146514654";
		multiply(str1, str2);

	}

	public static void multiply(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int[] result = new int[n1+n2];
		int n1Shift = 0;
		int n2Shift = 0;
		
		for(int i=n2-1;i>=0;i--) {
			int x = s2.charAt(i)-'0';
			int carry = 0;
			n1Shift = 0;
			for(int j=n1-1;j>=0;j--) {
				int y = s1.charAt(j)-'0';
				int sum = x * y + result[n1Shift+n2Shift] + carry;
				result[n1Shift+n2Shift] = sum%10;
				carry = sum/10;
				n1Shift+=1;
			}
			if(carry>0)
				result[n1Shift+n2Shift] = carry;
			n2Shift+=1;
		}
		int i = result.length-1;
		while(i>=0 && result[i]==0)
			i--;
		
		String s = "";
		while(i>=0) {
			s+=result[i];
			i--;
		}
		System.out.println(s);
	}
	
}
