package LinkLIst;

import java.util.Scanner;

import MyList.Ilist;

public class Linklist implements Ilist {

	public static Node head;// 单链表的头指针

	public Linklist() {// 单链表的构造函数
		head = new Node(); // 初始化头节点
	}

	public Linklist(int n, boolean Order) throws Exception {// 构造一个长度为n的单链表
		this();// 初始化头节点？？
		if (Order)// 用尾插法顺序建立单链表？？
			create1(n);
		else
			create2(n);

	}

	// 就地转置单链表
	public void reverse(Node head) {
	 
		// 单链表为空或只有头结点或只有一个元素，不用进行逆置操作
		//头结点，第一个结点，第二个结点
		if (head == null || head.next == null || head.next.next == null)
			return;
		Node p = head.next.next;// 令p指向线性表中第2个元素
		head.next.next = null;// 令线性表中第2个为空
		while (p != null) {// 从第2个元素开始p不为空
			Node q = p.next;
			// 将p插入头结点之后
			p.next = head.next;
			head.next = p;
			p = q;// 继续访问下一个元素
		}
	}
	
	// 用尾插法顺序建立单链表，n为链表的节点个数？？
	public void create1(int n) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int j = 0; j < n; j++) {
			insert(length(), sc.next());
		}
	}

	// 用头插法逆位序建立单链表，其中n为单链表的节点个数
	public void create2(int n) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int j = 0; j < n; j++) {
			insert(0, sc.next());
		}
	}

	// 将一个已存在头结点的单链表制成空表
	@Override
	public void clear() {
		head.data = null;//两个
		head.next = null;

	}

	// 判断带头节点的单链表是否为空
	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	// 带头节点的链表长度
	@Override
	public int length() {
		Node p = head.next;// p指向首节点
		int length = 0;
		while (p != null) {
			p = p.next;
			++length;
		}
		return length;
	}

	// 取出带头节点的单链表中的第i个节点
	@Override
	public Object get(int i) throws Exception {
		Node p = head.next;// 初始化，p指向首节点，j为计数器
		int j = 0;
		while (p != null && j < i) {// 从首节点开始向后查找，直到p指向第i个节点，或者p为空
			p = p.next;// 指针向后继节点
			++j;// 计数器的值加一
		}
		if (i < j || p == null) {//i<j是前面已经不存在，p==null是刚好最后那个元素不存在
			throw new Exception("第" + i + "个元素不存在");// i小于0或大于表长-1时，i不合法
		}
		return p.data;
	}

	// 带在带头节点的单链表中第i个节点之前插入一个值为x的新节点
	@Override
	public void insert(int i, Object x) throws Exception {
		Node p = head;// 初始化p为头节点这里是head
		int j = -1;// 初始化p为头节点，j为计数器
		while (p != null && j < i - 1) {// 寻找第i个节点的前驱???
			p = p.next;
			++j;
		}
		if (j > i - 1 || p == null)
			throw new Exception("插入位置不合法");
		Node s = new Node(x);// 生成新的节点
		s.next = p.next;
		p.next = s;// 修改连，使新节点插入链表中
	}
	
    
	// 删除带头节点的单链表中第i个节点(tip寻找前驱结点)
	@Override
	public void remove(int i) throws Exception {
		Node p = head;
		int j = -1;
		while (p.next != null && j < i - 1) {// 寻找第i个节点的前驱(j<i-1)，如果只有一个元素i=0;-1=-1
			p = p.next;//p为要删除的结点的前驱
			++j;
		}
		if (j > i - 1 || p.next == null)//p.next为要删除的结点,-1=-1，只有一个元素直接删除第一个元素
			throw new Exception("删除位置不合法");
		p.next = p.next.next;
	}

	// 在带头节点的单链表中查找值为x的节点
	@Override
	public int indexOf(Object  x) {
		Node p = head.next;
		int j = 0;// 初始化，p指向首节点，j为计数器

		while (p != null&&!p.data.equals(x)) {
			p = p.next;// 指针指向下一个节点
			++j;//和j++相同
		}
		if (p != null)
			return j;
		else
			return -1;// 值为x的节点不在单链表中，则返回-1
	}

	// 输出单链表中所有的节点
	@Override
	public void display() {
		Node node = head.next;// 取出带头节点的单链表中的首节点
		while (node != null) {
			System.out.print(node.data + " ");// 取出节点的值
			node = node.next;// 取出下一个节点
		}
	}

	public static void main(String[] a) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要创建链表的长度：");
		int n = in.nextInt();
		System.out.println("请输入链表的值：");
		Linklist L = new Linklist(n, false);
		L.display();
		System.out.println();
		System.out.println("请输入要删除的第n个节点：");
		int m = in.nextInt();
		L.remove(m);
		L.display();
		System.out.println();
		System.out.println("输入要查找的值");
		Object a1 = in.next();//这里是Object类型
		System.out.println(L.indexOf(a1));
		System.out.println("请输入要查找的第i个元素");
		int i = in.nextInt();
		System.out.println(L.get(i));
		System.out.println("转置后为：");
		L.reverse(head);
		L.display();

	}

}
