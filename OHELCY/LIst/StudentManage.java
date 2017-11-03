package LIst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StudentManage {
	static Scanner sc=new Scanner(System.in);
	static List<Department> listDepartment=new ArrayList<Department>();
	static List<Student> listStudent=new ArrayList<Student>();
	public static void addDepartment(Department department){
		//将department放入到listDepartment集合中
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
		//遍历listDepartment集合，找到要删除的department对象，将其从集合中删除注意：如果学生集合中已经有某个学生是这个学院的，那么应该做判断，不允许删除，否则学生的学院就不合理了。
		for(int i=0;i<listDepartment.size();i++){
			if(listDepartment.get(i).equals(department)){
				int s=i;
				listDepartment.remove(listDepartment.get(s));
			}
		}
	}*/
	public static void deleteDepartment(String departmentid){
		//遍历listDepartment集合，找到要删除的department对象，将其从集合中删除注意：如果学生集合中已经有某个学生是这个学院的，那么应该做判断，不允许删除，否则学生的学院就不合理了。
		for(int i=0;i<listDepartment.size();i++){
			if(listDepartment.get(i).getDepartmentID().equals(departmentid)){
				int s=i;
				listDepartment.remove(listDepartment.get(s));
				System.out.println("删除成功");
			}
		}
	}
	public void modifyDepartment(String departmentID,Department newDepartment){
		//遍历listDepartment集合，找到编号为departmentID的department对象，将其替换为newDepartment注意：修改了后，要把学生集合中的该学院对象都对应修改
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
		//遍历listDepartment集合，找到编号为departmentID的department对象，将其返回。
		for(int i=0;i<listDepartment.size();i++){
			if(listDepartment.get(i).getDepartmentID().equals(departmentID)){
				int u=i;
				return listDepartment.get(u);
			}
		}
		return null;
	}
	public Department getDepartmentByDempartmentName(String departmentName){
		//遍历listDepartment集合，找到学院名称为departmentName的department对象，将其返回。
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
	//。。。
	public void addStudent(Student student){
		//将student放入到liststudent集合中
		listStudent.add(student);
	}
	public void deleteStudent(Student student){
		//遍历listStudentID集合，找到要删除的student对象，将其从集合中删除
		for(int i=0;i<listStudent.size();i++){
			if(listStudent.get(i)==student){
				int m=i;
				listStudent.remove(m);
			}
		}
	}
	public void modifyStudent(String studentID,Student newStudent){
		//遍历listStudentID集合，找到编号为studentID的student对象，将其替换为newStudent
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
		//遍历listStudentID集合，找到编号为studentID的student对象，将其返回。
		for(int i=0;i<listStudent.size();i++){
			if(listStudent.get(i).getId().equals(StudentID)){
				int t = i;
				return listStudent.get(t);
			}
		}
		return null;
	}
	public Student getStudentByStudentName(String studentName){
		//遍历listStudentID集合，找到学院名称为studentName的student对象，将其返回。
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
		System.out.println("请选择你要的功能，输入（1，2，3...");
		System.out.println("1 添加学院");
		System.out.println("2 查询学院所有信息");
		System.out.println("3 删除学院信息");
		//。。。其他功能
		System.out.println("0 退出");
		return sc.next();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//显示菜单，接收用户输入
		while(true){
			String choice=showMenu();
			if(choice.equals("1")){
				//让用户输入学院编号、学院名称，
				System.out.println("请输入学院名称：");
				String s1=sc.next();
				String s2=sc.next();
				Department department=new Department(s1,s2);
				//调用addDepartment(department);
				addDepartment(department);
			}
			else if(choice.equals("2")){
				//...
				InquryDEpartment();
			}
			else if(choice.equals("3")){
				//...
				Department department=new Department();
				System.out.println("请输入学院号：");
				String s3=sc.next();
				deleteDepartment(s3);
				
			}
			
			else if(choice.equals("0")){
				System.exit(0);//退出系统
			}
		}
	}

}
