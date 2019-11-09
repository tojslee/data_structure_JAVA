package circular_list;

public class Iterator {
	private Node header, prev, cur;
	
	public Iterator(Node h) {
		header = h;
		prev = h;
		cur = h.next;
	}
	
	public boolean atEnd() {
		return (cur == header);
	}
	
	public int getData() {
		if(atEnd()) return -1;
		return cur.data;
	}
	
	public void next() {
		prev = cur;
		cur = cur.next;
	}
	
	public void insertAfter(int x) {
		Node newnode = new Node();
		
		newnode.data=x;
		newnode.next=cur.next;
		cur.next=newnode;
	}
	
	public int deleteCurrent() {
		int ret;
		
		if(cur==header) {
			ret = -1;
		}else {
			ret = cur.data;
			prev.next=cur.next;
			cur=cur.next;
		}
		return ret;
	}
}
