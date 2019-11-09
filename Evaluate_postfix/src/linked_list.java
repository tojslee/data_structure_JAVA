
public class linked_list {
	LNode first;
	LNode last;
	public void insertAtFront(int x) {
		LNode newnode = new LNode(x);
		newnode.next = first;
		first = newnode;
	}
	public int deleteFirst() {
		int result = first.data;
		first = first.next;
		return result;
	}
	public boolean isEmpty() {
		if (first==null) {
			return true;
		}
		else {return false;}
	}
}
