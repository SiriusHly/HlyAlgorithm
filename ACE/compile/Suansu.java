package compile;

public class Suansu {

	 int b;
	 int a;
	public Suansu() {
        this.a=10;//can don't use this.
        this.b=5;
	}
	 public int AddAB(int a,int b){//can direct to use AddAB().
		//this.a=a;
		//this.b=b;
		return a+b;	
	}
	 public int Sub(int a,int b){
		 this.a = a;
		 this.b = b;
		 return a-b;
	 }
	 public int MultiAB(int a,int b){
		 this.a = a;
		 this.b = b;
		 return a*b;
	 }
	 public double DivAB(int a,int b){
		 this.a = a;
		 this.b = b;
		 return (double)a>b?a/b:b/a;
	 }
	 

}
