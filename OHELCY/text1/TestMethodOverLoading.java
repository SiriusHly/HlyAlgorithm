package text1;
public class TestMethodOverLoading {
	public static void main(String[] args) {
System.out.println(max(3,4));
System.out.println(max(4.0,5.5));
System.out.println(max(12,4.4,3.4));
	}
	static int max(int num1,int num2){
		if(num1>num2)
			return num1;
		else
			return num2;
	}
	static double max(double num1,double num2){
		if(num1>num2)
			return num1;
		else
			return num2;
	}
	static double max(double num1,double num2,double num3){
		return max(max(num1,num2),num3);
	}

}
