package LinkLIst;

public class Node {

	public Object data;//��Žڵ��ֵ
	public Node next;//��̽ڵ������
	//�޲���ʱ�Ĺ��캯��
	public Node() {
		this(null,null);
	}
	//��һ������ʱ�Ĺ��캯��
	public Node(Object data){
		this(data,null);
	}
	//����������ʱ�Ĺ��캯��
	public Node(Object data,Node next){
		this.data=data;
		this.next=next;
	}
	public static void main(String[] args) {

	}

}
