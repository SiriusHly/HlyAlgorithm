package Huangliangyun;

public class FuShu {
private double a,b;//实部为a，虚部为b；
	public FuShu() {
	
	}
	public void set(double a, double b) {
		this.a = a;
		this.b = b;
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
	public void add(double a,double b){
		this.a+=a;
		this.b+=b;
	}
	public void minus(double a,double b){
		this.a-=a;
		this.b-=b;
	}
	public void print(){
		System.out.println("其结果为： "+this.a+"+"+this.b+"i");
	}
	

}
