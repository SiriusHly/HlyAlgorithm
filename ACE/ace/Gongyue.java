package ace;

import java.util.Scanner;

public class Gongyue {
public static int gcd(int a,int b){
	if(b==0){
		return a;
	}
	else{
		return gcd(b,a%b);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
int n=input.nextInt();
while(n--!=0){
	int a=input.nextInt();
	int b=input.nextInt();
	int t=gcd(a,b);
	System.out.println(t+" "+a*b/t);
}
	}

}
