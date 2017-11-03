package ace;
import java.util.Scanner;
public class Gcd {
	public static int ace(int a,int b){
		if(b==0){
			return a;
		}
		else{
			return ace(b,a%b);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		Scanner cin=new Scanner(System.in);
		n=cin.nextInt();m=cin.nextInt();
		System.out.println(ace(n,m)+"\n"+n*m/ace(n,m));

	}

}
