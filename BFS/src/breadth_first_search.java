
public class breadth_first_search {
	
	public static void BFS(Algraph graph, int n) {
		boolean[] visited = new boolean[graph.n];
		AlQueue q = new AlQueue();
		for(int i = 0; i < graph.n; i++) {
			visited[i] = false;
		}
		visit(visited, n);
		q.enqueue(n);
		while(!q.isEmpty()) {
			int f = q.dequeue();
			for(AlNode iter = graph.algraph[f].first; iter != null; iter = iter.next) {
				if(!visited[iter.key]) {
					visit(visited, iter.key);
					q.enqueue(iter.key);
				}
			}
		}
	}
	
	public static void visit(boolean[] visited, int n) {
		visited[n] = true;
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Algraph graph = new Algraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 4);
		graph.print();
		BFS(graph, 5);
	}

}
