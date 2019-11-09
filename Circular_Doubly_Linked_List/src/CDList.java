public class CDList {
	// must have following fields
	public CDNode first;
	public CDList() {
		first = null;
	}
	public void append (int x) {
		CDNode newnode = new CDNode(x);
		if(first==null) {
			first = newnode;
			newnode.next = newnode;
			newnode.prev = newnode;
			return;
		}
		first.prev.next = newnode;
		newnode.next = first;
		newnode.prev = first.prev;
		first.prev = newnode;
	}
	public CDIter getIter() {
		return new CDIter(first, this);
	}
	// end
	public void Print() {
		CDIter iterator = getIter();
		if(iterator.isValid()) {
			System.out.println(iterator.getValue());
			iterator.next();
			while(iterator.cur != first) {
				System.out.println(iterator.getValue());
				iterator.next();
			}
		}
		else {
			System.out.println("false");
		}
	}
}
