package ace;
//import java.util.Arrays;
import java.util.Scanner;
public class Ñ¡Ì«×Ó {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int [] a = new int [40];
int t=in.nextInt();
while(t-->0){
	int m=in.nextInt();
	for(int i=0;i<m;i++){
		a[i]=in.nextInt();
	}
	//Arrays.sort(a);
	for(int i=0;i<m;i++){
		for(int j=i+1;j<m;j++){
			if(a[i]>a[j]){
				int s=a[i];
				a[i]=a[j];
				a[j]=s;
			}
		}
	}
	
		System.out.println(a[m/2]);
	
			
			
}
	}

}
