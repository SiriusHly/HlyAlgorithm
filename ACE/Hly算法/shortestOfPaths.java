package Hly算法;

import java.util.Scanner;

public class shortestOfPaths {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long all = 1;
		int m = in.nextInt();
		int n = in.nextInt();
		m = m>= 0?m:-m;
		n = n>=0?n:-n;
		if(m>n){
			int t = m;
			m = n;
			n = t;
		}
		for(int i = n+1;i<=n+m;i++)
			all*=i;
		for(int i =2;i<=n;i++)
			all/=i;
		System.out.println("总条数为:"+all);
	}
	//排列组合问题Cm,n=Am,n/m!=n!/(n-m)!m!
	//m在上面

}
