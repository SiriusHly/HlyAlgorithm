package AD_Book;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.InitialContext;

public class Test {
	static int m;
	static List<Student> listStudent = new ArrayList<Student>();
	static Scanner sc = new Scanner(System.in);

	public static void caidan() {
		System.out.println("欢迎使用课外兴趣小组管理系统！");
		System.out.println("1、添加学生信息");
		System.out.println("2、修改学生信息");
		System.out.println("3、删除学生信息");
		System.out.println("4、查询学生信息");
		System.out.println("5、显示全部信息");
		System.out.println("6、退出系统");
		System.out.println("请选择您所需要的操作：");
	}

	static void readDataFromFileToListStudent() {
		// 把文件中保存的学生信息读入到listStudent集合中
		try {
			BufferedReader bf = new BufferedReader(new FileReader("E:\\StuData\\student.txt")); // 文件通过FileReader打开，然后在BufferedReader中进行缓冲读取
			String ss = null;
			while ((ss = bf.readLine()) != null) // readLine()从文件（或控制台）读取一行输入
			{
				String[] strings = ss.split(",");
				String xuehao1 = null, name = null, sex = null, xqnum = null, xqLei = null;
				xuehao1 = strings[0];
				name = strings[1];
				sex = strings[2];
				xqnum = strings[3];
				xqLei = strings[4];
				listStudent.add(new Student(xuehao1, name, sex, xqnum, xqLei));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void writeListStudentToFile() throws IOException {
		// 把集合listStudent中的学生对象写到文件中
		FileWriter fw = null;
		fw = new FileWriter("E:\\StuData\\student.txt", true);
		try {
			PrintWriter pf = new PrintWriter(fw);
			for (int i = 0; i < listStudent.size(); i++) {
				pf.print(listStudent.get(i).toString());
			}
			pf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 添加学生信息
	public static boolean addStudent() throws IOException {
		Student stu = new Student();

		System.out.println("请输入您要添加学生的学号：");
		String xuehao = sc.next();
		stu.xuehao = xuehao;
		System.out.println("请输入学生的姓名：");
		String name = sc.next();
		stu.name = name;
		System.out.println("请输入学生的性别：");
		String sex = sc.next();
		stu.sex = sex;
		System.out.println("请输入学生的兴趣编号：");
		String xqnum = sc.next();
		stu.xqnum = xqnum;
		System.out.println("请输入学生的兴趣类型：");
		String xqLei = sc.next();
		stu.xqLei = xqLei;
		listStudent.add(stu);
		System.out.println("您已添加成功");
		return true;
	}
	// 判断学号是否存在的函数
		public static Student isExistXueHao(String xueHao) {
			for (int i = 0; i < listStudent.size(); i++) {
				if (listStudent.get(i).getXuehao().equals(xueHao)) {
					m = i;
					return listStudent.get(m);
				}
			}
			return null;
		}

		// 修改学生信息
		public static boolean modifyStudent() throws IOException {
			System.out.println("请输入您要修改的学生的学号：");
			String xueHao = sc.next();
			Student student = isExistXueHao(xueHao);
			if (student == null) {
				System.out.println("该学号不存在，不能修改");
				return false;
			}
			System.out.println("修改后的学号是：");
			student.xuehao = sc.next();
			System.out.println("修改后的姓名是：");
			student.name = sc.next();
			System.out.println("修改后的性别是：");
			student.sex = sc.next();
			System.out.println("修改后的兴趣编号是：");
			student.xqnum = sc.next();
			System.out.println("修改后的兴趣类型是：");
			student.xqLei = sc.next();
			System.out.println("您已修改成功");
			return true;
		}

		// 删除学生信息
		public static boolean shanchu() throws IOException {
			System.out.println("请输入您要删除的学生的学号：");
			String xuehao = sc.next();
			Student student = isExistXueHao(xuehao);
			if (student == null) {
				System.out.println("该学号不存在，不能删除");
				return false;
			}
			for (int i = 0; i < listStudent.size(); i++) {
				if (student.xuehao.equals(xuehao)) {
					listStudent.remove(student);
					FileWriter fw = null;
					fw = new FileWriter("E:\\StuData\\student.txt");
					try {
						PrintWriter pf = new PrintWriter(fw);
						for (int i1 = 0; i1 < listStudent.size(); i1++) {
							pf.print(listStudent.get(i1).toString());
						}
						pf.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

					try {
						fw.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
			System.out.println("删除成功");
			return true;

		}

		// 查询信息
		public static boolean chaxun() throws IOException {
			System.out.println("请输入您要查询学生的学号：");
			String xuehao = sc.next();
			Student student = isExistXueHao(xuehao);
			if (student == null) {
				System.out.println("该学号不存在，不能查询");
				return false;
			}
			System.out.println((listStudent.get(m).xuehao + "," + listStudent.get(m).name + "," + listStudent.get(m).sex
					+ "," + listStudent.get(m).xqnum +","+ listStudent.get(m).xqLei) + "\r\n");
			return true;
		}

		// 显示全部信息
		public static boolean xianshi() throws IOException {
			for (int i = 0; i < listStudent.size(); i++) {
				System.out.println((listStudent.get(i).xuehao + "," + listStudent.get(i).name + "," + listStudent.get(i).sex
						+ "," + listStudent.get(i).xqnum + ","+listStudent.get(i).xqLei) + "\r\n");
			}
			return true;
		}

		// 主函数
		public static void main(String[] args) throws FileNotFoundException {
			readDataFromFileToListStudent();
			Student s = new Student();
			Scanner cin = new Scanner(System.in);
			int choose1, flag = 1;
			while (flag == 1) {
				caidan();
				choose1 = cin.nextInt();
				switch (choose1) {
				case 1:
					try {
						addStudent();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						modifyStudent();
						switch (choose1) {

						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						shanchu();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 4:
					try {
						chaxun();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					try {
						xianshi();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 6:
					flag = 0;
					try {
						writeListStudentToFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("您已成功退出！");
					break;
				default:
					System.out.println("您的输入有误，请重新输入！");
					break;
				}
			}
		}
	}

	class Student {
		Scanner sc = new Scanner(System.in);
		String xuehao, name, sex, xqnum, xqLei;

		public String getXuehao() {
			return xuehao;
		}
		public void setXuehao(String xuehao) {
			this.xuehao = xuehao;
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
		public String getXqnum() {
			return xqnum;
		}
		public void setXqnum(String xqnum) {
			this.xqnum = xqnum;
		}
		public String getXqLei() {
			return xqLei;
		}
		public void setXqLei(String xqLei) {
			this.xqLei = xqLei;
		}

		public Student() {
		}
		public Student(String xuehao, String name, String sex, String xqnum, String xqLei) {
			this.xuehao = xuehao;
			this.name = name;
			this.sex = sex;
			this.xqnum = xqnum;
			this.xqLei = xqLei;
		}

		// 用文件写入格式
		public String toString() {
			return (xuehao + "," + name + "," + sex + "," + xqnum + "," + xqLei) + "\r\n";
		}
	}


