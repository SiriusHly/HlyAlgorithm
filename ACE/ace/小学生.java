package ace;
import java.util.Scanner;
public class Ð¡Ñ§Éú {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input =new Scanner(System.in);
while(true){
	int n=input.nextInt(), m=input.nextInt();
	int i,j,k;
	i=0;
	if(n==0&&m==0){
		break;}
		int a=n%10;int b=n/10%10;int c=n/100;int d=m%10;int e=m/10%10;int f=m/100;
		if(a+d>9){
			i++;b+=1;}
			if(b+e>9){
				i++;c+=1;
			}
			if(c+f>9){
				i++;
			}
		
	System.out.println(i);
}
	
	
	}
}

