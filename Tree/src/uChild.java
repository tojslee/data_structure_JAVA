// child�� parent�� �̾��ִ� ���ν� �����͸� ������ ������ ����
// �� ���� �̾��� ������ ���� parent�� ������ ����
// ������ linked listó�� child����� ������ maximum�� ������ ���� �ʱ� ������ �߰��� �� ������ �÷��ִ°���
public class uChild {
	uNode node;
	uChild next;
	
	public void insert(int k) {
		uChild newnode = new uChild();
		newnode.next = null; // uChild��� ����
		newnode.node.insert(k, newnode); // uChild��忡 uNode����
	}
}
