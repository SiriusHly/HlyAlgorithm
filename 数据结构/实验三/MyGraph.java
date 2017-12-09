package ʵ����;

import java.util.Scanner;

/**
 * 
 * @author ������ time:2017.12.7 �ڽӾ���洢�ṹ
 * @param <AnyType>
 */
public class MyGraph<AnyType> {
	public final static int INFINITY = Integer.MAX_VALUE;
	private GraphKind kind;// ����
	private int vexNum, arcNum;// �������ͱ���
	private Object[] vexs;// ����
	private int[][] arcs;// �ڽӾ���
	Scanner in = new Scanner(System.in);

	public MyGraph() {
		this(null, 0, 0, null, null);
	}

	public MyGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][] arcs) {
		super();
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}

	// ����ͼ
	public void createGraph() {

		System.out.println("������ͼ������");
		GraphKind kind = GraphKind.valueOf(in.nextLine());
		switch (kind) {
		case UDG:
			createUDG();
			return;
		case DG:
			createDG();
			return;
		case UDN:
			createUDN();
			return;
		case DN:
			createDN();
			return;
		}

	}

	// ��������ͼ
	public void createUDG() {
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı���");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new Object[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�������");
		for (int v = 0; v < vexNum; v++)// ���춥������
			vexs[v] = in.next();
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		System.out.println("����������ߵ��������㼰��Ȩֵ");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());// �õ�������±�
			int u = locateVex(in.next());
			arcs[v][u] = arcs[u][v] = in.nextInt();
		}

	}

	// ��������ͼ
	public void createDG() {
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı���");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new Object[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�������");
		for (int v = 0; v < vexNum; v++)// ���춥������
			vexs[v] = in.next();
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		System.out.println("����������ߵ��������㼰��Ȩֵ");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());// �õ�������±�
			int u = locateVex(in.next());
			arcs[v][u] = in.nextInt();
		}
	}

	// ����������
	public void createUDN() {

	}

	// ����������
	public void createDN() {

	}

	// ���ض�����
	public int getVexNum() {
		return vexNum;
	}

	// ���ر���
	public int getarcNum() {
		return arcNum;
	}

	public void isValid_V(int v) throws Exception {
		if (v < 0 || v >= vexNum)
			throw new Exception("��" + v + "�����㲻����");
	}

	// ��������ֵvex��������ͼ�е�λ�ã����ͼ�в������˶��㣬����-1
	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].equals(vex))
				return v;
		return -1;
	}

	// ����v�Ľڵ��ֵ0<=v<vexNum
	public Object getVex(int v) throws Exception {
		isValid_V(v);
		return vexs[v];
	}

	// ���ص�һ���ڽӵ㣬��vû���ڽӵ��򷵻�-1������0<=v,w<vexNum;
	public int firstAdjVex(int v) throws Exception {// ��������v �Ͷ���w ֮�����һ���ߣ� ��ƶ���v
													// ��w ��Ϊ�ڽӵ㡣
		isValid_V(v);
		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;
		return -1;
	}

	// ����v�����w����һ���ڽӵ㣬��w��v�����һ���ڽӵ㣬�򷵻�-1������0<=v,w<vexNum

	public int nextAdjVex(int v, int w) throws Exception {
		isValid_V(v);
		;
		for (int j = w + 1; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)// arcx������ڽӾ��������v����ʱ�临�Ӷ���n
				return j;
		return -1;
	}

	public GraphKind getKind() {
		return kind;
	}

	public int[][] getArcs() {
		return arcs;
	}

	public Object[] getVexs() {
		return vexs;
	}

	// ��ĳ����Ķ�
	public int getDegree(Object v) throws Exception {
		int k = 0, s = 0;
		k = locateVex(v);
		for (int w = firstAdjVex(k); w >= 0; w = nextAdjVex(k, w)) // ����
			s++;
		//���
		for (Object i : vexs) {
			int u = locateVex(i);
			for (int w = firstAdjVex(u); w >= 0; w = nextAdjVex(u, w))
				if (vexs[w].equals(v))
					s++;
		}
		return s;

	}

	public static void main(String[] args) throws Exception {
		/**
		 * v1 v2 v3 v4 v1 v2 1 v2 v3 1 v2 v4 1 v3 v4 1
		 */
		MyGraph<String> s = new MyGraph<String>();
		Scanner in = new Scanner(System.in);
		s.createGraph();
		System.out.println("�������");
		System.out.println(s.firstAdjVex(1));
		System.out.println(s.nextAdjVex(1, 2));
		//GraphTraverse.BFSTraverse(s);
		System.out.println();
		//GraphTraverse.DFSTraverse(s);
		System.out.println("������Ҫ���ҵ�ĳ����Ķ�");
		while (in.hasNext()) {
			String k = in.next();
			System.out.println(s.getDegree(k));
		}

	}

}
