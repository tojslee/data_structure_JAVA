
public class SList {
	SNode tos;
	
	public SList(SNode t) {
		tos = t;
	}
	
	public SList() {
		tos = null;
	}
	
	public void insertFront(int x) {
		SNode newnode = new SNode();
		newnode.n = x;
		newnode.next = tos;
		tos = newnode;
	}
	
	public void print() {
		SNode iter = tos;
		while(iter != null) {
			System.out.println(iter.n);
			iter = iter.next;
		}
	}
	
	public int deleteFront() {
		if(tos == null) {
			return -1;
		}
		int res = tos.n;
		tos = tos.next;
		return res;
	}
	
	public int getFirst() {
		if(tos == null) {
			return -1;
		}
		return tos.n;
	}
}
