public class LList {
	public LNode first;
	public LNode last;
	public int length;
	
	public LList() {
		first = null;
		last = null;
		length=0;
	}
	public LIter getIter() {
		return (new LIter(this));
	}
	public LList(String s) {
		length=0;
		for(int i=1;i<=s.length();i++) {
			int x = s.charAt(s.length()-i)-'0';
			insert(x);
		}
	}
	public LList(String s, int x) {
		length=0;
		for(int i=1;i<=s.length();i++) {
			int e = s.charAt(s.length()-i) - '0';
			insertFront(e);
		}
	}
	public boolean isEmpty() {
		return (first == null);
	}
	public void insert(int x) {
		LNode newnode = new LNode(x);
		newnode.next = null;
		if(last ==null) {
			first = last = newnode;
		}else {
			last.next = newnode;
			last = newnode;
		}
		length++;
	}
	public void insertFront(int x) {
		LNode newnode = new LNode(x);
		if(last==null) {
			first = last = newnode;
		}
		else {
			newnode.next = first;
			first = newnode;
		}
		length++;
	}
	public boolean checker() {
		LIter check = this.getIter();
		boolean result = false;
		for(int i=0;i<this.length;i++) {
			if(check.getData()!=0) {
				result = true;
				break;
			}
			else {
				check.next();
			}
		}
		return result;
	}
}
