package problems;

public class PalindromePair {
	static int alphabetSize  =26;
	static TrieNode root;

	static class TrieNode {
		TrieNode[] children = new TrieNode[alphabetSize];
		boolean isEndOfWord;
		int index; //to indicate if end of palindrome	
		TrieNode() {
			isEndOfWord = false;
			for(int i=0;i<alphabetSize;i++)
				children[i] = new TrieNode();
		}

		static boolean isPalindrome(String key, int start, int end) {
			while(start<end) {
				if(key.charAt(start)!=key.charAt(end))
					return false;
				else {
					start++;
					end--;
				}
			}
			return true;
		}

		static void insert(String key) {
			TrieNode crawl = root;
			for(int i=key.length()-1;i>=0;i--) {
				int index = key.charAt(i)-'a';
				if(crawl.children[index]!=null)
					crawl.children[index] = new TrieNode();
				if(isPalindrome(key,))
			}
		}
	}

}
