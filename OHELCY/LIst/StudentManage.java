package LIst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentManage {
	static Scanner sc=new Scanner(System.in);
	static List<Department> listDepartment=new ArrayList<Department>();
	static List<Student> listStudent=new ArrayList<Student>();
	public static void addDepartment(Department department){
		//��department���뵽listDepartment������
		/*department.getDepartmentID();
		department.getDepartmentName();*/
		listDepartment.add(department);
	}
	public static void InquryDEpartment(){
		for(int i=0;i<listDepartment.size();i++){
			System.out.print(listDepartment.get(i).getDepartmentID());
			System.out.print(" ");
			System.out.print(listDepartment.get(i).getDepartmentName());
			System.out.println();
			
		}
	}
	/*public static void deleteDepartment(Department department){
		//����listDepartment���ϣ��ҵ�Ҫɾ����department���󣬽���Ӽ�����ɾ��ע�⣺���ѧ���������Ѿ���ĳ��ѧ�������ѧԺ�ģ���ôӦ�����жϣ�������ɾ��������ѧ����ѧԺ�Ͳ������ˡ�
		for(int i=0;i<listDepartment.size();i++){
			if(listDepartment.get(i).equals(department)){
				int s=i;
				listDepartment.remove(listDepartment.get(s));
			}
		}
	}*/
	public static void deleteDepartment(String departmentid){
		//����listDepartment���ϣ��ҵ�Ҫɾ����department���󣬽���Ӽ�����ɾ��ע�⣺���ѧ���������Ѿ���ĳ��ѧ�������ѧԺ�ģ���ôӦ�����жϣ�������ɾ��������ѧ����ѧԺ�Ͳ������ˡ�
		for(int i=0;i<listDepartment.size();i++){
			if(listDepartment.get(i).getDepartmentID().equals(departmentid)){
				int s=i;
				listDepartment.remove(listDepartment.get(s));
				System.out.println("ɾ���ɹ�");
			}
		}
	}
	public void modifyDepartment(String departmentID,Department newDepartment){
		//����listDepartment���ϣ��ҵ����ΪdepartmentID��department���󣬽����滻ΪnewDepartmentע�⣺�޸��˺�Ҫ��ѧ�������еĸ�ѧԺ���󶼶�Ӧ�޸�
		for(int i=0;i<listDepartment.size();i++){
			if(listDepartment.get(i).getDepartmentID().equals(departmentID)){
				int y = i;
				//newDepartment =new Department();
				listDepartment.get(y).setDepartmentName(newDepartment.getDepartmentName());
				listDepartment.get(y).setDepartmentID(newDepartment.getDepartmentID());
			}
		}
	}
	public Department getDepartmentByDempartmentID(String departmentID){
		//����listDepartment���ϣ��ҵ����ΪdepartmentID��department���󣬽��䷵�ء�
		for(int i=0;i<listDepartment.size();i++){
			if(listDepartment.get(i).getDepartmentID().equals(departmentID)){
				int u=i;
				return listDepartment.get(u);
			}
		}
		return null;
	}
	public Department getDepartmentByDempartmentName(String departmentName){
		//����listDepartment���ϣ��ҵ�ѧԺ����ΪdepartmentName��department���󣬽��䷵�ء�
		for(int i=0;i<listDepartment.size();i++){
			if(listDepartment.get(i).getDepartmentName().equals(departmentName)){
				int n = i;
				return listDepartment.get(n);
			}
		}
		return null;
	}
	public List<Department> DepartmentBy(){//??
		return listDepartment;
	}
	//������
	public void addStudent(Student student){
		//��student���뵽liststudent������
		listStudent.add(student);
	}
	public void deleteStudent(Student student){
		//����listStudentID���ϣ��ҵ�Ҫɾ����student���󣬽���Ӽ�����ɾ��
		for(int i=0;i<listStudent.size();i++){
			if(listStudent.get(i)==student){
				int m=i;
				listStudent.remove(m);
			}
		}
	}
	public void modifyStudent(String studentID,Student newStudent){
		//����listStudentID���ϣ��ҵ����ΪstudentID��student���󣬽����滻ΪnewStudent
		for(int i=0;i<listStudent.size();i++){
			if(listStudent.get(i).getId().equals(studentID)){
				int r = i;
				listStudent.get(r).setId(newStudent.getId());
				listStudent.get(r).setName(newStudent.getName());
				listStudent.get(r).setSex(newStudent.getSex());
			}
		}
	}
	public Student getStudentByStudentID(String StudentID){
		//����listStudentID���ϣ��ҵ����ΪstudentID��student���󣬽��䷵�ء�
		for(int i=0;i<listStudent.size();i++){
			if(listStudent.get(i).getId().equals(StudentID)){
				int t = i;
				return listStudent.get(t);
			}
		}
		return null;
	}
	public Student getStudentByStudentName(String studentName){
		//����listStudentID���ϣ��ҵ�ѧԺ����ΪstudentName��student���󣬽��䷵�ء�
		for(int i=0;i<listStudent.size();i++){
			if(listStudent.get(i).getId().equals(studentName)){
				int g = i;
				return listStudent.get(g);
			}
		}
		return null;
	}
	public List<Student> getAllStudent(){
		return listStudent;
	}
	public static String showMenu(){
		System.out.println("��ѡ����Ҫ�Ĺ��ܣ����루1��2��3...");
		System.out.println("1 ���ѧԺ");
		System.out.println("2 ��ѯѧԺ������Ϣ");
		System.out.println("3 ɾ��ѧԺ��Ϣ");
		//��������������
		System.out.println("0 �˳�");
		return sc.next();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ʾ�˵��������û�����
		while(true){
			String choice=showMenu();
			if(choice.equals("1")){
				//���û�����ѧԺ��š�ѧԺ���ƣ�
				System.out.println("������ѧԺ���ƣ�");
				String s1=sc.next();
				String s2=sc.next();
				Department department=new Department(s1,s2);
				//����addDepartment(department);
				addDepartment(department);
			}
			else if(choice.equals("2")){
				//...
				InquryDEpartment();
			}
			else if(choice.equals("3")){
				//...
				Department department=new Department();
				System.out.println("������ѧԺ�ţ�");
				String s3=sc.next();
				deleteDepartment(s3);
				
			}
			
			else if(choice.equals("0")){
				System.exit(0);//�˳�ϵͳ
			}
		}
	}

}
