package ace;
import java.util.Scanner;
public class ±¨Êý278 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int [] a = new int [1000];
Scanner in = new Scanner(System.in);
int t = in.nextInt();
while(t-->0){
	int n = in.nextInt();int m = in.nextInt();
	int s=0;
	 for (int i=2;i<=n;i++){
		 s=(s+m)%i;}
	 System.out.println(s+1);
		
	
}
	}

}
