package Practice;

public abstract class Animal<astract> {
public String name;
public int age;
public double weight;
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	public void showInfo() {
		System.out.println("name="+name+"  age="+age+"  weight="+weight);
	}
	public abstract void move();
	public abstract void eat();

}
