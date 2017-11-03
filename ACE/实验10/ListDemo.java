/**
 * 
 */
package 实验10;

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
		list1.add(new Student("张三", "男", 20));
		list1.add(new Student("李四", "男", 22));
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
		list3.addFirst(new Student("王五","男",23));
		list3.add(new Student("王六","男",24));
		list3.addFirst(new Student("王七","男",25));
		list3.addLast(new Student("王九","男",26));
		for(Student str :list3){
			System.out.print(str);
			System.out.println();
		}
	}

}
