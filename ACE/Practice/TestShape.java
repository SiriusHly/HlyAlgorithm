package Practice;

public class TestShape {

	public TestShape() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Shape s[] = new Shape[3];
		s[0]= new Circle1(3.5);
		s[1] = new Rectangle(4,5);
		for(int i=0;i<s.length-1;i++){
			System.out.println(s[i].area());
		}

	}

}
