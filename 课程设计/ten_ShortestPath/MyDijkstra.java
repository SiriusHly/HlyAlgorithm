package ten_ShortestPath;

import java.util.Scanner;
/*
 * author:������
 * 18.1.1
 */
public class MyDijkstra {
	static String c[] = { "A", "B", "C", "D" };
	private static int[] D;
	public final static int MAX = Integer.MAX_VALUE;

	public static void dijkstra(int[][] areas, int v) {// ����v�����ඥ������·��P[v]��·������D[v]
		int num = areas.length;
		D = new int[num];
		String path[] = new String[num];
		for (int i = 0; i < num; i++) {
			path[i] = c[v] + "->" + c[i];
		}
		// finish[i]Ϊtrueʱi����S���Ѿ����v��i�����·��a
		boolean finish[] = new boolean[num];
		for (int i = 0; i < num; i++) {
			finish[i] = false;
			D[i] = areas[v][i];

		}
		D[v] = 0;// ��ʼ��v��������S��
		finish[v] = true;
		int k = -1;
		// ��ʼѭ����ÿ�����v��ĳ������k�����·�������ӵ�S
		for (int i = 1; i < num; i++) {
			int min = MAX;// ��ǰ��֪v������������
			for (int f = 0; f < num; f++)
				if (!finish[f])//Ϊf�ģ�������̵ľ���ĵ�
					if (D[f] < min) {
						k = f;
						min = D[f];
					}
					finish[k] = true;// ��v�����k����S

					for (int j = 0; j < num; j++)
						if (!finish[j] && areas[k][j] < MAX && (min + areas[k][j] < D[j])) {
							D[j] = min + areas[k][j];
							path[j] = path[k] + "->" + c[j];
						}
		}
		for (int i = 0; i < num; i++) {
			System.out.println( "����"+c[v] + "������" + c[i] + "�����·��Ϊ��" + path[i] + "=" + D[i]);
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
			System.out.print("������" + c[i] + "�����·��·��Ϊ��" + D[i] + "    ");
		System.out.println();
	}*/

	public static void main(String[] arvs) {
		Scanner in = new Scanner(System.in);
		int areas[][] = { { 0, 1, 25, 9 }, { 1, 0, MAX, 2 }, { 25, MAX, 0, 18 }, { 9, 2, 18, 0 } };
		dijkstra(areas, search("A"));
		//display(D);
	}

}
