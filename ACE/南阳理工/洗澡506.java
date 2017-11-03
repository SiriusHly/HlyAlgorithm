package ÄÏÑôÀí¹¤;

import java.util.Scanner;
public class Ï´Ôè506 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
while(in.hasNext()){
	int n = in.nextInt();
	int s = n;
	for(int i = 1;i <=n;i++){
		int t = i;
		while(t!=0){
			if(t%10==4){
				s--;break;
			}
			t/=10;
		}
	}
	System.out.println(s);
}
	}

}
