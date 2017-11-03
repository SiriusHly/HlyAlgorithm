package compile;

public class TestSuansu {
	public static void main(String[]args){
	int  a = 0,b = 0;
	Suansu tp = new Suansu();
	System.out.println(tp.AddAB(tp.a,tp.b));//need to add tp.
	System.out.println(tp.Sub(tp.a,tp.b));
	System.out.println(tp.MultiAB(tp.a,tp.b));
	System.out.println((double)tp.DivAB(tp.a,tp.b));
	}
}
