public class LIter {
	LNode cur;
	public LIter(LList l) {
		cur = l.first;
	}
	public boolean isValid() {
		return (cur != null);
	}
	public int getData() {
		if(isValid()) {
			return cur.data;
		}
		return 0;
	}
	public void next() {
		cur = cur.next;
	}
}
