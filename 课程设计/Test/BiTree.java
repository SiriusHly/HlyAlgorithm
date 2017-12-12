package Test;

import Tree.BiTreeNode;

public class BiTree {
	BiTreeNode root;
	public static class BiTreeNode {
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

	public BiTree(String preOrder,String inOrder,int preIndex,int inIndex,int count) {
		if(count>0){
			char r = preOrder.charAt(preIndex);
			int i=0;
			for(;i<count;i++)
				if(r==inOrder.charAt(i+inIndex))
					break;
			root = new BiTreeNode(r);
			root.lchild = new BiTree(preOrder,inOrder,preIndex+1,inIndex,i).root;
			root.rchild = new BiTree(preOrder,inOrder,preIndex+i+1,inIndex+i+1,count-i-1).root;
				
		}
		
	}
	
	
	
	
	public static void main(String[]a){
		String S1 = "abdcef";
		String S2 = "dbaefc";
		
		
		
		BiTree T = new BiTree(S1, S2, 0, 0, S1.length());
	}
	
	
	
	
	
	
	
	
	

}
