package eight_AOV;

public class MyKahn {

	static int MAX = Integer.MAX_VALUE;
	static String c[] = { "C++", "Java", "Python", "Go", "Php" };

	public static void kahn(int areas[][]) {
		int flag[] = new int[areas.length];
		int n = 0;
		while (n < areas.length) {
			next: for (int i = 0; i < areas.length; i++) {// µÚiÁÐ
				for (int j = 0; j < areas.length; j++) 
					if (areas[j][i] != 0 && areas[j][i] != MAX || flag[i] > 0) 
						continue next;
				System.out.print(c[i] + " ");
				flag[i] = 1;
				for (int k = 0; k < areas.length; k++)
					areas[i][k] = MAX;
				n++;
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
