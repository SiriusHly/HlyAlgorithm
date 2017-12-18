package four_HuffmanNode;

import java.util.Scanner;

/*
 * author:������
 * time:12.15
 * ��������
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

	// ��Huffman������㷨��w���n���ַ���Ȩֵ
	public int[][] huffmanCoding(int[] W) {
		int n = W.length;// �ַ��ĸ���
		int m = 2 * n - 1;// ���������Ľ����
		HuffmanNode<AnyType>[] HN = new HuffmanNode[m];
		int i;
		for (i = 0; i < n; i++)
			HN[i] = new HuffmanNode<AnyType>(W[i]);// ����n������Ȩֵ�Ľ��
		for (i = n; i < m; i++) {// ��Huffman��
			// ��HN[0..i-1]ѡ����Huffman������weight��С���������min1��min2
			HuffmanNode<AnyType> min1 = selectMin(HN, i - 1);
			min1.flag = 1;
			HuffmanNode<AnyType> min2 = selectMin(HN, i - 1);
			min2.flag = 1;
			// ����min1��min2�ĸ���㣬���޸��丸����Ȩֵ
			HN[i] = new HuffmanNode<AnyType>();
			min1.parent = HN[i];
			min2.parent = HN[i];
			HN[i].lchild = min1;
			HN[i].rchild = min2;
			HN[i].weight = min1.weight + min2.weight;
			this.root = HN[i];
		}

		// ��Ҷ�ӵ���������ÿ���ַ���Huffman����
		int[][] HuffCode = new int[n][n];// ����ÿ���ַ�����Ĵ洢�ռ�
		for (int j = 0; j < n; j++) {
			int start = n - 1;// ����Ŀ�ʼλ�ã���ʼ��Ϊ����Ľ�β
			for (HuffmanNode<AnyType> c = HN[j], p = c.parent; p != null; c = p, p = p.parent) {//	
				// System.out.println(p.weight);
				// ��Ҷ�ӵ������������
				if (p.lchild.equals(c))
					HuffCode[j][start--] = 0;// ���ӱ���Ϊ0
				else
					HuffCode[j][start--] = 1;// �Һ��ӱ���Ϊ1
				HuffCode[j][start] = -1;// ���뿪ʼ��־Ϊ-1��������-1֮���0,1
			}
		}
		return HuffCode;
	}

	// ��HN[0...i-1]ѡ����Huffman������wight��С�Ľ��
	private HuffmanNode<AnyType> selectMin(HuffmanNode<AnyType>[] HN, int end) {
		HuffmanNode<AnyType> min = HN[end];
		for (int i = 0; i <= end; i++) {
			HuffmanNode<AnyType> h = HN[i];
			if (h.flag == 0 && h.weight < min.weight)// ����Huffman������Ȩֵ���µĽ��
				min = h;
		}
		return min;
	}
	
	//��������
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
	//ȫ������
	public void getTranslate(int [][]HN){
		HuffmanNode<AnyType> root=this.root;
		for(int i =0;i<HN.length;i++){//�г���
			for(int j=0;j<HN[i].length;j++){//�г���
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
		// int [] W = {23,11,5,3,29,14,7,8};//��ʼ��Ȩֵ
		int[] W = { 6, 30, 8, 9, 15, 24, 4, 12 };// ��ʼ��Ȩֵ
		MyHuffmanTree<String> T = new MyHuffmanTree<>();
		int[][] HN = T.huffmanCoding(W);// �����������
		System.out.println("����������Ϊ:");
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
		System.out.println("����Ϊ:");
		T.getTranslate(HN);
		/*while(in.hasNext()){
			String str = in.next();
			System.out.println(T.getTranslation(str));
		}*/
		
	}

}
