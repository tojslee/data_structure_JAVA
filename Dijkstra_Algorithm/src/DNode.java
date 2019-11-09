
public class DNode {
	public int vertex;
	public int d;
	public int prev;
	
	public DNode(int n) {
		vertex = n;
		d = 100; // plus infinity 대체 숫자 100 
	}
}
