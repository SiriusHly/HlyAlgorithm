package ��ϰ����;

public class ʵ����FuShu {
int a,b;
	public ʵ����FuShu(int a, int b) {
	this.a = a;
	this.b = b;
}
public void add1(ʵ����FuShu other){
	this.a+=other.a;
	this.b+=other.b;
}
public ʵ����FuShu add(ʵ����FuShu other){
	return new  ʵ����FuShu(other.a+=a,other.b+=b);
}
public String toString(){
	return a+"+"+b+"i";
}
	public static void main(String[] args) {
ʵ����FuShu f1 = new ʵ����FuShu(1,2);
ʵ����FuShu f2 = new ʵ����FuShu(3,4);
f1.add(f2);
System.out.println(f1);
ʵ����FuShu f3 = new ʵ����FuShu(1,3);
ʵ����FuShu f4 = new ʵ����FuShu(3,5);
ʵ����FuShu s = f3.add(f4);
System.out.println(s.toString());
	}

}
