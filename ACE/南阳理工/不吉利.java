package 南阳理工;
import java.util.Scanner;
public class 不吉利 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
while(in.hasNext()){
	boolean flag=false;;
	int n = in.nextInt();
	int k = n;
	while(k!=0){
		if(k%10==0){
			flag=true;;
		}
		k/=10;
	}
	if(flag==true){
		System.out.println("Unlucky");
	}
	else{
			int s=0;
			for(int i=1;i<=n;i++){
				int b = 1;
				int a = i;
				while(a!=0){
					if(a%10==0){
						b=0;
					}
					a/=10;
				}
				s+=b;
			}
			System.out.println(s);
		}
	}
}
}

