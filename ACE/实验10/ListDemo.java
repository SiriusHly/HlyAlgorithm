/**
 * 
 */
package ʵ��10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hly
 *
 */
public class ListDemo {

	public ListDemo() {
	}

	public static void main(String[] args) {
		List<Student> list1 = new ArrayList<Student>();
		list1.add(new Student("����", "��", 20));
		list1.add(new Student("����", "��", 22));
		for (int hly = 0; hly < list1.size(); hly++) {
			System.out.print(list1.get(hly));
			System.out.println();
			
		}
		/*for(Login str :list1){
			System.out.print(str);
			System.out.println();
		}*/
		List<String> list2 = new ArrayList<String>();
		list2.add("aaa");
		list2.add("bbb");
		for(String str :list2){
			System.out.print(str);
			System.out.println();
		}
		LinkedList<Student> list3 = new LinkedList<Student>();
		list3.addFirst(new Student("����","��",23));
		list3.add(new Student("����","��",24));
		list3.addFirst(new Student("����","��",25));
		list3.addLast(new Student("����","��",26));
		for(Student str :list3){
			System.out.print(str);
			System.out.println();
		}
	}

}
