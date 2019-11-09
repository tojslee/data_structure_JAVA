
public class AlQueue {
	AlList list;
	public AlQueue() {
		list = new AlList();
	}
	
	public void enqueue(int n) {
		list.insertEnd(n);
	}
	
	public int dequeue() {
		return list.deleteFirst();
	}
	
	public boolean isEmpty() {
		return (list.last == null);
	}
}
