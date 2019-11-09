
public class quick_sort {
	public static void quickSort(int[] a, int left, int right) {
		int pivot = a[left];
		int front = left;
		int i;
		if(left>=right)return;
		for(i=left;i<right+1;i++) {
			if(a[i]<pivot) {
				front++;
				int tmp = a[i];
				a[i] = a[front];
				a[front] = tmp;
			}
		}
		int tmp = a[front];
		a[front] = a[left];
		a[left] = tmp;
		
		quickSort(a, left, front-1);
		quickSort(a, front+1, right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5, 9, 23, 1, 2};
		quickSort(array, 0, 4);
		for(int i=0;i<5;i++) {
			System.out.println(array[i]);
		}
	}

}
