package eight_AOV;

/*
 * 17.12.29
 * author :ª∆¡º‘À
 */
public class MyTopology {
	

	static int MAX = Integer.MAX_VALUE;
	static String c[] = { "C++", "Java", "Python", "Go", "Php" };

	public static void kahn(int areas[][]) {
		int flag[] = new int[areas.length];
		int n = 0;
		while (n < areas.length) {
			loop1: for (int i = 0; i < areas.length; i++) {// µ⁄i¡–
				for (int j = 0; j < areas.length; j++) {
					if (areas[j][i] != 0 && areas[j][i] != MAX || flag[i] > 0) {
						continue loop1;
					}
				}
				System.out.print(c[i] + " ");
				for (int k = 0; k < areas.length; k++)
					areas[i][k] = MAX;
				n++;
				flag[i] = 1;
			}
		}
	}

	public static void main(String[] arvs) {
		int areas[][] = { { 0, 1, 1, MAX, MAX }, { MAX, 0, MAX, MAX, MAX }, { MAX, MAX, 0, 1, 1 },
				{ MAX, MAX, MAX, 0, MAX }, { MAX, MAX, MAX, 1, 0 } };
		// int areas[][] = { { 0, MAX, 1 }, { MAX, 0, MAX }, { MAX, 1, 0 }};
		kahn(areas);
	}

}
