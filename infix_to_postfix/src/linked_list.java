
public class linked_list {
	LNode first;
	LNode last;
	public void insertAtFront(char x) {
		LNode newnode = new LNode(x);
		newnode.next = first;
		first = newnode;
		if(last == null) {
			last = newnode;
		}
	}
	public char deleteFirst() {
		char result = first.data;
		first = first.next;
		return result;
	}
	public boolean isEmpty() {
		if (first==null) {
			return true;
		}
		else {return false;}
	}
	public char getFirst() {
		return first.data;
	}
}
