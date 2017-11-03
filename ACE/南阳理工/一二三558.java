package 南阳理工;
import java.util.Scanner;
public class 一二三558 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int  t = in.nextInt();
while(t-->0){
	String str =in.next();
	char [] a = str.toCharArray();
	if(a[0]=='o'&&a[1]=='n'||a[0]=='o'&&a[2]=='e'||a[1]=='n'&&a[2]=='e'){
		System.out.println(1);}
		else if(a[0]=='t'&&a[1]=='w'||a[0]=='t'&&a[2]=='o'||a[1]=='w'&&a[2]=='o'){
			System.out.println(2);
		}
		else
			System.out.println(3);
		
	}
}
	}


