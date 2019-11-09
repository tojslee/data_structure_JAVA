
public class QList {
	QNode first;
	QNode last;
	
	public QList() {
		first = null;
		last = null;
	}
	
	public void insertAtEnd(int x) {
		QNode newnode = new QNode();
		newnode.data = x;
		newnode.next = null;
		if(last == null) {
			first = newnode;
			last = newnode;
			return;
		}
		last.next = newnode;
		last = newnode;
	}
	
	public int deleteFirst() {
		if(last == null) {
			return -1;
		}
		int res = first.data;
		first = first.next;
		return res;
	}
	
	public void print() {
		QNode iter = first;
		while(iter!= null) {
			System.out.println(iter.data);
			iter = iter.next;
		}
	}
}
