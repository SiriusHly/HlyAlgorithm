package 南阳理工;
import java.util.Scanner;
public class 大小写的转换 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int t = in.nextInt();
while(t-->0){
	String str = in.next();
	char [] ch = str.toCharArray();
	for(int i=0;i<str.length();i++){
		if(Character.isLowerCase(ch[i])){
		ch[i]-=32;
		}
		else if(Character.isUpperCase(ch[i])){
			ch[i]+=32;
		}
	}
	for(int i=0;i<str.length();i++){
		System.out.print(ch[i]);
	}System.out.println();
}
	}

}
