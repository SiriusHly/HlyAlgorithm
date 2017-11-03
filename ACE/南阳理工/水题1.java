package 南阳理工;
import java.util.Scanner;
public class 水题1 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int  t= in.nextInt();
		while(t-->0){
			int s = 0;
			int n = in.nextInt();
			for(int i=0;i<=n*10;i++){
				for(int j=0;2*j<=n*10;j++){
					for(int k=0;5*k<=n*10;k++){
						if(i+2*j+5*k==n*10){
						s++;	
						}
					}
				}
			}System.out.println(s);
		}
	}
	}

