package Tree;
//二叉树链式存储结构的结点
public class BiTreeNode {
	public Object data;
	public BiTreeNode lchild ,rchild;
	//构造一个空节点
	public BiTreeNode(){
		this(null);
	}
	public BiTreeNode(Object data){
		this(data,null,null);
	}
	public BiTreeNode(Object data ,BiTreeNode lchild ,BiTreeNode rchild){
		this.data = data;
		this.lchild  = lchild;
		this.rchild = rchild;
	}
	
	
}
