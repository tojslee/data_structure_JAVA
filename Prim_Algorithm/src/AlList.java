public class AlList {
	AlNode first;
	AlNode last;
	public AlList() {
		first = null;
		last = null;
	}
	public void insertEnd(int n, int w) {
		AlNode newnode = new AlNode();
		newnode.key = n;
		newnode.next = null;
		newnode.weight = w;
		if(last == null) {
			first = last = newnode;
		}
		else {
			last.next = newnode;
			last = newnode;
		}
	}
}
