package MyPractiseList;

public class Node {
	public Object dada;
	public Node next;
	public Node(Object dada, Node next) {
		super();
		this.dada = dada;
		this.next = next;
	}
	public Node() {
		this(null,null);
		
	}
	public Node(Object data){
		this(data,null);
	}
	
}
