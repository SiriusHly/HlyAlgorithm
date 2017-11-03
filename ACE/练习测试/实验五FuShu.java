package 练习测试;

public class 实验五FuShu {
int a,b;
	public 实验五FuShu(int a, int b) {
	this.a = a;
	this.b = b;
}
public void add1(实验五FuShu other){
	this.a+=other.a;
	this.b+=other.b;
}
public 实验五FuShu add(实验五FuShu other){
	return new  实验五FuShu(other.a+=a,other.b+=b);
}
public String toString(){
	return a+"+"+b+"i";
}
	public static void main(String[] args) {
实验五FuShu f1 = new 实验五FuShu(1,2);
实验五FuShu f2 = new 实验五FuShu(3,4);
f1.add(f2);
System.out.println(f1);
实验五FuShu f3 = new 实验五FuShu(1,3);
实验五FuShu f4 = new 实验五FuShu(3,5);
实验五FuShu s = f3.add(f4);
System.out.println(s.toString());
	}

}
