
public class queue {
	QList list;
	
	public queue() {
		list = new QList();
	}
	
	public void enqueue(int x) {
		list.insertAtEnd(x);
	}
	
	public int dequeue() {
		return list.deleteFirst();
	}
	
	public void print() {
		list.print();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue q = new queue();
		q.enqueue(1);
		q.enqueue(4);
		q.enqueue(41);
		q.enqueue(24);
		q.print();
		System.out.println("");
		q.dequeue();
		q.dequeue();
		q.print();
	}

}
