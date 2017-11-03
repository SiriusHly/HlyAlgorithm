package ace;
import java.util.Arrays;
import java.util.Scanner; 
public class Ë®Ìâ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in= new Scanner(System.in);
while(in.hasNext()){
	int t = in.nextInt();
	for(int i=1;i<888;i++){
		int k = i;int s = 1;
		while(k!=0){
			s*=k%10;
			k/=10;
			if(s==t){
				System.out.println(i);break;	
			}
		}
	}
		
		
}
	}

}
