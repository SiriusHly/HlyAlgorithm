package XuanTi_System;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Home extends Login { 
	public  JPanel p5_1 = new JPanel();
	public JPanel p5_2 = new JPanel();
	public JPanel p5_21 = new JPanel();
	public JPanel p5_22 = new JPanel();
	public JPanel p5_3 = new JPanel();
	public JPanel p5_31 = new JPanel();
	public JPanel p5_32 = new JPanel();
	public JPanel p5_4 = new JPanel();
	
	public JLabel lblzy = new JLabel("欢迎使用毕业生选题系统管理端");
	public JButton btnsc = new JButton("删除");
	public JButton btncx = new JButton("查询");
	public JButton btnxg = new JButton("修改");
	public JButton btntj = new JButton("添加");
	public JButton btncz = new JButton("重置");
	//public JButton btnfh2 = new JButton("返回");
	
	JLabel lblxx = new JLabel("请输入学校:");
	JLabel lblxh = new JLabel("请输入学号:");
	JLabel lblxs = new JLabel("学生信息:");
	JLabel lblkt = new JLabel("课题信息:");
	JTextField txtxx = new JTextField(14);
	JTextField txtxh = new JTextField(14);
	
	JLabel lblxx2 = new JLabel("学校   : ");
	JLabel lblxy = new JLabel("学院   : ");
	JLabel lblbj = new JLabel("班级   : ");
	JLabel lblxm = new JLabel("姓名   : ");
	JLabel lblxh2 = new JLabel("学号   : ");
	JLabel lblxt = new JLabel("选题   : ");
	JLabel lbldh = new JLabel("电话   : ");
	JLabel lblmm = new JLabel("密码   : ");
	
	JTextField txtxx2 = new JTextField(20);
	JTextField txtxy = new JTextField(20);
	JTextField txtbj = new JTextField(20);
	JTextField txtxm = new JTextField(20);
	JTextField txtxh2 = new JTextField(20);
	JTextField txtxt = new JTextField(20);
	JTextField txtdh  = new JTextField(20);
	JTextField txtmm  = new JTextField(20);

	JLabel lblbh = new JLabel("课题编号   : ");
	JLabel lblmc = new JLabel("课题名称   : ");
	JLabel lbljs = new JLabel("指导教师   : ");
	JLabel lblss = new JLabel("开始时间   : ");
	JLabel lbles = new JLabel("结束时间   : ");
	JLabel lbljj = new JLabel("课题简介   : ");
	JLabel lbllx = new JLabel("课题类型   : ");
	JTextField txtbh = new JTextField(20);
	JTextField txtmc = new JTextField(20);
	JTextField txtjs = new JTextField(20);
	JTextField txtss = new JTextField(20);
	JTextField txtes = new JTextField(20);
	JTextField  txtjj = new JTextField(20);
	JTextField  txtlx = new JTextField(20);
	
	
	public  void init(){
		
		
	}
	
	public Home() {	
		jiemian();
		
			
	}
	public void jiemian(){
		lblzy.setForeground(Color.black);
		lblzy.setFont(new Font("隶书", Font.BOLD, 40));
		
	p5.setLayout(null);
	p5_4.setLayout(new FlowLayout());
	p5_3.setLayout(new GridLayout(1, 2));
	p5_31.setLayout(new FlowLayout(FlowLayout.LEFT));
	p5_32.setLayout(new FlowLayout(FlowLayout.LEFT));
	p5_21.setLayout(new FlowLayout(FlowLayout.LEFT));
	p5_22.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	p5_1.setBounds(0, 0, 700, 90);
	p5_2.setBounds(0, 90, 700, 70);
	p5_3.setBounds(0, 160, 700, 240);
	p5_4.setBounds(0, 400, 700, 80);
	
	p5_1.setBackground(Color.orange);
	p5_2.setBackground(Color.orange);
	p5_21.setBackground(Color.orange);
	p5_22.setBackground(Color.orange);
	p5_31.setBackground(Color.orange);
	p5_32.setBackground(Color.orange);
	p5_4.setBackground(Color.orange);
	p5_1.setBackground(Color.orange);
	
	
		p5_4.add(btncx);
		p5_4.add(btnsc);
		p5_4.add(btntj);
		p5_4.add(btnxg);
		p5_4.add(btnfh2);
		p5_4.add(btncz);
		
		btncx.setForeground(Color.BLUE);
		btnsc.setForeground(Color.orange);
		btntj.setForeground(Color.red);
		btnxg.setForeground(Color.gray);
		btnfh2.setForeground(Color.green);
		btncz.setForeground(Color.BLACK);
		
		/*p5_2.add(lblxx);
		p5_2.add(txtxx);
		p5_2.add(lblxh);
		p5_2.add(txtxh);*/
		
		Box box21 = Box.createHorizontalBox();
		box21.add(lblxx);
		box21.add(txtxx);
		Box box21H = Box.createVerticalBox();
		box21H.add(box21);
		p5_21.add(box21H);
		
		Box box22 = Box.createHorizontalBox();
		box22.add(lblxh);
		box22.add(txtxh);
		Box box22H = Box.createVerticalBox();
		box22H.add(box22);
		p5_22.add(box22H);
		
		Box box1 = Box.createHorizontalBox();
		box1.add(lblxs);
		
		Box box2 = Box.createHorizontalBox();
		box2.add(lblxx2,JLabel.CENTER);
		box2.add(txtxx2);
		
		Box box3 = Box.createHorizontalBox();
		box3.add(lblxy);
		box3.add(txtxy);
		
		Box box4 = Box.createHorizontalBox();
		box4.add(lblbj);
		box4.add(txtbj);
		
		Box box5 = Box.createHorizontalBox();
		box5.add(lblxm);
		box5.add(txtxm);
		
		Box box6 = Box.createHorizontalBox();
		box6.add(lblxh2);
		box6.add(txtxh2);
		
		Box box7 = Box.createHorizontalBox();
		box7.add(lblxt);
		box7.add(txtxt);
		
		Box box8= Box.createHorizontalBox();
		box8.add(lbldh);
		box8.add(txtdh);
		
		Box box9= Box.createHorizontalBox();
		box9.add(lblmm);
		box9.add(txtmm);
		
		Box boxH = Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box6);
		boxH.add(box7);
		boxH.add(box8);
		boxH.add(box9);
		p5_31.add(boxH);
		
		Box box11 = Box.createHorizontalBox();
		box11.add(lblkt);
		
		Box box12 = Box.createHorizontalBox();
		box12.add(lblbh,JLabel.CENTER);
		box12.add(txtbh);
		
		Box box13 = Box.createHorizontalBox();
		box13.add(lblmc);
		box13.add(txtmc);
		
		Box box14 = Box.createHorizontalBox();
		box14.add(lbljs);
		box14.add(txtjs);
		
		Box box15 = Box.createHorizontalBox();
		box15.add(lblss);
		box15.add(txtss);
		
		Box box16 = Box.createHorizontalBox();
		box16.add(lbles);
		box16.add(txtes);
		
		Box box17 = Box.createHorizontalBox();
		box17.add(lbllx);
		box17.add(txtlx);
		
		Box box18= Box.createHorizontalBox();
		box18.add(lbljj);
		box18.add(txtjj);
		
		Box box1H = Box.createVerticalBox();
		box1H.add(box11);
		box1H.add(box12);
		box1H.add(box13);
		box1H.add(box14);
		box1H.add(box15);
		box1H.add(box16);
		box1H.add(box17);
		box1H.add(box18);
		p5_32.add(box1H);
		
		p5_2.add(p5_21);
		
		p5_2.add(p5_22);
		p5_1.add(lblzy);
		p5.add(p5_1);
		p5.add(p5_2);
		
		p5.add(p5_3);
		p5.add(p5_4);
		p5_3.add(p5_31);
		p5_3.add(p5_32);
		txtmm.setEditable(false);
		//txtmm.setEnabled(false);
	}
	
}
