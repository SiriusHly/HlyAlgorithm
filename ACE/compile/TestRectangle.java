package compile;

public class TestRectangle {
	int length,width;
public static void main(String []args){
	Rectangle tp = new Rectangle();
	tp.setLength(40);
	tp.setWidth(89);
	System.out.println(tp.getArea());//如果里面有参数，要写       地址。参数
	System.out.println(tp.getPerimeter());
	tp.draw(tp.getLength(),tp.getWidth());
}

}
