package Test;

/**
 * author:黄良运
 * time:17.12.22
 * 哈夫曼树
 */
import java.util.*;

public class MyHuffman {
	public static HuffmanTree T = null;

	public String coding(String str) {
		ArrayList<HuffmanNode> leaf = new ArrayList<HuffmanNode>();
		T = build(str, leaf);
		// System.out.println("lead"+leaf.size());
		ArrayList<Codes> Code = code(leaf);
		String allCode = "";
		for(Codes c:Code)
			allCode+=c.getHuffmcode();
		return allCode;
	}

	public String decoing(String str) {
		char c[] = str.toCharArray();
		String strdecode = "";
		for (int ch = 0; ch < c.length;) {
			HuffmanNode p = T.root;
			while (p.lchild != null && p.rchild != null) {
				if (c[ch] == '0') {
					p = p.lchild;
					ch++;
				} else {
					p = p.rchild;
					ch++;
				}
			}
			strdecode += p.data;
			// System.out.println(p.str);
		}
		return strdecode;

	}

	public HuffmanTree build(String str, ArrayList<HuffmanNode> leaf) {
		ArrayList<Codes> weight = weight(str.toCharArray());
		//System.out.println("size"+weight.size());
		for(Codes c:weight){
			System.out.println(c.getLetter()+"个数:"+c.getHuffmweight());
		}
		LinkedList<HuffmanNode> l = new LinkedList<>();

		for (Codes c : weight) {
			HuffmanNode n = new HuffmanNode();
			n.setData(c.getLetter());
			n.setWeight(c.getHuffmweight());
			leaf.add(n);
			l.add(n);
		}

		while (l.size() > 1) {
			HuffmanNode p1 = selectMin(l);
			l.remove(p1);
			// System.out.println(l.size());
			HuffmanNode p2 = selectMin(l);
			l.remove(p2);
			HuffmanNode newNode = new HuffmanNode();
			newNode.setData(p1.getData() + p2.getData());
			newNode.setWeight(p1.getWeight() + p2.getWeight());
			newNode.setLchild(p1);
			newNode.setRchild(p2);
			p1.setParent(newNode);
			p2.setParent(newNode);
			l.add(newNode);
		}
		HuffmanTree t = new HuffmanTree();
		t.setRoot(l.poll());
		return t;

	}

	public HuffmanNode selectMin(LinkedList<HuffmanNode> L) {
		int min = L.get(0).getWeight();
		HuffmanNode p = L.get(0);
		for (int i = 0; i < L.size(); i++) {
			if (min > L.get(i).getWeight()) {
				min = L.get(i).getWeight();
				p = L.get(i);
			}
		}
		return p;
	}

	public ArrayList<Codes> code(ArrayList<HuffmanNode> leaf){
		//System.out.println("leaf:"+leaf.size());
		ArrayList<Codes> code = new ArrayList<>();
		for(HuffmanNode p: leaf){
			Character c = p.getData().charAt(0);
			//System.out.println("leafc"+c);
			String strCode ="";
			HuffmanNode cuNode = p;
			while(cuNode.parent!=null){
				if(cuNode.islchild()){
					strCode+="0";
				}
				else{
					strCode+="1";
				}
				cuNode = cuNode.parent;
			}
			strCode = new StringBuffer(strCode).reverse().toString();
			code.add(new Codes("c",strCode));
			System.out.println(c + ":" + strCode);
		}
		return code;
	}

	
	
	public ArrayList<Codes> weight(char []Arr){
		ArrayList<Codes> arrlist = new ArrayList<Codes>();
		arrlist.add(new Codes(String.valueOf(Arr[0]),1));
		for(int c = 1;c<Arr.length;c++){
			//System.out.println("arrsize"+arrlist.size());
			int s = arrlist.size();
			for(int i=0;i<s;i++){
				if(arrlist.get(i).getLetter().equals(String.valueOf(Arr[c]))){
					//System.out.println("=="+Arr[c]);
					arrlist.get(i).setHuffmweight(arrlist.get(i).getHuffmweight()+1);
					break;
				}
				else{
					arrlist.add(new Codes(String.valueOf(Arr[c]),1));
					break;
				}
			}
			
		}
		
		/*for(Codes i:arrlist)
			System.out.println("统计个数："+i.getLetter()+" "+i.getHuffmweight());*/
		return arrlist;
	}

	public void levelOrder(HuffmanTree t) {
		HuffmanNode p = null;
		Queue<HuffmanNode> queue = new LinkedList<>();
		if (t != null) {
			queue.offer(t.root);
			while (!queue.isEmpty()) {
				p = queue.poll();
				System.out.print(p.data + " ");
				if (p.lchild != null)
					queue.offer(p.lchild);
				if (p.rchild != null)
					queue.offer(p.rchild);
			}
		}
	}

	public void inOrder(HuffmanNode t) {
		if (t != null) {
			inOrder(t.lchild);
			System.out.print(t.data + " ");
			inOrder(t.rchild);
		}
	}

	public static void main(String[] arvs) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入一段字符");
		String str = in.next();
		MyHuffman myHuffman = new MyHuffman();
		String strcode = myHuffman.coding(str);
		System.out.println("哈夫曼编码为:" + strcode);
		System.out.println("哈夫曼译码为:" + myHuffman.decoing(strcode));
		System.out.println("层次遍历:");
		myHuffman.levelOrder(myHuffman.T);
		System.out.println();
		System.out.println("中序遍历");
		myHuffman.inOrder(myHuffman.T.root);
	}

	static class Codes{
		private String letter;
		private String huffmcode;
		private int huffmweight;
		public Codes(String letter, String huffmcode, int huffmweight) {
			this.letter = letter;
			this.huffmcode = huffmcode;
			this.huffmweight = huffmweight;
		}
		
		public Codes(String letter, String huffmcode) {
			this.letter = letter;
			this.huffmcode = huffmcode;
		}

		public Codes(String letter, int huffmweight) {
			this.letter = letter;
			this.huffmweight = huffmweight;
		}

		public String getLetter() {
			return letter;
		}
		public void setLetter(String letter) {
			this.letter = letter;
		}
		public String getHuffmcode() {
			return huffmcode;
		}
		public void setHuffmcode(String huffmcode) {
			this.huffmcode = huffmcode;
		}
		public int getHuffmweight() {
			return huffmweight;
		}
		public void setHuffmweight(int huffmweight) {
			this.huffmweight = huffmweight;
		}
		
		
	}
	
	static class HuffmanTree {
		private HuffmanNode root;

		public HuffmanNode getRoot() {
			return root;
		}

		public void setRoot(HuffmanNode root) {
			this.root = root;
		}

	}

	static class HuffmanNode {

		private String data = "";
		private int weight = 0;
		private HuffmanNode parent;
		private HuffmanNode lchild;
		private HuffmanNode rchild;

		public String getData() {
			return data;
		}

		public void setData(String str) {
			this.data = str;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public void setParent(HuffmanNode parent) {
			this.parent = parent;
		}

		public void setLchild(HuffmanNode lchild) {
			this.lchild = lchild;
		}

		public void setRchild(HuffmanNode rchild) {
			this.rchild = rchild;
		}
		public boolean isParent() {
			return parent == null;
		}

		public boolean islchild() {
			return parent != null && this == parent.lchild;
		}

		public boolean isrchild() {
			return parent != null && this == parent.rchild;
		}

	}

}
