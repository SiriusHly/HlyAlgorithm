package nine_MinimunCostSpanningTree;

/**
 * 
 * @author ������
 * time:17.12.26
 *
 */
public class MyPrim {
	// star���浽�˶�����С����ʼ����
	// ÿ����һ�����㣬�������ߺ��������ľ������������Ƚ�

	static int MAX = Integer.MAX_VALUE;

	public static void prim(int[][] areas, int n) {
		String[] c = new String[] { "����¥","�Ƽ���","�ݷ�¥","��Ϣ¥","ͼ���" };
		int[] lowweight = new int[n];
		int[] star = new int[n];
		int i, j, min, minid, sum = 0;

		for (i = 1; i < n; i++) {
			lowweight[i] = areas[0][i];
			star[i] = 0;
		}

		for (i = 1; i < n; i++) { 
			min = MAX;
			minid = 0;
			for (j = 1; j < n; j++) {
				if (lowweight[j] < min && lowweight[j] != 0) {
					min = lowweight[j];
					minid = j;
				}
			}
			System.out.println(c[star[minid]] + "---��" + c[minid] + " ���룺" + min);
			
			sum += min;
			lowweight[minid] = 0;
			for (j = 1; j < n; j++) { // û�ҵ��ִ�A��ʼ
				if (areas[minid][j] < lowweight[j]) {
					lowweight[j] = areas[minid][j];
					star[j] = minid;
				}
			}
		}
		 System.out.println("�ܾ���"+sum);
	}
	public static void main(String[] args) {
		int[][] areas = new int[][] { { 0, 2, 1, 8, MAX }, { 2, 0, MAX, 3, 4 }, { 1, MAX, 0, 9, MAX }, { 8, 3, 9, 0, 9 },
				{ MAX, 4, MAX, 9, 0 }

		};
		prim(areas, areas.length);
	}

}