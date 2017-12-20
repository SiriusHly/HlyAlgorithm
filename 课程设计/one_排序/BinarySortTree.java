package one_����;

import one_����.ElementType;
import one_����.KeyType;
import one_����.RecordNode;

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

	// �ݹ��㷨
	public Object searchBST(Comparable key) {
		if (key == null || !(key instanceof Comparable)) {// ���ܲ���ն�����߲��ɱȽϴ�С�Ķ���
			System.out.println("ŶŶ");
			return null;
		}
		System.out.println("�ú�");
		return searchBST(root, key);

	}

	// �����������㷨
	private Object searchBST(BiTreeNode p, Comparable key) {
		if (p != null) {
			if (key.compareTo(((RecordNode) p.data).key) == 0) {

				System.out.println("���2");
				System.out.println(((RecordNode) p.data).key);
				return p.data;
			}
			if (key.compareTo(((RecordNode) p.data).key) < 0) {
				return searchBST(p.lchild, key);
			} else {
				return searchBST(p.rchild, key);
			}
		}
		System.out.println("ʲô");
		return null;

	}

	// �����㷨
	public boolean insertBST(Comparable key, Object theElement) {
		if (key == null || !(key instanceof Comparable))
			return false;
		if (root == null) {
			root = new BiTreeNode(new RecordNode(key, theElement));
			return true;
		}
		return insertBST(root, key, theElement);

	}

	// ���ؼ���ֵΪkey������Ԫ��ΪtheElment�Ľ����뵽��pΪ���Ķ����������еĵݹ��㷨
	private boolean insertBST(BiTreeNode p, Comparable key, Object theElment) {
		if (key.compareTo(((RecordNode) p.data).key) == 0)
			return false;// ������ؼ����ظ��Ľ��
		if (key.compareTo(((RecordNode) p.data).key) < 0) {
			System.out.println("����");
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

	// ������������ɾ������
	public Object removeBST(Comparable key) {
		if (root == null || key == null || !(key instanceof Comparable)) {
			return null;
		}
		return removeBST(root, key, null);
	}

	// ɾ���ؼ���ֵΪelemkey�Ľ�㣬parent��p�ĸ����,pΪ��
	public Object removeBST(BiTreeNode p, Comparable elemkey, BiTreeNode parent) {
		if (p != null) {
			if (elemkey.compareTo(((RecordNode) p.data).key) < 0) {
				return removeBST(p.lchild, elemkey, p);// ���������еݹ�
			} else if (elemkey.compareTo(((RecordNode) p.data).key) > 0) {
				return removeBST(p.rchild, elemkey, p);
			} else if (p.lchild != null && p.rchild != null) {
				// ����Ҹý����������
				BiTreeNode innext = p.rchild;// Ѱ��p���и������µĺ�̽��innext
				while (innext.lchild != null) {// Ѱ��������������ĺ���
					innext = innext.lchild;
				}
				p.data = innext.data;// ��̽���滻p
				return removeBST(p.rchild, ((RecordNode) p.data).key, p);
			} else {// p��1�Ⱥ�Ҷ�ӽ��
				if (parent == null) {// ɾ������㣬��p==root
					if (p.lchild != null) {
						root = p.lchild;
					} else {
						root = p.rchild;
					}
					System.out.println("ɾ");
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
				System.out.println("ɾ2");
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
		int[] k = { 50, 13, 63, 8, 36, 90, 5, 10, 18, 70 };// �ؼ�������
		String[] item = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", };// ����Ԫ��
		KeyType[] key = new KeyType[k.length];
		ElementType[] elem = new ElementType[k.length];
		for (int i = 0; i < k.length; i++) {
			key[i] = new KeyType(k[i]);
			elem[i] = new ElementType(item[i]);
			if (BS.insertBST(key[i], elem[i])) {
				System.out.println(key[i].key + " " + elem[i] + " " + key[i].toString());
			}

		}

		System.out.println("�������");
		BS.inOrderTraverse(BS.root);
		System.out.println();
		KeyType keyValue = new KeyType();
		keyValue.key = 10;
		// int s=(int)BS.searchBST(keyValue);
		RecordNode found = (RecordNode) BS.searchBST(keyValue);
		// System.out.println("���ҵ��Ĺؼ��룺"+found.key+"��Ӧ������Ϊ:"+found.element);
		System.out.println("���ҵ��Ĺؼ��룺" + found + " " + keyValue.key + " " + keyValue);

		keyValue.key = 13;
		found = (RecordNode) BS.removeBST(keyValue);
		if (found != null) {
			System.out.println("ɾ���Ĺؼ��룺" + keyValue.key + "��Ӧ������Ϊ:" + found.element + found);
		} else {
			System.out.println("ɾ��ʧ��");
		}

	}
}
