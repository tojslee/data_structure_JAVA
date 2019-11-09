public class AQueue {
	int[] QArray;
	int front;
	int last;
	int length;
	
	public AQueue(int x) { // length는 전체 어레이의 길이를 의미함 --> 교수님이 주신 코드에서는 원소의 최대 개수를 의미했음
		QArray = new int[x];
		front = 0;
		last = -1;
		length = x;
	}
	
	public void enqueue(int x) {
		// queue가 비어 있지 않은 경우 --> 쓰지 않는 어레이의 인덱스 전에 last가 있는 경우
		if((last + 2) % (length - 1) == front) {
			return;
		}
		else {
			last = (last + 1) % (length - 1);
			QArray[last] = x;
		}
	}
	
	public int dequeue() {
		if((last + 1) % (length - 1) == front) {
			return -1;
		} // queue가 비어있는 경우 --> 쓰지 않은 어레이의 인덱스에 last가 있는 경우
		int res = QArray[front];
		front = (front + 1) % (length - 1);
		return res;
	}
	
	public void print() {
		if((last + 1) % (length - 1) == front) {
			return;
		}
		else {
			int t = front;
			while(true) {
				System.out.println(QArray[t]);
				if(last == t) {
					return;
				}
				t = (t + 1) % (length - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AQueue a = new AQueue(10);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(10);
		a.enqueue(1);
		a.enqueue(23);
		a.enqueue(12);
		a.enqueue(124);
		a.enqueue(109);
		a.enqueue(12453);
		a.enqueue(24);
		a.print();
		System.out.println("");
		a.dequeue();
		a.print();
		System.out.println("");
		a.enqueue(15);
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.enqueue(1);
		a.print();
	}

}
