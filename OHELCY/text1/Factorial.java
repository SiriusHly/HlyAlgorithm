package text1;

public class Factorial {

	public static void main(String[] args) {
System.out.println("please input a number");
int n = MYInput.readInt();
System.out.println(fact(n));
System.out.println("please input a nunber");
int s = MYInput.readInt();
System.out.println(fi(s));
System.out.println("the number of gcd is");
		System.out.println(gcd(4,7));
		System.out.println(gcd(44,53,57333));
	}
static long fact(long n){
	if(n==0)
		return 1;
		else
			return fact(n-1)*n;				
	}
static long gcd(long s,long k){
	if(k==0)
		return s;
	if(s<0)
		return gcd(-s,k);
	if(k<0)
		return gcd(s,-k);
	return 
			gcd(k,s%k);
}
static long gcd(long a,long b,long c){
	return gcd(gcd(a,b),c);
}
static long multiple(int a,int b){
	return a*b/gcd(a,b);
}
static long fi(long n){
	if(n==0||n==1)
		return 1;
		else
	 return fi(n-1)+fi(n-2);
	
}
}

