
public class binary_search_tree {
	BSTNode root;
	
	public binary_search_tree() {
		root = null;
	}
	
	public binary_search_tree(int d) {
		root = new BSTNode(d);
	}
	
	public void insert(int d) {
		BSTNode iter = this.root;
		BSTNode pare = this.root;
		while(iter != null) {
			if(d < iter.data) {
				iter = iter.left_child;
				if(iter != null) {
					pare = pare.left_child;
				}
			}
			else if(d == iter.data) {
				System.out.println("The data is in the tree");
				return;
			}
			else {
				iter = iter.right_child;
				if(iter != null) {
					pare = pare.right_child;
				}
			}
		}
		BSTNode newnode = new BSTNode(d);
		if(pare.data < d) {
			pare.right_child = newnode;
		}
		else {
			pare.left_child = newnode;
		}
	}
	
	public void delete(int d) {
		BSTNode iter = this.root;
		BSTNode pare = this.root;
		while(iter != null) {
			if(iter.data < d) {
				iter = iter.right_child;
				if(iter.data != d) {
					pare = pare.right_child;
				}
			}
			else if(iter.data == d) {
				if(pare.data < d) { // pare보다 크므로 오른쪽 자식노드임
					if(iter.right_child == null && iter.left_child == null) {
						pare.right_child = null;
					}
					else if(iter.right_child == null || iter.left_child == null) {
						if(iter.right_child == null) {
							pare.right_child = iter.left_child;
						}
						else {
							pare.right_child = iter.right_child;
						}
					}
					else {
						BSTNode min = iter;
						BSTNode min_p = iter;
						min = min.right_child;
						if(min.left_child != null || min.right_child != null) {
							min_p = min_p.right_child;
						}
						while(min.left_child != null || min.right_child != null) {
							min = min.left_child;
							if(min != null) {min_p = min_p.left_child;}
						}
						if(min_p.data == iter.data) {  //만약에 오른쪽 노드 한개가 최소이고, 그 값을 또 그 값의 right node로 놓으면 무한루프가 발생하기 때문에 이를 핸들링 하는 방법으로 iter의 오른쪽 노드를 null값으로 만듬
							iter.right_child = null;
						}
						min.left_child = iter.left_child;
						min.right_child = iter.right_child;
						pare.right_child = min;
					}
				}
				else {
					if(iter.right_child == null && iter.left_child == null) {
						pare.left_child = null;
					}
					else if(iter.right_child == null || iter.left_child == null) {
						if(iter.right_child == null) {
							pare.left_child = iter.left_child;
						}
						else {
							pare.left_child = iter.right_child;
						}
					}
					else {
						BSTNode min = iter;
						BSTNode min_p =iter;
						min = min.right_child;
						if(min.left_child != null || min.right_child != null) {
							min_p = min_p.right_child;
						}
						while(min.left_child != null || min.right_child != null) {
							min = min.left_child;
							if(min.left_child != null || min.right_child != null) {
								min_p = min_p.left_child;
							}
						}
						
						if(min_p.data == iter.data) {
							iter.right_child = null;
						}
						min.left_child = iter.left_child;
						min.right_child = iter.right_child;
						pare.left_child = min;
					}
				}
				return;
			}
			else {
				iter = iter.left_child;
				if(iter.data != d) {
					pare = pare.left_child;
				}
			}
		}
		System.out.println("The data is not in the tree");
	}
	
	public void inorderTraversal(BSTNode n) {
		if(n == null) return;
		
		inorderTraversal(n.left_child);
		visit(n);
		inorderTraversal(n.right_child);
	}
	
	public void visit(BSTNode n) {
		System.out.println(n.data);
	}
	
	public void split(int d, binary_search_tree small, binary_search_tree big) {
		if(root == null) {
			small = null;
			big = null;
			return;
		}
		BSTNode iter = this.root;
		BSTNode small_iter = null;
		BSTNode big_iter = null;
		BSTNode small_par = null;
		BSTNode big_par = null;
		while(iter != null) {
			if(iter.data < d) { // 찾는 값이 더 커서 노드 밑의 left 서브 트리를 다 small 에 넣어야 하는 경우
				if(small.root == null) { //이게 루트노드가 될 수 있을 때
					small.root = iter;
					iter = iter.right_child;
					small_par = small.root;
					small_iter = small.root.right_child;
				}
				else {
					if(small_par.right_child != null && small_par.right_child.data == small_iter.data) {
						small_par.right_child = iter;
						small_par = small_par.right_child;
					}
					else {
						small_par.left_child = iter;
						small_par = small_par.left_child;
					}
					iter = iter.right_child;
					small_iter = iter;
				}
			}
			else {
				if(big.root == null) {
					big.root = iter;
					big_par = big.root;
					iter = iter.left_child;
					big_iter = big.root.left_child;
				}
				else {
					if(big_par.right_child != null && big_par.right_child.data == big_iter.data) {
						big_par.right_child = iter;
						big_par = big_par.right_child;
					}
					else {
						big_par.left_child = iter;
						big_par = big_par.left_child;
					}
					iter = iter.left_child;
					big_iter = iter;
				}
			}
		}
		
		if(small.root != null) {
			if(small_par.right_child != null && small_iter != null && small_par.right_child.data == small_iter.data) {
				small_par.right_child = null;
			}
			else if (small_par.left_child != null && small_iter != null && small_par.left_child.data == small_iter.data) {
				small_par.left_child = null;
			}
		}
		
		if(big.root != null) {
			if(big_par.right_child != null && big_iter != null && big_par.right_child.data == big_iter.data) {
				big_par.right_child = null;
			}
			else if(big_par.left_child != null && big_iter != null && big_par.left_child.data == big_iter.data) {
				big_par.left_child = null;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		binary_search_tree tree = new binary_search_tree(35);
		tree.insert(12);
		tree.insert(24);
		tree.insert(35);
		tree.insert(12);
		tree.insert(48);
		tree.insert(2);
		tree.insert(3);
		tree.insert(1242);
		tree.insert(12);
		tree.insert(23);
		tree.insert(1);
		tree.insert(87);
		tree.insert(56);
		tree.inorderTraversal(tree.root);
		System.out.println("");
		binary_search_tree big = new binary_search_tree();
		binary_search_tree small = new binary_search_tree();
		tree.split(50, small, big);
		small.inorderTraversal(small.root);
		System.out.println("");
		big.inorderTraversal(big.root);
	}

}
