package ch9;

public class FuShu {
	private double a,b;
	public FuShu() {
		// TODO Auto-generated constructor stub
	}
	public FuShu(double a, double b) {
		this.a = a;
		this.b = b;
	}
	public FuShu add(FuShu other){
		//����other���Լ����䣬����һ���µĸ���
		return new FuShu(a+other.a,b+other.b);//aǰ��û��this
		
		
	}
	public void add1(FuShu other){
		//������Լ�����µĸ��������Լ�����other�������
		this.a+=other.a;
		this.b+=other.b;
		//������Լ�����µĸ��������Լ�����other�������
				/*this.a+=other.a;
				this.b+=other.b;*/
		
	}
	public FuShu add(FuShu fs1,FuShu fs2){
		return new FuShu(fs1.a+fs2.a,fs1.b+fs2.b);
	}
	public static void main(String[] args) {
		FuShu fs1=new FuShu(3,4);
		FuShu fs2=new FuShu(8,10);
		System.out.println("fs1="+fs1.toString1());
		fs1.add1(fs2);
		System.out.println("fs1="+fs1.toString1());//������Լ���
		System.out.println("fs2="+fs2.toString1());
		FuShu fs3=new FuShu(3,4);
		FuShu fs4=new FuShu(8,10);
		FuShu s =fs3.add(fs4);
		System.out.println("fs3="+fs3.toString1());//������Լ�����
		System.out.println("s="+s.toString1());//���
        FuShu fs5 = new FuShu();
        FuShu s2 = fs5.add(new FuShu(1,2),new FuShu(3,5));
        System.out.println("s2="+s2.toString1());
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

	
	public String toString1(){
		return a+"+"+b+"i";
	}

}
