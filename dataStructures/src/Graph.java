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
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
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
	}
}
