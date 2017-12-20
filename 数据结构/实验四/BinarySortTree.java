package ʵ����;
/*
 * author��������
 * time��12.10
 */

public class BinarySortTree<AnyType extends Comparable<?super AnyType>> {
	BiTreeNode<AnyType> root;

	public BinarySortTree() {
		root = null;
	}

	public void inOrderTraverse(BiTreeNode<AnyType> p) {
		if (p != null) {
			inOrderTraverse(p.lchild);
			System.out.print(p.data+" ");// ??
			inOrderTraverse(p.rchild);
		}
	}

	// �����������㷨
	private AnyType searchBST(BiTreeNode<AnyType> p,AnyType key) {
		if (p != null) {
			if (key.compareTo(p.data) == 0) {
				return p.data;
			}
			if (key.compareTo(p.data) < 0) {
				return searchBST(p.lchild, key);
			} else {
				return searchBST(p.rchild, key);
			}
		}
		return null;
	}

	// �����㷨
	public boolean insertBST(AnyType key) {
		if (key == null)
			return false;
		if (root == null) {
			root = new BiTreeNode<AnyType>(key);
			return true;
		}
		return insertBST(root, key);
	}

	private boolean insertBST(BiTreeNode<AnyType>p, AnyType key) {
		if (key.compareTo(p.data) == 0)
			return false;// ������ؼ����ظ��Ľ��
		if (key.compareTo(p.data) < 0) {
			if (p.lchild == null) {
				p.lchild = new BiTreeNode<AnyType>(key);// key
				return true;
			} else {
				return insertBST(p.lchild, key);
			}
		} else if (p.rchild == null) {
			p.rchild = new BiTreeNode<AnyType>(key);
			return true;
		} else {
			return insertBST(p.rchild, key);
		}
	}

	// ������������ɾ������
	public AnyType removeBST(AnyType key) {
		if (root == null || key == null) {
			return null;
		}
		return removeBST(root, key, null);
	}

	public AnyType removeBST(BiTreeNode<AnyType> p, AnyType elemkey, BiTreeNode<AnyType> parent) {
		if (p != null) {
			if (elemkey.compareTo(p.data) < 0) {
				return removeBST(p.lchild, elemkey, p);// ���������еݹ�
			} else if (elemkey.compareTo(p.data) > 0) {
				return removeBST(p.rchild, elemkey, p);
			} else if (p.lchild != null && p.rchild != null) {
				// ����Ҹý����������
				BiTreeNode<AnyType> innext = p.rchild;// Ѱ��p���и������µĺ�̽��innext
				while (innext.lchild != null) {// Ѱ��������������ĺ���
					innext = innext.lchild;
				}
				p.data = innext.data;// ��̽���滻p
				return removeBST(p.rchild, p.data, p);
			} else {// p��1�Ⱥ�Ҷ�ӽ��
				if (parent == null) {// ɾ������㣬��p==root
					if (p.lchild != null) {
						root = p.lchild;
					} else {
						root = p.rchild;
					}
	
					return p.data;
				}
				if (p == parent.lchild) {
					if (p.lchild == null) {
						parent.lchild = p.lchild;
					} else {
						parent.lchild = p.rchild;
					}
				} else if (p.lchild != null) {
					parent.rchild = p.lchild;
				} else {
					parent.rchild = p.rchild;
				}
				return p.data;
			}
		}
		return null;
	}

	public static class BiTreeNode<AnyType extends Comparable<?super AnyType>> {
		AnyType data;
		BiTreeNode<AnyType> lchild, rchild;

		public BiTreeNode() {
			this(null);
		}
		public BiTreeNode(AnyType data) {
			this(data, null, null);
		}
		public BiTreeNode(AnyType data, BiTreeNode<AnyType> lchild, BiTreeNode<AnyType> rchild) {
			this.data = data;
			this.lchild = lchild;
			this.rchild = rchild;
		}
	}

	public static void main(String[] args) {
		BinarySortTree<Integer> BS = new BinarySortTree<Integer>();
		//int[] k = { 45, 24, 53, 12, 37, 9 };// �ؼ�������
		int[] k = { 49,12,65,8,35,5,10,15,88,68};// �ؼ�������
		//String[] item = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", };// ����Ԫ��
		for (int i = 0; i < k.length; i++) {
			if (BS.insertBST(k[i])) {
				System.out.println(k[i]+" ");
			}
		}
		System.out.println("�������");
		BS.inOrderTraverse(BS.root);
		System.out.println();
		//System.out.println(BS.insertBST(53));
		BS.inOrderTraverse(BS.root);
		System.out.println();
		System.out.println(BS.removeBST(12));
		BS.inOrderTraverse(BS.root);
		System.out.println();
		System.out.println(BS.searchBST(BS.root, 9));
	}
}
