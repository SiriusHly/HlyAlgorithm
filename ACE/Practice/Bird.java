package Practice;

public class Bird extends Animal {
public Bird(String name,int age,double weight){
	this.name=name;
	this.age=age;
	this.weight=weight;
}
public void showInfo(){
	System.out.println("name="+name+"  age="+age+"  weight="+weight);
}
	@Override
	public void move() {
//		 TODO Auto-generated method stub
		System.out.println(name+"fly in the sky");
	}

	@Override
	public void eat() {
		System.out.println(name+"love to eat pesiastic");
		
	}

}
