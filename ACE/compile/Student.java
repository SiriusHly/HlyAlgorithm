package compile;
public class Student {
private String name;
private int age;
	public Student() {
	}
public Student(String name) {
		name = "no neme";
		age = 0;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public boolean isSameAge(Student s){
	if(this.age==s.age){//thinking  if this.age(change to s1.age) = s2.age
		return true;
	}
	return false;
}
public static void main(String arvs[]){
	Student s1 = new Student();
	s1.setName("zhangshuan");
	s1.setAge(20);
	System.out.println(s1.getName());
	System.out.println(s1.getAge());
	Student s2 = new Student();
	s2.setAge(20);
	System.out.println("same?"+s1.isSameAge(s2)+s2.age);
	
}


}
