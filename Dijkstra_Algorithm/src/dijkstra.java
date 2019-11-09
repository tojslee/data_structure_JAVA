
public class dijkstra {
	
	public static void SP(DGraph graph) {
		boolean[] s = new boolean[graph.n];
		DHeap d = new DHeap(graph.n); // 주의할 것 heap에서 index는 graph에서 vertex값보다 +1되어 있는 수임
		s[0] = true;
		DEdge iter = graph.graph[0].first;
		d.heap[d.vid2vid[0]].d = 0;
		while(iter != null) {
			d.decreaseKey(iter.weight, iter.to, 0);
			iter = iter.next;
		} // 초기설정
		d.deleteMin();
		
		while(true) {
			DNode min = d.QueryMin();
			s[min.vertex] = true; // 포함
			DEdge iter1 = graph.graph[min.vertex].first;
			while(iter1 != null) {
				if(d.heap[d.vid2vid[iter1.to]].d > d.heap[d.vid2vid[min.vertex]].d + iter1.weight) {
					d.decreaseKey(d.heap[d.vid2vid[min.vertex]].d + iter1.weight, iter1.to, min.vertex);
				}
				iter1 = iter1.next;
			}
			d.deleteMin();
			int no = 0;
			
			for(int i = 0; i< graph.n; i++) {
				if(s[i] == true) {
					no += 1;
				}
			}
			if(no == graph.n) {
				break;
			}
		}
		
		for(int i = 0; i< graph.n + 1; i++) {
			System.out.println(d.heap[i].d);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DGraph graph = new DGraph(6);
		graph.insertEdge(0, 1, 6);
		graph.insertEdge(0, 2, 2);
		graph.insertEdge(0, 3, 4);
		graph.insertEdge(3, 2, 1);
		graph.insertEdge(3, 4, 1);
		graph.insertEdge(2, 1, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 5, 1);
		graph.insertEdge(2, 4, 4);
		graph.insertEdge(2, 5, 4);
		graph.insertEdge(4, 5, 1);
		graph.insertEdge(5, 4, 1);
		
		SP(graph);
	}

}
