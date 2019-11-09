
public class radix_sort {
	
	public static int digit(int[] array) {
		int max = 0;
		for(int i = 0;i< array.length;i++) {
			String s = Integer.toString(array[i]);
			int leng = s.length();
			if(leng > max) {
				max = leng;
			}
		}
		return max;
	}
	
	public static void radix(int[] array) {
		RList[] list = new RList[11];
		for(int i = 0; i< 11; i++) {
			list[i] = new RList();
		}
		int max_length = digit(array);
		for(int m = 10; m < Math.pow(10, max_length + 1); m *= 10) {
			for(int i = 0; i < array.length; i++) {
				list[(array[i]%m)/(m/10)].insert(array[i]);
			}
			int n = 0;
			for(int i = 0; i< 11; i++) {
				while(true) {
					if(list[i].getFirst() != -1) {
						array[n++] = list[i].delete();
					}
					else {
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {12, 250, 48, 93, 26, 458, 1, 68, 3, 174, 2, 8, 452, 1234, 12513, 23123, 2312, 323, 998937, 34613, 2535, 624, 2125, 45};
		radix(a);
		for(int i = 0; i<a.length;i++) {
			System.out.println(a[i]);
		}
	}

}
