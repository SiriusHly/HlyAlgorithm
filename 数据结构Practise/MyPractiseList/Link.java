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

	// 尾插法
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
		return head.next == null;// 这里是head。next
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
			throw new Exception("您所删除的位置不合法");
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
			throw new Exception("插入的位置不合法");
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
			throw new Exception("您所查找的元素不存在");
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
			Node q = p.next;//第三个元素等等
			p.next=head.next;
			head.next=p;
			p=q;//记录下来的q给p
		}
		
	}
	public static void main(String []args) throws Exception{
		Scanner in = new Scanner(System.in);
		Link L = new Link();
		System.out.println("创建链表的长度");
		int n = in.nextInt();
		System.out.println("输入链表的值");
		L.create1(n);
		System.out.println("链表的长度为"+L.length());
		System.out.println("插入");
		int i = in.nextInt();
		Object j = in.next();
		L.insert(i, j);
		L.display();
		System.out.println();
		System.out.println("删除");
		int s = in.nextInt();
		L.remove(s);
		L.display();
		System.out.println("取第i个值");
		int k = in.nextInt();
		System.out.println(L.get(k));
		System.out.println("元素的位置");
		Object x = in.next();
		System.out.println(L.indexOf(x));
		System.out.println("转置后的列链表是");
		L.reverse(head);
		L.display();
				
	}

}
