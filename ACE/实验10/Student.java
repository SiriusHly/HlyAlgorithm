/**
 * 
 */
package 实验10;

/**
 * @author hly
 *
 */
public class Student {
	String name, sex;
	int age;

	public Student(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public Student() {

	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*public String toString() {
		return "姓名: " + name + "性別: " + sex + "年齡: " + age;
	}*/

	public static void main(String[] args) {

	}

}
