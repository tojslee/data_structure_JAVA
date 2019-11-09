package linked_list.java;

public class Iterator {
	private Node prev, cur;
	private linked_list llist;
	
	public Iterator(linked_list caller,Node first) {
		llist=caller;
		prev=null;
		cur=first;
	}
	
	public Node GetPrev() {
		return prev;
	}
	
	public Node GetCur() {
		return cur;
	}
	
	public int DeleteCurrent() {
		int ret;
		
		if(cur == null) return -1;
		ret = cur.data;
		cur = cur.next;
		if(prev==null) {
			llist.first=cur;
		} else {
			prev.next = cur;
		}
		if(cur==null)llist.last=prev;
		
		return ret;
	}
	
	public void InsertAfter(int x) {
		llist.InsertAfter(cur, x);
	}
	
	public boolean atEnd() {
		return (cur==null);
	}
	
	public int getData() {
		if(atEnd()) {
			return 0;
		}
		return cur.data;
	}
	
	public void next() {
		if(!atEnd()) {
			prev = cur;
			cur = cur.next;
		}
	}
}
