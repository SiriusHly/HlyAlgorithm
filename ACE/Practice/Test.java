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
Parentclass pp = c;//�����ChildClass��ʵ��c��ֵ��ParentClass��ʵ��pp��ʲô��˼
ChildClass cc = (ChildClass)pp;//�����ǰ�ppǿ��ת����Childclass���Ͳ���ֵ��cc��
//�����е��ң�����pp��cc�ֱ������ʲô
System.out.println(pp.sum(5, 5));//11 sum�������඼�У�������ֵ��ͬ��Ϊʲô���н����ͬ
System.out.println(cc.sum(5,5));//11
System.out.println(cc.x);//1  ������Ľ��Ϊʲô���ǲ�ͬ��
System.out.println(pp.x);//0
	}
}

