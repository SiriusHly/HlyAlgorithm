package ace;
import java.util.Scanner;
public class Main5 {
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
		int m,n,a,s=0;
		m=cin.nextInt();
		while(m--!=0){
			s=0;
			n=cin.nextInt();
			while(n--!=0){
				a=cin.nextInt();
				if(cc(a)){
					s+=a;
				}
			}
			System.out.println(s);
		}

	}

}
