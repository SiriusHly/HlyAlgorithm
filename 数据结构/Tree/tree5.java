package Tree;

public class tree5 {
	//���ڶ�������ͳ��Ҷ�ӽڵ��Ա
	public int countLeafNode(BiTreeNode T){
		int count =0;
		if(T!=null){
			if(T.lchild==null&&T.rchild==null){
				++count;
			}
			else{
				count+=countLeafNode(T.lchild);//����������Ҷ�ӽ����
				count+=countLeafNode(T.rchild);//����������Ҷ�ӽ����
			}
		}
		return count;
	}
	
	//���õݹ�ģ�ͷ���ʵ�ֵ��㷨
	public int countLeafNode1(BiTreeNode T){
		if(T==null)
			return 0;
		else if(T.lchild==null&&T.rchild==null)
			return 1;
		else 
			return countLeafNode1(T.lchild)+countLeafNode1(T.rchild);
	}
	
	
	
}
