
public class merge_sort {
	public static void mergeSort(int[] a, int length) {
		int[] aux = new int[length];
		domergeSort(a, 0, length-1, aux);
	}
	public static void domergeSort(int[] a, int left, int right, int[] aux) {
		if(left>=right) return;
		int mid = (right + left)/2;
		domergeSort(a, left, mid, aux);
		domergeSort(a, mid+1, right, aux);
		int i, j, k;
		for(i=left, j = mid+1, k=left;(i<=mid) && (j<=right);) {
			if(a[i]<=a[j]) {aux[k++]=a[i++];}
			else {aux[k++] = a[j++];}
		}
		while(i <= mid) {aux[k++] = a[i++];}
		while(j <= right) {aux[k++] = a[j++];}
		
		for(int s = left;s<right+1;s++) {
			a[s] = aux[s];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5, 9, 23, 1, 2};
		mergeSort(array, 5);
		for(int i=0;i<5;i++) {
			System.out.println(array[i]);
		}
	}

}
