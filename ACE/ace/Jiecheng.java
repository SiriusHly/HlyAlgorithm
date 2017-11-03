package ace;
import java.util.Scanner;
public class Jiecheng {
public static int ace(int n){
	int i,z=1;
	for(i=1;i<=n;i++){
		z*=i;
	}return z;
}
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int n=cin.nextInt();
			System.out.println(ace(n));
		}
	}

}
