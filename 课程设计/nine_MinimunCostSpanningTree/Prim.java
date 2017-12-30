package nine_MinimunCostSpanningTree;

/*
 * 2017.12.29
 * 黄良运
 */
public class Prim {
	// mst保存到此顶点最小的起始顶点
	// 每加入一个顶点，把其他边和这个顶点的距离和其他顶点比较

	static int MAX = Integer.MAX_VALUE;

	public static void prim(int[][] graph, int n) {

		char[] c = new char[] { 'A', 'B', 'C', 'D', 'E' };
		int[] lowcost = new int[n];
		int[] mst = new int[n];
		int i, j, min, minid, sum = 0;

		for (i = 1; i < n; i++) {
			lowcost[i] = graph[0][i];
			mst[i] = 0;
		}

		for (i = 1; i < n; i++) {

			min = MAX;
			minid = 0;
			for (j = 1; j < n; j++) {
				if (lowcost[j] < min && lowcost[j] != 0) {
					min = lowcost[j];
					minid = j;
				}
			}
			System.out.println(c[mst[minid]] + "到" + c[minid] + " 权值：" + min);

			sum += min;
			lowcost[minid] = 0;

			for (j = 1; j < n; j++) { // 没找到又从A开始
				if (graph[minid][j] < lowcost[j]) {
					lowcost[j] = graph[minid][j];
					mst[j] = minid;
				}
			}
		}

		System.out.println("sum:" + sum);
	}

	public static void main(String[] args) {
		int[][] map = new int[][] { { 0, 2, 1, 8, MAX }, { 2, 0, MAX, 3, 4 }, { 1, MAX, 0, 9, MAX }, { 8, 3, 9, 0, 9 },
				{ MAX, 4, MAX, 9, 0 }

		};
		prim(map, map.length);
	}

}