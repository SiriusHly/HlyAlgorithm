package 实验三;

import java.util.Scanner;

/*
 * author :黄良运
 * time:2017.12.7
 * 邻接表存储结构
 */
public class ALGraph {
	private GraphKind kind;// 图的种类标志
	private int vexNum, arcNum;// 图的顶点和边数
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

	// 创建图
	public void createGraph() {
		System.out.println("请输入图的类型");
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
		System.out.println("请输入图的顶点数，图的边数");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各顶点");
		for (int v = 0; v < vexNum; v++)// 构造顶点向量
			vexs[v] = new VNode(in.next());
		System.out.println("请输入各边顶点及其权值");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());
			int u = locateVex(in.next());
			int value = in.nextInt();// 权值
			addArc(v, u, value);
			addArc(u, v, value);
		}
	}

	public void createDN() {
		System.out.println("请输入图的顶点数，图的边数");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("请分别输入图的各顶点");
		for (int v = 0; v < vexNum; v++)// 构造顶点向量
			vexs[v] = new VNode(in.next());
		System.out.println("请输入各边顶点及其权值");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());
			int u = locateVex(in.next());
			int value = in.nextInt();// 权值
			addArc(v, u, value);
		}
	}

	// 在顶点v，u之间添加一条弧，其权值为value
	public void addArc(int v, int u, int value) {// u该弧所指向的顶点位置，该顶点的位置
		ArcNode arc = new ArcNode(u, value);// v1 v2 1 v2 v3 1 v2 v4 1 v3 v4 1
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}

	public void isValid_V(int v) throws Exception {
		if (v < 0 || v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在");
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
		return vexs[index].data;// 节点数组的数据
	}

	public int firstAdjVex(int v) throws Exception {
		isValid_V(v);
		VNode vex = vexs[v];
		if (vex.firstArc != null)
			return vex.firstArc.adjVex;// 指向顶点1的位置
		else
			return -1;
	}

	// 查找下一个邻接点的方法
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
		// 入度
		for (ArcNode arc = v.firstArc; arc != null; arc = arc.nextArc)
			count++;
		// 出度
		for (VNode u : vexs)
			for (ArcNode arc = u.firstArc; arc != null; arc = arc.nextArc)
				if (vexs[arc.adjVex].equals(v))
					count++;
		return count;
	}

	// 图的邻接表存储结构表示中的顶点节点类
	public static class VNode {
		public Object data;// 顶点信息
		public ArcNode firstArc;// 指向第一条依附于该顶点的弧

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

	// 图中邻接表存储结构表示中的边节点类
	public static class ArcNode {
		public int adjVex;// 该弧指向顶点的位置
		public int value;// 边的权值
		private ArcNode nextArc;// 指向下一条弧

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
		 * v1 v2 v3 v4 v1 v2 1 v2 v4 1 v2 v3 1 v3 v4 1 //头插注意顺序
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
