package Fuxi4;

import java.util.StringTokenizer;

public class ZiFu {

	
	public static void main(String[] args) {
String s1="I am a good student";
String s2="I am a good worker";
String s3="3,6,12,20";
System.out.println(s1.compareTo(s2));
StringTokenizer st = new StringTokenizer(s1);
while(st.hasMoreTokens()){
	System.out.println(st.nextToken());
}


	}

}
