package text1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/*
 * 4.9班级通讯录
要求：
1）	该系统主要处理通讯录的相关信息。
2）	通讯录信息主要包括：1姓名、2班级、3手机、4家庭电话、5电子邮件、6通讯录地址、7邮编等内容。
3）	完成以下的操作：实现通讯录信息的添加、修改、删除和查询。
提示：
1）建立班级类、通讯录类
2）班级、通讯录信息的初始化
3）班级、通讯录信息的添加、修改、删除、查找
4）班级、通讯录信息的输出
5）将通讯录信息保存为文件

 */
public class Student_Manager_hly1 extends JFrame implements ActionListener {

/*Situation_y massageInput = null;
Modify_y  modify = null;
Inquest_y inquest = null;
Delete_y  delete = null;*/
JMenuItem  in,mo,inq,de,ex;
Container con=null;
File file = null;
Hashtable message = null;//散列表设置为空
CardLayout card = null;
JMenuBar bar;
JMenu fileMenu; 
JLabel lbl; 
JPanel p1;


	public Student_Manager_hly1() {
		setTitle("班级通讯录");
		in = new JMenuItem("录入基本信息");
		mo = new JMenuItem("修改基本信息");
		inq = new JMenuItem("查询基本信息");
		de = new JMenuItem("删除基本信息");
		ex = new JMenuItem("退出系统");
		
		ex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		fileMenu = new JMenu("菜单");
		bar = new JMenuBar();
		fileMenu.add(in);
		fileMenu.addSeparator();//?
		fileMenu.add(mo);
		fileMenu.addSeparator();
		fileMenu.add(inq);
		fileMenu.addSeparator();
		fileMenu.add(de);
		fileMenu.addSeparator();
		//fileMenu.addSeparator();
		fileMenu.add(ex);
		bar.add(fileMenu);
		setJMenuBar(bar);
		lbl = new JLabel("欢迎使用班级通讯录",lbl.CENTER);
		lbl.setFont(new Font("隶书",Font.BOLD,30));
		lbl.setForeground(Color.blue);
		in.addActionListener(this);
		mo.addActionListener(this);
		inq.addActionListener(this);
		de.addActionListener(this);
		card= new CardLayout();
		con = getContentPane();
		p1 = new JPanel();
		p1.setLayout(card);
		file = new File("f:\\book\\Mess.txt");
		FileOutputStream out =null;
		if(!file.exists()){
			try{
			out = new FileOutputStream(file);
			ObjectOutputStream objectOut=new ObjectOutputStream(out);//写入文件
			objectOut.writeObject(message);
			objectOut.close();
			out.close();
			}
			catch(IOException e){
			}
			}
		/*massageInput = new Situation_y(file);
		modify = new Modify_y(file); 
		inquest = new Inquest_y(this,file);
		delete = new Delete_y(file); 
		p1.add("欢迎语界面",lbl);
		p1.add("录入界面",massageInput);
		p1.add("修改界面",modify);
		p1.add("删除界面",delete);*/
		con.add(p1,BorderLayout.CENTER);
	    con.validate();
		addWindowListener(new WindowAdapter()
		{ public void windowClosing(WindowEvent e)
		{
		System.exit(0);
		}
		});
		setVisible(true);
		setBounds(500,200,420,380);//设置窗口的大小
					
		}			
				
	

	public static void main(String[] args) {
		//Student_Manager_hly y = new Student_Manager_hly();//删掉
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
























