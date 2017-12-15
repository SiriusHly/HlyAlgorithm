package ʵ����;

import java.util.Scanner;

/**
 * 
 * @author ������ time:2017.12.7 �ڽӾ���洢�ṹ
 * @param <AnyType>
 */
public class MyGraph<AnyType extends Comparable<?super AnyType>> {
	
	public final static int INFINITY = Integer.MAX_VALUE;
	private int vexNum, arcNum;// �������ͱ���
	private AnyType[] vexs;// ����
	private int[][] arcs;// �ڽӾ���
	Scanner in = new Scanner(System.in);

	public MyGraph() {
		this(0, 0, null, null);
	}

	public MyGraph( int vexNum, int arcNum, AnyType[] vexs, int[][] arcs) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}

	// ��������ͼ
	public void createUDG() {
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı���");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = (AnyType[])new Object[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�������");
		for (int v = 0; v < vexNum; v++)// ���춥������
			vexs[v] = (AnyType)in.next();
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		System.out.println("����������ߵ��������㼰��Ȩֵ");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex((AnyType)in.next());// �õ�������±�
			int u = locateVex((AnyType)in.next());
			arcs[v][u] = arcs[u][v] = in.nextInt();
		}

	}

	// ��������ͼ
	public void createDG() {
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı���");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = (AnyType[]) new String[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�������");
		for (int v = 0; v < vexNum; v++)// ���춥������
			vexs[v] = (AnyType)in.next();
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		System.out.println("����������ߵ��������㼰��Ȩֵ");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex((AnyType)in.next());// �õ�������±�
			int u = locateVex((AnyType)in.next());
			arcs[v][u] = in.nextInt();
		}
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
	public int locateVex(AnyType vex) {
		for (int v = 0; v < vexNum; v++){
			//System.out.println("vex"+vexs[v]);
			if (vexs[v].toString().equals(vex.toString()))
		
				return v;
		}
		return -1;
	}

	// ����v�Ľڵ��ֵ0<=v<vexNum
	public AnyType getVex(int v) throws Exception {
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
		for (int j = w + 1; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)// arcx������ڽӾ��������v����ʱ�临�Ӷ���n
				return j;
		return -1;
	}

	// ��ĳ����Ķ�
	public int getDegree(AnyType v) throws Exception {
		int k = 0, s = 0;
		k = locateVex(v);
		for (int w = firstAdjVex(k); w >= 0; w = nextAdjVex(k, w)) // ����
			s++;
		//���
		for (AnyType i : vexs) {
			int u = locateVex(i);
			for (int w = firstAdjVex(u); w >= 0; w = nextAdjVex(u, w))
				if (vexs[w].toString().compareTo(v.toString())==0)
					s++;
					//System.out.println("to"+v.toString());		
		}
		return s;

	}
	

	public static void main(String[] args) throws Exception {
		/**
		 * v1 v2 v3 v4 v1 v2 1 v2 v3 1 v2 v4 1 v3 v4 1
		 * 1 2 3 4 1 2 1 2 3 1 2 4 1 3 4 1
		 */
		MyGraph<String> myGraph = new MyGraph<String>();
		Scanner in = new Scanner(System.in);
		myGraph.createDG();
		System.out.println("�������");
		System.out.println(myGraph.firstAdjVex(1));
		System.out.println(myGraph.nextAdjVex(1, 2));
		//GraphTraverse.BFSTraverse(s);
		System.out.println();
		//GraphTraverse.DFSTraverse(s);
		System.out.println("������Ҫ���ҵĽ����");
		while (in.hasNext()) {//int  k = in.nextInt();
			String k = in.next();
			System.out.println(myGraph.getDegree(k)+"��");
		}

	}



}
