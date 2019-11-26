package problems;

import java.util.HashMap;

public class AlphabetSoup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"cata","cat","bat","rat"};
		char[] alphabets = {'c','b','r'};
		System.out.println(isSorted(words,alphabets));

	}
	
	public static boolean isSorted(String[] words, char[] alphabet) {
		HashMap<Character,Integer> idx = new HashMap<>();
		for(int i=0;i<alphabet.length;i++)
			idx.put(alphabet[i], i);
		for(int i=0;i<words.length-1;i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			int m = word1.length()<word2.length()?word1.length():word2.length();
			int p = word1.length()>word2.length()?word1.length():word2.length();
			int k = 0;
			while(k<m) {
				if(word1.charAt(k)==word2.charAt(k)) {
					k++;
				}
				else
					break;
			}
			if(k==word2.length())
				return false;
			if(k!=m && idx.get(word1.charAt(k))-idx.get(word2.charAt(k)) > 0) {
				return false;
			}
		}
		return true;
	}

}
