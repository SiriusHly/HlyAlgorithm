package three_Hash;


/**
 * 
 * @author hly time :17.12.31 线性探测法处理冲突
 *
 */
public class StudentInformation_ {
	Student tab[];
	int size;

	public StudentInformation_(int size) {
		this.size = size;
		tab = new Student[size];
		
	}

	public boolean insert(Student stu) {
		int i = stu.getName().hashCode() % size;
		while (tab[i] != null) {
			i = (i + 1) % size;
		}
		tab[i] = stu;
		return true;
	}

	public Student search(String name) {
		int i = name.hashCode() % size;
		while (true) {
			if (tab[i].getName().equals(name))
				return tab[i];
			else if (tab[i] == null)
				return null;
			else
				i = (i + 1) % size;
		}
	}

	public boolean remove(String name) {

		int i = name.hashCode() % size;
		while (true) {
			if (tab[i].getName().equals(name)) {
				tab[i] = null;
				return true;
			} else if (tab[i] == null)
				return false;
			else
				i = (i + 1) % size;
		}
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			if (tab[i] != null)
				System.out.println("tab[" + i + "]" + tab[i].toString());
			else
				System.out.println("tab[" + i + "]无信息");
		}
	}

	public static void main(String[] arvs) {
		StudentInformation_ stuInfo = new StudentInformation_(15);

		for (int i = 1; i < 12; i++)
			stuInfo.insert(new Student("张" + i, "Java", "2016111040" + 3 * i, "男", "178651688" + 2 * i, "中国"));
		System.out.println("插入后:");
		stuInfo.display();
		System.out.println("删除后后:");
		stuInfo.remove("张6");
		stuInfo.display();
		System.out.println("查找:");
		System.out.println(stuInfo.search("张8"));
	}
}
