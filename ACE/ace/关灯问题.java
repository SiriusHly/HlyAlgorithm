package ace;
import java.util.Scanner;
public class 关灯问题 {
	//好题，巧妙的解法er
	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		int m=input.nextInt(),n=input.nextInt();
		int []a=new int [m+1];
		for(int i=1;i<=m;i++){
			a[i]=1;
		}
		for(int i=2;i<=n;i++){
			for(int j=1;j<m;j++){
				if(j%i==0){
					a[j]++;
					
				}
			}
		}for(int i=1;i<=m;i++){
			if(a[i]%2==1){
				System.out.println(i+" ");
			}
		}
	}

}
