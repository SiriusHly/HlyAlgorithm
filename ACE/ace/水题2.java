package ace;
import java.util.Arrays;
import java.util.Scanner;
public class Ë®Ìâ2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int t = in.nextInt();
while(t-->0){
	int s = in.nextInt();
	int k = s;
	int j = 1;
	while(k/10!=0){
		j*=10;
		k/=10;
	}
	System.out.println((int)s%j);
}
	}
}
	

