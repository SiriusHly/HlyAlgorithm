package Practice;
class Outer {
String name;
int i;

	public Outer() {
		name="outer";
		i=20;
	}
	class Inner{
		String name;
		int i;
		public Inner(){
			name="inner";
			i=10;
		}
		public void printInfo(){
			System.out.println(Outer.this.name+" "+ Outer.this.i);
			System.out.println(name+" "+i);
		}
	}

}
public class TestOuter{
	public static void main(String args[]){
		Outer o =new Outer();
		Outer.Inner i = o.new Inner();
		i.printInfo();
	}
}
