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
 * 4.9�༶ͨѶ¼
Ҫ��
1��	��ϵͳ��Ҫ����ͨѶ¼�������Ϣ��
2��	ͨѶ¼��Ϣ��Ҫ������1������2�༶��3�ֻ���4��ͥ�绰��5�����ʼ���6ͨѶ¼��ַ��7�ʱ�����ݡ�
3��	������µĲ�����ʵ��ͨѶ¼��Ϣ����ӡ��޸ġ�ɾ���Ͳ�ѯ��
��ʾ��
1�������༶�ࡢͨѶ¼��
2���༶��ͨѶ¼��Ϣ�ĳ�ʼ��
3���༶��ͨѶ¼��Ϣ����ӡ��޸ġ�ɾ��������
4���༶��ͨѶ¼��Ϣ�����
5����ͨѶ¼��Ϣ����Ϊ�ļ�

 */
public class Student_Manager_hly1 extends JFrame implements ActionListener {

/*Situation_y massageInput = null;
Modify_y  modify = null;
Inquest_y inquest = null;
Delete_y  delete = null;*/
JMenuItem  in,mo,inq,de,ex;
Container con=null;
File file = null;
Hashtable message = null;//ɢ�б�����Ϊ��
CardLayout card = null;
JMenuBar bar;
JMenu fileMenu; 
JLabel lbl; 
JPanel p1;


	public Student_Manager_hly1() {
		setTitle("�༶ͨѶ¼");
		in = new JMenuItem("¼�������Ϣ");
		mo = new JMenuItem("�޸Ļ�����Ϣ");
		inq = new JMenuItem("��ѯ������Ϣ");
		de = new JMenuItem("ɾ��������Ϣ");
		ex = new JMenuItem("�˳�ϵͳ");
		
		ex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		fileMenu = new JMenu("�˵�");
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
		lbl = new JLabel("��ӭʹ�ð༶ͨѶ¼",lbl.CENTER);
		lbl.setFont(new Font("����",Font.BOLD,30));
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
			ObjectOutputStream objectOut=new ObjectOutputStream(out);//д���ļ�
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
		p1.add("��ӭ�����",lbl);
		p1.add("¼�����",massageInput);
		p1.add("�޸Ľ���",modify);
		p1.add("ɾ������",delete);*/
		con.add(p1,BorderLayout.CENTER);
	    con.validate();
		addWindowListener(new WindowAdapter()
		{ public void windowClosing(WindowEvent e)
		{
		System.exit(0);
		}
		});
		setVisible(true);
		setBounds(500,200,420,380);//���ô��ڵĴ�С
					
		}			
				
	

	public static void main(String[] args) {
		//Student_Manager_hly y = new Student_Manager_hly();//ɾ��
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
























