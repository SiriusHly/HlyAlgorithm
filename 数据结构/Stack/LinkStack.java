package Stack;

import LinkLIst.Node;

public class LinkStack implements IStack {
	private Node top;
	@Override
	public void clear(){
		top=null;
	}

	@Override
	public boolean isEmpty() {
		
		return top==null;
	}

	@Override
	public int length() {
		Node p =top;
		int length = 0;
		while(p!=null){
			p=p.next;
			++length;
		}
		return length;
	}

	@Override
	public Object peek() {
		if(!isEmpty())
			return top.data;
		else
		return null;
	}

	@Override
	public void push(Object x) throws Exception {
		Node p = new Node(x);
		p.next = top;
		top=p;
	}

	@Override
	public Object pop() {
		if(isEmpty())
		return null;
		else{
			Node p = top;
			top=top.next;
			return p.data;
					
			
		}
	}

	@Override
	public void display() {
		Node p = top;
		while(p!=null){
			System.out.println(p.data.toString()+" ");
			p=p.next;
		}
	}

	@Override
	public boolean isPalindrome(String str) throws Exception {
		
		return false;
	}

}
