import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

	int vertices;
	LinkedList<Integer> adjList[];
	
	Graph(int noOfVertices){
		vertices = noOfVertices;
		adjList = new LinkedList[vertices];
		
		for(int i=0;i<vertices;i++) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int src, int des) {
		adjList[src].add(des);
		adjList[des].add(src);
	}
	
	public void printGraph() {
		for(int i=0;i<vertices;i++) {
			for(int j:adjList[i]) {
				System.out.println(j+" ");
			}
			System.out.println("i is" + Integer.toString(i));
		}
	}
	
	public void DFS(int s) {
		boolean visited[] = new boolean[vertices];
		
		DFSutil(s, visited);
	
	}
	
	private void DFSutil(int s, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[s] = true;
		System.out.println(s + "");
		Iterator<Integer> it = adjList[s].listIterator();
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n])
				DFSutil(n,visited);
		}	
	}

	public void BFS(int s) {
		/*
		 * Visited queue : initialize all values as false
		 */
		boolean visited[] = new boolean[vertices];
		/*
		 * Queue for BFS
		 */
		LinkedList<Integer> queue = new LinkedList<Integer>();

		/*
		 * BFS operation
		 */
		visited[s] = true;
		queue.add(s);
		while(queue.size()!=0) {
			s = queue.poll();
			System.out.print(s);
			Iterator<Integer> it = adjList[s].listIterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void shortestPath(int a, int b) {
	ArrayList<Integer> listOfPrimes = sieveOfErosthotenes(a,b);
	listOfPrimes.add(b);
	int n = listOfPrimes.size();
	Graph graph = new Graph(n);
	for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			if(isOneStepAway(listOfPrimes.get(i),listOfPrimes.get(j))) {
				graph.addEdge(i, j);
			}
		}
	}
	int aIndex = listOfPrimes.indexOf(a);
	int bIndex = listOfPrimes.indexOf(b);
	for(int i=0;i<BFSout.size();i++) {
		if(BFSout.get(i)==bIndex)
			return;
		else
			System.out.println(listOfPrimes.get(BFSout.get(i)));
	}
	}
	
	private static boolean isOneStepAway(Integer a, Integer b) {
		String s1 = Integer.toString(a);
		String s2 = Integer.toString(b);
		int c=0;
		if(s1.charAt(0)!=s2.charAt(0))
			c++;
		if(s1.charAt(1)!=s2.charAt(1))
			c++;
		if(s1.charAt(2)!=s2.charAt(2))
			c++;
		if(s1.charAt(3)!=s2.charAt(3))
			c++;
		return (c==1);
	}

	public static ArrayList<Integer> sieveOfErosthotenes(int a, int n){
		ArrayList<Integer> listofPrimes = new ArrayList<Integer>();
		boolean prime[] = new boolean[n];
		for(int i=0;i<n;i++)
			prime[i]=true;
		
		for(int p=2;p*p<=n;p++) {
			if(prime[p]) {
				for(int i=p*p;i<n;i+=p) {
					prime[i] = false;
				}
			}
		}
		
		for(int i=0;i<n;i++)
			if(prime[i] && i>=a && i<=n)
				listofPrimes.add(i);
		return listofPrimes;
	}
	
	public static void main(String[] args) {
		/*
		 * Testing example 2 from geek for geeks
		 */
		/*
        Graph g = new Graph(4); 
        
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.DFS(2); 
        */
		
		/*
		 * Testing example 1 from geek for geeks
		 */
		/*
		int V = 5; 
        Graph graph = new Graph(V); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 4); 
        graph.addEdge(1, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
        graph.printGraph(); 
        graph.BFS(0);
        */
		
		/*
		 * testing sieve of erosthotenes
		ArrayList<Integer> listOfPrimes = sieveOfErosthotenes(0,50);
		for(int prime:listOfPrimes) {
			if(prime>=2)
				System.out.println(Integer.toString(prime));
			
		}
		*/
		
		/*
		 * Testing prime numbers shortest path one digit a time
		 */
		int num1 = 1033;
		int num2 = 8179;
		shortestPath(num1, num2);
		
	}
}