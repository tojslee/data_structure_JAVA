
public class union_find {
	int n;
	int[] parent;
	int[] card;
	
	public union_find(int n) {
		this.n = n;
		parent = new int[n];
		card = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = -1;
			card[i] = 1;
		}
	}
	
	public void union(int a, int b) { // a, b --> root
		if(card[a] >= card [b]) {
			parent[b] = a;
			card[a] += card[b];
		}
		else {
			parent[a] = b;
			card[b] += card[a];
		}
	}
	
	public int find(int x) {
		int root = x;
		int a = 0;
		while(root != -1) {
			a = root;
			root = parent[a];
		}
		return a;
	}
}
