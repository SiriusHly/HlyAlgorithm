package ten_ShortestPath;

import java.util.Scanner;
/*
 * author:黄良运
 * 18.1.1
 */
public class MyDijkstra {
	static String c[] = { "A", "B", "C", "D" };
	private static int[] D;
	public final static int MAX = Integer.MAX_VALUE;

	public static void dijkstra(int[][] areas, int v) {// 顶点v到其余顶点的最短路径P[v]和路径长度D[v]
		int num = areas.length;
		D = new int[num];
		String path[] = new String[num];
		for (int i = 0; i < num; i++) {
			path[i] = c[v] + "->" + c[i];
		}
		// finish[i]为true时i属于S，已经求得v到i的最短路径a
		boolean finish[] = new boolean[num];
		for (int i = 0; i < num; i++) {
			finish[i] = false;
			D[i] = areas[v][i];

		}
		D[v] = 0;// 初始化v顶点属于S集
		finish[v] = true;
		int k = -1;
		// 开始循环，每次求得v到某个顶点k的最短路径，并加到S
		for (int i = 1; i < num; i++) {
			int min = MAX;// 当前所知v顶点的最近距离
			for (int f = 0; f < num; f++)
				if (!finish[f])//为f的，其中最短的距离的点
					if (D[f] < min) {
						k = f;
						min = D[f];
					}
					finish[k] = true;// 离v最近的k加入S

					for (int j = 0; j < num; j++)
						if (!finish[j] && areas[k][j] < MAX && (min + areas[k][j] < D[j])) {
							D[j] = min + areas[k][j];
							path[j] = path[k] + "->" + c[j];
						}
		}
		for (int i = 0; i < num; i++) {
			System.out.println( "城市"+c[v] + "出发到" + c[i] + "的最短路径为：" + path[i] + "=" + D[i]);
		}
	}
	public static int search(String str) {
		for (int k = 0; k < c.length; k++)
			if (c[k].equals(str))
				return k;
		return -1;
	}

	/*public static void display(int[] D) {
		for (int i = 0; i < D.length; i++)
			System.out.print("到顶点" + c[i] + "的最短路径路径为：" + D[i] + "    ");
		System.out.println();
	}*/

	public static void main(String[] arvs) {
		Scanner in = new Scanner(System.in);
		int areas[][] = { { 0, 1, 25, 9 }, { 1, 0, MAX, 2 }, { 25, MAX, 0, 18 }, { 9, 2, 18, 0 } };
		dijkstra(areas, search("A"));
		//display(D);
	}

}
