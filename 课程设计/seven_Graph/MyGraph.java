package seven_Graph;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import seven_Graph.ALGraph.VNode;

/**
 * 
 * @author ������ time:2017.12.7 �ڽӾ���洢�ṹ
 * @param <AnyType>
 *            1.����Ķ� 2.���ӣ�ɾ���� 3.���ӣ�ɾ������4.�洢�ṹ��ת��
 */
public class MyGraph<AnyType extends Comparable<? super AnyType>> {

	public final static int INFINITY = Integer.MAX_VALUE;
	private int vexNum, arcNum;// �������ͱ���
	private AnyType[] vexs;// ����
	private int[][] arcs;// �ڽӾ���

	public MyGraph() {
		this(0, 0, null, null);
	}

	public MyGraph(int vexNum, int arcNum, AnyType[] vexs, int[][] arcs) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}

	public void setVexNum(int vexNum) {
		this.vexNum = vexNum;
	}

	public void setArcNum(int arcNum) {
		this.arcNum = arcNum;
	}

	public void setVexs(AnyType[] vexs) {
		this.vexs = vexs;
	}

	public void setArcs(int[][] arcs) {
		this.arcs = arcs;
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
	public int locateVex(AnyType vex) throws Exception {
		for (int v = 0; v < vexNum; v++) {
			// System.out.println("vex"+vexs[v]);
			if (vexs[v].toString().equals(vex.toString()))
				return v;
		}
		throw new Exception(vex + "������㲻����");
	}

	// ����v�Ľڵ��ֵ0<=v<vexNum
	public AnyType getVex(int v) throws Exception {
		isValid_V(v);
		return vexs[v];
	}

	// ���ص�һ���ڽӵ㣬��vû���ڽӵ��򷵻�-1������0<=v,w<vexNum;
	public int firstAdjVex(int v) throws Exception {// ��������v �Ͷ���w ֮�����һ���ߣ� ��ƶ���v
													// // ��w ��Ϊ�ڽӵ㡣
		isValid_V(v);
		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;
		return -1;
	}

	// ����v�����w����һ���ڽӵ㣬��w��v�����һ���ڽӵ㣬�򷵻�-1������0<=v,w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		isValid_V(v);
		for (int j = w + 1; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)// arcx������ڽӾ��������v����ʱ�临�Ӷ���n
				return j;
		return -1;
	}

	// ��ĳ����Ķ�
	/*
	 * public int getDegree(AnyType v) throws Exception { int k = 0, s = 0; k =
	 * locateVex(v); for (int w = firstAdjVex(k); w >= 0; w = nextAdjVex(k, w))
	 * // ���� s++; // ��� for (AnyType i : vexs) { int u = locateVex(i); for (int
	 * w = firstAdjVex(u); w >= 0; w = nextAdjVex(u, w)) if
	 * (vexs[w].toString().compareTo(v.toString()) == 0) s++; } return s; }
	 */

	// ��vex1��vex2֮������һ����
	public boolean addArc(AnyType vex1, AnyType vex2, int weight) throws Exception {
		int v = locateVex(vex1);
		int u = locateVex(vex2);
		arcs[v][u] = weight;
		return true;
	}

	// ɾ����arcsҲҪ�ı�
	public boolean deleteArc(AnyType vex1, AnyType vex2) throws Exception {
		int v = locateVex(vex1);
		int u = locateVex(vex2);
		arcs[v][u] = INFINITY;
		return true;
	}

	// ���Ӷ���
	public boolean addVex(AnyType vex) {
		vexs[vexNum] = vex;
		vexNum++;

		return true;
	}

	// ɾ������ǳ��鷳������һ����鷳
	public boolean deleteVex(AnyType vex) throws Exception {
		int k = 0;
		int arcs2 [][] = new int [vexNum-1][vexNum-1];
		ArrayList<Integer> li = new ArrayList<Integer>();
		int v = locateVex(vex);
		for (int i = v; i < vexNum - 1; i++)
			vexs[i] = vexs[i + 1];
		//
		// ��ɾ���Ķ�����ص�Ȩֵ����Ϊ0
		for (int j = 0; j < vexNum; j++)
			arcs[v][j] = INFINITY;
		for (int i = 0; i < vexNum; i++)
			arcs[i][v] = INFINITY;
		// arcsǰ��
		for (int i = 0; i < vexNum ; i++)
			for (int j = 0; j < vexNum ; j++)
				if(i!=v||j!=v)
				li.add(arcs[i][j]);
		for(int i=0;i<vexNum-1;i++)
			for(int j=0;j<vexNum-1;j++)
				arcs2[i][j] = li.get(k++);
		this.arcs = arcs2;
		vexNum--;
		return true;
	}

	// �󶥵�Ķ�
	public int getDegree(AnyType vex) throws Exception {
		int degreeCount = 0;
		int v = locateVex(vex);
		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] < INFINITY)
				degreeCount++;
		for (int i = 0; i < vexNum; i++)
			if (arcs[i][v] < INFINITY)
				degreeCount++;
		return degreeCount;
	}

	// �ڽӾ���ת��Ϊ�ڽӱ�
	public ALGraph<AnyType> AmToAl() {
		
		ALGraph<AnyType> alGraph = new ALGraph<AnyType>();
		alGraph.setVexNum(vexNum);
		alGraph.setArcNum(arcNum);
		VNode<AnyType>[] vexs = new VNode[vexNum];
		for (int v = 0; v < vexNum; v++) {// ���춥������
			vexs[v] = new VNode<AnyType>(this.vexs[v]);
			System.out.print(vexs[v].data + " ");
		}
		alGraph.setVexs(vexs);
		for (int k = 0; k < vexNum; k++)
			for (int l = vexNum - 1; l >= 0; l--)// �������㶮��
				if (arcs[k][l] < INFINITY) {
					System.out.println(arcs[k][l]);
					alGraph.addArc(k, l, arcs[k][l]);
				}

		return alGraph;
	}

	/**
	 * v1 v2 v3 v4 v1 v2 1 v2 v4 1 v2 v3 1 v3 v4 1 //ͷ��ע��˳�� 1 2 3 4 1 2 1 2 4 1
	 * 2 3 1 3 4 1
	 */
	

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		/**
		 * v1 v2 v3 v4 v1 v2 1 v2 v3 1 v2 v4 1 v3 v4 1 1 2 3 4 1 2 1 2 3 1 2 4 1
		 * 3 4 1
		 */
		MyGraph<String> myGraph = new MyGraph<String>();
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı���");
		int vexNum = in.nextInt();
		int arcNum = in.nextInt();
		myGraph.setVexNum(vexNum);
		myGraph.setArcNum(arcNum);
		String[] vexs = new String[5];
		System.out.println("��ֱ�����ͼ�ĸ�������");
		for (int v = 0; v < vexNum; v++)// ���춥������
			vexs[v] = in.next();
		myGraph.setVexs(vexs);
		int[][] arcs = new int[5][5];
		for (int v = 0; v < 5; v++)
			for (int u = 0; u < 5; u++)
				arcs[v][u] = INFINITY;
		System.out.println("����������ߵ��������㼰��Ȩֵ");
		for (int k = 0; k < arcNum; k++) {
			int v = myGraph.locateVex(in.next());// �õ�������±�
			int u = myGraph.locateVex(in.next());
			arcs[v][u] = in.nextInt();
			// arcs[u][v] = arcs[v][u] = in.nextInt();
		}
		myGraph.setArcs(arcs);
		System.out.println("�������");
		System.out.println(myGraph.firstAdjVex(1));
		System.out.println(myGraph.nextAdjVex(1, 2));
		//myGraph.addArc("v1", "v3", 1);
		//myGraph.deleteArc("v2", "v3");
		myGraph.addVex("v5");
		myGraph.addArc("v1", "v5", 1);
		myGraph.deleteVex("v4");
		System.out.println("�ı����");
		// GraphTraverse.BFSTraverse(s);
		System.out.println();

		System.out.println("AmToAl��Եĵ�һ���ڽӵ�" + myGraph.AmToAl().firstAdjVex(0));
		// GraphTraverse.DFSTraverse(s);
		System.out.println("������Ҫ���ҵĽ����");
		while (in.hasNext()) {// int k = in.nextInt();
			String k = in.next();
			System.out.println(myGraph.getDegree(k) + "��");
		}

	}

}
