
public class DHeap {
	DNode[] heap;
	int[] vid2vid; // virtex의 위치를 알려줌
	int num;
	int n;
	
	public DHeap(int n) {
		heap = new DNode[n + 1];
		vid2vid = new int[n];
		this.n = n;
		this.num = n;
		for(int i = 0; i< n+1; i++) {
			heap[i] = new DNode(i - 1);
		}
		for(int i = 0; i< n; i++) {
			vid2vid[i] = i+1;
		}
	}
	
	public DNode QueryMin() {
		return heap[1];
	}
	
	public void matching(int index) {
		while(true) {
			if(index != 1 && heap[index].d < heap[index/2].d) {
				DNode tmp = heap[index];
				heap[index] = heap[index/2];
				heap[index/2] = tmp;
				vid2vid[heap[index].vertex] = index;
				vid2vid[heap[index/2].vertex] = index / 2;
				index = index / 2;
			}
			else {
				break;
			}
		}
	}
	
	public void deleteMin() {
		DNode tmp = heap[1];
		heap[1] = heap[num];
		heap[num] = tmp;
		vid2vid[heap[num].vertex] = num;
		vid2vid[heap[1].vertex] = 1; 
		// change with the biggest value
		
		num -= 1;
		heapify(1);
	}
	
	public void heapify(int index) {
		while(true) {
			if(index*2 + 1 <= num) {
				if(heap[index].d > heap[index*2].d || heap[index].d > heap[index*2].d) {
					if(heap[index*2].d > heap[index*2 + 1].d) {
						DNode tmp = heap[index*2 + 1];
						heap[index*2 + 1] = heap[index];
						heap[index] = tmp;
						vid2vid[heap[index].vertex] = index;
						vid2vid[heap[index * 2 +1].vertex] = index * 2 + 1;
						index = index *2 +1;
					}
					else {
						DNode tmp = heap[index*2];
						heap[index*2] = heap[index];
						heap[index] = tmp;
						vid2vid[heap[index].vertex] = index;
						vid2vid[heap[index * 2].vertex] = index*2; 
						index = index *2;
					}
				}
				else {
					break;
				}
			}
			else if(index*2 <= num) {
				if(heap[index*2].d < heap[index].d) {
					DNode tmp = heap[index];
					heap[index] = heap[index*2];
					heap[index*2] = tmp;
					vid2vid[heap[index].vertex] = index;
					vid2vid[heap[index * 2].vertex] = index * 2;
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
	
	public void decreaseKey(int key, int vertex, int from) {
		heap[vid2vid[vertex]].d = key; // decrease Key
		heap[vid2vid[vertex]].prev = from;
		matching(vid2vid[heap[vid2vid[vertex]].vertex]);
	}
	
}
