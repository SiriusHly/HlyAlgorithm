package Test;

import java.util.Arrays;

import Tree.BiTreeNode;

public class BiTree {
	BiTreeNode root;

	public static class BiTreeNode {
		public Object data;
		public BiTreeNode lchild, rchild;

		// 构造一个空节点
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

	// 链式基数排序

	public void jishu(int data[]) {

		radixSort(data, data.length, 3); // 3:最大数的位数
		// System.out.println("排序后的数组：");
		print(data);

	}

	public static void radixSort(int[] data, int radix, int d) {

		// 缓存数组

		int[] tmp = new int[data.length];

		// buckets用于记录待排序元素的信息

		// buckets数组定义了max-min个桶

		int[] buckets = new int[radix];

		for (int i = 0, rate = 1; i < d; i++) {

			// 重置count数组，开始统计下一个关键字

			Arrays.fill(buckets, 0);

			// 将data中的元素完全复制到tmp数组中

			System.arraycopy(data, 0, tmp, 0, data.length);

			// 计算每个待排序数据的子关键字

			for (int j = 0; j < data.length; j++) {

				int subKey = (tmp[j] / rate) % radix;

				buckets[subKey]++;

			}

			for (int j = 1; j < radix; j++) {

				buckets[j] = buckets[j] + buckets[j - 1];

			}

			// 按子关键字对指定的数据进行排序

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
