package 双向循环链表;

import javax.print.attribute.standard.MediaSize.NA;

public class DoubleLinkedList<AnyType extends Comparable<? super AnyType>> {
	
	static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> nextNode;
		public Node<AnyType> prevNode;
		
		public Node(AnyType data){
			this(data,null,null);
		}
		
		public Node(AnyType data, Node<AnyType> nextNode, Node<AnyType> prevNode) {
			super();
			this.data = data;
			this.nextNode = nextNode;
			this.prevNode = prevNode;
		}
	}
	
	private Node<AnyType> head;
	private Node<AnyType> tail;
	
	public DoubleLinkedList(){
		head =tail= new Node<AnyType>(null);
	}

	public int length(){
		int length =0;
		Node<AnyType> p = head.nextNode;
		while(p!=null){
			length++;
			p = p.nextNode;
		}
		return length;
	}
	
	public boolean isEmpty(){
		return head.nextNode==null;
	}
	
	public AnyType get(int index){
		if(index>0){
			int k=0;
			Node<AnyType> p = head.nextNode;
			while(p!=null&&k<index){
				k++;
				p=p.nextNode;
			}
			if(p!=null)
				return p.data;	
		}	
		return null;
	}
	
	public AnyType set(int index,AnyType data){
		AnyType oldData = null;
		if(index>0&&index<length()&&data!=null){
			int k = 0;
			Node<AnyType> p= head.nextNode;
			while(p!=null&&k<index){
				p=p.nextNode;
				k++;
			}
			if(p!=null){
				oldData = p.data;
				p.data = data;
			}
		}
		return oldData;
	}
	
	public void clear(){
		head.nextNode = null;
		tail= head;
	}
	
	public AnyType remove(int index){
		int size = length();
		if(index<=0||index>=length()||isEmpty())
			return null;
		Node<AnyType> p = head;
		int k = 0;
		while(p!=null&&k<index){
			p=p.nextNode;
			k++;
		}
		if(p.nextNode!=null)//后面还有节点
			p.nextNode.prevNode = p.prevNode;
		p.prevNode.nextNode=p.nextNode;//
		if(p==tail)//后面没有节点
			tail = p.prevNode;
		return p.data;
	}
	
	public void display(){
		int k=0;
		Node<AnyType> p = head.nextNode;
		while(p!=null){
			System.out.println(p.data);
		}
	}
	
	public int getFirstNum(){
		Node<AnyType> p = head.nextNode;
		AnyType data = p.data;
		int count = 0;
		while(p!=null||!(data.compareTo(p.data)==0)){
			p=p.nextNode;
			count++;
		}
		if(p!=null)
			return count;
		return -1;
	}
	

}
