package ten_ShortestPath;

import java.util.Scanner;

public class MyDijkstra {
	static String c[] = { "A", "B", "C", "D" };
	private static boolean[][] P;
	private static int[] D;
	public final static int MAX = Integer.MAX_VALUE;

	public static void dijkstra(int[][] areas, int v) {// ����v�����ඥ������·��P[v]��·������D[v]
		int num = areas.length;
		P = new boolean[num][num];
		D = new int[num];
		// finish[i]Ϊtrueʱi����S���Ѿ����v��i�����·��a
		boolean finish[] = new boolean[num];
		for (int i = 0; i < num; i++) {
			finish[i] = false;
			D[i] = areas[v][i];
			for (int j = 0; j < num; j++) {
				P[i][j] = false;// ��Ϊ·��
				if (D[i] < MAX) {
					P[i][v] = true;
					P[i][i] = true;
				}
			}
		}
		D[v] = 0;// ��ʼ��v��������S��
		finish[v] = true;
		int k = -1;
		// ��ʼѭ����ÿ�����v��ĳ������k�����·�������ӵ�S
		for (int i = 1; i < num; i++) {
			int min = MAX;// ��ǰ��֪v������������
			for (int f = 0; f < num; f++)
				if (!finish[f]) {
					if (D[f] < min) {
						k = f;
						min = D[f];
					}
					finish[k] = true;// ��v�����k����S
					for (int j = 0; j < num; j++)
						if (!finish[j] && areas[k][j] < MAX && (min + areas[k][j] < D[j])) {
							D[j] = min + areas[k][j];
							System.arraycopy(P[k], 0, P[j], 0, P[k].length);
							P[j][j] = true;
						}
				}
		}
	}

	public static int search(String str) {
		for (int k = 0; k < c.length; k++)
			if (c[k].equals(str))
				return k;
		return -1;

	}

	public static void display(int[] D) {
		for (int i = 0; i < D.length; i++)
			System.out.print("������" + c[i] + "�����·��·��Ϊ��" + D[i] + "    ");
		System.out.println();
	}

	public static void main(String[] arvs) {

		Scanner in = new Scanner(System.in);
		int areas[][] = { { 0, 1, 5, 9 }, { 1, 0, MAX, 2 }, { 5, MAX, 0, 8 }, { 9, 2, 8, 0 } };
		dijkstra(areas, search("C"));
		display(D);
	}

}
