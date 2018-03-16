package seven_Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * author :������
 * time:2017.12.7
 * �ڽӱ�洢�ṹ
 */
public class ALGraph<AnyType extends Comparable<? super AnyType>> {
	private int vexNum, arcNum;// ͼ�Ķ���ͱ���
	private VNode<AnyType>[] vexs;
	static boolean visit[];

	public ALGraph(int vexNum, int arcNum, VNode<AnyType>[] vexs) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	public ALGraph() {
		this(0, 0, null);
	}

	// �ڶ���v��u֮�����һ��������ȨֵΪvalue
	public void addArc(int v, int u, int value) {// u�û���ָ��Ķ���λ�ã��ö����λ��
		ArcNode<AnyType> arc = new ArcNode<AnyType>(u, value);// v1 v2 1 v2 v3 1
																// v2 v4 1 v3 v4
																// 1
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}

	// ɾ��һ����
	public void deleteArc(AnyType v1, AnyType v2) throws Exception {
		int v = locateVex(v1);
		int u = locateVex(v2);
		// System.out.println(v+" "+u);
		VNode<AnyType> vex = vexs[v];
		for (ArcNode<AnyType> arc = vex.firstArc; arc != null; arc = arc.nextArc)
			if (vexs[arc.adjVex].equals(vexs[u])) {
				System.out.println("de" + vexs[u].data);
				arc = arc.nextArc;
			}
	}

	public void isValid_V(int v) throws Exception {
		if (v < 0 || v >= vexNum)
			throw new Exception("��" + v + "�����㲻����");
	}

	public int locateVex(AnyType vex) throws Exception {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].data.toString().compareTo(vex.toString()) == 0)
				return v;
		throw new Exception(vex + "������㲻����");
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

	public int getDegree(AnyType vex) throws Exception {
		int i = locateVex(vex);
		VNode<AnyType> v = vexs[i];
		int count = 0;

		for (ArcNode<AnyType> arc = v.firstArc; arc != null; arc = arc.nextArc)
			count++;

		for (VNode<AnyType> u : vexs)
			for (ArcNode<AnyType> arc = u.firstArc; arc != null; arc = arc.nextArc)
				if (vexs[arc.adjVex].equals(v))// arc.adjVex��ָ�򶥵��λ��
					count++;
		return count;
	}

	// ���Ӷ���
	public boolean addVex(AnyType vex) {
		vexs[vexNum] = new VNode<AnyType>(vex);
		vexs[vexNum].firstArc = null;
		vexNum++;
		return true;
	}

	// ɾ������
	public boolean deleteVex(AnyType vex) throws Exception {
		int i = locateVex(vex);// ���ݵ�vexs.data�±�
		VNode<AnyType> v = vexs[i];// �õ��ڵ��λ��
		
		for (VNode<AnyType> u : vexs)
			for (ArcNode<AnyType> arc = u.firstArc; arc != null; arc = arc.nextArc)
				if (vexs[arc.adjVex].equals(v)) {
					System.out.println("de" + vex);
					arc.nextArc = arc.nextArc.nextArc;
				}

		for (int j = i; j < vexNum - 1; j++)
			vexs[j] = vexs[j + 1];
		vexNum--;

		return true;
	}

	
	public void connectDFS(ALGraph<AnyType> G, int v) throws Exception {
		visit[v] = true;
		for (int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w)) {
			if (!visit[w])
				connectDFS(G, w);
		}
	}

	public int connect(ALGraph<AnyType> G) throws Exception {
		visit = new boolean[G.getVexNum()];
		for (boolean i : visit)
			i = false;
		int count = 0;
		for (int i = 0; i < G.getVexNum(); i++) {
			if (!visit[i]) {
				count++;
				connectDFS(G, i);
			}
		}
		return count;
	}
	
	public boolean pathDFS(ALGraph<AnyType> G, AnyType A, AnyType B) throws Exception {
		int v = locateVex(A);
		int u = locateVex(B);
		visit = new boolean[G.getVexNum()];
		for (boolean i : visit)
			i = false;
		connectDFS(G, v);
		if (visit[v] == visit[u] == true) {
			return true;
		}
		return false;
	}
	
	
		public int[] pathBFS(ALGraph<AnyType> G,AnyType A,AnyType B) throws Exception{
			int parent [] = new int [G.getVexNum()];
			int v = locateVex(A);
			int u = locateVex(B);
			boolean flag =false;
			/*visit = new boolean[G.getVexNum()];
			Arrays.fill(visit, false);*/
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(v);
			while(!queue.isEmpty()&&!flag){
				int i = queue.poll();
				for(int w = G.firstAdjVex(i);w>=0;w = G.nextAdjVex(i, w)){
					if(u ==w){
						parent[w] =i;
						flag = true;
						break;	
					}
					else
					parent[w] = i;
					queue.offer(w);
				}	
			}
			return parent;
		}

	// ͼ���ڽӱ�洢�ṹ��ʾ�еı߽ڵ���
	public static class ArcNode<AnyType> {
		public int adjVex;// �û�ָ�򶥵��λ��
		public int value;// �ߵ�Ȩֵ
		private ArcNode<AnyType> nextArc = null;// ָ����һ����

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

	public static void main(String[] y) throws Exception {
		Scanner in = new Scanner(System.in);
		ALGraph<String> alGraph = new ALGraph<String>();
		/**
		 * v1 v2 v3 v4 v1 v2 1 v2 v4 1 v2 v3 1 v3 v4 1 //ͷ��ע��˳�� 1 2 3 4 1 2 1 2
		 * 4 1 2 3 1 3 4 1
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
		// alGraph.deleteVex("v3");
		// alGraph.deleteVex("v2");
		// alGraph.addVex("v5");
		// alGraph.deleteArc("v2","v4");
		
		System.out.println("��ͼ����ͨ��������Ϊ:" + alGraph.connect(alGraph) + "��");
		
		System.out.println(alGraph.pathDFS(alGraph, "v1", "v2"));
		System.out.println(alGraph.pathDFS(alGraph, "v2", "v3"));
		
				System.out.println("��·��Ϊ:");
				int parent [] = alGraph.pathBFS(alGraph, "v1", "v4");
				int v = alGraph.locateVex("v1");
				int u = alGraph.locateVex("v4");
				int i =u;
				System.out.print("v4");
				while(i!=v){
					System.out.print("->");
					System.out.print(vexs[parent[i]].data);
					i = parent[i];
				}
				System.out.println();
		System.out.println("������Ҫ���ҵĽ��");
		while (in.hasNext()) {
			String s = in.next();
			// Character c = v.charAt(0);
			System.out.println(alGraph.getDegree(s) + "��");

		}
	}

}
