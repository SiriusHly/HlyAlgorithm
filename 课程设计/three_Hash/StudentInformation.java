package three_Hash;

import java.util.LinkedList;
/**
 * 
 * @author ������
 * time:17.12.31
 * ����ַ�������ͻ
 */
public class StudentInformation {
	public LinkedList<Student> tab[];

	public StudentInformation(int size) {
		this.tab = new LinkedList[size];
		for(int i =0;i<size;i++)
			tab[i] = new LinkedList<Student>();
	}
	
	public int hash(int key){
		return key%tab.length;
	}
	
	public void insert(Student stu){
		String name = stu.getName();
		int hashnumber = name.hashCode();
		int i = hash(hashnumber);
		tab[i].add(0,stu);
	}
	
	public void displayTab(){
		for(int i=0;i<tab.length;i++){
			System.out.println("tab["+i+"]");
		for(Student stu:tab[i])
			System.out.println(stu.toString());
		}
	}
	
	//�������ֲ��Ҷ���
	public Student search(String name){
		int hashnumber = name.hashCode();
		int i = hash(hashnumber);
		for(Student stu:tab[i]){
			if(stu.getName().equals(name))
				return stu;
		}
		return null;
	}
	
	public boolean remove(String name){
		int hashnumber = name.hashCode();
		int i = hash(hashnumber);
		for(Student stu:tab[i]){
			if(stu.getName().equals(name))
				tab[i].remove(stu);
				return true;
		}
		return false;
	}
	
	public static void main(String[]arvs){
		StudentInformation stuInfo = new StudentInformation(6);
		for(int i =1 ;i<12;i++)
			stuInfo.insert(new Student("��"+i, "Java", "2016111040"+3*i, "��", "178651688"+2*i, "�й�"));
		System.out.println("�����:");
		stuInfo.displayTab();
		System.out.println("��10".hashCode()%6);
		System.out.println(stuInfo.remove("��11"));
		System.out.println("ɾ����:");
		stuInfo.displayTab();
		System.out.println("����:");
		System.out.println(stuInfo.search("��8").toString());
	}

}

