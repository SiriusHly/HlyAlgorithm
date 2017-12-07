package Tree;

public class DebugBiTree {
	// 创建二叉树
	public BiTree createBiTree() {
		//前缀表达式对应于二叉树的先序遍历
		/*BiTreeNode d = new BiTreeNode("D");
		BiTreeNode g = new BiTreeNode("G");
		BiTreeNode h = new BiTreeNode("H");
		BiTreeNode e = new BiTreeNode("E", g, null);
		BiTreeNode b = new BiTreeNode("B", d, e);
		BiTreeNode f = new BiTreeNode("F", null, h);
		BiTreeNode c = new BiTreeNode("C", f, null);
		BiTreeNode a = new BiTreeNode("A", b, c);*/
		
		//作业一前中后缀表达式
		/*BiTreeNode i = new BiTreeNode("d");
		BiTreeNode h = new BiTreeNode("c");
		BiTreeNode g = new BiTreeNode("b");
		BiTreeNode f = new BiTreeNode("a");
		BiTreeNode e = new BiTreeNode("+",h,i);
		BiTreeNode d = new BiTreeNode("*",f,g);
		BiTreeNode c = new BiTreeNode("e");
		BiTreeNode b = new BiTreeNode("*",d,e);
		BiTreeNode a = new BiTreeNode("-",b,c);*/
		
		//作业三孩子兄弟
		BiTreeNode k = new BiTreeNode("H");
		BiTreeNode j = new BiTreeNode("K");
		BiTreeNode i = new BiTreeNode("G",j,k);
		BiTreeNode h = new BiTreeNode("J");
		BiTreeNode g = new BiTreeNode("F",null,i);
		BiTreeNode f = new BiTreeNode("I",null,h);
		BiTreeNode e = new BiTreeNode("D");
		BiTreeNode d = new BiTreeNode("E",f,g);
		BiTreeNode c = new BiTreeNode("C",d,e);
		BiTreeNode b = new BiTreeNode("B",null,c);
		BiTreeNode a = new BiTreeNode("A",b,null);
		return new BiTree(a);
	}

	public static void main(String[] args) throws Exception {
		DebugBiTree debugBiTree = new DebugBiTree();
		BiTree biTree = debugBiTree.createBiTree();
		BiTreeNode root = biTree.root;
		System.out.print("递归先根遍历序列为：");
		biTree.preRootTraverse(root);
		System.out.println();
		System.out.print("非递归先根遍历");
		biTree.preRootTraverse();
		System.out.println();
		System.out.print("递归中根遍历");
		biTree.inRootTraverse(root);
		System.out.println();
		System.out.print("非递归中根遍历");
		biTree.inRootTraverse();
		System.out.println();
		System.out.print("递归后根遍历");
		biTree.postRootTraverse(root);
		System.out.println();
		System.out.print("非递归后根遍历");
		biTree.postRootTraverse();
		System.out.println();
		//递归交换左右子树
		System.out.println("交换左右子树后的先跟遍历");
		biTree.changeLAndR(root);
		biTree.preRootTraverse(root);
		System.out.println();
		/*String preOrder = "ABDEGCFH";
		String inOrder = "DBGEAFHC";
		//根据先根和中根创建一棵树
		BiTree T = new BiTree(preOrder,inOrder,0,0,preOrder.length());
		System.out.println("后跟遍历");
		T.postRootTraverse();*/
		
		
		String preStr = "AB##CD###";
		BiTree T = new BiTree(preStr);
		System.out.println("先根遍历");
		T.preRootTraverse();
		System.out.println();
		System.out.println("中根遍历");
		T.inRootTraverse();
		System.out.println();
		System.out.println("后根遍历");
		T.postRootTraverse();
		System.out.println();
		System.out.println(T.countNode(T.root));
		
		
		
		/*BiTree e = new BiTree();
		String sqBiTree ="ABCDE";//-*e*+abcd
		//创建了一颗二叉树
		BiTreeNode root = e.createBiTree(sqBiTree, 0);
		BiTree T = new BiTree(root);
		System.out.println("中根遍历");
		T.inRootTraverse();
		System.out.println();
		System.out.println("先根遍历");
		T.preRootTraverse();
		System.out.println();
		System.out.println("后根遍历");
		T.postRootTraverse();
		System.out.println();
		System.out.println("层次遍历");
		T.levelTraverse();
		System.out.println();
		System.out.println("树的深度为"+e.getDepth(root));
		tree5 t = new tree5();
		System.out.println("叶子结点为"+t.countLeafNode1(root));*/
	}
}
