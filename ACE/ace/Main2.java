package ace;
import java.util.Scanner;
public class Main2
{
	public static void main(String[] args){
		Scanner cin=new Scanner(System.in);
		int i,j;
		int[]a;
		a=new int[10];
		for(i=0;i<5;i++)
		{
			a[i]=cin.nextInt();
		} 
		for(i=0;i<5;i++)
		{
			for(j=i+1;j<5;j++){
				if(a[i]<a[j]){
					int t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
			}
		}
		System.out.println(a[4]+" "+a[0]);
	}
}