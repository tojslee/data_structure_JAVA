
public class Algraph {
	int n;
	AlList[]  algraph;
	int[] dfn;
	int[] low;
	int sequence;
	int cvertex;
	int[] cver;
	int root_child;
	
	public Algraph(int n) {
		this.n = n;
		algraph = new AlList[n];
		for(int i = 0; i < n; i++) {
			algraph[i] = new AlList();
		}
		dfn = new int[n];
		low = new int[n];
		cver = new int[n];
		for(int i = 0; i < this.n; i++) {
			dfn[i] = -1;
			low[i] = -1;
			cver[i] = -1;
		} // initialization of DFSNum and LOWNum
		sequence = 1;
		cvertex = 0;
		root_child = 0;
	}
	
	public void addEdge(int from, int to) {
		algraph[from].insertEnd(to);
		algraph[to].insertEnd(from);
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
	
	public void findBC(int v, int parent) {
		int x;
		// if the vertex is not visited --> DFSNum would be -1
		if (dfn[v] == -1) {
			dfn[v] = low[v] = sequence;
			sequence++;
		} // if the vertex is not visited set dfn and low
		
		AlNode iter = new AlNode(); // pointer to each edge of graph
		iter = algraph[v].first;
		while(iter != null) { // for each incident edge (v, x)
			x = iter.key; // set x for the to vertex of edge
			if(x == parent || dfn[v] < dfn[x]) {
				iter = iter.next;
				continue;
			}
			else {
				// push(v, x)
				if(dfn[x] != -1) { // if x has been visited --> back edge
					low[v] = Math.min(low[v], dfn[x]);
				}
				else { // if the edge is a tree edge
					if(v == 0) {
						root_child++;
					}
					findBC(x, v);
					low[v] = Math.min(low[v], low[x]);
					if(low[x] >= dfn[v]) { // the vertex v is a cut vertex
						if(v == 0) { // if vertex is root with over 2 children
							if(root_child >= 2) {
								cver[cvertex] = v;
								cvertex++;
							}
						}
						else {
							cver[cvertex] = v;
							cvertex++;
						}
						// pop edge until the edge is (v, x)
					}
				}
			}
			iter = iter.next;
		}
	}
	
}
