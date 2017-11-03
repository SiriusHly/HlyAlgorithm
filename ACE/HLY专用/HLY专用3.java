package HLY专用;
import java.util.*;
import java.util.Scanner;
public class HLY专用3 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		double x = in.nextDouble();
		double s= 0;
		int i=0;
		int b=1;
		for(i=1;i<100;i++){
			s+=Math.pow(-1, i)*Math.pow(x,i*2)*jie(i*2);	
				
			}
		System.out.println((double)(Math.round(s*1000000))/1000000);
		}
	public static int jie(int n){
		if(n==1||n==0)
			return 1;
		return jie(n-1)*n;
	}
}

