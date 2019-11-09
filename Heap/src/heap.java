public class heap {
	public int[] hArray;
	public int length;
	public int index;
	
	public heap(int[] array, int length) {
		hArray = new int[length + 1];
		for(int i=0;i<array.length;i++) {
			hArray[i] = array[i];
		}
		this.length = length;
		index = array.length - 1;
	}
	
	public heap(int length) {
		this.length = length;
		this.index = 1;
		hArray = new int[length + 1];
	}
	
	public void createHeap() {
		for(int i = index ; i > 0 ; i--) {
			heapify(i);
		}
	}
	
	public void heapify(int index) { //������ �̰� heapify�� �ƴ϶� �׳� down -> up���� ���� �Ӽ��� ���ߴ� ������ --> �� ������ �׳� ���߿� ���� ���Ҹ� ���� �� ����ϴ� �����
		while(true) {
			if(hArray[index] > hArray[index/2] && index != 1) {
				int tmp = hArray[index];
				hArray[index] = hArray[index/2];
				hArray[index/2] = tmp;
				index = index / 2;
			}
			else {
				return;
			}
		}
	}
	
	public void insert(int x) {
		if(index == length) {
			System.out.println("The heap is full");
		}
		else {
			hArray[++index] = x;
			heapify(index);
		}
	}
	
	public int deleteMax() {
		if( index == 0 ) {
			return -1;
		}
		int res = hArray[1];
		int d = 1;
		hArray[1] = hArray[index--];
		while(true) { // �̰� ���� heapify������ �ϴ� �ڵ��� -->  heapify�� ����� �� right sub tree, left sub tree�� ��� ���� �� up->down���� ������ �����Ͽ� heap�� ������ ���ߴ� ����
			if(2*d + 1 <= this.length && (hArray[d] < hArray[2*d] || hArray[d] < hArray[2*d + 1])) {
				int f;
				if(hArray[2*d] > hArray[2*d + 1]) {
					f = 2*d;
				}
				else {f = 2*d +1;}
				int tmp = hArray[f];
				hArray[f] = hArray[d];
				hArray[d] = tmp;
				d = f;
			}
			else {
				break;
			}
		}
		return res;
	}
	
	public void print() {
		for(int i=1;i<=index;i++) {
			System.out.println(hArray[i]);
		}
	}
	
	public int getMax() {
		if( index == 0 ) {return -1;}
		else {return hArray[1];}
	}
	
	public heap union(heap other) {
		heap newheap = new heap(other.length + this.length);
		for(int i = 0; i< other.index; i++) {
			newheap.hArray[i] = other.hArray[i];
		}
		for(int i = other.index; i < other.index + this.index; i++) {
			newheap.hArray[i] = this.hArray[i];
		}
		newheap.createHeap();
		return newheap;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 12, 5, 1, 4, 23, 19};
		heap h = new heap(a, 10);
		h.createHeap();
		h.print();
		h.insert(2);
		h.insert(9);
		System.out.println("");
		h.print();
		h.deleteMax();
		System.out.println("");
		h.print();
		
		heap h1 = new heap(8);
		h1.insert(3);
		h1.insert(5);
		h1.insert(9);
		h1.insert(10);
		h1.insert(2);
		System.out.println("");
		h1.print();
		
	}

}
