package 南阳理工;
import java.util.Arrays;
import java.util.Scanner;
public class 一道水题525{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int t = in.nextInt();
while(t-->0){
	int n = in.nextInt();
	int [] a= new int [n];
	for(int i = 0;i<n;i++){
		a[i]= in.nextInt();
	}
	Arrays.sort(a);
	
		System.out.println(a[n/2]);
	
	}
	}
}

