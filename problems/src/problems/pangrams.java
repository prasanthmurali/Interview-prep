package problems;

import java.util.Arrays;

public class pangrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "The quick brown fox jumps over the lazy dog"; 
		  
        if (checkPangram(str) == true) 
            System.out.print(str + " is a pangram."); 
        else
            System.out.print(str+ " is not a pangram."); 

	}
	
	public static boolean checkPangram(String str) {
		
		boolean[] markedArray = new boolean[26];
		Arrays.fill(markedArray, false);
		
		str = str.toLowerCase();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='a'&&str.charAt(i)<='z') {
				int charIndex = str.charAt(i)-'a';
				markedArray[charIndex] = true;
			}
		}
		
		for(int i=0;i<26;i++) 
			if(!markedArray[i])
				return false;
		
		return true;
		
		
	}

}
