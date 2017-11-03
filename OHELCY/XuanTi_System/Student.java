package XuanTi_System;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Student extends Manager { 
	public  JPanel p6_1 = new JPanel();
	public JPanel p6_2 = new JPanel();
	
	public JPanel p6_3 = new JPanel();
	public JPanel p6_31 = new JPanel();
	public JPanel p6_32 = new JPanel();
	public JPanel p6_4 = new JPanel();
	//public JPanel p6 = new JPanel();
	
	public JLabel lblzy2 = new JLabel("欢迎使用毕业生选题系统学生端");
	public JLabel lblts = new JLabel("             请完善您的信息");
	//public JButton btnsc = new JButton("删除");
	public JButton btncx2 = new JButton("查询");
	public JButton btnxg2= new JButton("修改");
	public JButton btntj2 = new JButton("录入");
	public JButton btncz3 = new JButton("重置");
	//public JButton btnfh3 = new JButton("返回");
	
	//JLabel lblxx = new JLabel("请输入学校:");
	//JLabel lblxh = new JLabel("请输入学号:");
	JLabel lblxs = new JLabel("学生信息:");
	JLabel lblkt = new JLabel("课题信息:");
	//JTextField txtxx = new JTextField(14);
	//JTextField txtxh = new JTextField(14);
	
	JLabel lblxx2 = new JLabel("学校   : ");
	JLabel lblxy = new JLabel("学院   : ");
JLabel lblbj = new JLabel("班级   : ");
	JLabel lblxm = new JLabel("姓名   : ");
	JLabel lblxh2 = new JLabel("学号   : ");
		JLabel lblxt = new JLabel("选题   : ");
		JLabel lbldh = new JLabel("电话   : ");
    static		JTextField txtxx3 = new JTextField(20);
	static	JTextField txtxy2 = new JTextField(20);
	static	JTextField txtbj2 = new JTextField(20);
	static	JTextField txtxm2 = new JTextField(20);
	static	JTextField txtxh3 = new JTextField(20);
	static	JTextField txtxt2 = new JTextField(20);
	static	JTextField txtdh2  = new JTextField(20);

	JLabel lblbh = new JLabel("课题编号   : ");
	JLabel lblmc = new JLabel("课题名称   : ");
	JLabel lbljs = new JLabel("指导教师   : ");
	JLabel lblss = new JLabel("开始时间   : ");
	JLabel lbles = new JLabel("结束时间   : ");
	JLabel lbljj = new JLabel("课题简介   : ");
	JLabel lbllx = new JLabel("课题类型   : ");
	static	JTextField txtbh2 = new JTextField(20);
	static	JTextField txtmc2 = new JTextField(20);
	static	JTextField txtjs2 = new JTextField(20);
	static	JTextField txtss2 = new JTextField(20);
	static	JTextField txtes2 = new JTextField(20);
	static	JTextField  txtjj2 = new JTextField(20);
	static	JTextField  txtlx2 = new JTextField(20);
	
	public Student() {	
		jiemian2();
					
	}
	public void jiemian2(){
		lblzy2.setForeground(Color.black);
		lblzy2.setFont(new Font("隶书", Font.BOLD, 40));
		
		lblts.setForeground(Color.black);
		lblts.setFont(new Font("隶书", Font.BOLD, 30));
		
	p6.setLayout(null);
	p6_4.setLayout(new FlowLayout());
	p6_3.setLayout(new GridLayout(1, 2));
	p6_31.setLayout(new FlowLayout(FlowLayout.LEFT));
	p6_32.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	
	p6_1.setBounds(0, 0, 700, 90);
	p6_2.setBounds(0, 90, 700, 70);
	p6_3.setBounds(0, 160, 700, 240);
	p6_4.setBounds(0, 400, 700, 80);
	
	p6_1.setBackground(Color.blue);
	p6_2.setBackground(Color.blue);
	//p6_21.setBackground(Color.orange);
	//p6_22.setBackground(Color.orange);
	p6_31.setBackground(Color.blue);
	p6_32.setBackground(Color.blue);
	p6_4.setBackground(Color.blue);
	
	
		p6_4.add(btntj2);
		p6_4.add(btnxg2);
		p6_4.add(btnfh3);
		p6_4.add(btncz3);
		
		btntj2.setForeground(Color.red);
		btnxg2.setForeground(Color.gray);
		btnfh3.setForeground(Color.green);
		btncz3.setForeground(Color.BLACK);
		
		Box box1 = Box.createHorizontalBox();
		box1.add(lblxs);
		
		Box box2 = Box.createHorizontalBox();
		box2.add(lblxx2,JLabel.CENTER);
		box2.add(txtxx3);
		
		Box box3 = Box.createHorizontalBox();
		box3.add(lblxy);
		box3.add(txtxy2);
		
		Box box4 = Box.createHorizontalBox();
		box4.add(lblbj);
		box4.add(txtbj2);
		
		Box box5 = Box.createHorizontalBox();
		box5.add(lblxm);
		box5.add(txtxm2);
		
		Box box6 = Box.createHorizontalBox();
		box6.add(lblxh2);
		box6.add(txtxh3);
		
		Box box7 = Box.createHorizontalBox();
		box7.add(lblxt);
		box7.add(txtxt2);
		
		Box box8= Box.createHorizontalBox();
		box8.add(lbldh);
		box8.add(txtdh2);
		
		Box boxH = Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box6);
		boxH.add(box7);
		boxH.add(box8);
		p6_31.add(boxH);
		
		Box box11 = Box.createHorizontalBox();
		box11.add(lblkt);
		
		Box box12 = Box.createHorizontalBox();
		box12.add(lblbh,JLabel.CENTER);
		box12.add(txtbh2);
		
		Box box13 = Box.createHorizontalBox();
		box13.add(lblmc);
		box13.add(txtmc2);
		
		Box box14 = Box.createHorizontalBox();
		box14.add(lbljs);
		box14.add(txtjs2);
		
		Box box15 = Box.createHorizontalBox();
		box15.add(lblss);
		box15.add(txtss2);
		
		Box box16 = Box.createHorizontalBox();
		box16.add(lbles);
		box16.add(txtes2);
		
		Box box17 = Box.createHorizontalBox();
		box17.add(lbllx);
		box17.add(txtlx2);
		
		Box box18= Box.createHorizontalBox();
		box18.add(lbljj);
		box18.add(txtjj2);
		
		Box box1H = Box.createVerticalBox();
		box1H.add(box11);
		box1H.add(box12);
		box1H.add(box13);
		box1H.add(box14);
		box1H.add(box15);
		box1H.add(box16);
		box1H.add(box17);
		box1H.add(box18);
		p6_32.add(box1H);
		
		p6_1.add(lblzy2);
		p6_2.add(lblts);
		p6.add(p6_1);
		p6.add(p6_2);
		p6_3.add(p6_31);
		p6_3.add(p6_32);
		p6.add(p6_3);
		p6.add(p6_4);
		
	}
	
}
