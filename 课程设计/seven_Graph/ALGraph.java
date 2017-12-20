package seven_Graph;

import java.util.Scanner;

/*
 * author :������
 * time:2017.12.7
 * �ڽӱ�洢�ṹ
 */
public class ALGraph<AnyType extends Comparable<?super AnyType>> {
	private int vexNum, arcNum;// ͼ�Ķ���ͱ���
	private VNode<AnyType>[] vexs;
	
	public ALGraph(int vexNum, int arcNum, VNode<AnyType>[] vexs) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	public ALGraph() {
		this( 0, 0, null);
	}

	// �ڶ���v��u֮�����һ��������ȨֵΪvalue
	public void addArc(int v, int u, int value) {// u�û���ָ��Ķ���λ�ã��ö����λ��
		ArcNode<AnyType> arc = new ArcNode<AnyType>(u, value);// v1 v2 1 v2 v3 1 v2 v4 1 v3 v4 1
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}

	public void isValid_V(int v) throws Exception {
		if (v < 0 || v >= vexNum)
			throw new Exception("��" + v + "�����㲻����");
	}

	public int locateVex(AnyType vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].data.toString().compareTo(vex.toString())==0)
				return v;
		return -1;
	}

	public int getVexNum() {
		return vexNum;
	}

	public int getArcNum() {
		return arcNum;
	}

	public VNode<AnyType>[] getVexs() {
		return vexs;
	}

	public void setVexNum(int vexNum) {
		this.vexNum = vexNum;
	}

	public void setArcNum(int arcNum) {
		this.arcNum = arcNum;
	}

	public void setVexs(VNode<AnyType>[] vexs) {
		this.vexs = vexs;
	}

	public AnyType getVex(int index) throws Exception {
		isValid_V(index);
		return vexs[index].data;// �ڵ����������
	}

	public int firstAdjVex(int v) throws Exception {
		isValid_V(v);
		VNode<AnyType> vex = vexs[v];
		if (vex.firstArc != null)
			return vex.firstArc.adjVex;// ָ�򶥵�1��λ��
		else
			return -1;
	}

	// ������һ���ڽӵ�ķ���
	public int nextAdjVex(int v, int w) throws Exception {
		isValid_V(v);
		VNode<AnyType> vex = vexs[v];
		ArcNode<AnyType> arcvw = null;
		for (ArcNode<AnyType> arc = vex.firstArc; arc != null; arc = arc.nextArc) {
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

	public int getDegree(AnyType vex) {
		int i=locateVex(vex);
		VNode<AnyType> v = vexs[i];
		int count = 0;
		
		for (ArcNode<AnyType> arc = v.firstArc; arc != null; arc = arc.nextArc)
			count++;
		
		for (VNode<AnyType> u : vexs)
			for (ArcNode<AnyType> arc = u.firstArc; arc != null; arc = arc.nextArc)
				if (vexs[arc.adjVex].equals(v))//arc.adjVex��ָ�򶥵��λ��
					count++;
		return count;
	}

	// ͼ���ڽӱ�洢�ṹ��ʾ�еĶ���ڵ���
	public static class VNode<AnyType> {
		public AnyType data;// ������Ϣ
		public ArcNode<AnyType> firstArc;// ָ���һ�������ڸö���Ļ�

		public VNode() {
			this(null, null);
		}

		public VNode(AnyType data) {
			this(data, null);
		}

		public VNode(AnyType data, ArcNode<AnyType> firstArc) {
			this.data = data;
			this.firstArc = firstArc;
		}
	}

	// ͼ���ڽӱ�洢�ṹ��ʾ�еı߽ڵ���
	public static class ArcNode<AnyType> {
		public int adjVex;// �û�ָ�򶥵��λ��
		public int value;// �ߵ�Ȩֵ
		private ArcNode<AnyType> nextArc;// ָ����һ����

		public ArcNode() {
			this(-1, 0, null);
		}

		public ArcNode(int adjVex) {
			this(adjVex, 0);
		}

		public ArcNode(int adjVex, int value) {
			this(adjVex, value, null);
		}

		public ArcNode(int adjVex, int value, ArcNode<AnyType> nextArc) {
			super();
			this.adjVex = adjVex;
			this.value = value;
			this.nextArc = nextArc;
		}
	}
	public static void main(String[] y) throws Exception {
		Scanner in = new Scanner(System.in);
		ALGraph<String> alGraph = new ALGraph<String>();
		/**
		 * v1 v2 v3 v4 v1 v2 1 v2 v4 1 v2 v3 1 v3 v4 1 //ͷ��ע��˳��
		 * 1 2 3 4 1 2 1 2 4 1 2 3 1 3 4 1 
		 */
		System.out.println("������ͼ�Ķ�������ͼ�ı���");
		int vexNum = in.nextInt();
		int arcNum = in.nextInt();
		alGraph.setVexNum(vexNum);
		alGraph.setArcNum(arcNum);
		VNode<String>[] vexs = new VNode[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ�����");
		for (int v = 0; v < vexNum; v++)// ���춥������
			vexs[v] = new VNode<String>(in.next());
		alGraph.setVexs(vexs);
		System.out.println("��������߶��㼰��Ȩֵ");
		for (int k = 0; k < arcNum; k++) {
			int v = alGraph.locateVex(in.next());
			int u = alGraph.locateVex(in.next());
			int value = in.nextInt();// Ȩֵ
			alGraph.addArc(v, u, value);
		}
		
		System.out.println(alGraph.firstAdjVex(2));
		System.out.println(alGraph.nextAdjVex(1, 2));
		System.out.println();
		System.out.println("������Ҫ���ҵĽ��");
		while (in.hasNext()) {// 0 1;1 3;2 2;3 2
			String v = in.next(); 
			//Character c = v.charAt(0);
			System.out.println(alGraph.getDegree(v)+"��");

		}
	}
	
}
