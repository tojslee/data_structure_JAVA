
public class stack {
	private final linked_list llist;
	
	public stack() {
		llist = new linked_list();
	}
	public void push(char x) {
		llist.insertAtFront(x);
	}
	public char pop() {
		return llist.deleteFirst();
	}
	public boolean isEmpty() {
		return llist.isEmpty();
	}
	public char top() {
		return llist.getFirst();
	}
}
