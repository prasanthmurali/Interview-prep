package problems;
import java.util.*;

public class Substring {

	public static void main(String[] args) {
		//System.out.println(lengthOfLongestSubstring("abba"));
		
//		ArrayList<String> substrings = subStrings("abc");
//		System.out.println(substrings);
		
		String s = "ababd";
		System.out.println(longestPalindrome(s));
		
	}
	
	/********/	/********/	/********/	/********/	/********/	/********/
	
	/*
	 * Longest Palindrome expand from middle
	 */
	
	public static String longestPalindrome(String s) {
		int n = s.length();
		if(s==null)
			return "";
		if(n==0 || n==1)
			return s;
		int start = 0;
		int end = 0;
		for(int i=0;i<n;i++) {
			int len1 = expandFromMiddle(s,i,i);
			int len2 = expandFromMiddle(s,i,i+1);
			int len = Math.max(len1, len2);
			if (len>end-start){
				start = i-(len-1)/2;
				end = i+len/2;
			}
		}		
		return s.substring(start,end+1);
	}
	
	public static int expandFromMiddle(String s, int left, int right) {
		if(s==null || left>right)
			return 0;
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
			left--;
			right++;
		}
		return right-left-1;
	}
	
	/********/	/********/	/********/	/********/	/********/	/********/
	
	/* 
	 * DP Longest Palindrome implementation
	 */
	public static String longestPalindromeDP(String s) {
		int n = s.length();
		if(s==null || n==0)
			return "";
		Boolean[][] palindrome = new Boolean[n][n];
		int i,j;
		
		/*
		 * Set palindrome to be false for all j<i
		 */
		for(i=0;i<n;i++) {
			for(j=0;j<i;j++)
				palindrome[i][j]=false;
		}
		
		/*
		 * Set palindrome to be true for all j=i
		 * (single letter palindrome)
		 */
		i=0;
		for(j=i;j<n;j++) {
			palindrome[j][j]=true;
		}
		
		/*
		 * Two letter palindromes (if any) 
		 */
		for(i=0;i<n-1;i++)
			if(s.charAt(i)==s.charAt(i+1))
				palindrome[i][i+1]=true;
			else
				palindrome[i][i+1] = false;
		
		if(n>2)
		{
			i=0;
			j=i+1;
			for(int k=2;k<n;k++)
				for(i=0;i<n-1;i++) {
					j = i+k;
					if(j==n)
						break;
					if(s.charAt(i)==s.charAt(j)&&palindrome[i+1][j-1])
						palindrome[i][j]=true;
					else
						palindrome[i][j] = false;
				}
		}
		
		int max = 0;
		String out = s.substring(0,1);
		for(i=0;i<n;i++) {
			for(j=i;j<n;j++) {
				if(palindrome[i][j]&&j-i>max) {
					out = s.substring(i,j+1);
					max = j-i;
				}
			}
		}
		return out;
	}
	
	/********/	/********/	/********/	/********/	/********/	/********/
	
	/*
	 * Brute force generate all substrings of a string 
	 */
	public static ArrayList<String> subStrings(String s) {
		ArrayList<String> substrings = new ArrayList<>();
		int n = s.length();
		for (int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				substrings.add(s.substring(i,j+1));
			}
		}
		return substrings;
	}
	
	/********/	/********/	/********/	/********/	/********/	/********/
	
	/*
	 * Longest substring without repeating characters
	 */
	
 public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int n = s.length();
        int maxSoFar = 0;
        int start = 0;
        int end = 1;
        if (n==0)
            return 0;
        if(n==1)
        	
            return 1;
        h.put(s.charAt(start),start);
        for(;end<n;end++){
            // if end character is already seen before 
            if(h.containsKey(s.charAt(end))){
                if(end-start > maxSoFar)
                    maxSoFar=end-start;
               // if(end!=n-1)
                if(h.get(s.charAt(end)) + 1>start)
                		start = h.get(s.charAt(end)) + 1;
                h.put(s.charAt(end),end);
                	//start = h.get(s.charAt(end));
            }
            h.put(s.charAt(end),end);
        }
        if(end-start > maxSoFar)
        		return end-start;
        return maxSoFar;
    }

}
