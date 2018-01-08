package six_ChildAndBrother;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author ������ time��2017.12.15 ���ĺ����ֵܱ�ʾ ���ĸ�������������ȡ�����ĺ��Ӹ�����ʵ�������ȸ�������Ͳ�α��� ��
 *         ɭ�ֵ����������ͬ�����Ӧ�Ķ���������������� ��ɭ�ֵ����������ͬ�����Ӧ�Ķ����������������
 *         ������������ͺ�������ֱ��Ӧ����ת���ɵĶ�������������������������
 */
public class MyCSTBiTree<AnyType extends Comparable<? super AnyType>> {
	private CSTBiTreeNode<AnyType> root = null;
	static int count = 0;

	public MyCSTBiTree() {
		root = null;
	}

	public CSTBiTreeNode<AnyType> createCST(AnyType[] preOrder) {
		CSTBiTreeNode<AnyType> root = null;
		if (count < preOrder.length) {
			AnyType data = preOrder[count++];
			if (!data.equals("#")) {
				root = new CSTBiTreeNode<AnyType>(data);
				root.firstchild = createCST(preOrder);
				root.nextsibling = createCST(preOrder);
			} else {
				root = null;
			}
		}
		return root;
	}

	public void preOrder(CSTBiTreeNode<AnyType> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.firstchild);
			preOrder(root.nextsibling);
		}
	}

	public void InOrder(CSTBiTreeNode<AnyType> root) {
		if (root != null) {
			InOrder(root.firstchild);
			System.out.print(root.data + " ");
			InOrder(root.nextsibling);
		}
	}

	public void gradationTraverse(CSTBiTreeNode<AnyType> root) {
		if (root != null) {
			Queue<CSTBiTreeNode<AnyType>> queue = new LinkedList<CSTBiTreeNode<AnyType>>();
			queue.add(root);
			while (!queue.isEmpty()) {
				for (CSTBiTreeNode<AnyType> T = queue.poll(); T != null; T = T.nextsibling) {
					System.out.print(T.data + " ");
					if (T.firstchild != null)
						queue.add(T.firstchild);
				}
			}
		}
	}
	//�������
	public int getDepth(CSTBiTreeNode<AnyType> root){
		int m,max =0;
		if(root==null)
			return 0;
		else if(root.firstchild==null)
			return 1;
		else{ 
			for(CSTBiTreeNode<AnyType> p = root.firstchild;p!=null;p=p.nextsibling){
				m=getDepth(p);
				if(m>max)
					max =m;
			}
			return max+1;
		}
	}
	//���Ľ��ĸ���
	static int nodeCount =0;
	public int getNodeNum(CSTBiTreeNode<AnyType> root){
		if(root!=null){
			nodeCount++;
			getNodeNum(root.firstchild);
			getNodeNum(root.nextsibling);
		}
		return nodeCount;
	}
	/*//���ĺ��ӽ��ĸ���
	static int childNum=0;
	public int getchildCount(CSTBiTreeNode<AnyType> root){
		if(root!=null){
			if(root.firstchild!=null)
			++childNum;
			getchildCount(root.firstchild);
			getchildCount(root.nextsibling);
		}
		return childNum;
	}*/
	//���ĺ��ӽ�����
	static int countNodeChild =0;
	public int getNodeChild(CSTBiTreeNode<AnyType> root,AnyType n){
		if(root!=null){
			if(root.data!=n){
				getNodeChild(root.firstchild,n);
				getNodeChild(root.nextsibling,n);
			}
			else{
				CSTBiTreeNode<AnyType> p = root.firstchild;
				while(p!=null){
					p = p.nextsibling;
					countNodeChild++;
				}
				
			}
		}
		return countNodeChild;
	}
	
	

	static class CSTBiTreeNode<AnyType> {
		AnyType data;
		CSTBiTreeNode<AnyType> firstchild, nextsibling;

		public CSTBiTreeNode() {
			this(null);
		}

		public CSTBiTreeNode(AnyType data) {
			this(data, null, null);
		}

		public CSTBiTreeNode(AnyType data, CSTBiTreeNode<AnyType> firstchild, CSTBiTreeNode<AnyType> nextsibling) {
			this.data = data;
			this.firstchild = firstchild;
			this.nextsibling = nextsibling;
		}

	}

	public static void main(String[] hly) {
		// String[] string = {"a", "b", "d", "#", "#", "#", "c", "e", "#", "#",
		// "f", "#", "#"};
		String[] string = { "a", "b", "d", "#", "e", "#", "#", "c", "#", "f", "#", "#", "#" };
		MyCSTBiTree<String> cstBiTree = new MyCSTBiTree<String>();
		CSTBiTreeNode<String> r = cstBiTree.createCST(string);
		//���������Ӧ������������
		System.out.println("�����������:");
		cstBiTree.preOrder(r);
		System.out.println();
		//���ĺ����Ӧ����������
		System.out.println("���ĺ������:");
		cstBiTree.InOrder(r);
		System.out.println();
		System.out.println("���Ĳ�α���:");
		cstBiTree.gradationTraverse(r);
		System.out.println();
		System.out.println("���������:"+cstBiTree.getDepth(r));
		System.out.println("���Ľ��ĸ���:"+cstBiTree.getNodeNum(r));
		//System.out.println("���ĺ��ӽ��ĸ���:"+cstBiTree.getchildCount(r));
		System.out.println("���Ľ�㺢�ӵĸ���:"+cstBiTree.getNodeChild(r, "a"));
	}

}
