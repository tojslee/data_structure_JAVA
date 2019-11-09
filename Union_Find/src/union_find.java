
public class union_find {
	int n;
	int[] parent;
	int[] cardinality;
	
	public union_find(int n) {
		this.n = n;
		parent = new int[n];
		cardinality = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = -1;
		}
		for(int i = 0; i < n; i++) {
			cardinality[i] = 1;
		}
	}
	
	public void union(int j, int k) {
		if(cardinality[j] >= cardinality[k]) {
			parent[k] = j;
			cardinality[j] += cardinality[k];
		}
		else{
			parent[j] = k;
			cardinality[k] += cardinality[j];
		}
	}
	
	public int find(int k) {
		int s = k;
		int d = 0;
		while(s != -1) {
			d = s;
			s = parent[s];
		}
		
		s = k;
		int f = 0;
		while(s != d) {
			f = s;
			s = parent[s];
			parent[f] = d;
		}
		return d;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		union_find uf = new union_find(7);
		uf.union(0, 2);
		uf.union(4, 5);
		uf.union(3, 6);
		uf.union(3, 4);
		uf.find(5);
	}

}
