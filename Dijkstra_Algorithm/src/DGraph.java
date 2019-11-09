
public class DGraph {
	public DList[] graph;
	public int n;
	
	public DGraph(int n) {
		graph = new DList[n];
		for(int i = 0; i< n; i++) {
			graph[i] = new DList();
		}
		this.n = n;
	}
	
	public void insertEdge(int f, int t, int w) {
		graph[f].insertEnd(t, w);
	}
}
