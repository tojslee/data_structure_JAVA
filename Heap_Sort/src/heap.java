public class heap {
	int[] a;
	int length;
	int po;
	public heap(int length){
		a = new int[length + 1];
		this.length = length;
		po = 1;
	}
	
	public void insert(int x) {
		a[po++] = x;
	}
	
	public void heapify(int index) {
		while(a[index/2] < a[index]) {
			if(index == 1) {break;}
			int tmp = a[index];
			a[index] = a[index/2];
			a[index/2] = tmp;
		}
	}
	
	public void deleteMax() {
		int tmp = a[1];
		a[1] = a[length + 1];
		a[length + 1] = tmp;
		length--;
		while(true) {
			int f = 1;
			if(a[f] < a[2*f] || a[f] < a[2*f + 1]) {
				int t;
				if(a[2*f] < a[2*f + 1]) {t = 2*f + 1;}
				else {t = 2*f;}
				int s = a[t];
				a[t] = a[f];
				a[f] = s;
				f = t;
			}
			else {
				break;
			}
		}
	}
}
