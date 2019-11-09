
public class GEdge {
	int from;
	int to;
	int weight;
	boolean compo;
	
	public GEdge(int a, int b, int w) {
		from = a;
		to = b;
		weight = w;
		compo = false;
	}
}
