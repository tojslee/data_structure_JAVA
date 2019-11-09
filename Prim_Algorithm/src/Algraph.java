
public class Algraph {
	int n;
	AlList[]  algraph;
	
	public Algraph(int n) {
		this.n = n;
		algraph = new AlList[n];
		for(int i = 0; i < n; i++) {
			algraph[i] = new AlList();
		}
	}
	
	public void addEdge(int from, int to, int w) {
		algraph[from].insertEnd(to, w);
		algraph[to].insertEnd(from, w);
	}
	
	public void print() {
		for(int i = 0; i<n;i++) {
			System.out.print(i);
			System.out.print("-> ");
			AlNode iter = algraph[i].first;
			while(true) {
				if(iter != null) {
					System.out.print(iter.key);
					System.out.print(" ");
				}
				else {
					break;
				}
				iter = iter.next;
			}
			System.out.println();
		}
	}
}
