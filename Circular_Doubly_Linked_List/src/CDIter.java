public class CDIter {
	public CDList list;
	// this must be included
	public CDNode cur;
	public boolean isValid() {
		return (cur != null);
	}
	public int getValue() {
		if(isValid()) {return cur.data;}
		return -1;
	}
	public boolean setValue(int x) {
		if(isValid()) {
			cur.data = x;
			return true;
		}
		else {return false;}
	}
	public int delete() {
		if(isValid()) {
			int result = cur.data;
			if(cur.next == cur) {
				list.first = null;
				cur = null;
				return result;
			}
			else {
				if(cur == list.first) {
					cur.next.prev = cur.prev;
					cur.prev.next = cur.next;
					next();
					list.first = cur;
				}
				else {
					cur.next.prev = cur.prev;
					cur.prev.next = cur.next;
					next();
				}
				return result;
			}
		}
		else {
			return -1;
		}
	}
	public boolean insertBefore(int x) {
		if(isValid()) {
			CDNode newnode = new CDNode(x);
			if(cur == list.first) {
				newnode.next = list.first;
				newnode.prev = list.first.prev;
				newnode.prev.next = newnode;
				list.first.prev = newnode;
				list.first = newnode;
			}
			else {
				newnode.prev = cur.prev;
				cur.prev.next = newnode;
				cur.prev = newnode;
				newnode.next = cur;
			}
			return true;
		}
		return false;
	}
	public boolean insertAfter(int x) {
		if(isValid()) {
			CDNode newnode = new CDNode(x);
			newnode.prev = cur;
			newnode.next = cur.next;
			cur.next.prev = newnode;
			cur.next = newnode;
		}
		return false;
	}
	public void prev() {
		cur = cur.prev;
		return;
	}
	public void next() {
		cur = cur.next;
		return;
	}
	// end
	public CDIter(CDNode f, CDList l) {
		cur = f;
		list = l;
	}
}

