package linked_list.java;

public class linked_list {
	public Node first;
	public int length;
	public Node last;
	
	public Iterator getIterator() {
		return new Iterator(this, first);
	}
	
	public linked_list() {
		first=null;
		length=0;
		last=null;
	}
	
	public boolean isEmpty() {
		return (first==null);
	}
	
	public void InsertAtFront(int x) {
		Node newnode;
		
		newnode=new Node();
		newnode.data=x;
		newnode.next=first;
		first=newnode;
		if(last == null) last=newnode;
	}
	
	public int DeleteFirst() {
		int ret;
		
		if(first==null) return -1;
		ret = first.data;
		first = first.next;
		if(first==null) last=null;
		return ret;
	}
	
	public void DisplayAll() {
		Iterator i = getIterator();
		
		while(!i.atEnd()) {
			System.out.println(i.getData());
			i.next();
		}
		/*
		 * for(i=list.getIterator();!i.atEnd();i.next()){
		 * 		System.out.println(i.getData());
		 * }
		 */
	}
	
	public void InsertAfter(Node n, int x) {
		Node newnode;
		
		if (n==null) return;
		newnode = new Node();
		newnode.data=x;
		newnode.next=n.next;
		n.next=newnode;
		if(newnode.next==null)last=newnode;
	}
	
	public void InsertAtEnd(int x) {
		Node newnode;
		
		newnode = new Node();
		newnode.data = x;
		newnode.next = null;
		if(last==null) {
			first=last=newnode;
		}else {
			last.next=newnode;
			last=newnode;
		}
	}

	public static void main(String[] args) {
	}

}
