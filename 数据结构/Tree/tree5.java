package Tree;

public class tree5 {
	//基于二叉树类统计叶子节点成员
	public int countLeafNode(BiTreeNode T){
		int count =0;
		if(T!=null){
			if(T.lchild==null&&T.rchild==null){
				++count;
			}
			else{
				count+=countLeafNode(T.lchild);//加上左子树叶子结点树
				count+=countLeafNode(T.rchild);//加上右子树叶子结点树
			}
		}
		return count;
	}
	
	//采用递归模型方法实现的算法
	public int countLeafNode1(BiTreeNode T){
		if(T==null)
			return 0;
		else if(T.lchild==null&&T.rchild==null)
			return 1;
		else 
			return countLeafNode1(T.lchild)+countLeafNode1(T.rchild);
	}
	
	
	
}
