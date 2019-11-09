
public class binary_tree {
	public BTNode root;
	
	public binary_tree(int d) {
		root = new BTNode(d);
	}
	
	public binary_tree(BTNode a) {
		root = a;
	}
	
	public void visit(BTNode node) {
		if(node==null)return;
		else {
			System.out.println(node.data);
		}
	}
	
	public void inorderTraversal(BTNode node) {
		if(node == null) return;
		else {
			inorderTraversal(node.left_child);
			visit(node);
			inorderTraversal(node.right_child);
		}
	}
	
	public void postorderTraversal(BTNode node) {
		if(node == null) return;
		else {
			postorderTraversal(node.left_child);
			postorderTraversal(node.right_child);
			visit(node);
		}
	}
	
	public void preorderTraversal(BTNode node) {
		if(node == null) return;
		else {
			visit(node);
			preorderTraversal(node.left_child);
			preorderTraversal(node.right_child);
		}
	}
}
