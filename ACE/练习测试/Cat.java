package 练习测试;

public class Cat {
private static int sid=0;
private String name;
static int  id;
	public Cat(String name) {
		this.name=name;
		/*sid++;
		id=sid;*/
		id=sid++;//先执行id=sid后，sid再++；
	}
public void info(){
	System.out.println(name+" "+id);
}
public static void main(String []a){
	Cat.sid=100;
	Cat mimi = new Cat("mimi");//
	mimi.sid=2000;
	Cat pipi = new Cat ("pipi");
	mimi.info();
	pipi.info();
}
}
