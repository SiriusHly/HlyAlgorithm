package สตั้7;

import java.util.StringTokenizer;

public class StringDemo {
	public static void main(String[] yun) {
		String s1 = "I sm s good student";
		String s2 = "I am a good worker";
		String s3 = "3,6,12,20";
		int some = 0;
		System.out.println(s1.compareTo(s2));
		StringTokenizer st = new StringTokenizer(s1);
		System.out.println("The total number of the word is :" + st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println(s1.indexOf("student"));
		String s[] = s2.split(" ");
		/*
		 * for(int i=0;i<s.length;i++){
		 *  System.out.println(s[i]);
		 *   }
		 */
		for (String i : s) {
			System.out.println(i);
		}
		String sArray[] = s3.split(",");
		int iArray[] = new int[sArray.length];
		for (int i = 0; i < sArray.length; i++) {
			iArray[i] = Integer.parseInt(sArray[i]);
			some += iArray[i];
		}
		System.out.println(some);

	}
}
