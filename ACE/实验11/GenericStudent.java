package 实验11;

public class GenericStudent<T, V> {
	T name;
	V age;

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public V getAge() {
		return age;
	}

	public void setAge(V age) {
		this.age = age;
	}

	public void print() {
		System.out.println("名字:"+name+" 年龄:"+age);
	}

	public GenericStudent(T name, V age) {
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) {
    GenericStudent<String, Integer> s1 = new GenericStudent<String, Integer>("张三", 20);
    s1.setName("李四");
    s1.setAge(30);
    s1.print();
	}

}
