package 实验二;

/**
 * author:黄良运
 * time：11.30
 */
import java.util.Stack;

public class BiTree<AnyType> {
	BiTreeNode<AnyType> root=null;
	static int $ = 0;

	public BiTree() {
		this.root = null;
	}

	public BiTree(AnyType[] preorder) {// "a","b","d","#","#","#","c","e","#","#","f","#","#"
		AnyType data = preorder[$++];
		if (data!="#") {
			root = new BiTreeNode<AnyType>(data);
			root.lchild = new BiTree<AnyType>(preorder).root;
			root.rchild = new BiTree<AnyType>(preorder).root;
		} else 
			root = null;
		
	}

	int count = 0;

	public BiTreeNode<AnyType> create(AnyType[] h) {
		BiTreeNode<AnyType> root = null;
		if (count < h.length) {
			AnyType data = h[count++];
			if (!data.equals("#")) {
				root = new BiTreeNode<AnyType>(data);
				root.lchild = create(h);
				root.rchild = create(h);
			} else {
				root = null;
			}
		}
		return root;
	}

	// static inner class
	static class BiTreeNode<AnyType> {
		public AnyType data;
		public BiTreeNode<AnyType> lchild, rchild;

		public BiTreeNode() {
			this(null);
		}

		public BiTreeNode(AnyType data) {
			this(data, null, null);
		}

		public BiTreeNode(AnyType data, BiTreeNode<AnyType> lchild, BiTreeNode<AnyType> rchild) {
			super();
			this.data = data;
			this.lchild = lchild;
			this.rchild = rchild;
		}
	}

	// non-Recursive traversal by preorder
	public void preTraverse_nonR(BiTreeNode<AnyType> root) {
		BiTreeNode<AnyType> T = root;
		if (T != null) {
			Stack<BiTreeNode<AnyType>> S = new Stack<BiTreeNode<AnyType>>();
			S.push(T);
			while (!S.isEmpty()) {
				T = S.pop();
				System.out.print(T.data + " ");
				while (T != null) {
					if (T.lchild != null)
						System.out.print(T.lchild.data + " ");
					if (T.rchild != null)
						S.push(T.rchild);
					T = T.lchild;
				}
			}
		}

	}

	// non-Recursive traversal by inorder
	public void inTraverse_nonR(BiTreeNode<AnyType> root) {
		BiTreeNode<AnyType> T = root;
		if (T != null) {
			Stack<BiTreeNode<AnyType>> S = new Stack<BiTreeNode<AnyType>>();
			S.push(T);
			while (!S.isEmpty()) {
				while (S.peek() != null)
					S.push(S.peek().lchild);
				// Let the lchild into stack all the time,the last node is
				// null,pop it.
				S.pop();
				if (!S.isEmpty()) {
					T = S.pop();
					System.out.print(T.data + " ");
					S.push(T.rchild);
				}
			}
		}

	}

	// non_Recurisive traversal by postorder
	public void postTraverse_nonR(BiTreeNode<AnyType> root) {
		BiTreeNode<AnyType> T = root;
		if (T != null) {
			Stack<BiTreeNode<AnyType>> S = new Stack<BiTreeNode<AnyType>>();
			S.push(T);
			boolean flag;
			BiTreeNode<AnyType> p = null;
			while (!S.isEmpty()) {
				while (S.peek() != null)
					S.push(S.peek().lchild);
				S.pop();

				while (!S.isEmpty()) {
					T = S.peek();
					if (T.rchild == null || T.rchild == p) {
						System.out.print(T.data + " ");
						S.pop();
						p = T;
						flag = true;
					} else {
						S.push(T.rchild);// 有右孩子没访问就到这一步
						flag = false;
					}
					if (!flag)
						break;
				}
			}

		}
	}

	// the depth of the binary tree
	public int getDepth(BiTreeNode<AnyType> root) {
		if (root != null) {
			int lDepth = getDepth(root.lchild);
			// System.out.println("l :"+lDepth);
			int rDepth = getDepth(root.rchild);
			// System.out.println("r :"+rDepth);
			return 1 + (lDepth > rDepth ? lDepth : rDepth);
		}
		return 0;
	}

	// the number of leaves's node
	int c = 0;

	public int leaf(BiTreeNode<AnyType> root) {
		if (root != null) {
			if (root.lchild == null && root.rchild == null)
				c++;
			leaf(root.lchild);
			leaf(root.rchild);
		}
		return c;
	}

	// Recursive traversal by preorder
	public void preTraverse(BiTreeNode<AnyType> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preTraverse(root.lchild);
			preTraverse(root.rchild);
		}
	}

	// Recursive traversal by infix Order
	public void inTraverse(BiTreeNode<AnyType> root) {
		if (root != null) {
			inTraverse(root.lchild);
			System.out.print(root.data + " ");
			inTraverse(root.rchild);
		}
	}

	// Recursive traversal by postorder
	public void postTraverse(BiTreeNode<AnyType> root) {
		if (root != null) {
			postTraverse(root.lchild);
			postTraverse(root.rchild);
			System.out.print(root.data + " ");
		}
	}

	public int getTreeLeaf(BiTreeNode<AnyType> root) {
		if (root == null)
			return 0;
		else {
			int leftTreeLeaf = getTreeLeaf(root.lchild);
			int rightTreeLeaf = getTreeLeaf(root.rchild);
			if (root.lchild == null && root.rchild == null)
				return leftTreeLeaf + rightTreeLeaf + 1;
			else
				return leftTreeLeaf + rightTreeLeaf;
		}
	}

	// non-Recursive traversal by postorder
	public static void main(String[] args) {
		String[] a = { "a", "b", "d", "#", "#", "#", "c", "e", "#", "#", "f", "#", "#" };
		Character[] b = { 'a', 'b', 'd', '#', '#', '#', 'c', 'e', '#', '#', 'f', '#', '#' };

		BiTree<String> biTree = new BiTree<String>(a);// ABDEGCFH//DBGEAFHC
		BiTree<String> biTree2 = new BiTree<String>();// ABDEGCFH//DBGEAFHC
		// biTree.root = biTree.createBiTreeByPreorder(a);
		biTree.preTraverse(biTree.root);// abdcef
		System.out.println();
		biTree.preTraverse_nonR(biTree.root);
		System.out.println();
		biTree.inTraverse(biTree.root);// dbaecf
		System.out.println();
		biTree.inTraverse_nonR(biTree.root);
		System.out.println();
		biTree.postTraverse(biTree.root);
		System.out.println();
		biTree.postTraverse_nonR(biTree.root);// dbefca
		System.out.println();
		System.out.println("深度:" + biTree.getDepth(biTree.root));
		System.out.println("叶子:" + biTree.getTreeLeaf(biTree.root));
		System.out.println("叶子:" + biTree.leaf(biTree.root));

		System.out.println();
		BiTreeNode<String> f = biTree2.create(a);
		biTree2.preTraverse(f);
		System.out.println();
		biTree2.inTraverse(f);
	}
}
