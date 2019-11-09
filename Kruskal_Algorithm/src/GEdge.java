
public class GEdge {
	int from;
	int to;
	int weight;
	boolean component;
	
	public GEdge(int a, int b, int w) {
		from = a;
		to = b;
		weight = w;
		component = false;
	}
}
