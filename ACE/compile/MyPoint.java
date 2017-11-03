package compile;

public class MyPoint {
private int x;
private int y;
	public MyPoint() {
		x = 0;
		y = 0;
	}
	public MyPoint(int x,int y){
		this.x = x;
		this.y = y;
	}
	float getD(MyPoint p){
		return (float)Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
	}
	public static void main(String []args){
		MyPoint p1 = new MyPoint(2,3);//先给构造方法复制了
		MyPoint p2 = new MyPoint(4,5);
	
		System.out.println(p1.getD(p2));
	}

}
