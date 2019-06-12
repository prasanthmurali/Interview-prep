package problems;

public class anagrams {
	
	static int arrayOfPrimes[] = {2,3,5,7,11,13,17,19,23,27,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "abcde";
		String s2 = "cdabe";
		String s3 = "fdgba";
		
		System.out.println("String 1:"+s1+ " String 2:"+s2 + " "+ isAnagram(s1,s2));
		System.out.println("String 1:"+s1+ " String 2:"+s2 + " "+ isAnagram(s3,s2));
		
	}
	
	public static boolean isAnagram(String s1, String s2) {
		
		int s1Value=1;
		int s2Value=1;
		
		for(int i=0;i<s1.toLowerCase().length();i++) {
			s1Value = s1Value*arrayOfPrimes[s1.charAt(i)-'a'];
			s2Value = s2Value*arrayOfPrimes[s2.charAt(i)-'a'];
		}
		
		return s1Value == s2Value;
	}
	
}
