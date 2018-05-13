package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryAndHeap<AnyType extends Comparable<? super AnyType>> {
	BiTreeNode<AnyType> root;

	static class BiTreeNode<AnyType> {
		AnyType data;
		BiTreeNode<AnyType> lchild, rchild;

		public BiTreeNode(AnyType data, BiTreeNode<AnyType> lchild, BiTreeNode<AnyType> rchild) {
			this.data = data;
			this.lchild = lchild;
			this.rchild = rchild;
		}

		public BiTreeNode(AnyType data) {
			this(data, null, null);
		}
	}

	public MyBinaryAndHeap(BiTreeNode<AnyType> root) {
		this.root = root;
	}

	// 详解：inIndex中根遍历序列在Inorder中的开始位置，count表示树中结点的个数
	public MyBinaryAndHeap(AnyType preOrder[], AnyType inOrder[], int preIndex, int inIndex, int count) {
		if (count > 0) {// 先根和中根非空
			AnyType r = preOrder[preIndex];// 取先根遍历中的第一个结点作为根结点
			int i = 0;
			for (; i < count; i++)// 寻找根结点在中根遍历中的序列
				if (r.compareTo(inOrder[i + inIndex]) == 0)
					break;
			root = new BiTreeNode<AnyType>(r);
			root.lchild = new MyBinaryAndHeap<AnyType>(preOrder, inOrder, preIndex + 1, inIndex, i).root;
			// index+i+1中根遍历序列开始的位置，整个中根序列序列开始的位置，a左边结束之后preindex+i+1=3，也就是c的位置
			root.rchild = new MyBinaryAndHeap<AnyType>(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1,
					count - 1 - i).root;
			// System.out.println(inIndex + i + 1);
		}
	}

	// 深度为k，结点个数为2^k-1为满二叉树

	public void postTraverse(BiTreeNode<AnyType> root) {
		if (root != null) {
			postTraverse(root.lchild);
			postTraverse(root.rchild);
			System.out.print(root.data + " ");
		}
	}

	public void preTraverse(BiTreeNode<AnyType> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preTraverse(root.lchild);
			preTraverse(root.rchild);

		}
	}

	public void inTraverse(BiTreeNode<AnyType> root) {
		if (root != null) {
			inTraverse(root.lchild);
			System.out.print(root.data + " ");
			inTraverse(root.rchild);

		}
	}

	ArrayList<AnyType> Arr = new ArrayList<>();

	
	public boolean isCompleteBinaryTree(BiTreeNode<AnyType> root) {
		if (root == null)
			return true;
		Queue<BiTreeNode<AnyType>> queue = new LinkedList<>();

		queue.add(root);
		boolean shouldleaff = false;
		int s = 0;
		while (queue.size() > 0) {
			BiTreeNode<AnyType> node = queue.poll();
			Arr.add(node.data);
			if (shouldleaff && (node.lchild != null || node.rchild != null))
				return false;
			if (node.lchild == null && node.rchild != null)
				return false;
			if (node.lchild != null)
				queue.add(node.lchild);
			if (node.rchild != null)
				queue.add(node.rchild);
			else
				shouldleaff = true;
		}
		return true;

	}

	// 7.筛选法调整堆排序算法
	// 将以low为根结点的子树调整成小顶堆，low、和high分别是序列的上界和下界
	public void sift(int low, int high, AnyType[] Arr) { 
		int i = low;
		int j = 2 * i + 1;
		AnyType temp = Arr[i];
		while (j < high) {
			if (j < high - 1 && Arr[j].compareTo(Arr[j + 1]) < 0) {// 选出最小的子树左右
				j++;
			}
			if (temp.compareTo(Arr[j]) < 0) {// 左右子树比他小就换上去
				Arr[i] = Arr[j];
				i = j;// 每一次j给i从j开始
				j = 2 * i + 1;
			} else {
				j = high + 1;
			}
		}
		Arr[i] = temp;
	}

	// 7.堆排序算法
	public AnyType[] heapSort(AnyType Arr[]) {
		int n = Arr.length;
		AnyType temp;
		for (int i = n / 2 - 1; i >= 0; i--) {// 非叶子结点n/2-1开始调整的根结点，得到一个初始堆
			sift(i, n, Arr);
		}
		for (int i = n - 1; i > 0; i--) {
			temp = Arr[0];
			Arr[0] = Arr[i];// 最后一个和第一个交换
			Arr[i] = temp;
			sift(0, i, Arr);
		}
		return Arr;
	}

	public static void main(String[] hly) {
		String[] S1 = { "a", "b", "d", "c", "e", "f" };
		String[] S2 = { "d", "b", "a", "e", "c", "f" };
		String[] S3 = { "b", "x", "y", "d", "c" };
		String[] S4 = { "y", "x", "d", "b", "c" };

		MyBinaryAndHeap<String> T = new MyBinaryAndHeap<String>(S3, S4, 0, 0, S3.length);
		MyBinaryAndHeap<String> T2 = new MyBinaryAndHeap<String>(S1, S2, 0, 0, S1.length);
		T.postTraverse(T.root);
		System.out.println();
		T.preTraverse(T.root);
		System.out.println();
		T.inTraverse(T.root);
		System.out.println();
		System.out.println(T.isCompleteBinaryTree(T.root));
		boolean flag = true;

		for (String i : T.Arr)
			System.out.print(i + " ");
		System.out.println();

		for (int i = 0; i < T.Arr.size(); i++) {
			if (i != 0 && T.Arr.get(i).compareTo(T.Arr.get((i - 1) / 2)) > 0)
				flag = true;
			else
				flag = false;
		}
		System.out.println(flag);
		String[] S = (String[]) T.Arr.toArray(new String[0]);
		
		for (String j : T.heapSort(S))
			System.out.print(j + " ");
	}

}
