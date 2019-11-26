package problems;

public class AutoComplete {
	static TrieNode root;
	static int alphabetSize = 26;

	static class TrieNode{
		TrieNode[] children = new TrieNode[alphabetSize];
		boolean isEndOfWord;

		TrieNode() {
			for(int i=0;i<alphabetSize;i++)
				children[i] = null;
			isEndOfWord = false;
		}
	}

	public static void insert(String key) {
		TrieNode crawl = root;
		for(int i=0;i<key.length();i++) {
			int letter = key.charAt(i)-'a';
			if(crawl.children[letter]==null) {
				crawl.children[letter] = new TrieNode();
			}
			crawl = crawl.children[letter];
		}
		crawl.isEndOfWord = true;
	}

	public static void findFromPrefix(String prefix) {
		TrieNode crawl = root;
		for(int i=0;i<prefix.length();i++)
			crawl = crawl.children[prefix.charAt(i)-'a'];
		printPrefix(crawl, prefix);
	}

	private static void printPrefix(TrieNode crawl, String prefix) {
		if(crawl.isEndOfWord)
			System.out.println(prefix);
		for(int i=0;i<alphabetSize;i++) {
			if(crawl.children[i]!=null)
				printPrefix(crawl.children[i],prefix+(char)('a'+i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = {"abc","acd","bcd","def","a","aba"};
		// prefix: a - abc acd a aba 
		// prefix: b - bcd
		root = new TrieNode();
		for(String s: dict) {
			insert(s);
		}
		String prefix = "b";
		findFromPrefix(prefix);
	}

}
