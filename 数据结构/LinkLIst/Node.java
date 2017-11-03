package LinkLIst;

public class Node {

	public Object data;//存放节点的值
	public Node next;//后继节点的引用
	//无参数时的构造函数
	public Node() {
		this(null,null);
	}
	//带一个参数时的构造函数
	public Node(Object data){
		this(data,null);
	}
	//带两个参数时的构造函数
	public Node(Object data,Node next){
		this.data=data;
		this.next=next;
	}
	public static void main(String[] args) {

	}

}
