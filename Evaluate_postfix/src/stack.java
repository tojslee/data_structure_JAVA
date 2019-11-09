public class stack {
	private final linked_list llist;
	
	public stack() {
		llist = new linked_list();
	}
	public void push(int x) {
		llist.insertAtFront(x);
	}
	public int pop() {
		return llist.deleteFirst();
	}
	public boolean isEmpty() {
		return llist.isEmpty();
	}
}
