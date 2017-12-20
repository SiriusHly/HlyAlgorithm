package one_排序;

import one_排序.ElementType;
import one_排序.KeyType;
import one_排序.RecordNode;

public class BinarySortTree {
	BiTreeNode root;

	public BinarySortTree() {
		root = null;
	}

	public void inOrderTraverse(BiTreeNode p) {
		if (p != null) {
			inOrderTraverse(p.lchild);
			System.out.print(((RecordNode) p.data).element + " ");// ??
			inOrderTraverse(p.rchild);
		}
	}

	// 递归算法
	public Object searchBST(Comparable key) {
		if (key == null || !(key instanceof Comparable)) {// 不能插入空对象或者不可比较大小的对象
			System.out.println("哦哦");
			return null;
		}
		System.out.println("好好");
		return searchBST(root, key);

	}

	// 二叉树查找算法
	private Object searchBST(BiTreeNode p, Comparable key) {
		if (p != null) {
			if (key.compareTo(((RecordNode) p.data).key) == 0) {

				System.out.println("输出2");
				System.out.println(((RecordNode) p.data).key);
				return p.data;
			}
			if (key.compareTo(((RecordNode) p.data).key) < 0) {
				return searchBST(p.lchild, key);
			} else {
				return searchBST(p.rchild, key);
			}
		}
		System.out.println("什么");
		return null;

	}

	// 插入算法
	public boolean insertBST(Comparable key, Object theElement) {
		if (key == null || !(key instanceof Comparable))
			return false;
		if (root == null) {
			root = new BiTreeNode(new RecordNode(key, theElement));
			return true;
		}
		return insertBST(root, key, theElement);

	}

	// 将关键字值为key，数据元素为theElment的结点插入到以p为根的二叉排序树中的递归算法
	private boolean insertBST(BiTreeNode p, Comparable key, Object theElment) {
		if (key.compareTo(((RecordNode) p.data).key) == 0)
			return false;// 不插入关键字重复的结点
		if (key.compareTo(((RecordNode) p.data).key) < 0) {
			System.out.println("插入");
			if (p.lchild == null) {
				p.lchild = new BiTreeNode(new RecordNode(key, theElment));// key
																			// =keyType
																			// >int
				return true;
			} else {
				return insertBST(p.lchild, key, theElment);
			}
		} else if (p.rchild == null) {
			p.rchild = new BiTreeNode(new RecordNode(key, theElment));
			return true;
		} else {
			return insertBST(p.rchild, key, theElment);
		}

	}

	// 二叉排序树的删除排序
	public Object removeBST(Comparable key) {
		if (root == null || key == null || !(key instanceof Comparable)) {
			return null;
		}
		return removeBST(root, key, null);
	}

	// 删除关键字值为elemkey的结点，parent是p的父结点,p为根
	public Object removeBST(BiTreeNode p, Comparable elemkey, BiTreeNode parent) {
		if (p != null) {
			if (elemkey.compareTo(((RecordNode) p.data).key) < 0) {
				return removeBST(p.lchild, elemkey, p);// 在左子树中递归
			} else if (elemkey.compareTo(((RecordNode) p.data).key) > 0) {
				return removeBST(p.rchild, elemkey, p);
			} else if (p.lchild != null && p.rchild != null) {
				// 相等且该结点有左子树
				BiTreeNode innext = p.rchild;// 寻找p在中跟次序下的后继结点innext
				while (innext.lchild != null) {// 寻找右子树中最左的孩子
					innext = innext.lchild;
				}
				p.data = innext.data;// 后继结点替换p
				return removeBST(p.rchild, ((RecordNode) p.data).key, p);
			} else {// p是1度和叶子结点
				if (parent == null) {// 删除根结点，即p==root
					if (p.lchild != null) {
						root = p.lchild;
					} else {
						root = p.rchild;
					}
					System.out.println("删");
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
				System.out.println("删2");
				return p.data;
			}
		}
		return null;
	}

	public static class BiTreeNode {
		Object data;
		BiTreeNode lchild, rchild;

		public BiTreeNode() {
			this(null);
		}

		public BiTreeNode(Object data) {
			this(data, null, null);
		}

		public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {
			this.data = data;
			this.lchild = lchild;
			this.rchild = rchild;
		}

	}

	public static void main(String[] arv) {
		BinarySortTree BS = new BinarySortTree();
		int[] k = { 50, 13, 63, 8, 36, 90, 5, 10, 18, 70 };// 关键字数组
		String[] item = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", };// 数据元素
		KeyType[] key = new KeyType[k.length];
		ElementType[] elem = new ElementType[k.length];
		for (int i = 0; i < k.length; i++) {
			key[i] = new KeyType(k[i]);
			elem[i] = new ElementType(item[i]);
			if (BS.insertBST(key[i], elem[i])) {
				System.out.println(key[i].key + " " + elem[i] + " " + key[i].toString());
			}

		}

		System.out.println("中序遍历");
		BS.inOrderTraverse(BS.root);
		System.out.println();
		KeyType keyValue = new KeyType();
		keyValue.key = 10;
		// int s=(int)BS.searchBST(keyValue);
		RecordNode found = (RecordNode) BS.searchBST(keyValue);
		// System.out.println("查找到的关键码："+found.key+"对应的姓氏为:"+found.element);
		System.out.println("查找到的关键码：" + found + " " + keyValue.key + " " + keyValue);

		keyValue.key = 13;
		found = (RecordNode) BS.removeBST(keyValue);
		if (found != null) {
			System.out.println("删除的关键码：" + keyValue.key + "对应的姓氏为:" + found.element + found);
		} else {
			System.out.println("删除失败");
		}

	}
}
