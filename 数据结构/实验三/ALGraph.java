package ʵ����;

import java.util.Scanner;

/*
 * author :������
 * time:2017.12.7
 * �ڽӱ�洢�ṹ
 */
public class ALGraph {
	private GraphKind kind;// ͼ�������־
	private int vexNum, arcNum;// ͼ�Ķ���ͱ���
	private VNode[] vexs;
	Scanner in = new Scanner(System.in);

	public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs) {
		super();
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	public ALGraph() {
		this(null, 0, 0, null);
	}

	// ����ͼ
	public void createGraph() {
		System.out.println("������ͼ������");
		GraphKind kind = GraphKind.valueOf(in.next());
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

	public void createUDG() {

	}

	public void createDG() {

	}

	public void createUDN() {
		System.out.println("������ͼ�Ķ�������ͼ�ı���");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�����");
		for (int v = 0; v < vexNum; v++)// ���춥������
			vexs[v] = new VNode(in.next());
		System.out.println("��������߶��㼰��Ȩֵ");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());
			int u = locateVex(in.next());
			int value = in.nextInt();// Ȩֵ
			addArc(v, u, value);
			addArc(u, v, value);
		}
	}

	public void createDN() {
		System.out.println("������ͼ�Ķ�������ͼ�ı���");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�����");
		for (int v = 0; v < vexNum; v++)// ���춥������
			vexs[v] = new VNode(in.next());
		System.out.println("��������߶��㼰��Ȩֵ");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());
			int u = locateVex(in.next());
			int value = in.nextInt();// Ȩֵ
			addArc(v, u, value);
		}
	}

	// �ڶ���v��u֮�����һ��������ȨֵΪvalue
	public void addArc(int v, int u, int value) {// u�û���ָ��Ķ���λ�ã��ö����λ��
		ArcNode arc = new ArcNode(u, value);// v1 v2 1 v2 v3 1 v2 v4 1 v3 v4 1
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}

	public void isValid_V(int v) throws Exception {
		if (v < 0 || v >= vexNum)
			throw new Exception("��" + v + "�����㲻����");
	}

	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].data.equals(vex))
				return v;
		return -1;
	}

	public int getVexNum() {
		return vexNum;
	}

	public int getArcNum() {
		return arcNum;
	}

	public VNode[] getVexs() {
		return vexs;
	}

	public GraphKind getKind() {
		return kind;
	}

	public Object getVex(int index) throws Exception {
		isValid_V(index);
		return vexs[index].data;// �ڵ����������
	}

	public int firstAdjVex(int v) throws Exception {
		isValid_V(v);
		VNode vex = vexs[v];
		if (vex.firstArc != null)
			return vex.firstArc.adjVex;// ָ�򶥵�1��λ��
		else
			return -1;
	}

	// ������һ���ڽӵ�ķ���
	public int nextAdjVex(int v, int w) throws Exception {
		isValid_V(v);
		VNode vex = vexs[v];
		ArcNode arcvw = null;
		for (ArcNode arc = vex.firstArc; arc != null; arc = arc.nextArc) {
			if (arc.adjVex == w) {
				arcvw = arc;
				break;
			}
		}
		if (arcvw != null && arcvw.nextArc != null)
			return arcvw.nextArc.adjVex;
		else
			return -1;

	}

	public int getDegree(int i) {
		VNode v = vexs[i];
		int count = 0;
		// ���
		for (ArcNode arc = v.firstArc; arc != null; arc = arc.nextArc)
			count++;
		// ����
		for (VNode u : vexs)
			for (ArcNode arc = u.firstArc; arc != null; arc = arc.nextArc)
				if (vexs[arc.adjVex].equals(v))
					count++;
		return count;
	}

	// ͼ���ڽӱ�洢�ṹ��ʾ�еĶ���ڵ���
	public static class VNode {
		public Object data;// ������Ϣ
		public ArcNode firstArc;// ָ���һ�������ڸö���Ļ�

		public VNode() {
			this(null, null);
		}

		public VNode(Object data) {
			this(data, null);
		}

		public VNode(Object data, ArcNode firstArc) {
			this.data = data;
			this.firstArc = firstArc;
		}
	}

	// ͼ���ڽӱ�洢�ṹ��ʾ�еı߽ڵ���
	public static class ArcNode {
		public int adjVex;// �û�ָ�򶥵��λ��
		public int value;// �ߵ�Ȩֵ
		private ArcNode nextArc;// ָ����һ����

		public ArcNode() {
			this(-1, 0, null);
		}

		public ArcNode(int adjVex) {
			this(adjVex, 0);
		}

		public ArcNode(int adjVex, int value) {
			this(adjVex, value, null);
		}

		public ArcNode(int adjVex, int value, ArcNode nextArc) {
			super();
			this.adjVex = adjVex;
			this.value = value;
			this.nextArc = nextArc;
		}
	}

	public static void main(String[] y) throws Exception {
		/**
		 * v1 v2 v3 v4 v1 v2 1 v2 v4 1 v2 v3 1 v3 v4 1 //ͷ��ע��˳��
		 */
		Scanner in = new Scanner(System.in);
		ALGraph S = new ALGraph();
		S.createGraph();
		System.out.println(S.firstAdjVex(2));
		System.out.println(S.nextAdjVex(1, 2));
		GraphTraverse.BFSTraverse(S);
		System.out.println();
		GraphTraverse.DFSTraverse(S);
		while (in.hasNext()) {// 0 1;1 3;2 2;3 2
			int v = in.nextInt();
			System.out.println(S.getDegree(v));

		}
	}
}
