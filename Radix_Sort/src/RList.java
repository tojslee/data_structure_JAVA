
public class RList {
	RNode first, last;
	
	public void insert(int x) {
		RNode newnode = new RNode(x);
		if(last == null) {
			newnode.next = null;
			first = last = newnode;
		}
		else {
			last.next = newnode;
			last = newnode;
		}
	}
	
	public int delete() {
		if(first == null) {
			return -1;
		}
		else {
			int res = first.data;
			first = first.next;
			if(last.data == res) {
				last = null;
			}
			return res;
		}
	}
	
	public int getFirst() {
		if(first == null) {
			return -1;
		}
		else {
			return first.data;
		}
	}
}
