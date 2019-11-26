package dataStructures;

import java.util.HashMap;

public class Trie2 {

	static int alphabetSize = 26;
	static TrieNode root;

	static class TrieNode{

		TrieNode[] children = new TrieNode[alphabetSize];
		boolean isEndOfWord;
		TrieNode() {
			isEndOfWord = false;
			for(int i=0;i<alphabetSize;i++)
				children[i] = null;
		}
	}

	static void validWordsUsingCharacters(char[] characters, String[] dictionary) {
		HashMap<Character,Integer>  charHash= new HashMap<>();
		for(int i=0;i<characters.length;i++)
			charHash.put(characters[i], i);
		for(int i=0;i<dictionary.length;i++) {
			modifiedInsert(dictionary[i],charHash);
		}
	}


	/*
	 * Insert Method to help with validWordsUsingCharacters
	 */
	private static void modifiedInsert(String key, HashMap<Character, Integer> charHash) {
		TrieNode crawl = root;
		for(int i=0;i<key.length();i++) {
			if(charHash.containsKey(key.charAt(i))) {
				int letter = key.charAt(i)-'a';
				if(crawl.children[letter]==null) {
					crawl.children[letter] = new TrieNode();
				}
				crawl = crawl.children[letter];
			}
			else 
				return;

		}
		crawl.isEndOfWord = true;
		System.out.println(key);
	}

	static boolean search(String key) {
		TrieNode crawl =root;
		for(int i=0;i<key.length();i++) {
			int letter = key.charAt(i)-'a';
			if(crawl.children[letter]==null)
				return false;
			crawl = crawl.children[letter];
		}
		return(crawl!=null && crawl.isEndOfWord);
	}

	static void insert(String key) {
		TrieNode crawl = root;
		for(int i=0;i<key.length();i++) {
			System.out.println(key.charAt(i));
			int letter = key.charAt(i)-'a';
			System.out.println(letter);
			if(crawl.children[letter]==null) {
				crawl.children[letter] = new TrieNode();
			}
			crawl = crawl.children[letter];
		}
		crawl.isEndOfWord = true;
	}

	public static void main(String[] args) {
		
		String keys[] = {"the", "a", "there", "answer", "any", 
				"by", "bye", "their"}; 

		String output[] = {"Not present in trie", "Present in trie"}; 


		root = new TrieNode(); 

		// Construct trie 
		int i; 
		for (i = 0; i < keys.length ; i++) 
			insert(keys[i]); 

		// Search for different keys 
		if(search("the") == true) 
			System.out.println("the --- " + output[1]); 
		else System.out.println("the --- " + output[0]); 

		if(search("these") == true) 
			System.out.println("these --- " + output[1]); 
		else System.out.println("these --- " + output[0]); 

		if(search("a") == true) 
			System.out.println("their --- " + output[1]); 
		else System.out.println("their --- " + output[0]); 

		if(search("thaw") == true) 
			System.out.println("thaw --- " + output[1]); 
		else System.out.println("thaw --- " + output[0]);
		 

		/*
		root = new TrieNode();
		char[] characters = {'a','e','o','b','m','g','l'};
		String[] dictionary = {"go","bat","me","eat","goal","boy","run"};
		validWordsUsingCharacters(characters, dictionary);
		 */
	}

}
