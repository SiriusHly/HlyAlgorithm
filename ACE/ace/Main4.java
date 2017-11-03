package ace;
import java.util.Scanner;
public class Main4 {
	public static boolean cc(int n){
		int i;
		if(n==1){
			return false;
		}
		for(i=2;i<n;i++)
		{
			if(n%i==0){
				return false;
				}
		}return true;
	}

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int m,n,a,s=0,i;
		m=cin.nextInt();
		for(i=2;i<=m;i++){
			if(cc(i)){
				
			System.out.println(i);}
		}

	}

}
