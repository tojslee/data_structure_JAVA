
public class Agraph {
	int a;
	int[][] agraph;
	
	public Agraph(int a) {
		this.a = a;
		agraph = new int[a][a];
		for(int i = 0;i<a;i++) {
			agraph[i] = new int[a];
		}
		for(int i = 0;i<a;i++) {
			for(int j = 0;j<a;j++) {
				agraph[i][j] = 0;
			}
		}
	}
	
	public void addEdge(int from, int to) {
		agraph[from][to] = 1;
		agraph[to][from] = 1;
	}
	
	public void print() {
		for(int i = 0;i<a;i++) {
			System.out.print(i);
			System.out.print("-> ");
			for(int j = 0;j<a;j++) {
				if(agraph[i][j] == 1) {
					System.out.print(j);
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agraph graph = new Agraph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 3);
		graph.print();
	}

}
