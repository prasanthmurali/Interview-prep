package dataStructures;

public class Trie {

	 int alphabetSize = 26;
	 Trie[] children = new Trie[alphabetSize];
	 boolean isEndOfWord;
	 
	 public Trie() {
		 isEndOfWord = false;
		 for(int i=0;i<alphabetSize;i++)
			 this.children[i] = null;
	 }
	 
	 static void insert(Trie root, String key) {
		 Trie crawl = root;
		 for(int i=0;i<key.length();i++) {
			 int index = key.charAt(i)-'a';
			 if(crawl.children[key.charAt(i)-'a']==null)
				 crawl.children[key.charAt(i)-'a'] = new Trie();
			 crawl = crawl.children[key.charAt(i)-'a'];
		 }
		 crawl.isEndOfWord = true;
	 }
	 
	 static boolean search(Trie root, String key) {
		 Trie crawl = root;
		 for(int i=0;i<key.length();i++) {
			 if(crawl.children[key.charAt(i)-'a']==null)
				 return false;
			 crawl = crawl.children[key.charAt(i)-'a'];
		 }
		 return crawl.isEndOfWord == true;
	 }
	
	public static void main(String[] args) {
		
		/*
		// TODO Auto-generated method stub
		String keys[] = {"the", "a", "there", "answer", "any", 
		                "by", "bye", "their"}; 
		
		String output[] = {"Not present in trie", "Present in trie"}; 
		
		
		Trie root = new Trie(); 
		
		// Construct trie 
		int i; 
		for (i = 0; i < keys.length ; i++) 
		   insert(root,keys[i]); 
		
		// Search for different keys 
		if(search(root,"the") == true) 
		   System.out.println("the --- " + output[1]); 
		else System.out.println("the --- " + output[0]); 
		 
		if(search(root,"these") == true) 
		   System.out.println("these --- " + output[1]); 
		else System.out.println("these --- " + output[0]); 
		 
		if(search(root,"their") == true) 
		   System.out.println("their --- " + output[1]); 
		else System.out.println("their --- " + output[0]); 
		 
		if(search(root,"thaw") == true) 
		   System.out.println("thaw --- " + output[1]); 
		else System.out.println("thaw --- " + output[0]); 
*/
		String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"};
		char boggle[][] = {{'G','I','Z'}, 
                {'U','E','K'}, 
                {'Q','S','E'} 
};
		wordBoggle(dictionary, boggle);
		
	}
	
	public static void wordBoggle(String[] dictionary, char boggle[][] ) {
		Trie dictWords = new Trie();
		for(int i=0;i<dictionary.length;i++)
			insert(dictWords,dictionary[i].toLowerCase());
		int m = boggle.length;
		int n = boggle[0].length;
		String str = "";
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++) {
				if(dictWords.children[boggle[i][j]-'A']!=null) {
					str+=boggle[i][j];
					searchWords(boggle,i,j, visited, dictWords.children[boggle[i][j]-'A'],str,m,n);
					str  ="";
				}
			}		
	}

	private static void searchWords(char[][] boggle, int i, int j, boolean[][] visited, Trie dictWords, String str, int m, int n) {
		int alphabetSize = 26;
		if(dictWords.isEndOfWord)
			System.out.println(str);
		if(isSafe(i,j,visited,m,n)) {
			visited[i][j] = true;
			for(int k=0;k<alphabetSize;k++) {
				if(dictWords.children[k]!=null) {
					char ch = (char) ((k)+'A');
					if(isSafe(i+1, j+1, visited,m,n) && boggle[i+1][j+1]==ch)
						searchWords(boggle,i+1,j+1,visited, dictWords.children[k], str+ch, m ,n);
					if(isSafe(i, j+1, visited,m,n)&& boggle[i][j+1]==ch)
						searchWords(boggle,i,j+1,visited, dictWords.children[k], str+ch, m ,n);
					if(isSafe(i, j-1, visited,m,n)&& boggle[i][j-1]==ch)
						searchWords(boggle,i,j-1,visited, dictWords.children[k], str+ch, m ,n);
					if(isSafe(i+1, j, visited,m,n)&& boggle[i+1][j]==ch)
						searchWords(boggle,i+1,j,visited, dictWords.children[k], str+ch, m ,n);
					if(isSafe(i+1, j-1, visited,m,n)&& boggle[i+1][j-1]==ch)
						searchWords(boggle,i+1,j-1,visited, dictWords.children[k], str+ch, m ,n);
					if(isSafe(i-1, j, visited,m,n)&& boggle[i-1][j]==ch)
						searchWords(boggle,i-1,j,visited, dictWords.children[k], str+ch, m ,n);
					if(isSafe(i-1, j-1, visited,m,n )&& boggle[i-1][j-1]==ch)
						searchWords(boggle,i-1,j-1,visited, dictWords.children[k], str+ch, m ,n);
					if(isSafe(i-1, j+1, visited, m , m)&& boggle[i-1][j+1]==ch)
						searchWords(boggle,i-1,j+1,visited, dictWords.children[k], str+ch, m ,n);
				}
			}
			visited[i][j] = false;
		}
	}

	private static boolean isSafe(int i, int j, boolean[][] visited,int m,int n) {
	    return (i >=0 && i < m && j >=0 && j < n && !visited[i][j]);
	}

}
