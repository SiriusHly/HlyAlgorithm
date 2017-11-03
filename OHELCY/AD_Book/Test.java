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
		System.out.println("��ӭʹ�ÿ�����ȤС�����ϵͳ��");
		System.out.println("1�����ѧ����Ϣ");
		System.out.println("2���޸�ѧ����Ϣ");
		System.out.println("3��ɾ��ѧ����Ϣ");
		System.out.println("4����ѯѧ����Ϣ");
		System.out.println("5����ʾȫ����Ϣ");
		System.out.println("6���˳�ϵͳ");
		System.out.println("��ѡ��������Ҫ�Ĳ�����");
	}

	static void readDataFromFileToListStudent() {
		// ���ļ��б����ѧ����Ϣ���뵽listStudent������
		try {
			BufferedReader bf = new BufferedReader(new FileReader("E:\\StuData\\student.txt")); // �ļ�ͨ��FileReader�򿪣�Ȼ����BufferedReader�н��л����ȡ
			String ss = null;
			while ((ss = bf.readLine()) != null) // readLine()���ļ��������̨����ȡһ������
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
		// �Ѽ���listStudent�е�ѧ������д���ļ���
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

	// ���ѧ����Ϣ
	public static boolean addStudent() throws IOException {
		Student stu = new Student();

		System.out.println("��������Ҫ���ѧ����ѧ�ţ�");
		String xuehao = sc.next();
		stu.xuehao = xuehao;
		System.out.println("������ѧ����������");
		String name = sc.next();
		stu.name = name;
		System.out.println("������ѧ�����Ա�");
		String sex = sc.next();
		stu.sex = sex;
		System.out.println("������ѧ������Ȥ��ţ�");
		String xqnum = sc.next();
		stu.xqnum = xqnum;
		System.out.println("������ѧ������Ȥ���ͣ�");
		String xqLei = sc.next();
		stu.xqLei = xqLei;
		listStudent.add(stu);
		System.out.println("������ӳɹ�");
		return true;
	}
	// �ж�ѧ���Ƿ���ڵĺ���
		public static Student isExistXueHao(String xueHao) {
			for (int i = 0; i < listStudent.size(); i++) {
				if (listStudent.get(i).getXuehao().equals(xueHao)) {
					m = i;
					return listStudent.get(m);
				}
			}
			return null;
		}

		// �޸�ѧ����Ϣ
		public static boolean modifyStudent() throws IOException {
			System.out.println("��������Ҫ�޸ĵ�ѧ����ѧ�ţ�");
			String xueHao = sc.next();
			Student student = isExistXueHao(xueHao);
			if (student == null) {
				System.out.println("��ѧ�Ų����ڣ������޸�");
				return false;
			}
			System.out.println("�޸ĺ��ѧ���ǣ�");
			student.xuehao = sc.next();
			System.out.println("�޸ĺ�������ǣ�");
			student.name = sc.next();
			System.out.println("�޸ĺ���Ա��ǣ�");
			student.sex = sc.next();
			System.out.println("�޸ĺ����Ȥ����ǣ�");
			student.xqnum = sc.next();
			System.out.println("�޸ĺ����Ȥ�����ǣ�");
			student.xqLei = sc.next();
			System.out.println("�����޸ĳɹ�");
			return true;
		}

		// ɾ��ѧ����Ϣ
		public static boolean shanchu() throws IOException {
			System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
			String xuehao = sc.next();
			Student student = isExistXueHao(xuehao);
			if (student == null) {
				System.out.println("��ѧ�Ų����ڣ�����ɾ��");
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
			System.out.println("ɾ���ɹ�");
			return true;

		}

		// ��ѯ��Ϣ
		public static boolean chaxun() throws IOException {
			System.out.println("��������Ҫ��ѯѧ����ѧ�ţ�");
			String xuehao = sc.next();
			Student student = isExistXueHao(xuehao);
			if (student == null) {
				System.out.println("��ѧ�Ų����ڣ����ܲ�ѯ");
				return false;
			}
			System.out.println((listStudent.get(m).xuehao + "," + listStudent.get(m).name + "," + listStudent.get(m).sex
					+ "," + listStudent.get(m).xqnum +","+ listStudent.get(m).xqLei) + "\r\n");
			return true;
		}

		// ��ʾȫ����Ϣ
		public static boolean xianshi() throws IOException {
			for (int i = 0; i < listStudent.size(); i++) {
				System.out.println((listStudent.get(i).xuehao + "," + listStudent.get(i).name + "," + listStudent.get(i).sex
						+ "," + listStudent.get(i).xqnum + ","+listStudent.get(i).xqLei) + "\r\n");
			}
			return true;
		}

		// ������
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
					System.out.println("���ѳɹ��˳���");
					break;
				default:
					System.out.println("���������������������룡");
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

		// ���ļ�д���ʽ
		public String toString() {
			return (xuehao + "," + name + "," + sex + "," + xqnum + "," + xqLei) + "\r\n";
		}
	}


