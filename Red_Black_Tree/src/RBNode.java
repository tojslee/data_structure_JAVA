
public class RBNode {
	public int data;
	public RBNode parent;
	public RBNode right, left;
	public boolean red;
	public boolean extraBlack;
	public boolean isLeft; // 이 노드가 left child인지 아닌지
	public boolean nill;
	
	// get booleans
	public boolean isRed() {
		if(nill) {
			return false;
		}
		return red;
	}
	public boolean isLeft() {return isLeft;}
	public boolean isExBlack() {if(nill) {return false;} return extraBlack;}
	public boolean isNill() {return nill;}
	
	public RBNode() {
		nill = true;
	}
	
	public RBNode(int n) {
		data = n;
		nill = false;
	}
}
