
public class bubble_sort {
	public static void bubbleSort(int[] a, int length) {
		boolean sorted;
		do {
			sorted = true;
			for(int i = 0 ;i < length - 1; i++) {
				if(a[i] > a[i+1]) {
					int tmp = a[i+1];
					a[i+1] = a[i];
					a[i] = tmp;
					sorted = false;
				}
			}
		} while(!sorted);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5, 9, 23, 1, 2};
		bubbleSort(array, 5);
		for(int i=0;i<5;i++) {
			System.out.println(array[i]);
		}
	}

}
