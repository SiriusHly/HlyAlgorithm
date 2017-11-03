package HLY专用;
import java.util.Scanner;
public class HLY专用1{
	public static boolean su(int n){
		int i;
		if(n==1){
			return false;
		}
		for(i=2;i<n;i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	public static void main(String []arvs){
		Scanner in = new Scanner(System.in);
		int s=0;
		for(int i=100;i<=200;i++){
			if(su(i)){
				System.out.print(i+" ");
				s++;
				if(s==10){
					System.out.println();
					s=0;
				}
			}
		}
	}
}