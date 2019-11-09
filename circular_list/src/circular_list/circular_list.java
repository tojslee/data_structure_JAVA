package circular_list;

public class circular_list {
	
	private final Node header;
	
	public circular_list() {
		Node newnode = new Node();
		newnode.next = newnode;
		header = newnode;
	}
	
	public boolean isEmpty() {
		return (header.next ==header);
	}
	
	public Iterator getIterator() {
		return new Iterator(header);
	}

	public static void main(String[] args) {
	}

}
