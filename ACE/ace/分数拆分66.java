package ace;
import java.util.Scanner;
public class ·ÖÊý²ð·Ö66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
int t = in.nextInt();
while(t-->0){
	int k = in.nextInt();
	for(int y = k+1;y<=2*k;y++){
		int x = k*y/(y-k);
		if(k*y%(y-k)==0){
			System.out.println("1/"+k+'='+"1/"+x+"+1/"+y);
		}
	}
}
	}

}
