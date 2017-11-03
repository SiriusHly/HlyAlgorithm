package Practice;

class Parentclass{
	int  x = 0;
	int sum(int a,int b){
		return a+b;
	}
	int sub(int a,int b){
		return a-b;
	}
}
	class ChildClass extends Parentclass{
		int x = 1;
		int y =2;
		int sum(int a,int b){
			return a+b+1;
		}
		int multi(int a,int b){
			return a*b;
		}
	}

public class Test {
	public static void main(String[] args) {
Parentclass p = new Parentclass();
ChildClass c = new ChildClass();
Parentclass pp = c;//这里把ChildClass的实例c赋值给ParentClass的实例pp是什么意思
ChildClass cc = (ChildClass)pp;//这里是把pp强制转换成Childclass类型并赋值给cc吗。
//上面有点乱，这样pp和cc分别代表了什么
System.out.println(pp.sum(5, 5));//11 sum父类子类都有，但返回值不同，为什么运行结果相同
System.out.println(cc.sum(5,5));//11
System.out.println(cc.x);//1  这两项的结果为什么又是不同的
System.out.println(pp.x);//0
	}
}

