
public class heap_sort {
	public static void heapSort(heap s) {
		int ind = (s.length + 1)/2;
		while(ind != 1) {
			s.heapify(ind);
			ind--;
		}
		for(int i=0;i < s.length;i++) {
			s.deleteMax();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		heap h = new heap(10);
		h.insert(4);
		h.insert(1);
		h.insert(24);
		h.insert(12);
		h.insert(15);
		h.insert(20);
		h.insert(30);
		h.insert(2);
		h.insert(9);
		h.insert(11);
		for(int i = 5; i > 0 ;i--) {
			h.heapify(i);
		}
		heapSort(h);
	}

}
