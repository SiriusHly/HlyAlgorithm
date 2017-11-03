package ace;
import java.util.Scanner;
public class Feibonaqi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int []a=new int [22];
		a[1]=1;a[2]=1;
		for(int i=2;i<22;i++){
			a[i]=a[i-1]+a[i-2];
		}
		int n=input.nextInt();
		while(n--!=0){
			int j=input.nextInt();
			System.out.println(a[j]);
		}

	}

}
