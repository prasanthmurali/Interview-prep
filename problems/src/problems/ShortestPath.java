package problems;

public class ShortestPath {
	static int V = 9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
			{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
			{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
			{ 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
			{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
			ShortestPath t = new ShortestPath(); 
			t.dikjstra(graph, 0); 
	}

	void dikjstra(int[][] graph, int src) {
		int dist[] = new int[V];
		Boolean[] sptSet = new Boolean[V];
		for(int i=0;i<V;i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for(int count=0;count<V-1;count++) {
			int u = minDist(dist, sptSet);
			sptSet[u] = true;
			for(int v=0;v<V;v++)
				if(!sptSet[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]) {
					dist[v] = dist[u]+graph[u][v];
				}
		}
		printSolution(dist);
	}

	void printSolution(int[] dist) {
		for(int i=0;i<dist.length;i++)
			System.out.println(dist[i]);
	}

	private int minDist(int[] dist, Boolean[] sptSet) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE, minIndex = -1;
		for(int i=0;i<dist.length;i++) {
			if(!sptSet[i] && dist[i]<min) {
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
