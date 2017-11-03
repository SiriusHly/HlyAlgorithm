package 实验10;



import java.util.ArrayList;
import java.util.List;
public class ListSort {
	public static <T extends Comparable<? super T>> void paiXu(List<T> list){
		T temp;
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.size();j++){
				if(list.get(i).compareTo(list.get(j))>0){
					temp=list.get(i);
					list.set(i,list.get(j));
					list.set(j,temp);
				}
			}
		}
	}
	public static void main(String[] args) {
		List<Employee1> list1=new ArrayList<Employee1>();
		list1.add(new Employee1("Tom",2000));
		list1.add(new Employee1("Lily",3000));
		list1.add(new Employee1("David",1000));
		paiXu(list1);
		for(int i=0;i<list1.size();i++)
			System.out.println(list1.get(i));
		List<Employee1> list2=new ArrayList<Employee1>();
		list2.add(new Manager1("Tom",2000,"1个"));
		list2.add(new Manager1("Lily",3000,"2个"));
		list2.add(new Manager1("David",1000,"3个"));
		paiXu(list2);
		for(int i=0;i<list2.size();i++)
			System.out.println(list2.get(i));
	}
}
class Employee1 implements Comparable<Employee1> {
	String name;
	int wage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public Employee1(){
		
	}
	public Employee1(String name,int wage){
		this.name=name;
		this.wage=wage;
	}
	public String toString() {
		return "[姓名：" + name + ", 工资：" + wage + "]";
	}
	
	public int compareTo(Employee1 e) {
		// TODO Auto-generated method stub
		return this.wage-e.wage;
	}

}

class Manager1 extends Employee1{
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Manager1(String name,int wage,String phone){
		super(name,wage);this.phone=phone;
	}
	public String toString() {
		return "[姓名："+name+"工资："+wage+"手机：" + phone + "]";
	}
}
