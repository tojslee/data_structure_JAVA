// child와 parent를 이어주는 노드로써 데이터를 가지고 있지는 않음
// 이 노드로 이어진 노드들은 같은 parent를 가지고 있음
// 일종의 linked list처럼 child노드의 개수가 maximum이 정해져 있지 않기 때문에 추가가 될 때마다 늘려주는것임
public class uChild {
	uNode node;
	uChild next;
	
	public void insert(int k) {
		uChild newnode = new uChild();
		newnode.next = null; // uChild노드 생성
		newnode.node.insert(k, newnode); // uChild노드에 uNode연결
	}
}
