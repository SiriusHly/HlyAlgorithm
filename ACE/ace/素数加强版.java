package ace;
import java.util.Scanner;
public class ËØÊý¼ÓÇ¿°æ {
public static boolean ace(int n){
	int i;
	if(n==0||n==1){
		return false;
	}
	for(i=2;i<=Math.sqrt(n);i++){
		if(n%i==0){
			return false;
		}	
	}return true;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in =new Scanner(System.in);
int t=in.nextInt();
while(t-->0){
	int n=in.nextInt();
	if(ace(n)){
		System.out.println(n);
	}
	else if(n==0||n==1){
		System.out.println(2);
	}
	else{
		for(int i=n,j=n;;i--,j++){
			if(ace(j)){
				System.out.println(j);
				break;
			}
			else if(ace(i)){
				System.out.println(i);
				break;
			}
			
		}
	}
}
	}

}
