package ace;
import java.util.Scanner;
public class Jioushu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
int n=input.nextInt();
while(n--!=0){
	int m=input.nextInt();
	for(int i=1;i<=m;i++){
		if(i%2!=0){
			System.out.print(i+" ");
			
		}
	}
	System.out.println();
	for(int i=1;i<=m;i++){
		if(i%2==0){
			System.out.print(i+" ");
		}
	}
	System.out.println();
}
	}

}
