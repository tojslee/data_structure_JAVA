
public class deapth_first_search {
	
	public static void DFS(Algraph graph, int find) {
		boolean[] visited = new boolean[graph.n];
		for(int i = 0; i < graph.n; i++) {
			visited[i] = false;
		}
		doDFS(visited, graph, find);
	}
	
	public static void doDFS(boolean[] visited, Algraph graph, int find) {
		if(!visited[find]) {
			visit(visited, find);
		}
		for(AlNode iter = graph.algraph[find].first; iter != null; iter = iter.next) {
			if(!visited[iter.key]) {
				doDFS(visited, graph, iter.key);
			}
		}
	}
	
	public static void visit(boolean[] visited, int i) {
		visited[i] = true;
		System.out.println(i);
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
		DFS(graph, 5);
		
	}

}
