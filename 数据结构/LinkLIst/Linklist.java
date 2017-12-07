package LinkLIst;

import java.util.Scanner;

import MyList.Ilist;

public class Linklist implements Ilist {

	public static Node head;// �������ͷָ��

	public Linklist() {// ������Ĺ��캯��
		head = new Node(); // ��ʼ��ͷ�ڵ�
	}

	public Linklist(int n, boolean Order) throws Exception {// ����һ������Ϊn�ĵ�����
		this();// ��ʼ��ͷ�ڵ㣿��
		if (Order)// ��β�巨˳������������
			create1(n);
		else
			create2(n);

	}

	// �͵�ת�õ�����
	public void reverse(Node head) {
	 
		// ������Ϊ�ջ�ֻ��ͷ����ֻ��һ��Ԫ�أ����ý������ò���
		//ͷ��㣬��һ����㣬�ڶ������
		if (head == null || head.next == null || head.next.next == null)
			return;
		Node p = head.next.next;// ��pָ�����Ա��е�2��Ԫ��
		head.next.next = null;// �����Ա��е�2��Ϊ��
		while (p != null) {// �ӵ�2��Ԫ�ؿ�ʼp��Ϊ��
			Node q = p.next;
			// ��p����ͷ���֮��
			p.next = head.next;
			head.next = p;
			p = q;// ����������һ��Ԫ��
		}
	}
	
	// ��β�巨˳����������nΪ����Ľڵ��������
	public void create1(int n) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int j = 0; j < n; j++) {
			insert(length(), sc.next());
		}
	}

	// ��ͷ�巨��λ��������������nΪ������Ľڵ����
	public void create2(int n) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int j = 0; j < n; j++) {
			insert(0, sc.next());
		}
	}

	// ��һ���Ѵ���ͷ���ĵ������Ƴɿձ�
	@Override
	public void clear() {
		head.data = null;//����
		head.next = null;

	}

	// �жϴ�ͷ�ڵ�ĵ������Ƿ�Ϊ��
	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	// ��ͷ�ڵ��������
	@Override
	public int length() {
		Node p = head.next;// pָ���׽ڵ�
		int length = 0;
		while (p != null) {
			p = p.next;
			++length;
		}
		return length;
	}

	// ȡ����ͷ�ڵ�ĵ������еĵ�i���ڵ�
	@Override
	public Object get(int i) throws Exception {
		Node p = head.next;// ��ʼ����pָ���׽ڵ㣬jΪ������
		int j = 0;
		while (p != null && j < i) {// ���׽ڵ㿪ʼ�����ң�ֱ��pָ���i���ڵ㣬����pΪ��
			p = p.next;// ָ�����̽ڵ�
			++j;// ��������ֵ��һ
		}
		if (i < j || p == null) {//i<j��ǰ���Ѿ������ڣ�p==null�Ǹպ�����Ǹ�Ԫ�ز�����
			throw new Exception("��" + i + "��Ԫ�ز�����");// iС��0����ڱ�-1ʱ��i���Ϸ�
		}
		return p.data;
	}

	// ���ڴ�ͷ�ڵ�ĵ������е�i���ڵ�֮ǰ����һ��ֵΪx���½ڵ�
	@Override
	public void insert(int i, Object x) throws Exception {
		Node p = head;// ��ʼ��pΪͷ�ڵ�������head
		int j = -1;// ��ʼ��pΪͷ�ڵ㣬jΪ������
		while (p != null && j < i - 1) {// Ѱ�ҵ�i���ڵ��ǰ��???
			p = p.next;
			++j;
		}
		if (j > i - 1 || p == null)
			throw new Exception("����λ�ò��Ϸ�");
		Node s = new Node(x);// �����µĽڵ�
		s.next = p.next;
		p.next = s;// �޸�����ʹ�½ڵ����������
	}
	
    
	// ɾ����ͷ�ڵ�ĵ������е�i���ڵ�(tipѰ��ǰ�����)
	@Override
	public void remove(int i) throws Exception {
		Node p = head;
		int j = -1;
		while (p.next != null && j < i - 1) {// Ѱ�ҵ�i���ڵ��ǰ��(j<i-1)�����ֻ��һ��Ԫ��i=0;-1=-1
			p = p.next;//pΪҪɾ���Ľ���ǰ��
			++j;
		}
		if (j > i - 1 || p.next == null)//p.nextΪҪɾ���Ľ��,-1=-1��ֻ��һ��Ԫ��ֱ��ɾ����һ��Ԫ��
			throw new Exception("ɾ��λ�ò��Ϸ�");
		p.next = p.next.next;
	}

	// �ڴ�ͷ�ڵ�ĵ������в���ֵΪx�Ľڵ�
	@Override
	public int indexOf(Object  x) {
		Node p = head.next;
		int j = 0;// ��ʼ����pָ���׽ڵ㣬jΪ������

		while (p != null&&!p.data.equals(x)) {
			p = p.next;// ָ��ָ����һ���ڵ�
			++j;//��j++��ͬ
		}
		if (p != null)
			return j;
		else
			return -1;// ֵΪx�Ľڵ㲻�ڵ������У��򷵻�-1
	}

	// ��������������еĽڵ�
	@Override
	public void display() {
		Node node = head.next;// ȡ����ͷ�ڵ�ĵ������е��׽ڵ�
		while (node != null) {
			System.out.print(node.data + " ");// ȡ���ڵ��ֵ
			node = node.next;// ȡ����һ���ڵ�
		}
	}

	public static void main(String[] a) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("������Ҫ��������ĳ��ȣ�");
		int n = in.nextInt();
		System.out.println("�����������ֵ��");
		Linklist L = new Linklist(n, false);
		L.display();
		System.out.println();
		System.out.println("������Ҫɾ���ĵ�n���ڵ㣺");
		int m = in.nextInt();
		L.remove(m);
		L.display();
		System.out.println();
		System.out.println("����Ҫ���ҵ�ֵ");
		Object a1 = in.next();//������Object����
		System.out.println(L.indexOf(a1));
		System.out.println("������Ҫ���ҵĵ�i��Ԫ��");
		int i = in.nextInt();
		System.out.println(L.get(i));
		System.out.println("ת�ú�Ϊ��");
		L.reverse(head);
		L.display();

	}

}
