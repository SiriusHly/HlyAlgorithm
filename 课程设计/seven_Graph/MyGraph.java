package seven_Graph;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import seven_Graph.ALGraph.VNode;

/**
 * 
 * @author 黄良运 time:2017.12.7 邻接矩阵存储结构
 * @param <AnyType>
 *            1.求结点的度 2.增加，删除边 3.增加，删除顶点4.存储结构的转换
 */
public class MyGraph<AnyType extends Comparable<? super AnyType>> {

	public final static int INFINITY = Integer.MAX_VALUE;
	private int vexNum, arcNum;// 顶点数和边数
	private AnyType[] vexs;// 顶点
	private int[][] arcs;// 邻接矩阵

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

	// 返回边数
	public int getarcNum() {
		return arcNum;
	}

	public void isValid_V(int v) throws Exception {
		if (v < 0 || v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在");
	}

	// 给定顶点值vex，返回在图中的位置，如果图中不包含此顶点，返回-1
	public int locateVex(AnyType vex) throws Exception {
		for (int v = 0; v < vexNum; v++) {
			// System.out.println("vex"+vexs[v]);
			if (vexs[v].toString().equals(vex.toString()))
				return v;
		}
		throw new Exception(vex + "这个顶点不存在");
	}

	// 返回v的节点的值0<=v<vexNum
	public AnyType getVex(int v) throws Exception {
		isValid_V(v);
		return vexs[v];
	}

	// 返回第一个邻接点，若v没有邻接点则返回-1，其中0<=v,w<vexNum;
	public int firstAdjVex(int v) throws Exception {// 假若顶点v 和顶点w 之间存在一条边， 则称顶点v
													// // 和w 互为邻接点。
		isValid_V(v);
		for (int j = 0; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)
				return j;
		return -1;
	}

	// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0<=v,w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		isValid_V(v);
		for (int j = w + 1; j < vexNum; j++)
			if (arcs[v][j] != 0 && arcs[v][j] < INFINITY)// arcx存的是邻接矩阵遍历第v，行时间复杂度是n
				return j;
		return -1;
	}

	// 求某个点的度
	/*
	 * public int getDegree(AnyType v) throws Exception { int k = 0, s = 0; k =
	 * locateVex(v); for (int w = firstAdjVex(k); w >= 0; w = nextAdjVex(k, w))
	 * // 出度 s++; // 入度 for (AnyType i : vexs) { int u = locateVex(i); for (int
	 * w = firstAdjVex(u); w >= 0; w = nextAdjVex(u, w)) if
	 * (vexs[w].toString().compareTo(v.toString()) == 0) s++; } return s; }
	 */

	// 在vex1和vex2之间增加一条边
	public boolean addArc(AnyType vex1, AnyType vex2, int weight) throws Exception {
		int v = locateVex(vex1);
		int u = locateVex(vex2);
		arcs[v][u] = weight;
		return true;
	}

	// 删除边arcs也要改变
	public boolean deleteArc(AnyType vex1, AnyType vex2) throws Exception {
		int v = locateVex(vex1);
		int u = locateVex(vex2);
		arcs[v][u] = INFINITY;
		return true;
	}

	// 增加顶点
	public boolean addVex(AnyType vex) {
		vexs[vexNum] = vex;
		vexNum++;

		return true;
	}

	// 删除顶点非常麻烦，不是一般的麻烦
	public boolean deleteVex(AnyType vex) throws Exception {
		int k = 0;
		int arcs2 [][] = new int [vexNum-1][vexNum-1];
		ArrayList<Integer> li = new ArrayList<Integer>();
		int v = locateVex(vex);
		for (int i = v; i < vexNum - 1; i++)
			vexs[i] = vexs[i + 1];
		//
		// 所删除的顶点相关的权值都置为0
		for (int j = 0; j < vexNum; j++)
			arcs[v][j] = INFINITY;
		for (int i = 0; i < vexNum; i++)
			arcs[i][v] = INFINITY;
		// arcs前移
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

	// 求顶点的度
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

	// 邻接矩阵转化为邻接表
	public ALGraph<AnyType> AmToAl() {
		
		ALGraph<AnyType> alGraph = new ALGraph<AnyType>();
		alGraph.setVexNum(vexNum);
		alGraph.setArcNum(arcNum);
		VNode<AnyType>[] vexs = new VNode[vexNum];
		for (int v = 0; v < vexNum; v++) {// 构造顶点向量
			vexs[v] = new VNode<AnyType>(this.vexs[v]);
			System.out.print(vexs[v].data + " ");
		}
		alGraph.setVexs(vexs);
		for (int k = 0; k < vexNum; k++)
			for (int l = vexNum - 1; l >= 0; l--)// 倒过来你懂得
				if (arcs[k][l] < INFINITY) {
					System.out.println(arcs[k][l]);
					alGraph.addArc(k, l, arcs[k][l]);
				}

		return alGraph;
	}

	/**
	 * v1 v2 v3 v4 v1 v2 1 v2 v4 1 v2 v3 1 v3 v4 1 //头插注意顺序 1 2 3 4 1 2 1 2 4 1
	 * 2 3 1 3 4 1
	 */
	

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		/**
		 * v1 v2 v3 v4 v1 v2 1 v2 v3 1 v2 v4 1 v3 v4 1 1 2 3 4 1 2 1 2 3 1 2 4 1
		 * 3 4 1
		 */
		MyGraph<String> myGraph = new MyGraph<String>();
		System.out.println("请分别输入图的顶点数，图的边数");
		int vexNum = in.nextInt();
		int arcNum = in.nextInt();
		myGraph.setVexNum(vexNum);
		myGraph.setArcNum(arcNum);
		String[] vexs = new String[5];
		System.out.println("请分别输入图的各个顶点");
		for (int v = 0; v < vexNum; v++)// 构造顶点向量
			vexs[v] = in.next();
		myGraph.setVexs(vexs);
		int[][] arcs = new int[5][5];
		for (int v = 0; v < 5; v++)
			for (int u = 0; u < 5; u++)
				arcs[v][u] = INFINITY;
		System.out.println("请输入各个边的两个顶点及其权值");
		for (int k = 0; k < arcNum; k++) {
			int v = myGraph.locateVex(in.next());// 得到顶点的下标
			int u = myGraph.locateVex(in.next());
			arcs[v][u] = in.nextInt();
			// arcs[u][v] = arcs[v][u] = in.nextInt();
		}
		myGraph.setArcs(arcs);
		System.out.println("输出结束");
		System.out.println(myGraph.firstAdjVex(1));
		System.out.println(myGraph.nextAdjVex(1, 2));
		//myGraph.addArc("v1", "v3", 1);
		//myGraph.deleteArc("v2", "v3");
		myGraph.addVex("v5");
		myGraph.addArc("v1", "v5", 1);
		myGraph.deleteVex("v4");
		System.out.println("改变结束");
		// GraphTraverse.BFSTraverse(s);
		System.out.println();

		System.out.println("AmToAl相对的第一个邻接点" + myGraph.AmToAl().firstAdjVex(0));
		// GraphTraverse.DFSTraverse(s);
		System.out.println("请输入要查找的结点是");
		while (in.hasNext()) {// int k = in.nextInt();
			String k = in.next();
			System.out.println(myGraph.getDegree(k) + "个");
		}

	}

}
