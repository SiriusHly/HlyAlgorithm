package Á·Ï°²âÊÔ;

public class Car {
private String type;
private String color;
private double sex;
	public Car() {
	}
	

	public Car(String type, String color, double sex) {
		this.type = type;
		this.color = color;
		this.sex = sex;
	}
	


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getSex() {
		return sex;
	}


	public void setSex(double sex) {
		this.sex = sex;
	}
public void print(){
	System.out.println(type+" "+color+" "+sex);
}

	public static void main(String[] args) {
Car car1 = new Car("ÈýÏá5×ù","ºÚÉ«",8000);
car1.print();
	}

}
