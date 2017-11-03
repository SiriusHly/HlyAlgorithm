package ace;
import java.util.Scanner;
public class Main3{
	public static void main(String args[]){
		int n,a,s=0;
		Scanner cin=new Scanner(System.in);
		n=cin.nextInt();
		while(n--!=0){
			a=cin.nextInt();
			if(a%2==0){
				s+=a;
			}
		}
		System.out.println(s);
	}

}
