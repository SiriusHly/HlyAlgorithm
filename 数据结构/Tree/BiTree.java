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

	// ���ȸ��������и��������д���һ�Ŷ��������㷨
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
		if (count > 0) {// �ȸ����и��ǿ�
			char r = preOrder.charAt(preIndex);// ȡ�ȸ������еĵ�һ�������Ϊ���ڵ�
			int i = 0;
			for (; i < count; i++)// Ѱ�Ҹ��ڵ����и������е�λ�ú���û�л�����
				if (r == inOrder.charAt(i + inIndex))
					break;
			root = new BiTreeNode(r);// �������ĸ��ڵ�
			root.lchild = new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root;// ����������
			root.rchild = new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - 1 - i).root;// ����������

		}
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}

	public BiTreeNode getRoot() {
		return root;
	}

	// �ɱ������������ȸ���������һ�Ŷ������㷨
	private static int index = 0;// ���ڼ�¼preStr������ֵString S="abd###ce##f##";

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

	// �ȸ������������ݹ��㷨
	public void preRootTraverse(BiTreeNode T) {
		if (T != null) {
			System.out.print(T.data);
			preRootTraverse(T.lchild);
			preRootTraverse(T.rchild);
		}
	}

	// �ȸ������������ǵݹ��㷨
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

	// �и������������ݹ��㷨
	public void inRootTraverse(BiTreeNode T) {
		if (T != null) {
			inRootTraverse(T.lchild);
			System.out.print(T.data);
			inRootTraverse(T.rchild);
		}
	}

	// �и������������ǵݹ��㷨
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

	// ��������������ݹ��㷨
	public void postRootTraverse(BiTreeNode T) {
		if (T != null) {
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.print(T.data);
		}
	}

	// ��������������ǵݹ��㷨
	public void postRootTraverse() throws Exception {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();
			S.push(T);
			Boolean flag;// Ĭ��Ϊfalse
			BiTreeNode P = null;// ��¼������������Һ���
			while (!S.isEmpty()) {
				while (S.peek() != null)// ��©�ʾ�
					S.push(((BiTreeNode) S.peek()).lchild);
				S.pop();
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();
					if (T.rchild == null || T.rchild == P) {// ��ʾû���Һ��ӻ����Һ����Ѿ��������
						System.out.print(T.data);
						S.pop();
						P = T;
						flag = true;
					} else {
						S.push(T.rchild);
						flag = false;
					}
					if (!flag)
						break;// ��һ��while
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
			BiTreeNode<AnyType> p = null;//��¼���ʹ����Һ���
			while(!S.isEmpty()){
				while(S.peek()!=null)
					S.push(S.peek().lchild);
				S.pop();
				
				while(!S.isEmpty()){
					T = S.peek();
					if(T.rchild==null||T.rchild==p){//��ʾ�Һ����Ѿ��������
						System.out.print(T.data+" ");
						S.pop();
						p=T;//�Ѿ������¼
						flag =true;
					}
					else{
						S.push(T.rchild);//���Һ���û���ʾ͵���һ��
						flag = false;//����ѭ������δ������Һ���Ϊ����
					}
					if(!flag)
						break;
				}
			}
			
		}
	}*/
	// ��α����������㷨����������
	public void levelTraverse() {
		BiTreeNode T = root;
		if (T != null) {

		}
	}

	// �������ϵĲ����㷨
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

	// ���������ȵ��㷨
	public int getDepth(BiTreeNode T) {
		if (T != null) {
			int lDepth = getDepth(T.lchild);
			int rDepth = getDepth(T.rchild);
			return 1 + (lDepth > rDepth ? lDepth : rDepth);
		}
		return 0;
	}

	// ͳ�ƶ������ڵ�������㷨
	public int countNode(BiTreeNode T) {
		int count = 0;
		if (T != null) {
			++count;
			count += countNode(T.lchild);
			count += countNode(T.rchild);
		}
		return count;
	}

	// �ж����Ŷ������Ƿ����
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

	// ͳ�ƶ������н��������㷨(���õݹ�ģ��)
	public int countNode1(BiTreeNode T) {
		if (T == null)
			return 0;
		else
			return countNode1(T.lchild) + countNode1(T.rchild) + 1;
	}

	// ���������ȵ��㷨(���õݹ�ģ��)
	public int getDepth1(BiTreeNode T) {
		if (T == null)
			return 0;
		else if (T.lchild == null && T.rchild == null)
			return 1;
		else
			return 1 + (getDepth1(T.lchild) > getDepth1(T.rchild) ? getDepth1(T.lchild) : getDepth1(T.rchild));
	}

	// �ж����Ŷ������Ƿ���ȣ����õݹ�ģ��
	public boolean isEqual1(BiTreeNode T1, BiTreeNode T2) {
		if (T1 == null && T2 == null)
			return true;
		else if (T1 != null && T2 != null)
			return (T1.data.equals(T2.data)) && (isEqual1(T1.lchild, T2.lchild)) && (isEqual1(T1.rchild, T2.rchild));
		else
			return false;
	}

	// ��˳��洢����ȫ������������һ�Ŷ�����������index��ʶ���ڵ���˳��洢�ṹ�е�λ��
	public BiTreeNode createBiTree(String sqBiTree, int index) {
		BiTreeNode root = null;
		if (index < sqBiTree.length()) {
			root = new BiTreeNode(sqBiTree.charAt(index));
			root.lchild = createBiTree(sqBiTree, 2 * index + 1);
			root.rchild = createBiTree(sqBiTree, 2 * index + 2);

		}
		return root;
	}
	//�ݹ�ʵ�ֽ�����������������������
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
