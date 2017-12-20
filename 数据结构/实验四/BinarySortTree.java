package 实验四;
/*
 * author：黄良运
 * time：12.10
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

	// 二叉树查找算法
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

	// 插入算法
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
			return false;// 不插入关键字重复的结点
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

	// 二叉排序树的删除排序
	public AnyType removeBST(AnyType key) {
		if (root == null || key == null) {
			return null;
		}
		return removeBST(root, key, null);
	}

	public AnyType removeBST(BiTreeNode<AnyType> p, AnyType elemkey, BiTreeNode<AnyType> parent) {
		if (p != null) {
			if (elemkey.compareTo(p.data) < 0) {
				return removeBST(p.lchild, elemkey, p);// 在左子树中递归
			} else if (elemkey.compareTo(p.data) > 0) {
				return removeBST(p.rchild, elemkey, p);
			} else if (p.lchild != null && p.rchild != null) {
				// 相等且该结点有左子树
				BiTreeNode<AnyType> innext = p.rchild;// 寻找p在中跟次序下的后继结点innext
				while (innext.lchild != null) {// 寻找右子树中最左的孩子
					innext = innext.lchild;
				}
				p.data = innext.data;// 后继结点替换p
				return removeBST(p.rchild, p.data, p);
			} else {// p是1度和叶子结点
				if (parent == null) {// 删除根结点，即p==root
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
		//int[] k = { 45, 24, 53, 12, 37, 9 };// 关键字数组
		int[] k = { 49,12,65,8,35,5,10,15,88,68};// 关键字数组
		//String[] item = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", };// 数据元素
		for (int i = 0; i < k.length; i++) {
			if (BS.insertBST(k[i])) {
				System.out.println(k[i]+" ");
			}
		}
		System.out.println("中序遍历");
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
