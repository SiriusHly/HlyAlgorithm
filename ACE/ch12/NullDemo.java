package ch12;

public class NullDemo {
	Car myCar;
	public NullDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NullDemo nd=new NullDemo();
		try{
			int a=3,b=2,c=0;
			c=a/b;
			nd.myCar.startEngine();
			
			System.out.println("��ʼ�����������ɹ�");
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("������Ȼ�������У�û���Զ��˳�");
	}

}
class Car{
	String color,type;

	public Car(String color, String type) {
		super();
		this.color = color;
		this.type = type;
	}
	public void startEngine(){
		System.out.println("��ʼ����������");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
