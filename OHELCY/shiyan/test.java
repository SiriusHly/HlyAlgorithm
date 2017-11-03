package shiyan;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//ʵ��ѧ����Ϣ�Ĵ洢��ɾ������ҵȹ���
class Student{
	private String name,sex,stuNum,style,num;
	private static String filePath="C:/StuData/";
	//�޲ι��캯��
	public Student(){
		name=sex=stuNum=style=num="";
	}
	//���ι��캯��
	Student(String stuNum,String name,String sex,String num,String 

style){
		this.stuNum=stuNum;
		this.name=name;
		this.sex=sex;
		this.style=style;
		this.num=num;
	}
	
	public String getStuNum(){
		return stuNum;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSex(){
		return sex;
	}
	
	public String getNum(){
		return num;
	}
	
	public String getStyle(){
		return style;
	}
	//д���ļ���ʽ
	public String toString(){
		return stuNum+","+name+","+sex+","+num+","+style+"\r\n";
	}
	//����ı���
	public void save(){
		try{
		FileWriter wf=new FileWriter(filePath+getStuNum

()+".txt");
		char[] buffer=toString().toCharArray();
		wf.write(buffer);
		wf.close();
		JOptionPane.showMessageDialog(null,"����ɹ�!");
		}
		catch (Exception e) {Edit.tips("����ʧ��!");}
	}
	//�����ɾ��
	public static void Delete(String stuNum){
		File f=new File(filePath+stuNum+".txt");
		if(f.exists()){f.delete();JOptionPane.showMessageDialog

(null,"ɾ���ɹ�!");}
		else Edit.tips("�޸�ѧ����Ϣ!");
	}
	//����Ĳ���
	public static Student find(String stuNum){
		try{
        BufferedReader bfr=new BufferedReader(new FileReader(filePath

+stuNum+".txt"));
		String aim=bfr.readLine();
		String name,sex,style,num;
		String[] tmp=aim.split(",");
		name=tmp[1];sex=tmp[2];num=tmp[3];style=tmp[4];
		bfr.close();
		return new Student(stuNum,name,sex,num,style);
		}
		catch (Exception e) {
			return new Student();
		}
	}
	//�ж��Ƿ�Ϊ����
	public static boolean isInt(String aim){
		if(aim.length()==0)return false;
		for(int i=0;i<aim.length();i++)
			if(aim.charAt(i)>'9'||aim.charAt(i)<'0')return 

false;
		return true;
	}
}
//��������ʾ����
class Temp extends JFrame{
	private TextField stuNum;
	private JLabel tip;
	private JButton ok;
	Temp(String deal){
		super("����ѧ��");
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		stuNum=new TextField(20);
		tip=new JLabel("������Ҫ"+deal+"��ѧ��");
		tip.setForeground(Color.red);
		ok=new JButton("ȷ��");
		con.add(tip);
		con.add(stuNum);
		con.add(ok);
		setSize(220, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//��ȷ����ť��Ӽ��������Բ�ͬ������д���
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!Student.isInt(stuNum.getText())){
				Edit.tips("������������!");
				stuNum.setText(null);
				stuNum.requestFocus();
				}
				else if(deal.equals("ɾ��"))

{Student.Delete(stuNum.getText());dispose();}
				else{
					Student stu=Student.find

(stuNum.getText());
					if(stu.getStuNum().length()==0) 

Edit.tips("δ�ҵ���ѧ����Ϣ!");
					else{Edit edit=new Edit

(stu,deal);dispose();}
					}
			}
		});
	}
}
//����������޸ģ���ѯ����ʾ����
class Edit extends JFrame{
	private TextField stuNum,name,sex,num,style;
	private JButton save;
	private JLabel tip,t1,t2,t3,t4;
	Edit(Student stu,String deal){
		super(deal+"ѧ����Ϣ");
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		stuNum=new TextField(stu.getStuNum(),20);
		name=new TextField(stu.getName(),20);
		sex=new TextField(stu.getSex(),20);
		num=new TextField(stu.getNum(),20);
		style=new TextField(stu.getStyle(),20);
		save=new JButton("ȷ��");
		tip=new JLabel("����������������Ҫ"+deal+"��ѧ����Ϣ!������");
		tip.setForeground(Color.red);
		con.add(tip);
		con.add(new JLabel("����ѧ��:"));
		con.add(stuNum);
		con.add(new JLabel("��������:"));
		con.add(name);
		con.add(new JLabel("�����Ա�:"));
		con.add(sex);
		con.add(new JLabel("��Ȥ���:"));
		con.add(num);
		con.add(new JLabel("��Ȥ����:"));
		con.add(style);
		con.add(save);
		if(deal.equals("��ѯ")){
			stuNum.setEditable(false);
			name.setEditable(false);
			sex.setEditable(false);
			num.setEditable(false);
			style.setEditable(false);
		}
		setSize(300, 250);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//��ȷ����ť�����������ÿ�������Ƿ������������������б���
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(deal.equals("��ѯ"))dispose();
				else{
				if(!Student.isInt(stuNum.getText())){
					tips("������������ѧ��!");
					stuNum.setText

(null);stuNum.requestFocus();
					}
				else if(name.getText().length()==0){
					tips("������ѧ������!");
					name.setText

(null);name.requestFocus();
					}
				else if(!sex.getText().equals("��")&&!

sex.getText().equals("Ů")){
					tips("������'��'����'Ů'!");
					sex.setText

(null);sex.requestFocus();
				}
				else if(!Student.isInt(num.getText())){
					tips("��������������Ȥ���!");
					num.setText

(null);num.requestFocus();
					}
				else if(style.getText().length()==0){
					tips("��������Ȥ����!");
					style.setText

(null);style.requestFocus();
					}
			else {Student stu=new Student(stuNum.getText

(),name.getText(),sex.getText(),num.getText(),style.getText());
				stu.save();dispose();
			}
			}}
		});
	}

	//����������ʾ����
	public static void tips(String tip){
		JOptionPane.showMessageDialog(null,tip,"����",JOptionPane.ERROR_MESSAGE);
	}
}
//����������
class StudentMage extends JFrame{
	private JButton ad,mod,del,que;
	private JLabel tip;
	StudentMage(){
		super("������ȤС�����");
		File file = new File("C:\\StuData");//��ʼ��ʱ�����ļ������ļ���
		file.mkdir();
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		tip=new JLabel("��ӭ���ٿ�����ȤС�����ϵͳ!");
		tip.setForeground(Color.red);
		ad=new JButton("���ѧ����Ϣ");
		mod=new JButton("�޸�ѧ����Ϣ");
		del=new JButton("ɾ��ѧ����Ϣ");
		que=new JButton("��ѯѧ����Ϣ");
		con.add(tip);
		con.add(ad);
		con.add(mod);
		con.add(del);
		con.add(que);
		setSize(300, 150);
		setCenter();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//�ֱ�Ը�����ť��Ӽ���
		ad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Edit edit=new Edit(new Student(),"���");
			}
		});
		addLis(mod,"�޸�");
		addLis(del,"ɾ��");
		addLis(que,"��ѯ");
	}
	//��ť����
	public void addLis(JButton but,String t){
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Temp temp=new Temp(t);
			}
		});
	}
	//��������ʾ����Ļ����
	public void setCenter(){
		Dimension screenSize=Toolkit.getDefaultToolkit

().getScreenSize();
		int screenWidth=screenSize.width;
		int screenHeight=screenSize.height;
		Dimension frameSize=getSize();
		int x=(screenWidth-frameSize.width)/2;
		int y=(screenHeight-frameSize.height)/2;
		setLocation(x,y);
	}
}
//������
public class test {
	public static void main(String[] args){
		StudentMage a=new StudentMage();
	}
}
