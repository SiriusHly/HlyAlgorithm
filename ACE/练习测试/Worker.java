package ��ϰ����;

public class Worker extends Person {
public double salary;
	public Worker() {
	}

	public Worker(String name, int age, String sex,double salary) {
		super(name, age, sex);
		this.salary= salary;

	}
	public void print(){
		System.out.println(super.getName()+" "+super.getAge()+" "+super.getSex()+" "+salary);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public static void main(String[] args) {
Worker w1 = new Worker("����",25,"��",1600);
w1.print();
	}

}
