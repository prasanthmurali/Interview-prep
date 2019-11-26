package dataStructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
	int V;
	LinkedList<Integer> adjListArray[];

	Graph(int V){
		this.V = V;
		this.adjListArray = new LinkedList[V];

		for(int i=0;i<V;i++) {
			this.adjListArray[i] = new LinkedList<>();
		}

	}

	static void addEdge(Graph g, int edge, int vertex) {
		g.adjListArray[edge].add(vertex);
		g.adjListArray[vertex].add(edge);
	}

	static void printGraph(Graph g) {
		for(int i=0;i<g.V;i++) {
			System.out.println("New");
			System.out.println(i);
			for(Integer j:g.adjListArray[i]) {
				System.out.println(j + " ");
			}
		}
	}

	void DFS(int v) {
		boolean visited[] = new boolean[V];
		DFSutil(v,visited);
	}

	private void DFSutil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println(v);

		Iterator<Integer> lst = adjListArray[v].listIterator();
		while(lst.hasNext()) {
			int n = lst.next();
			if(!visited[n])
				DFSutil(n,visited);
		}
	}

	private void BFS(int s) {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		while(queue.size()!=0) {
			s = queue.poll();
			System.out.println(s);
			Iterator<Integer> lst = adjListArray[s].listIterator();
			while(lst.hasNext()) {
				int n = lst.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(4); 

		addEdge(g,0, 1); 
		addEdge(g,0, 2); 
		addEdge(g,1, 2); 
		addEdge(g,2, 0); 
		addEdge(g,2, 3); 
		addEdge(g,3, 3); 
		printGraph(g);
		// print the adjacency list representation of  
		// the above graph 
		System.out.println("BFS");
		g.BFS(2);

	}

}
