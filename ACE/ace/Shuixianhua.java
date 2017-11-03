package ace;
import java.util.Scanner;
public class Shuixianhua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input=new Scanner (System.in);
while(true){
	int n=input.nextInt();
	if(n==0){
		break;
	}
	else{
		int a=n%10;
		int b=n/10%10;
		int c=n/100;
		if(a*a*a+b*b*b+c*c*c==n){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
}
	}

}
