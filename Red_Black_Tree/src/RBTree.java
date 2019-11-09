
public class RBTree {
	RBNode root;
	
	public RBTree() {
		root = new RBNode();
	}
	
	public void rotateRight(RBNode n) {
		RBNode x = n.left;
		if(n != root) {
			if(n.isLeft()) {
				n.parent.left = x;
				
			}
			else {
				n.parent.right = x;
			}
		}
		else {
			root = x;
			root.parent = null;
		}
		n.left = x.right;
		n.left.isLeft = true;
		n.left.parent = n;
		x.right = n;
		x.right.isLeft = false;
		x.right.parent = x;
	}
	
	public void rotateLeft(RBNode n) {
		RBNode x = n.right;
		if(n != root) {
			if(n.isLeft()) {
				n.parent.left = x;
			}
			else {
				n.parent.right = x;
			}
		}
		else {
			root = x;
			root.parent = null;
		}
		n.right = x.left;
		n.right.isLeft = false;
		n.right.parent = n;
		x.left = n;
		x.left.isLeft = true;
		x.left.parent = x;
	}
	
	public void insert(int k) {
		// newnode ¼³Á¤
		RBNode newnode = new RBNode(k);
		newnode.left = new RBNode();
		newnode.right = new RBNode();
		newnode.red = true;
		
		// Binary Search Tree insert
		RBNode iter = this.root;
		RBNode pare = null;
		while(!iter.isNill()) {
			if(iter.data > k) {
				pare = iter;
				iter = iter.left;
			}
			else if(iter.data < k) {
				pare = iter;
				iter = iter.right;
			}
		}
		
		// insertion
		newnode.parent = pare;
		if(pare == null) {
			root = newnode;
		}
		else {
			if(pare.data > k) {
				pare.left = newnode;
				newnode.isLeft = true;
			}
			else {
				pare.right = newnode;
				newnode.isLeft = false;
			}
		}
		
		//matching property
		RBNode x = newnode;
		while(x != this.root && x.parent.red) {
			if(x.parent.isLeft()) {
				if(x.parent.parent.right.isRed()) {
					// if uncle is red ( uncle is right child of grandparent )
					x.parent.red = false;
					x.parent.parent.right.red = false;
					x.parent.parent.red = true;
					x = x.parent.parent;
				}
				else {
					// if uncle is not red
					if(!x.isLeft()) {
						// if x is right child of parent
						RBNode p = x.parent;
						rotateLeft(x.parent);
						// left rotate at parent
						// x = former parent
						x = p;
					}
					x.parent.red = false;
					x.parent.parent.red = true;
					rotateRight(x.parent.parent);
					x = root;
				}
			}
			else {
				if(x.parent.parent.left.isRed()) {
					// if uncle is red ( uncle is right child of grandparent )
					x.parent.red = false;
					x.parent.parent.left.red = false;
					x.parent.parent.red = true;
					x = x.parent.parent;
				}
				else {
					// if uncle is not red
					if(!x.isLeft()) {
						// if x is right child of parent
						RBNode p = x.parent;
						rotateLeft(x.parent);
						// left rotate at parent
						// x = former parent
						x = p;
					}
					x.parent.red = false;
					x.parent.parent.red = true;
					rotateRight(x.parent.parent);
					x = root;
				}
			}
		}
		root.red = false;
	}
	
	public void delete(int k) {
		
	}
}
