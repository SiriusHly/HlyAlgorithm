package 实验三;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author 黄良运
 * time：2017.12.6
 * 深度广度优先遍历
 *
 */
public class GraphTraverse {

	private static boolean[] visited;// 访问标记数组
	// 广度遍历

	public static void BFSTraverse(ALGraph  G) throws Exception {
		visited = new boolean[G.getVexNum()];// 访问标志数组
		for(boolean v :visited)
			 v =false;// 初始化
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v])// 尚未访问
				BFS(G, v);
	}

	private static void BFS(ALGraph G, int v) throws Exception {
		visited[v] = true;
		System.out.print(G.getVex(v).toString() + " ");// 返回节点的值  
		Queue<Integer> Q = new LinkedList<>();// 辅助队列Q
		Q.offer(v);// v入队
		while (!Q.isEmpty()) {
			int u = Q.poll();// u为下标
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))// w为u的第一个邻接点
				if (!visited[w]) {// w为u的为访问邻接点
					visited[w] = true;
					System.out.print(G.getVex(w) + " ");
					Q.offer(w);
				}
		}
		
	}
	
	//深度优先
	public static boolean[] visited_;
	
	public static void DFSTraverse(ALGraph G) throws Exception{
		visited_ = new boolean[G.getVexNum()];
		for(boolean v :visited_)
			v = false;
		for(int v = 0 ;v<G.getVexNum();v++)
			if(!visited_[v])
				DFS(G,v);
		
	}
	
	
	public static void DFS(ALGraph G,int v) throws Exception{
		//由第v个顶点出发深度优先遍历图G
		visited_[v]=true;
		System.out.print(G.getVex(v).toString()+" ");
		for(int w = G.firstAdjVex(v);w>=0;w = G.nextAdjVex(v, w))
			if(!visited_[w])
				DFS(G,w);
	}


}
