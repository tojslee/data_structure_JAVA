public class stack {
	SList list;
	
	public stack() {
		list = new SList();
	}
	
	public void pop() {
		list.deleteFront();
	}
	
	public int peek() {
		return list.getFirst();
	}
	
	public void push(int x) {
		list.insertFront(x);
	}
	
	public void print() {
		list.print();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		stack s = new stack();
		s.push(1);
		s.push(5);
		s.push(34);
		s.pop();
		s.print();
		System.out.println(s.peek());
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.print();
	}

}
