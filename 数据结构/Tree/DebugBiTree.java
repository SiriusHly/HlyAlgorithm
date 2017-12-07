package Tree;

public class DebugBiTree {
	// ����������
	public BiTree createBiTree() {
		//ǰ׺���ʽ��Ӧ�ڶ��������������
		/*BiTreeNode d = new BiTreeNode("D");
		BiTreeNode g = new BiTreeNode("G");
		BiTreeNode h = new BiTreeNode("H");
		BiTreeNode e = new BiTreeNode("E", g, null);
		BiTreeNode b = new BiTreeNode("B", d, e);
		BiTreeNode f = new BiTreeNode("F", null, h);
		BiTreeNode c = new BiTreeNode("C", f, null);
		BiTreeNode a = new BiTreeNode("A", b, c);*/
		
		//��ҵһǰ�к�׺���ʽ
		/*BiTreeNode i = new BiTreeNode("d");
		BiTreeNode h = new BiTreeNode("c");
		BiTreeNode g = new BiTreeNode("b");
		BiTreeNode f = new BiTreeNode("a");
		BiTreeNode e = new BiTreeNode("+",h,i);
		BiTreeNode d = new BiTreeNode("*",f,g);
		BiTreeNode c = new BiTreeNode("e");
		BiTreeNode b = new BiTreeNode("*",d,e);
		BiTreeNode a = new BiTreeNode("-",b,c);*/
		
		//��ҵ�������ֵ�
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
		System.out.print("�ݹ��ȸ���������Ϊ��");
		biTree.preRootTraverse(root);
		System.out.println();
		System.out.print("�ǵݹ��ȸ�����");
		biTree.preRootTraverse();
		System.out.println();
		System.out.print("�ݹ��и�����");
		biTree.inRootTraverse(root);
		System.out.println();
		System.out.print("�ǵݹ��и�����");
		biTree.inRootTraverse();
		System.out.println();
		System.out.print("�ݹ�������");
		biTree.postRootTraverse(root);
		System.out.println();
		System.out.print("�ǵݹ�������");
		biTree.postRootTraverse();
		System.out.println();
		//�ݹ齻����������
		System.out.println("����������������ȸ�����");
		biTree.changeLAndR(root);
		biTree.preRootTraverse(root);
		System.out.println();
		/*String preOrder = "ABDEGCFH";
		String inOrder = "DBGEAFHC";
		//�����ȸ����и�����һ����
		BiTree T = new BiTree(preOrder,inOrder,0,0,preOrder.length());
		System.out.println("�������");
		T.postRootTraverse();*/
		
		
		String preStr = "AB##CD###";
		BiTree T = new BiTree(preStr);
		System.out.println("�ȸ�����");
		T.preRootTraverse();
		System.out.println();
		System.out.println("�и�����");
		T.inRootTraverse();
		System.out.println();
		System.out.println("�������");
		T.postRootTraverse();
		System.out.println();
		System.out.println(T.countNode(T.root));
		
		
		
		/*BiTree e = new BiTree();
		String sqBiTree ="ABCDE";//-*e*+abcd
		//������һ�Ŷ�����
		BiTreeNode root = e.createBiTree(sqBiTree, 0);
		BiTree T = new BiTree(root);
		System.out.println("�и�����");
		T.inRootTraverse();
		System.out.println();
		System.out.println("�ȸ�����");
		T.preRootTraverse();
		System.out.println();
		System.out.println("�������");
		T.postRootTraverse();
		System.out.println();
		System.out.println("��α���");
		T.levelTraverse();
		System.out.println();
		System.out.println("�������Ϊ"+e.getDepth(root));
		tree5 t = new tree5();
		System.out.println("Ҷ�ӽ��Ϊ"+t.countLeafNode1(root));*/
	}
}
