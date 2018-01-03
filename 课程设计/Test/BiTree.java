package Test;

import java.util.Arrays;

import Tree.BiTreeNode;

public class BiTree {
	BiTreeNode root;

	public static class BiTreeNode {
		public Object data;
		public BiTreeNode lchild, rchild;

		// ����һ���սڵ�
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

	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
		if (count > 0) {
			char r = preOrder.charAt(preIndex);
			int i = 0;
			for (; i < count; i++)
				if (r == inOrder.charAt(i + inIndex))
					break;
			root = new BiTreeNode(r);
			root.lchild = new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root;
			root.rchild = new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root;

		}

	}

	// ��ʽ��������

	public void jishu(int data[]) {

		radixSort(data, data.length, 3); // 3:�������λ��
		// System.out.println("���������飺");
		print(data);

	}

	public static void radixSort(int[] data, int radix, int d) {

		// ��������

		int[] tmp = new int[data.length];

		// buckets���ڼ�¼������Ԫ�ص���Ϣ

		// buckets���鶨����max-min��Ͱ

		int[] buckets = new int[radix];

		for (int i = 0, rate = 1; i < d; i++) {

			// ����count���飬��ʼͳ����һ���ؼ���

			Arrays.fill(buckets, 0);

			// ��data�е�Ԫ����ȫ���Ƶ�tmp������

			System.arraycopy(data, 0, tmp, 0, data.length);

			// ����ÿ�����������ݵ��ӹؼ���

			for (int j = 0; j < data.length; j++) {

				int subKey = (tmp[j] / rate) % radix;

				buckets[subKey]++;

			}

			for (int j = 1; j < radix; j++) {

				buckets[j] = buckets[j] + buckets[j - 1];

			}

			// ���ӹؼ��ֶ�ָ�������ݽ�������

			for (int m = data.length - 1; m >= 0; m--) {

				int subKey = (tmp[m] / rate) % radix;

				data[--buckets[subKey]] = tmp[m];

			}

			rate *= radix;

		}
	}

	public static void print(int[] data) {

		for (int i = 0; i < data.length; i++) {

			System.out.print(data[i] + " ");

		}

		// System.out.println();

	}

	public static void main(String[] a) {
		String S1 = "abdcef";
		String S2 = "dbaefc";

		BiTree T = new BiTree(S1, S2, 0, 0, S1.length());
	}

}
