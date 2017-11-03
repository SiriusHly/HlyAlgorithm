package Á·Ï°²âÊÔ;

public class Baoma extends Car {
double speed;
	

	public Baoma() {
	}

	public Baoma(String type, String color, double sex,double speed) {
		super(type, color, sex);
		this.speed=speed;

	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
public void print(){
	System.out.println(super.getType()+" "+super.getColor()+" "+super.getSex()+" "+speed);
}
	public static void main(String[] args) {
Baoma baoma1 = new Baoma("ÈıÏá6×ù","ºìÉ«",9000,220);
baoma1.print();
	}

}
