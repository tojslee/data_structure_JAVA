
public class kruskal {
	
	public static void sort(GEdge[] edges) {
		quickSort(edges, 0, edges.length - 1);
	}
	
	public static void quickSort(GEdge[] edges, int left, int right) {
		if(left >= right) {
			return;
		}
		int front = left;
		int pivot = edges[front].weight;
		
		for(int i = left + 1; i <= right; i++) {
			if(edges[i].weight < pivot) {
				front++;
				GEdge tmp = edges[i];
				edges[i] = edges[front];
				edges[front] = tmp;
			}
		}
		GEdge tmp = edges[front];
		edges[front] = edges[left];
		edges[left] = tmp;
		
		quickSort(edges, left, front - 1);
		quickSort(edges, front + 1, right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get sorted list of edges
		int edge, vertex;
		edge = 6;
		vertex = 6;
		/*
		list[0] = new GEdge(0, 1, 10);
		list[1] = new GEdge(0, 2, 2);
		list[2] = new GEdge(0, 4, 9);
		list[3] = new GEdge(1, 2, 4);
		list[4] = new GEdge(1, 5, 8);
		list[5] = new GEdge(2, 3, 7);
		list[6] = new GEdge(3, 4, 3);
		list[7] = new GEdge(3, 5, 5);
		list[8] = new GEdge(4, 5, 6);
		*/
		GEdge[] list = new GEdge[edge];
		list[0] = new GEdge(0, 1, 10);
		list[1] = new GEdge(0, 2, 2);
		list[2] = new GEdge(1, 2, 4);
		list[3] = new GEdge(3, 4, 3);
		list[4] = new GEdge(3, 5, 5);
		list[5] = new GEdge(4, 5, 6);
		sort(list);
		
		// making a subgraph
		union_find sub = new union_find(vertex);
		int add = 0;
		int i = 0;
		while(add != vertex - 1) {
			if(sub.find(list[i].from) == sub.find(list[i].to)) {
				if(sub.find(list[i].from)== -1) { // 둘다 component가 아닐때/ 둘다 root인 경우
					list[i].component = true;
					sub.union(list[i].from, list[i].to);
					add++;
				}
				// 아니면 무언가 어딘가에 둘다 같은 곳에 속해있다는 거니까
			}
			else {
				list[i].component = true;
				sub.union(sub.find(list[i].from), sub.find(list[i].to));
				add++;
			}
			i++;
			if(i==edge) {
				break;
			}
		}
		
		if(add != vertex - 1) {
			System.out.println("There's no MST in graph");
		}
		else {
			for(int s = 0; s < edge; s++) {
				if(list[s].component) {
					System.out.print(list[s].from);
					System.out.print(" ");
					System.out.println(list[s].to);
				}
			}
		}
	}

}
