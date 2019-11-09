
public class minHeap {
	int n;
	int edgeNum;
	GEdge[] edges;
	
	public minHeap(int n) {
		this.n = n;
		edgeNum = 0;
		edges = new GEdge[n + 1];
	}
	
	public void insertEdge(int from, int to, int weight) {
		edges[++edgeNum] = new GEdge(from, to, weight);
		int index = edgeNum;
		while(true) {
			if(edges[index/2] != null && edges[index/2].weight > weight) {
				// heap property violation
				GEdge tmp = edges[index];
				edges[index] = edges[index/2];
				edges[index/2] = tmp;
				index = index / 2;
			}
			else {
				break;
			}
		}
	}
	
	public void deleteMin() {
		GEdge tmp = edges[1];
		edges[1] = edges[edgeNum];
		edges[edgeNum] = tmp;
		// change node with last edge
		edgeNum -=1;
		heapify(1);
	}
	
	public GEdge findMin() {
		return edges[1];
	}
	
	public void heapify(int index) {
		while(true) {
			if(index*2 + 1 <= edgeNum) {
				if(edges[index*2].weight < edges[index].weight && edges[index*2 + 1].weight < edges[index].weight) {
					if(edges[index*2].weight > edges[index*2 + 1].weight) {
						GEdge tmp = edges[index*2 + 1];
						edges[index*2 + 1] = edges[index];
						edges[index] = tmp;
						index = index*2 + 1;
					}
					else {
						GEdge tmp = edges[index*2];
						edges[index*2] = edges[index];
						edges[index] = tmp;
						index = index*2;
					}
				}
				else if(edges[index*2].weight < edges[index].weight) {
					GEdge tmp = edges[index*2];
					edges[index*2] = edges[index];
					edges[index] = tmp;
					index = index*2;
				}
				else if(edges[index*2 + 1].weight < edges[index].weight) {
					GEdge tmp = edges[index*2 + 1];
					edges[index*2 + 1] = edges[index];
					edges[index] = tmp;
					index = index*2 + 1;
				}
				else {
					break;
				}
			}
			else if(index * 2 <= edgeNum) {
				if(edges[index*2].weight < edges[index].weight) {
					GEdge tmp = edges[index*2];
					edges[index*2] = edges[index];
					edges[index] = tmp;
					index = index*2;
				}
				else {
					break;
				}
			}
			else {
				break;
			}
		}
	}
}
