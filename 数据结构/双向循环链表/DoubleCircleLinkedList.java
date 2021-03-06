package 双向循环链表;

import java.util.Scanner;


/**
 * 
 * @author 黄良运
 * time：2017.12.5
 *
 * @param <AnyType>
 */
public class DoubleCircleLinkedList<AnyType> {
	
	public static class Node<AnyType> {
		Node<AnyType> prevNode;
		Node<AnyType> nextNode; 
		AnyType data;
		public Node(){
			this(null);
		}
		
		public Node(AnyType data){
			this(data,null,null);
		}
		
		public Node(AnyType data,Node<AnyType> prevNode, Node<AnyType> nextNode) {
			super();
			this.data = data;
			this.prevNode =prevNode;
			this.nextNode = nextNode;
		}
	}
	
	private Node<AnyType> head;
	int size;

	public DoubleCircleLinkedList() {
		head = new Node<AnyType>(null);
	    head.nextNode = head;
	    head.prevNode = head;
	    size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return head.nextNode==null;
	}
	//验证范围合法性
	public void validate(int index) throws Exception{
		if(index<0||index>size()){
			throw new Exception(index<0?"查找节点小于0":"查找节点超出范围");
		}
	}
	
	public Node<AnyType> getNode(int index) throws Exception{
		Node<AnyType> p = head;
		validate(index);
		if(index<size()/2){
			for(int i=0;i<=index;i++)
				p=p.nextNode;
			}
		else{
			for(int i=size();i>index;i--)
				p=p.prevNode;
		}
		return p;
	}
	
	public AnyType get(int index) throws Exception{
		validate(index);
		return getNode(index).data;
	}
	
	public void display() throws Exception{
		Node<AnyType> p = head.nextNode;
		for(int i=0;i<size();i++){
			System.out.print(p.data+" ");
			p=p.nextNode;
		}
		System.out.println();
	}
		
	public void insert(int index,AnyType data) throws Exception{
		Node<AnyType> q = getNode(index);
		Node<AnyType> p = new Node<>(data);
		p.prevNode = q.prevNode;
		p.nextNode = q;
		q.prevNode.nextNode=p;
		q.prevNode=p;
		size++;
	}
	
	public void addHead(AnyType data) throws Exception{
		insert(0, data);
	}
	
	public void addRear(AnyType data) throws Exception{
		insert(size, data);
	}
	
	public void remove(int index) throws Exception{
		validate(index);
		Node<AnyType>  p =getNode(index);
		p.prevNode.nextNode=p.nextNode;
		p.nextNode.prevNode=p.prevNode;
		size--;
		p=null;
		
	}
	
	
	public void inverse(){
		Node<AnyType>p , q , k;
		p = head.nextNode;
		q=p.nextNode;
		while(p!=head){// p q p    k
			k =q.nextNode;
			q.nextNode = p;
			p.prevNode = q;
			p = q;
			q = k;
		}
		q.nextNode = p;
		p.prevNode = q;
	}
	
	public static void main(String[] args) throws Exception{
		DoubleCircleLinkedList<Integer> La = new DoubleCircleLinkedList<Integer>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),s;
		for(int i=0;i<n;i++){
			s = in.nextInt();
			La.addHead(s);
		}
		System.out.println("头插法插入后的结果:");
		La.display();
		System.out.println("就地逆置后的结果：");
		La.inverse();
		La.display();
		//System.out.println("第0个节点前驱"+La.getNode(0).prevNode.data);
		//System.out.println("第3个节点前驱"+La.getNode(3).data);
		//System.out.println("大小"+La.size());
		System.out.println("删除第五个结点:");
		La.remove(4);
		La.display();
		System.out.println("第四个结点插入88:");
		La.insert(3,88);
		La.display();
		System.out.println("第二个位置上的元素:"+La.get(1));
		
	}
}



