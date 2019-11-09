
public class insertion_sorrt {

	public static void insertionSort(int[] a, int length) {
		for(int i=0;i<length;i++) {
			int val = a[i];
			for(int j = i - 1;j >= 0; j--) {
				if(a[j]>val) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
				else {break;}
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {5, 9, 23, 1, 2};
		insertionSort(array, 5);
		for(int i=0;i<5;i++) {
			System.out.println(array[i]);
		}
	}
}
