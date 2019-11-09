import java.io.*;
public class Assignment51 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String s;
			int pos, n, m, a, b;
			BufferedReader rd = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter wr = new BufferedWriter(new FileWriter("output.txt"));
			s = rd.readLine();
			pos = s.indexOf(" ");
			n = Integer.parseInt(s.substring(0, pos)); // vertices
			m = Integer.parseInt(s.substring(pos + 1)); // edges
			Algraph graph =  new Algraph(n);
			for(int i = 0; i < m; i++) {
				s = rd.readLine();
				pos = s.indexOf(" ");
				a = Integer.parseInt(s.substring(0, pos)); // edge from
				b = Integer.parseInt(s.substring(pos + 1)); // edge to
				graph.addEdge(a, b);
			} // getting graph from input.txt
			
			// dfs�ϸ鼭 bcc
			graph.findBC(0, -1);
			
			String ans = Integer.toString(graph.cvertex + 1);
			wr.write(ans);
			
			// file close
			rd.close();
			wr.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
