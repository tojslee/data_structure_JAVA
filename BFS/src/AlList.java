
public class AlList {
	AlNode first;
	AlNode last;
	public AlList() {
		first = null;
		last = null;
	}
	public void insertEnd(int n) {
		AlNode newnode = new AlNode();
		newnode.key = n;
		newnode.next = null;
		if(last == null) {
			first = last = newnode;
		}
		else {
			last.next = newnode;
			last = newnode;
		}
	}
	public int deleteFirst() {
		if(last == null) {
			return -1;
		}
		else {
			int res = first.key;
			first = first.next;
			if(last.key == res) {
				last = null;
			}
			return res;
		}
	}
}
