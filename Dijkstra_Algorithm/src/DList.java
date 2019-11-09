
public class DList {
	public DEdge first, last;
	
	public DList() {
		first = last = null;
	}
	
	public void insertEnd(int t, int w) {
		DEdge newnode = new DEdge(t, w);
		newnode.next = null;
		if(last == null) {
			first = last = newnode;
		}
		else {
			last.next = newnode;
			last = newnode;
		}
	}
}
