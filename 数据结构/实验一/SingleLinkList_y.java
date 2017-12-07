package 实验一;

import java.util.Scanner;

/**
 * 
 * @author 黄良运 time :2017.11.26
 * 带头结点单链表
 * @param <AnyType>
 */
public class SingleLinkList_y<AnyType extends Comparable<? super AnyType>> {
	
	private static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> nextNode;

		public Node(AnyType data, Node<AnyType> nextNode) {
			super();
			this.data = data;
			this.nextNode = nextNode;
		}

		public Node(AnyType data) {
			super();
			this.data = data;
			nextNode = null;
		}

	}
	private int size;
	private Node<AnyType> firstNode;

	public SingleLinkList_y() {
		//this(0, null);
		size=0;
		firstNode=new Node<AnyType>(null);
	}

	// get this single linked list size                                                                                                    bggjjjjjjjjjjjjjjjjj
	public SingleLinkList_y(int size, Node<AnyType> fitstNode) {
		super();
		this.size = size;
		this.firstNode = fitstNode;
	}

	public int getSize() {
		return size;
	}

	// return this single linked list a node
	public Node<AnyType> getNode(int index) throws Exception {
		//首节点
		Node<AnyType> p = this.firstNode.nextNode;
		// Node<AnyType> q = firstNode.nextNode;//带头结点
		if (index < 0 || index >= getSize() || firstNode.nextNode == null)
			throw new Exception(firstNode != null ? index < 0 ? "操作范围小于0" : "操作范围大于单链表长度" : "单链表为空");
		for (int r = 0; r < index; r++)
			p = p.nextNode;
		return p;
	}

	// get the single linked list node's data
	public AnyType getNodeData(int index) throws Exception {
		if (index < 0 || index >= getSize() || firstNode == null)
			throw new Exception(firstNode != null ? index < 0 ? "操作范围小于0" : "操作范围大于单链表的长度" : "单链表为空");
		return getNode(index).data;
	}

	// interpolate a Node at index
	public void insert(int index, AnyType x) throws Exception {
		Node<AnyType> newNode = new Node<AnyType>(x);
		Node<AnyType> p = firstNode;
		int j=-1;
		while(j<index-1&&p!=null){
			p=p.nextNode;
			j++;
		}
		if(j>index-1||p==null){
			throw new Exception("插入位置不合法");
		}
		newNode.nextNode=p.nextNode;
		p.nextNode= newNode;
		size++;
	}

	// the last interpolation
	public boolean addRear(AnyType x) throws Exception {
		insert(getSize(), x);
		return true;
	}

	// the first interpolation
	public boolean addHead(AnyType x) throws Exception {
		insert(0, x);
		return true;
	}

	// remove the node where at index
	public void remove(int index) throws Exception {
		if (index < 0 || index >= size)
			throw new Exception(     index < 0 ? "删除位置小于零" : "删除位置大于单链表长度");
		if (index == 0) {
			//删除位置是首节点
			firstNode.nextNode = firstNode.nextNode.nextNode;
			size--;
		} else {
			Node<AnyType> p = getNode(index - 1);
			p.nextNode = p.nextNode.nextNode;
			size--;
		}
	}

	// display the single linked list node's data
	public void display(SingleLinkList_y<AnyType> L) {
		Node<AnyType> p = L.firstNode.nextNode;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.nextNode;
		}
		System.out.println();
	}

	// move the min number to the single linked list head
	public SingleLinkList_y<AnyType> moveMin(SingleLinkList_y<AnyType> L) throws Exception {
		Node<AnyType> p = L.firstNode.nextNode;
		//int count = 0, i;
		AnyType s = p.data;// s记录下最小的值
		while (p.nextNode != null) {
			p = p.nextNode;
			// count++;
			if (s.compareTo(p.data) >= 0) {
				s = p.data;
				// i=count;
			}
		}
		// All min number
		for (int y = 0; y < size; y++) {
			if (getNodeData(y).equals(s)) {
				remove(y);
				addHead(s);
			}
		}
		/*
		 * remove(i);//3 3 1 7 4 6 addHead(s);
		 */
		return L;

	}

	// attain the index
	public int getIndex(SingleLinkList_y<AnyType> L, AnyType x) {
		Node<AnyType> p = L.firstNode.nextNode;
		int count = 0;
		while (p != null) {
			if (p.data != x) {
				p = p.nextNode;
				count++;
			} else
				return count;
		}
		return count;
	}

	

	// get an single linked list size
	public int getSize(SingleLinkList_y<AnyType> L) {
		int count = 0;
		if (L.firstNode == null)
			return -1;
		Node<AnyType> p = L.firstNode;
		while (p != null) {
			count++;
			p = p.nextNode;
		}
		return count;
	}

	public static void main(String[] hly) throws Exception {
		SingleLinkList_y<Integer> La = new SingleLinkList_y<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.println("请输入元素的个数：");
		int n = in.nextInt();
		System.out.println("请输入元素的值：");
		for (int i = 0; i < n; i++)
			La.addHead(in.nextInt());// 21 75 30 18 42 56
		in.close();
		
		La.display(La);
		System.out.println("第三个位置插入67");
		La.insert(3, 67);
		La.display(La);
		System.out.println("删除第四");
		La.remove(4);
		La.display(La);
		System.out.println("取第五个元素：" + La.getNodeData(5));
		La.moveMin(La);
		System.out.println("最小元素移到前面：");
		La.display(La);

		// La.remove(8);
		// La.insert(9, 10);
		// System.out.println("取第七个"+La.getNodeData(6));

	}

}
