package ace;
import java.util.Scanner;
public class Chengjizhuanhuan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
int n = input.nextInt();
while(n--!=0){
	int m = input.nextInt();
	if(m>=90&&m<=100){
		System.out.println("A");
	}
	else if(m>=80&&m<=89){
		System.out.println("B");
	}
	else if(m>=70&&m<=79){
		System.out.println("C");
	}
	else if(m>=60&&m<=69){
		System.out.println("D");
	}
	else if(m>=0&&m<=59){
		System.out.println("E");
	}
}
	}

}
