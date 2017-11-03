package shiyan;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//实现学生信息的存储、删除与查找等功能
class Student{
	private String name,sex,stuNum,style,num;
	private static String filePath="C:/StuData/";
	//无参构造函数
	public Student(){
		name=sex=stuNum=style=num="";
	}
	//含参构造函数
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
	//写入文件格式
	public String toString(){
		return stuNum+","+name+","+sex+","+num+","+style+"\r\n";
	}
	//对象的保存
	public void save(){
		try{
		FileWriter wf=new FileWriter(filePath+getStuNum

()+".txt");
		char[] buffer=toString().toCharArray();
		wf.write(buffer);
		wf.close();
		JOptionPane.showMessageDialog(null,"保存成功!");
		}
		catch (Exception e) {Edit.tips("保存失败!");}
	}
	//对象的删除
	public static void Delete(String stuNum){
		File f=new File(filePath+stuNum+".txt");
		if(f.exists()){f.delete();JOptionPane.showMessageDialog

(null,"删除成功!");}
		else Edit.tips("无该学生信息!");
	}
	//对象的查找
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
	//判断是否为整数
	public static boolean isInt(String aim){
		if(aim.length()==0)return false;
		for(int i=0;i<aim.length();i++)
			if(aim.charAt(i)>'9'||aim.charAt(i)<'0')return 

false;
		return true;
	}
}
//弹出的提示窗口
class Temp extends JFrame{
	private TextField stuNum;
	private JLabel tip;
	private JButton ok;
	Temp(String deal){
		super("输入学号");
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		stuNum=new TextField(20);
		tip=new JLabel("请输入要"+deal+"的学号");
		tip.setForeground(Color.red);
		ok=new JButton("确定");
		con.add(tip);
		con.add(stuNum);
		con.add(ok);
		setSize(220, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//对确定按钮添加监听，并对不同情况进行处理
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!Student.isInt(stuNum.getText())){
				Edit.tips("请输入正整数!");
				stuNum.setText(null);
				stuNum.requestFocus();
				}
				else if(deal.equals("删除"))

{Student.Delete(stuNum.getText());dispose();}
				else{
					Student stu=Student.find

(stuNum.getText());
					if(stu.getStuNum().length()==0) 

Edit.tips("未找到该学生信息!");
					else{Edit edit=new Edit

(stu,deal);dispose();}
					}
			}
		});
	}
}
//对象操作，修改，查询等显示窗口
class Edit extends JFrame{
	private TextField stuNum,name,sex,num,style;
	private JButton save;
	private JLabel tip,t1,t2,t3,t4;
	Edit(Student stu,String deal){
		super(deal+"学生信息");
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		stuNum=new TextField(stu.getStuNum(),20);
		name=new TextField(stu.getName(),20);
		sex=new TextField(stu.getSex(),20);
		num=new TextField(stu.getNum(),20);
		style=new TextField(stu.getStyle(),20);
		save=new JButton("确定");
		tip=new JLabel("　　　　下面是您要"+deal+"的学生信息!　　　");
		tip.setForeground(Color.red);
		con.add(tip);
		con.add(new JLabel("　　学号:"));
		con.add(stuNum);
		con.add(new JLabel("　　姓名:"));
		con.add(name);
		con.add(new JLabel("　　性别:"));
		con.add(sex);
		con.add(new JLabel("兴趣编号:"));
		con.add(num);
		con.add(new JLabel("兴趣类型:"));
		con.add(style);
		con.add(save);
		if(deal.equals("查询")){
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
		//对确定按钮监听，并检查每个输入是否符合条件，并对其进行保存
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(deal.equals("查询"))dispose();
				else{
				if(!Student.isInt(stuNum.getText())){
					tips("请输入正整数学号!");
					stuNum.setText

(null);stuNum.requestFocus();
					}
				else if(name.getText().length()==0){
					tips("请输入学生姓名!");
					name.setText

(null);name.requestFocus();
					}
				else if(!sex.getText().equals("男")&&!

sex.getText().equals("女")){
					tips("请输入'男'或者'女'!");
					sex.setText

(null);sex.requestFocus();
				}
				else if(!Student.isInt(num.getText())){
					tips("请输入正整数兴趣编号!");
					num.setText

(null);num.requestFocus();
					}
				else if(style.getText().length()==0){
					tips("请输入兴趣类型!");
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

	//弹出错误提示窗口
	public static void tips(String tip){
		JOptionPane.showMessageDialog(null,tip,"错误",JOptionPane.ERROR_MESSAGE);
	}
}
//程序主界面
class StudentMage extends JFrame{
	private JButton ad,mod,del,que;
	private JLabel tip;
	StudentMage(){
		super("课外兴趣小组管理");
		File file = new File("C:\\StuData");//初始化时创建文件储存文件夹
		file.mkdir();
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		tip=new JLabel("欢迎光临课外兴趣小组管理系统!");
		tip.setForeground(Color.red);
		ad=new JButton("添加学生信息");
		mod=new JButton("修改学生信息");
		del=new JButton("删除学生信息");
		que=new JButton("查询学生信息");
		con.add(tip);
		con.add(ad);
		con.add(mod);
		con.add(del);
		con.add(que);
		setSize(300, 150);
		setCenter();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//分别对各个按钮添加监听
		ad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Edit edit=new Edit(new Student(),"添加");
			}
		});
		addLis(mod,"修改");
		addLis(del,"删除");
		addLis(que,"查询");
	}
	//按钮监听
	public void addLis(JButton but,String t){
		but.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Temp temp=new Temp(t);
			}
		});
	}
	//将窗口显示在屏幕中央
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
//测试类
public class test {
	public static void main(String[] args){
		StudentMage a=new StudentMage();
	}
}
