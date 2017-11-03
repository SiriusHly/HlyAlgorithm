package ace;
import java.util.Scanner;
public class ÌâÄ¿25201´® {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner (System.in);
int t = in.nextInt();
	int [][] a = new int [3][3];
	
	for(int i=0;i<3;i++){
		for(int j=0;i<3;j++){
		a[i][j] = in.nextInt();
		}
	}
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			System.out.print(a[j][i]+" ");
		}System.out.println();
	}
	
	
	
}
	

}
