package ¾­µä´úÂë;

public class FuShu {
private double a,b;
	public FuShu() {
	}
	public FuShu add(FuShu other){
		this.a+=other.a;
		this.b+=other.b;
		return this;
	}
	public void add1(FuShu other){
		this.a+=other.a;
		this.b+=other.b;
	}
	public FuShu add(FuShu f1,FuShu f2){
		return new FuShu(f1.a+f2.a,f1.b+f2.b);
	}

	public static void main(String[] args) {
   FuShu f1 = new FuShu(3,4);
    FuShu f2 = new FuShu(8,10);
    System.out.println("f1="+f1.toString());
    f1.add1(f2);
    System.out.println("f1="+f1);
    System.out.println("f2="+f2);
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public FuShu(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}
	public String toString(){
		return a+"+"+b+"i";
	}

}
