
public class heap {
	int[] hArray;
	int length;
	int index;
	
	public heap(int[] array, int length) {
		hArray = new int[length + 1];
		for(int i = 1; i < array.length + 1; i++) {
			hArray[i] = array[i - 1];
		}
		this.length = length;
		this.index = array.length; // hArray가 차있는 제일 마지막 index를 저장
		createHeap();
	}
	
	public heap(int length) {
		hArray = new int[length + 1];
		this.length = length;
		this.index = 0;
	}
	
	public void insert(int n) {
		hArray[++index] = n;
		downup(index);
	}
	
	public void createHeap() {
		for(int i = this.index; i > 0; i--) {
			heapify(i);
		}
	}
	
	public void heapify(int index) {
		while(true) {
			if(index * 2 + 1 <= this.index) {
				if(hArray[index*2] > hArray[index] || hArray[index*2 + 1] > hArray[index]) {
					if(hArray[index * 2] > hArray[index * 2 + 1]) {
						int tmp = hArray[index * 2];
						hArray[index * 2] = hArray[index];
						hArray[index] = tmp;
						index = index * 2;
					}
					else {
						int tmp = hArray[index * 2 + 1];
						hArray[index * 2 + 1] = hArray[index];
						hArray[index] = tmp;
						index = index * 2 + 1;
					}
				}
				else {
					break;
				}
			}
			else if(index * 2 <= this.index) {
				if(hArray[index * 2] > hArray[index]) {
					int tmp = hArray[index * 2];
					hArray[index * 2] = hArray[index];
					hArray[index] = tmp;
					index = index * 2;
				}
				else {
					break;
				}
			}
			else {
				break;
			}
		}
	}
	
	public void downup(int index) {
		while(true) {
			if(index != 1 && hArray[index] > hArray[index/2]) {
				int tmp = hArray[index];
				hArray[index] = hArray[index/2];
				hArray[index/2] = tmp;
				index = index / 2;
			}
			else {
				break;
			}
		}
	}
	
	public int getMax() {
		return hArray[1];
	}
	
	public int deleteMax() {
		int max = hArray[1];
		hArray[1] = hArray[this.index];
		hArray[this.index] = max;
		this.index -= 1;
		
		heapify(1);
		
		return max;
	}
	
	public int delete(int index) {
		int key = hArray[index];
		hArray[index] = hArray[this.index];
		hArray[this.index] = key;
		this.index -= 1;
		
		heapify(index);
		
		return key;
	}
	
	public heap union(heap h) {
		int[] newarray = new int[this.index + h.index];
		for(int i = 0; i < this.index; i++) {
			newarray[i] = this.hArray[i + 1];
		}
		for(int i = this.index; i < this.index + h.index; i++) {
			newarray[i] = h.hArray[i - this.index + 1];
		}
		
		heap newheap = new heap(newarray, this.length + h.length);
		return newheap;
	}
	
	public void print() {
		for(int i = 1; i <= index; i++) {
			System.out.println(hArray[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		heap h = new heap(9);
		h.insert(1);
		h.insert(3);
		h.insert(2);
		h.insert(10);
		h.insert(7);
		h.print();
		System.out.println("");
		
		int[] array = {4,15,12, 51,132};
		heap h1 = new heap(array, 10);
		h1.print();
		System.out.println("");
		System.out.println(h1.deleteMax());
		System.out.println("");
		h1.print();
		System.out.println();
		
		heap u = h.union(h1);
		u.print();
		u.delete(5);
		System.out.println();
		u.print();
	}

}
