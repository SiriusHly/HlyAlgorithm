package MyPractiseList;

import javax.swing.event.AncestorEvent;


/**
 * 
 * @author hly
 *
 * @param <AnyType>
 *            1.extends表明AnyType只能继承Comparable接口的类或者其子类 2.Comparable<?super
 *            AnyType>表示类型是AnyType或AnyType的上层父类 3.T是自定义泛型 ？通配符泛型
 */
public class MySingleLinkList<AnyType extends Comparable<? super AnyType>> {

	private int size;
	private Node<AnyType> firstNode;

	public MySingleLinkList(int size, Node<AnyType> firstNode) {
		this.size = 0;
		this.firstNode = firstNode;
	}

	public MySingleLinkList() {
		firstNode = null;
		size = 0;
	}

	// return this singlelink size
	public int getSize() {
		return size;
	}

	// return a singlelink size
	public int getSize(MySingleLinkList<AnyType> La) {
		int count = 0;
		if (La.firstNode == null)
			return -1;
		Node<AnyType> p = La.firstNode;
		while (p != null) {
			++count;
			p = p.nextNode;
		}
		return count;
	}

	// find the node
	public Node<AnyType> getNode(int index) throws Exception {
		Node<AnyType> p;
		if (index < 0 || index > getSize())
			throw new Exception(index < 0 ? "范围小于零" : "范围大了");
		p = firstNode;
		for (int hly = 0; hly < index; hly++)
			p = p.nextNode;
		return p;
	}

	// get the node's data
	public AnyType getNodeData(int index) throws Exception {
		return getNode(index).data;
	}

	// change the ond data to new data and return old data
	public AnyType setNodeData(int index, AnyType newData) throws Exception {
		Node<AnyType> p = getNode(index);
		AnyType oldData = p.data;
		p.data = newData;
		return oldData;
	}

	// insert data
	public void add(int index, AnyType x) throws Exception {
		Node<AnyType> newNode = new Node<AnyType>(x);
		if (this.firstNode == null || index == 0) {
			newNode.nextNode = firstNode;
			firstNode = newNode;
			size++;
		} else {
			Node<AnyType> p = getNode(index - 1);
			newNode.nextNode = p.nextNode;// 1 2 3(p) 4(add) 5()
			p.nextNode = newNode;
			size++;
		}
	}

	// insert the end position
	public boolean add(AnyType x) throws Exception {
		add(getSize(), x);
		return true;
	}

	// delete node
	public boolean remove(int index) throws Exception {
		if (firstNode == null)
			return false;
		if (index == 0 || this.firstNode.nextNode == null) {
			this.firstNode = null;
			size--;
		} else {
			Node<AnyType> p = getNode(index - 1);//1 2 3 4(q) 5 6 ,5->4
			p.nextNode = p.nextNode.nextNode;
			size--;
			/*
			 * q=p.nextNode; p.nextNode=q.nextNode;
			 */
		}
		return true;
	}

	// SingleLink is or not contain the x;
	public int contains(AnyType x, MySingleLinkList<AnyType> La) {
		int index = 0;
		Node<AnyType> p = La.firstNode;
		if (p == null)
			return -1;
		while (p.data != x) {
			index++;
			p = p.nextNode;
		}
		return index;
	}

	// merge two singlelink
	public boolean merge(MySingleLinkList<AnyType> La, MySingleLinkList<AnyType> Lb) throws Exception {
		for (int hly = 0; hly < Lb.getSize(); hly++) {
			AnyType n = (AnyType) Lb.getNodeData(hly);
			boolean f = La.add(n);
			if (!f)
				return false;
		}
		return true;
	}

	// merge two singlelink and sort
	public MySingleLinkList<AnyType> merge(MySingleLinkList<AnyType> La, MySingleLinkList<AnyType> Lb,
			MySingleLinkList<AnyType> Lc) throws Exception {
		Node<AnyType> pa = La.firstNode, pb = Lb.firstNode;
		AnyType temp;
		while (pa != null && pb != null) {
			if (pa.data.compareTo(pb.data) < 0) {
				temp = pa.data;
				pa = pa.nextNode;
			} else {
				temp = pb.data;
				pb = pb.nextNode;
			}
			Lc.add(temp);
		}
		while (pa != null) {
			Lc.add(pa.data);
			pa = pa.nextNode;
		}
		while (pb != null) {
			Lc.add(pb.data);
			pb = pb.nextNode;
		}
		return Lc;
	}
	//display the singleLink
	public void display(MySingleLinkList<AnyType> La){
		Node<AnyType> p = La.firstNode;
		while(p!=null){
			System.out.print(p.data+" ");
			p=p.nextNode;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		//initialize two singlelink
		MySingleLinkList<Integer> La = new MySingleLinkList<Integer>();
		MySingleLinkList<Integer> Lb = new MySingleLinkList<Integer>();
		for(int i=20;i<30;i++)
			La.add(i);
		La.display(La);
		for(int i=2;i<6;i++)
			Lb.add(i);
		Lb.display(Lb);
		La.add(2,66);
		La.display(La);
		La.remove(3);
		La.display(La);
		
	}

	private static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> nextNode;

		public Node(AnyType data, Node<AnyType> nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}

		public Node(AnyType data) {
			this.data = data;
			nextNode = null;
		}

		public Node() {
			data = null;
			nextNode = null;
		}
	}
}
