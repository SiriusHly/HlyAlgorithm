package four_HuffmanNode;

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
		Map<Character, String> MapCode = code(leaf);
		String allCode = "";
		for (Character c : str.toCharArray()) {
			allCode += MapCode.get(c);
		}
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
		Map<Character, Integer> weight = weight(str.toCharArray());

		for (Character c : weight.keySet())
			System.out.println(c + "个数:" + weight.get(c));
		LinkedList<HuffmanNode> l = new LinkedList<>();

		for (Character c : weight.keySet()) {
			HuffmanNode n = new HuffmanNode();
			n.setData(c.toString());
			n.setWeight(weight.get(c));
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

	// 编码
	public Map<Character, String> code(ArrayList<HuffmanNode> leaf) {
		Map<Character, String> code = new HashMap<Character, String>();
		for (HuffmanNode p : leaf) {
			Character c = p.getData().charAt(0);
			String strCode = "";
			HuffmanNode cuNode = p;
			while (cuNode.parent != null) {
				if (cuNode.islchild()) {
					strCode += "0";
				} else {
					strCode += "1";
				}
				cuNode = cuNode.parent;
			}
			strCode = new StringBuffer(strCode).reverse().toString();
			code.put(c, strCode);
			System.out.println(c + ":" + strCode);

		}
		return code;
	}

	// 通过频率设置权重
	public Map<Character, Integer> weight(char[] Arr) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character c : Arr)
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		return map;
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
