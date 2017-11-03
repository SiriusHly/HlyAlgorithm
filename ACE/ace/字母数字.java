package ace;
import java.util.Scanner;
public class ×ÖÄ¸Êý×Ö {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int t = in.nextInt();
while(t-->0){
	int m=0;
	String str = in.next();
	char ch = str.charAt(0);
	int n = in.nextInt();
	if(ch>='A'&&ch<='Z'){
		m = ch-64;
	}
	else{
		m = 96-(int)ch;
	}
	System.out.println(m+n);
}
	}

}
