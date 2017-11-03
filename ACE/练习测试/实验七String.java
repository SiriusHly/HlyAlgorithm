package 练习测试;

import java.util.StringTokenizer;

public class 实验七String {

	public 实验七String() {
	}

	public static void main(String[] args) {
		String s1="I am a good student";
		String s2="I am a good worker";
		String s3="3,6,12,20";
		System.out.println(s1.compareTo(s2));
		StringTokenizer t = new StringTokenizer(s1," ");
		while(t.hasMoreTokens()){
			System.out.println(t.nextToken());
		}
		String s4 []=s2.split(" ");
		for(String i:s4){
			System.out.println(i);
		}
		System.out.println(s1.indexOf("student"));
		String sArray[]=s3.split(",");
		int iArray[]= new int [1024];
		int sum=0;
		for(int i=0;i<sArray.length;i++){
			iArray[i]=Integer.parseInt(sArray[i]);
			sum +=iArray[i];
		}
		System.out.println(sum);
		
		
		
		

	}

}
