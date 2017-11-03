package Problem;

public class A {
int m=0,n=0;
long f(){
	return m+n;
}
}
class B extends A{
	int m=1,n=1;
	long f(){
		long result=0;
		super.m=10;
		super.n=30;result=super.f()+(m+n);
		return result;
	}
	long g(){
		long result=0;
		result=super.f();
		return result/2;
	}
}
class Example{
	public static void main(String args[]){
		B b = new B();
		b.m=6;
		b.n=2;
		long resultOne=b.g();
		long resultTwo=b.f();
		long resultT=b.g();
		System.out.println("One="+resultOne+"Two="+resultTwo+" Three="+resultT);
	}
}
