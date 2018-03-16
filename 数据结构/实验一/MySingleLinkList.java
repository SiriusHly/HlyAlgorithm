package 实验一;



/**
 * 
 * @author 黄良运
 *
 * @param <AnyType>
 *            1.extends表明AnyType只能继承Comparable接口的类或者其子类 2.Comparable<?super
 *            AnyType>表示类型是AnyType或AnyType的上层父类 3.T是自定义泛型 ？通配符泛型
 *             这个?就是传过来的对象不确定，而且必须是Comparable的子类或者子接口。
 *             
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
		// 若创建头结点，则初始化头结点，其与方法也要相应改变p初始指针
		// firstNode = new Node<AnyType>(null);
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
	public int getIndex(MySingleLinkList<AnyType> L,AnyType x){
		Node<AnyType> p= L.firstNode;
		int count=0;
		while(p!=null){
			if(p.data!=x){
				p=p.nextNode;
			count++;
			}
			else{
				break;
			}
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

	// the last interpolation
	public boolean addRear(AnyType x) throws Exception {
		add(getSize(), x);
		return true;
	}

	// the first interpolation
	public boolean addHead(AnyType x) throws Exception {
		add(0, x);
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
			Node<AnyType> p = getNode(index - 1);// 1 2 3 4(q) 5 6 ,5->4
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
			boolean f = La.addHead(n);
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
			Lc.addHead(temp);
		}
		while (pa != null) {
			Lc.addHead(pa.data);
			pa = pa.nextNode;
		}
		while (pb != null) {
			Lc.addHead(pb.data);
			pb = pb.nextNode;
		}
		return Lc;
	}

	// display the singleLink
	public void display(MySingleLinkList<AnyType> La) {
		Node<AnyType> p = La.firstNode;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.nextNode;
		}
		System.out.println();
	}

	/*// move the min number to the single linked list head
	public MySingleLinkList<AnyType> moveMin(MySingleLinkList<AnyType> L) throws Exception {
		Node<AnyType> p = L.firstNode;
		int count = 0, i = 0;
		AnyType s = p.data;
		while (p.nextNode != null) {
			p = p.nextNode;
			count++;
			if (s.compareTo(p.data) > 0) {
				s = p.data;
				i = count;
			}
		}
		remove(i);
		addHead(s);
		return L;
	}*/
	
	// move the min number to the single linked list head
	public MySingleLinkList<AnyType> moveMin(MySingleLinkList<AnyType> L) throws Exception {
		Node<AnyType> p = L.firstNode;
		int count = 0, i = 0;
		AnyType s = p.data;
		while (p.nextNode != null) {
			p = p.nextNode;
			count++;
			if (s.compareTo(p.data) > 0) {
				s = p.data;
				i = count;
			}
		}
		int j = 0;
		Node<AnyType> q = firstNode;
		
		while(j<i-1&&q!=null){
			q= q.nextNode;
			j++;
		}
		if(j>i&&q==null)
			throw new Exception("插入位置不合法");
		q.nextNode = q.nextNode.nextNode;
		size--;
		
		Node<AnyType> x = new Node(s);
		x.nextNode = firstNode;
		firstNode = x;
		size--;
		return L;
	}
	
	/*public void moveMin(Node<AnyType> root){
		Node<AnyType> p= root;
		Node<AnyType> q=null;
		Node<AnyType> pre,pre2=null;
		AnyType s = p.data;
		int i = 0;
		while(p.nextNode!=null){
			pre = p ;
			p = p.nextNode;
			if(s.compareTo(p.data)>0){
				s = p.data;
				q = p;
				pre2 = pre;
			}
		}
		pre2.nextNode = pre2.nextNode.nextNode;
		q.nextNode = firstNode.nextNode;
		firstNode.nextNode =q;
		
		
		
		
	}*/

	public Node<AnyType> getNode2(int index) throws Exception {
		Node<AnyType> p = this.firstNode;
		int k = 0;
		while (p != null || k < index) {
			p = p.nextNode;
			k++;
		}
		if (p == null || k > index) {
			throw new Exception("第" + index + "个元素不存在");
		}
		return p;
	}

	public void insert(int i, Object x) throws Exception {
		Node p = firstNode;// 初始化p为头节点这里是head
		int j = -1;// 初始化p为头节点，j为计数器
		while (p != null && j < i - 1) {// 寻找第i个节点的前驱???
			p = p.nextNode;
			++j;
		}
		if (j > i - 1 || p == null)
			throw new Exception("插入位置不合法");
		Node s = new Node(x);// 生成新的节点
		s.nextNode = p.nextNode;
		p.nextNode = s;// 修改连，使新节点插入链表中
	}
	
	public void reverseprint(Node<AnyType> head){
		if(head == null)
			return ;
		else
		{
			reverseprint(head.nextNode);
			System.out.print(head.data+" ");
		}
	}
	/*public Node<AnyType> reverse(Node<AnyType> head){
		Node<AnyType> p = head.nextNode;
		head.nextNode  = null;
		while(p!=null){
			Node<AnyType> q = p.nextNode;
			p.nextNode = head.nextNode;
			head.nextNode = p;
			p = q;
		}
		return head;
	}*/
	public Node reverse(){
		Node p = firstNode;
		firstNode = null;
		while(p!=null){
			Node q = p.nextNode;
			p.nextNode = firstNode;
			firstNode = p;
			p = q;
		}
		return firstNode;
		
	}

	public static void main(String[] args) throws Exception {
		// initialize two singlelink
		MySingleLinkList<Integer> La = new MySingleLinkList<Integer>();
		MySingleLinkList<Integer> Lb = new MySingleLinkList<Integer>();
		for (int i = 20; i < 30; i++)
			La.addRear(i);
		System.out.println("head"+La.firstNode.data);
		System.out.println(La.getNodeData(0));

		La.display(La);
		System.out.println("逆序输出：");
		La.reverseprint(La.firstNode);
		System.out.println("就地逆置：");
		La.reverse();
		La.display(La);
		System.out.println("最小前移：");
		
		La.display(La.moveMin(La));
		//La.moveMin(La);
		//La.display(La);
		/*
		 * for(int i=2;i<6;i++) Lb.add(i); Lb.display(Lb); La.add(2,66);
		 * La.display(La); La.remove(3); La.display(La);
		 */

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
