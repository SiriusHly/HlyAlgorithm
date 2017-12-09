package 实验三;

import java.util.Scanner;

/**
 * 
 * @author 黄良运 time:2017.12.7 邻接矩阵存储结构
 * @param <AnyType>
 */
public class MyGraph<AnyType> {
	public final static int INFINITY = Integer.MAX_VALUE;
	private GraphKind kind;// 种类
	private int vexNum, arcNum;// 顶点数和边数
	private Object[] vexs;// 顶点
	private int[][] arcs;// 邻接矩阵
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

	// 创建图
	public void createGraph() {

		System.out.println("请输入图的类型");
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

	// 创建无向图
	public void createUDG() {
		System.out.println("请分别输入图的顶点数，图的边数");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个顶点");
		for (int v = 0; v < vexNum; v++)// 构造顶点向量
			vexs[v] = in.next();
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		System.out.println("请输入各个边的两个顶点及其权值");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());// 得到顶点的下标
			int u = locateVex(in.next());
			arcs[v][u] = arcs[u][v] = in.nextInt();
		}

	}

	// 创建有向图
	public void createDG() {
		System.out.println("请分别输入图的顶点数，图的边数");
		vexNum = in.nextInt();
		arcNum = in.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个顶点");
		for (int v = 0; v < vexNum; v++)// 构造顶点向量
			vexs[v] = in.next();
		arcs = new int[vexNum][vexNum];
		for (int v = 0; v < vexNum; v++)
			for (int u = 0; u < vexNum; u++)
				arcs[v][u] = INFINITY;
		System.out.println("请输入各个边的两个顶点及其权值");
		for (int k = 0; k < arcNum; k++) {
			int v = locateVex(in.next());// 得到顶点的下标
			int u = locateVex(in.next());
			arcs[v][u] = in.nextInt();
		}
	}

	// 创建无向网
	public void createUDN() {

	}

	// 创建有向网
	public void createDN() {

	}

	// 返回顶点数
	public int getVexNum() {
		return vexNum;
	}

	// 返回边数
	public int getarcNum() {
		return arcNum;
	}

	public void isValid_V(int v) throws Exception {
		if (v < 0 || v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在");
	}

	// 给定顶点值vex，返回在图中的位置，如果图中不包含此顶点，返回-1
	public int locateVex(Object vex) {
		for (int v = 0; v < vexNum; v++)
			if (vexs[v].equals(vex))
				return v;
		return -1;
	}

	// 返回v的节点的值0<=v<vexNum
	public Object getVex(int v) throws Exception {
		isValid_V(v);
		return vexs[v];
	}

	// 返回第一个邻接点，若v没有邻接点则返回-1，其中0<=v,w<vexNum;
	public int firstAdjVex(int v) throws Exception {// 假若顶点v 和顶点w 之间存在一条边， 则称顶点v
													// 和w 互为邻接点。
		isValid_V(v);
		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;
		return -1;
	}

	// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0<=v,w<vexNum

	public int nextAdjVex(int v, int w) throws Exception {
		isValid_V(v);
		;
		for (int j = w + 1; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)// arcx存的是邻接矩阵遍历第v，行时间复杂度是n
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

	// 求某个点的度
	public int getDegree(Object v) throws Exception {
		int k = 0, s = 0;
		k = locateVex(v);
		for (int w = firstAdjVex(k); w >= 0; w = nextAdjVex(k, w)) // 出度
			s++;
		//入度
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
		System.out.println("输出结束");
		System.out.println(s.firstAdjVex(1));
		System.out.println(s.nextAdjVex(1, 2));
		//GraphTraverse.BFSTraverse(s);
		System.out.println();
		//GraphTraverse.DFSTraverse(s);
		System.out.println("请输入要查找的某个点的度");
		while (in.hasNext()) {
			String k = in.next();
			System.out.println(s.getDegree(k));
		}

	}

}
