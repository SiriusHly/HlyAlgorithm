package Tree;


import Stack.LinkStack;

/*Hly
 * 2*/
public class BiTree {
	BiTreeNode root;

	public BiTree() {
		this.root = null;
	}

	public BiTree(BiTreeNode root) {
		this.root = root;
	}

	// 由先根遍历和中根遍历序列创建一颗二叉树的算法
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
		if (count > 0) {// 先根和中根非空
			char r = preOrder.charAt(preIndex);// 取先根遍历中的第一个结点作为根节点
			int i = 0;
			for (; i < count; i++)// 寻找根节点在中根遍历中的位置后面没有花括号
				if (r == inOrder.charAt(i + inIndex))
					break;
			root = new BiTreeNode(r);// 建立树的根节点
			root.lchild = new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root;// 建立左子树
			root.rchild = new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - 1 - i).root;// 建立右子树

		}
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}

	public BiTreeNode getRoot() {
		return root;
	}

	// 由标明空子数的先根遍历创建一颗二叉树算法
	private static int index = 0;// 用于记录preStr的索引值String S="abd###ce##f##";

	public BiTree(String preStr) {//AB##CD###
		char c = preStr.charAt(index++);
		if (c != '#') {
			root = new BiTreeNode(c);
			root.lchild = new BiTree(preStr).root;
			root.rchild = new BiTree(preStr).root;
		} else {
			root = null;                                    
		}
	}

	// 先根遍历二叉树递归算法
	public void preRootTraverse(BiTreeNode T) {
		if (T != null) {
			System.out.print(T.data);
			preRootTraverse(T.lchild);
			preRootTraverse(T.rchild);
		}
	}

	// 先根遍历二叉树非递归算法
	public void preRootTraverse() throws Exception {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();
			S.push(T);
			// System.out.println(S.length());
			while (!S.isEmpty()) {
				T = (BiTreeNode) S.pop();
				System.out.print(T.data);
				while (T != null) {
					if (T.lchild != null)
						System.out.print(T.lchild.data);
					if (T.rchild != null)
						S.push(T.rchild);
					T = T.lchild;
				}
			}
		}
	}

	// 中根遍历二叉树递归算法
	public void inRootTraverse(BiTreeNode T) {
		if (T != null) {
			inRootTraverse(T.lchild);
			System.out.print(T.data);
			inRootTraverse(T.rchild);
		}
	}

	// 中跟遍历二叉树非递归算法
	public void inRootTraverse() throws Exception {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();
			S.push(T);
			while (!S.isEmpty()) {
				while (S.peek() != null)
					S.push(((BiTreeNode) S.peek()).lchild);
				S.pop();
				if (!S.isEmpty()) {
					T = (BiTreeNode) S.pop();
					System.out.print(T.data);
					S.push(T.rchild);
				}
			}
		}

	}

	// 后跟遍历二叉树递归算法
	public void postRootTraverse(BiTreeNode T) {
		if (T != null) {
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.print(T.data);
		}
	}

	// 后跟遍历二叉树非递归算法
	public void postRootTraverse() throws Exception {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();
			S.push(T);
			Boolean flag;// 默认为false
			BiTreeNode P = null;// 记录访问输出过的右孩子
			while (!S.isEmpty()) {
				while (S.peek() != null)// 别漏词句
					S.push(((BiTreeNode) S.peek()).lchild);
				S.pop();
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();
					if (T.rchild == null || T.rchild == P) {// 表示没有右孩子或者右孩子已经输出过了
						System.out.print(T.data);
						S.pop();
						P = T;
						flag = true;
					} else {
						S.push(T.rchild);
						flag = false;
					}
					if (!flag)
						break;// 第一层while
				}
			}
		}
	}

	/*public void postTraverse_nonR(BiTreeNode<AnyType> root){
		BiTreeNode<AnyType> T = root;
		if(T!=null){
			Stack<BiTreeNode<AnyType>> S = new Stack<BiTreeNode<AnyType>>();
			S.push(T);
			boolean flag;
			BiTreeNode<AnyType> p = null;//记录访问过的右孩子
			while(!S.isEmpty()){
				while(S.peek()!=null)
					S.push(S.peek().lchild);
				S.pop();
				
				while(!S.isEmpty()){
					T = S.peek();
					if(T.rchild==null||T.rchild==p){//表示右孩子已经输出过了
						System.out.print(T.data+" ");
						S.pop();
						p=T;//已经输出记录
						flag =true;
					}
					else{
						S.push(T.rchild);//有右孩子没访问就到这一步
						flag = false;//跳出循环，以未输出的右孩子为中心
					}
					if(!flag)
						break;
				}
			}
			
		}
	}*/
	// 层次遍历二叉树算法，自左向右
	public void levelTraverse() {
		BiTreeNode T = root;
		if (T != null) {

		}
	}

	// 二叉树上的查找算法
	public BiTreeNode searchNode(BiTreeNode T, Object x) {
		if (T != null) {
			if (T.data.equals(x))
				return T;
			else {
				BiTreeNode lresult = searchNode(T.lchild, x);
				return lresult != null ? lresult : searchNode(T.rchild, x);
			}
		}
		return null;
	}

	// 求二叉树深度的算法
	public int getDepth(BiTreeNode T) {
		if (T != null) {
			int lDepth = getDepth(T.lchild);
			int rDepth = getDepth(T.rchild);
			return 1 + (lDepth > rDepth ? lDepth : rDepth);
		}
		return 0;
	}

	// 统计二叉树节点个数的算法
	public int countNode(BiTreeNode T) {
		int count = 0;
		if (T != null) {
			++count;
			count += countNode(T.lchild);
			count += countNode(T.rchild);
		}
		return count;
	}

	// 判断两颗二叉树是否相等
	public boolean isEqual(BiTreeNode T1, BiTreeNode T2) {
		if (T1 == null && T2 == null)
			return true;
		if (T1 != null && T2 != null)
			if (T1.data.equals(T2.data))
				if (isEqual(T1.lchild, T2.lchild))
					if (isEqual(T1.rchild, T2.rchild))
						return true;
		return false;
	}

	// 统计二叉树中结点个数的算法(采用递归模型)
	public int countNode1(BiTreeNode T) {
		if (T == null)
			return 0;
		else
			return countNode1(T.lchild) + countNode1(T.rchild) + 1;
	}

	// 求二叉树深度的算法(采用递归模型)
	public int getDepth1(BiTreeNode T) {
		if (T == null)
			return 0;
		else if (T.lchild == null && T.rchild == null)
			return 1;
		else
			return 1 + (getDepth1(T.lchild) > getDepth1(T.rchild) ? getDepth1(T.lchild) : getDepth1(T.rchild));
	}

	// 判断两颗二叉树是否相等，采用递归模型
	public boolean isEqual1(BiTreeNode T1, BiTreeNode T2) {
		if (T1 == null && T2 == null)
			return true;
		else if (T1 != null && T2 != null)
			return (T1.data.equals(T2.data)) && (isEqual1(T1.lchild, T2.lchild)) && (isEqual1(T1.rchild, T2.rchild));
		else
			return false;
	}

	// 由顺序存储的完全二叉树建立的一颗二叉树，其中index标识根节点在顺序存储结构中的位置
	public BiTreeNode createBiTree(String sqBiTree, int index) {
		BiTreeNode root = null;
		if (index < sqBiTree.length()) {
			root = new BiTreeNode(sqBiTree.charAt(index));
			root.lchild = createBiTree(sqBiTree, 2 * index + 1);
			root.rchild = createBiTree(sqBiTree, 2 * index + 2);

		}
		return root;
	}
	//递归实现交换二叉树的左右子树交换
	public void changeLAndR(BiTreeNode root_From){
		if(root_From==null)
			return ;
		else{
			BiTreeNode T =root_From.lchild;
			root_From.lchild = root_From.rchild;
			root_From.rchild = T;
			changeLAndR(root_From.lchild);
			changeLAndR(root_From.rchild);
		}
	}

}
