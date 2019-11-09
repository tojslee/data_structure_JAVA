
public class binary_tree_traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = new String[10];
		s[0] = "1 2 3";
		String[] a = s[0].split(" ");
		int x1 = Integer.parseInt(a[0]);
		int x2 = Integer.parseInt(a[1]);
		int x3 = Integer.parseInt(a[2]);
		BTNode n1 = new BTNode(x1);
		BTNode n2 = new BTNode(x2);
		BTNode n3 = new BTNode(x3);
		n1.left_child = n2;
		n1.right_child = n3;
		binary_tree t = new binary_tree(n1);
		t.inorderTraversal(t.root);
		System.out.println("");
		t.postorderTraversal(t.root);
		System.out.println("");
		t.preorderTraversal(t.root);
		
	}

}
