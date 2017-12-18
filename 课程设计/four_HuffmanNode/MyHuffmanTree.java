package four_HuffmanNode;

import java.util.Scanner;

/*
 * author:黄良运
 * time:12.15
 * 哈夫曼树
 */
public class MyHuffmanTree<AnyType extends Comparable<? super AnyType>> {
	HuffmanNode<AnyType> root = null;
	public MyHuffmanTree() {
		root = null;
	}

	static class HuffmanNode<AnyType> {
		public int weight;
		public int flag;
		public HuffmanNode<AnyType> parent, lchild, rchild;

		public HuffmanNode(int weight) {
			flag = 0;
			parent = lchild = rchild = null;
			this.weight = weight;
		}

		public HuffmanNode() {
			this(0);
		}
	}

	// 求Huffman编码的算法，w存放n个字符的权值
	public int[][] huffmanCoding(int[] W) {
		int n = W.length;// 字符的个数
		int m = 2 * n - 1;// 哈夫曼树的结点数
		HuffmanNode<AnyType>[] HN = new HuffmanNode[m];
		int i;
		for (i = 0; i < n; i++)
			HN[i] = new HuffmanNode<AnyType>(W[i]);// 构造n个具有权值的结点
		for (i = n; i < m; i++) {// 建Huffman树
			// 在HN[0..i-1]选择不在Huffman树中且weight最小的两个结点min1和min2
			HuffmanNode<AnyType> min1 = selectMin(HN, i - 1);
			min1.flag = 1;
			HuffmanNode<AnyType> min2 = selectMin(HN, i - 1);
			min2.flag = 1;
			// 构造min1和min2的父结点，并修改其父结点的权值
			HN[i] = new HuffmanNode<AnyType>();
			min1.parent = HN[i];
			min2.parent = HN[i];
			HN[i].lchild = min1;
			HN[i].rchild = min2;
			HN[i].weight = min1.weight + min2.weight;
			this.root = HN[i];
		}

		// 从叶子到根逆向求每个字符的Huffman编码
		int[][] HuffCode = new int[n][n];// 分配每个字符编码的存储空间
		for (int j = 0; j < n; j++) {
			int start = n - 1;// 编码的开始位置，初始化为数组的结尾
			for (HuffmanNode<AnyType> c = HN[j], p = c.parent; p != null; c = p, p = p.parent) {//	
				// System.out.println(p.weight);
				// 从叶子到根逆向求编码
				if (p.lchild.equals(c))
					HuffCode[j][start--] = 0;// 左孩子编码为0
				else
					HuffCode[j][start--] = 1;// 右孩子编码为1
				HuffCode[j][start] = -1;// 编码开始标志为-1，编码是-1之后的0,1
			}
		}
		return HuffCode;
	}

	// 在HN[0...i-1]选择不在Huffman树中且wight最小的结点
	private HuffmanNode<AnyType> selectMin(HuffmanNode<AnyType>[] HN, int end) {
		HuffmanNode<AnyType> min = HN[end];
		for (int i = 0; i <= end; i++) {
			HuffmanNode<AnyType> h = HN[i];
			if (h.flag == 0 && h.weight < min.weight)// 不在Huffman树中且权值最下的结点
				min = h;
		}
		return min;
	}
	
	//单独译码
	public int getTranslation(String str){
		HuffmanNode<AnyType> root = this.root;
		int i=0;
		while(i<str.length()){
			if(str.charAt(i++)=='0')
				root= root.lchild;
				///System.out.println(root.weight);
			else
				root= root.rchild;
				///System.out.println(root.weight);
		}
		return root.weight;
	}
	//全部译码
	public void getTranslate(int [][]HN){
		HuffmanNode<AnyType> root=this.root;
		for(int i =0;i<HN.length;i++){//行长度
			for(int j=0;j<HN[i].length;j++){//列长度
				if(HN[i][j]==-1){
					for(int k=j+1;k<HN[i].length;k++){
						if(HN[i][k]==0){
							root = root.lchild;
						}
						else{
							root = root.rchild;
						}
					}
					System.out.print(root.weight+" ");
				}
			}
			root = this.root;
		}
		
		
		
	}
	
	
	
	public static void main(String[] hly) {
		Scanner in = new Scanner(System.in);
		// int [] W = {23,11,5,3,29,14,7,8};//初始化权值
		int[] W = { 6, 30, 8, 9, 15, 24, 4, 12 };// 初始化权值
		MyHuffmanTree<String> T = new MyHuffmanTree<>();
		int[][] HN = T.huffmanCoding(W);// 求哈夫曼编码
		System.out.println("哈夫曼编码为:");
		for (int i = 0; i < HN.length; i++) {
			System.out.print(W[i] + " ");
			for (int j = 0; j < HN[i].length; j++) {
				if (HN[i][j] == -1) {
					for (int k = j + 1; k < HN[i].length; k++)
						System.out.print(HN[i][k]);
					break;
				}
			}
			System.out.println();
		}
		System.out.println("译码为:");
		T.getTranslate(HN);
		/*while(in.hasNext()){
			String str = in.next();
			System.out.println(T.getTranslation(str));
		}*/
		
	}

}
