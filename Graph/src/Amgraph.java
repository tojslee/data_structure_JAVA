
public class Amgraph {
	int a;
	AmNode[] amgraph;
	
	public Amgraph(int n) {
		a = n;
		amgraph = new AmNode[n];
	}
	
	public void addEdge(int i, int j) {
		AmNode newnode = new AmNode();
		newnode.i = i;
		newnode.j = j;
		newnode.i_list = null;
		newnode.j_list = null;
		if(amgraph[i] == null) {
			amgraph[i] = newnode;
		}
		else {
			AmNode iter = amgraph[i];
			boolean check = true;
			while(true) {
				if(iter.i == i) {
					if(iter.i_list != null) {
						iter = iter.i_list;
					}
					else {
						check = true;
						break;
					}
				}
				else {
					if(iter.j_list != null) {
						iter = iter.j_list;
					}
					else {
						check = false;
						break;
					}
				}
			}
			if(check) {
				iter.i_list = newnode;
			}
			else {
				iter.j_list = newnode;
			}
		}
		
		//j위치 찾기
		if(amgraph[j] == null) {
			amgraph[j] = newnode;
		}
		else {
			AmNode iter = amgraph[j];
			boolean check = true;
			while(true) {
				if(iter.j == i) {
					if(iter.i_list != null) {
						iter = iter.i_list;
					}
					else {
						check = true;
						break;
					}
				}
				else {
					if(iter.j_list != null) {
						iter = iter.j_list;
					}
					else {
						check = false;
						break;
					}
				}
			}
			if(check) {
				iter.i_list = newnode;
			}
			else {
				iter.j_list = newnode;
			}
		}
	}
	
	public void print() {
		for(int i = 0; i < a ; i++) {
			System.out.print(i);
			System.out.print("-> ");
			AmNode iter = amgraph[i];
			while(true) {
				if(iter.i == i) {
					System.out.print(iter.j);
					System.out.print(" ");
					if(iter.i_list == null) {
						break;
					}
					else {
						iter = iter.i_list;
					}
				}
				else {
					System.out.print(iter.i);
					System.out.print(" ");
					if(iter.j_list == null) {
						break;
					}
					else {
						iter = iter.j_list;
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Amgraph graph = new Amgraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.print();
	}

}
