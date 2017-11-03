package ace;
import java.io.*;
import java.util.*;

public class Hanxindianbing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
int a=input.nextInt();
int b=input.nextInt();
int c=input.nextInt();
for(int i=10;i<=101;i++){
	if((i-a)%3==0&&(i-b)%5==0&&(i-c)%7==0){
		System.out.println(i);
		break;
	}
	else if(i==101){
		System.out.println("No answer");
	}
	
}

	}

}


