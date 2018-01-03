package ʵ����;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author ������
 * time��2017.12.6
 * ��ȹ�����ȱ���
 *
 */
public class GraphTraverse {

	private static boolean[] visited;// ���ʱ������
	// ��ȱ���

	public static void BFSTraverse(ALGraph  G) throws Exception {
		visited = new boolean[G.getVexNum()];// ���ʱ�־����
		for(boolean v :visited)
			 v =false;// ��ʼ��
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v])// ��δ����
				BFS(G, v);
	}

	private static void BFS(ALGraph G, int v) throws Exception {
		visited[v] = true;
		System.out.print(G.getVex(v).toString() + " ");// ���ؽڵ��ֵ  
		Queue<Integer> Q = new LinkedList<>();// ��������Q
		Q.offer(v);// v���
		while (!Q.isEmpty()) {
			int u = Q.poll();// uΪ�±�
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))// wΪu�ĵ�һ���ڽӵ�
				if (!visited[w]) {// wΪu��Ϊ�����ڽӵ�
					visited[w] = true;
					System.out.print(G.getVex(w) + " ");
					Q.offer(w);
				}
		}
		
	}
	
	//�������
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
		//�ɵ�v���������������ȱ���ͼG
		visited_[v]=true;
		System.out.print(G.getVex(v).toString()+" ");
		for(int w = G.firstAdjVex(v);w>=0;w = G.nextAdjVex(v, w))
			if(!visited_[w])
				DFS(G,w);
	}


}
