package nine_MinimunCostSpanningTree;

/**
 * 
 * @author ������
 * time:17.12.26
 *
 */
public class MyPrim {
	// mst���浽�˶�����С����ʼ����
	// ÿ����һ�����㣬�������ߺ��������ľ������������Ƚ�

	static int MAX = Integer.MAX_VALUE;

	public static void prim(int[][] graph, int n) {
		char[] c = new char[] { 'A', 'B', 'C', 'D', 'E' };
		int[] lowpath = new int[n];
		int[] star = new int[n];
		int i, j, min, minid, sum = 0;

		for (i = 1; i < n; i++) {
			lowpath[i] = graph[0][i];
			star[i] = 0;
		}

		for (i = 1; i < n; i++) {
			min = MAX;
			minid = 0;
			for (j = 1; j < n; j++) {
				if (lowpath[j] < min && lowpath[j] != 0) {
					min = lowpath[j];
					minid = j;
				}
			}
			System.out.println(c[star[minid]] + "->" + c[minid] + " ��" + min);
			sum += min;
			lowpath[minid] = 0;
			for (j = 1; j < n; j++) { // û�ҵ��ִ�A��ʼ
				if (graph[minid][j] < lowpath[j]) {
					lowpath[j] = graph[minid][j];
					star[j] = minid;
				}
			}
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		int[][] map = new int[][] { { 0, 2, 1, 8, MAX }, { 2, 0, MAX, 3, 4 }, { 1, MAX, 0, 9, MAX }, { 8, 3, 9, 0, 9 },
				{ MAX, 4, MAX, 9, 0 }

		};
		prim(map, map.length);
	}

}