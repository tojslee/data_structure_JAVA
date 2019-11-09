
public class selection_sort {
	
	public static void selectionSort(int[] a, int length) {
		for(int i=0;i<length-1;i++) {
			int min = a[i];
			int index = i;
			for(int j=i+1;j<length;j++) {
				if(a[j]<min) {min = a[j]; index= j;}
			}
			int tmp = a[i];
			a[i] = min;
			a[index] = tmp;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5, 9, 23, 1, 2};
		selectionSort(array, 5);
		for(int i=0;i<5;i++) {
			System.out.println(array[i]);
		}
	}

}
