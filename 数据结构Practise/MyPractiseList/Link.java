package MyPractiseList;
import java.util.Scanner;
public class Link implements Ilist {
	public static Node head;

	public Link() {
		head = new Node();
	}

	public Link(int n, boolean Order) throws Exception {
		if (Order)
			create1(n);
		else
			create2(n);
	}

	// β�巨
	public void create1(int n) throws Exception {
		Scanner in = new Scanner(System.in);
		for (int j = 0; j < n; j++) {
			insert(length(), in.next());
		}
	}

	public void create2(int n) throws Exception {
		Scanner in = new Scanner(System.in);
		for (int j = 0; j < n; j++) {
			insert(0, in.next());
		}
	}

	@Override
	public void clear() {
		head.dada = null;
		head.next = null;
	}

	@Override
	public boolean isEmpty() {
		return head.next == null;// ������head��next
	}

	@Override
	public void remove(int i) throws Exception {
		Node p = head;
		int j = -1;
		while (p.next != null && j < i - 1) {
			p = p.next;
			++j;
		}
		if (p.next == null && j > i - 1)
			throw new Exception("����ɾ����λ�ò��Ϸ�");
		p.next = p.next.next;

	}

	@Override
	public void insert(int i, Object x) throws Exception {
		Node p = head;
		int j = -1;
		while (p != null && j < i - 1) {
			p = p.next;
			++j;
		}
		if (p == null || j > i - 1)
			throw new Exception("�����λ�ò��Ϸ�");
		Node s = new Node(x);
		s.next = p.next;
		p.next = s;
	}

	@Override
	public int length() {
		Node p = head.next;
		int length = 0;
		while (p != null) {
			p = p.next;
			++length;
		}
		return length;
	}

	@Override
	public void display() {
		Node p = head.next;
		while (p != null) {
			System.out.print(p.dada + " ");
			p = p.next;
		}
	}

	@Override
	public Object get(int i) throws Exception {
		int j = 0;
		Node p = head.next;
		while (p != null && j < i) {
			p = p.next;
			j++;
		}
		if (i < j && p == null)
			throw new Exception("�������ҵ�Ԫ�ز�����");
		return p.dada;
	}

	@Override
	public int indexOf(Object x) {
		Node p = head.next;
		int j = 0;
		while (p != null && !p.dada.equals(x)) {
			p = p.next;
			++j;
		}
		if (p != null)
			return j;
		return -1;
	}
	public void reverse(Node head){
		if(head==null||head.next==null||head.next.next==null)
			return ;
		Node  p = head.next.next;
		head.next.next=null;
		while(p!=null){
			Node q = p.next;//������Ԫ�صȵ�
			p.next=head.next;
			head.next=p;
			p=q;//��¼������q��p
		}
		
	}
	public static void main(String []args) throws Exception{
		Scanner in = new Scanner(System.in);
		Link L = new Link();
		System.out.println("��������ĳ���");
		int n = in.nextInt();
		System.out.println("���������ֵ");
		L.create1(n);
		System.out.println("����ĳ���Ϊ"+L.length());
		System.out.println("����");
		int i = in.nextInt();
		Object j = in.next();
		L.insert(i, j);
		L.display();
		System.out.println();
		System.out.println("ɾ��");
		int s = in.nextInt();
		L.remove(s);
		L.display();
		System.out.println("ȡ��i��ֵ");
		int k = in.nextInt();
		System.out.println(L.get(k));
		System.out.println("Ԫ�ص�λ��");
		Object x = in.next();
		System.out.println(L.indexOf(x));
		System.out.println("ת�ú����������");
		L.reverse(head);
		L.display();
				
	}

}
