package 南阳理工;
import java.util.Scanner;
public class 司马光扎坑783 {
	public static int gcd(int a,int b){
		if(b==0){
			return a;
		}
		return gcd(b,a%b);
	}
public static void main(String []args){
	Scanner in = new Scanner(System.in);
	while(in.hasNext()){
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		if(c%(gcd(a,b))==0){
			System.out.println("YES");
			
		}
		else{
			System.out.println("NO");
		}
		
	}
}
}
