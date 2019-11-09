
public class prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int edges = 6;
		int vertices = 6;
		AlList list = new AlList();
		
		boolean[] compo = new boolean[vertices];
		Algraph graph = new Algraph(vertices);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 2);
		//graph.addEdge(0, 4, 9);
		//graph.addEdge(2, 3, 7);
		graph.addEdge(1, 2, 4);
		//graph.addEdge(1, 5, 8);
		graph.addEdge(3, 4, 3);
		graph.addEdge(4, 5, 6);
		graph.addEdge(3, 5, 5);
		minHeap heap = new minHeap(edges);
		compo[0] = true;
		AlNode iter = graph.algraph[0].first;
		while(iter != null) {
			heap.insertEdge(0, iter.key, iter.weight);
			iter = iter.next;
		}
		
		for(int i = 0; i < vertices - 1; i++) {
			while(heap.edgeNum != 0 && compo[heap.findMin().from] == true && compo[heap.findMin().to] == true) {
				heap.deleteMin();
			} // 둘다 componenet 여서 edge가 candidate이 아닌 경우
			
			if(heap.edgeNum == 0) {
				System.out.println("No MST");
				return;
			}
			
			// candidate인 경우
			heap.findMin().compo = true;
			int from = heap.findMin().from;
			int to = heap.findMin().to;
			list.insertEnd(from, to);
			heap.deleteMin(); // edge delete
			
			// candidate 새로 된 edge add
			if(!compo[from]) {
				AlNode iter1 = graph.algraph[from].first;
				while(iter1!=null) {
					if(!compo[iter1.key]) {
						heap.insertEdge(from, iter1.key, iter1.weight);
					}
					iter1 = iter1.next;
				}
			}
			if(!compo[to]) {
				AlNode iter2 = graph.algraph[to].first;
				while(iter2 != null) {
					if(!compo[iter2.key]) {
						heap.insertEdge(to, iter2.key, iter2.weight);
					}
					iter2 = iter2.next;
				}
			}
			
			compo[from] = true;
			compo[to] = true;
			if(heap.edgeNum == 0) {
				System.out.println("There are no MST");
				return;
			}
		}
		
		AlNode iter4 = list.first;
		while(iter4 != null) {
			System.out.print(iter4.key);
			System.out.print(" ");
			System.out.println(iter4.weight);
			iter4 = iter4.next;
		}
		
	}

}
