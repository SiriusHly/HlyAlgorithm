package XuanTi_System;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	public JLabel lbltitle = new JLabel("毕业生选题管理系统");
	public JLabel lbltitle2 = new JLabel("毕业生选题管理系统注册");
	public JLabel lblname = new JLabel("用户名:");
	public JLabel lblname2 = new JLabel("请输入学号  :");
	public JLabel lblxx2 = new JLabel("请输入学校  :");
	

	public JTextField txtname = new JTextField(26);
	public JTextField txtname2 = new JTextField(26);
	public JTextField txtxx2 = new JTextField(26);
	public JLabel lblpw = new JLabel("密  码:");
	public JLabel lblpw2 = new JLabel("请输入密码  :");
	public JPasswordField txtpw = new JPasswordField(26);
	public JPasswordField txtpw2 = new JPasswordField(26);
	public JButton btndl = new JButton("登录");
	public JButton btnzc = new JButton("注册");
	public JButton btnqd = new JButton("确定");
	public JButton btnfh = new JButton("返回");
	public JButton btnfh2 = new JButton("返回");
	public JButton btnfh3 = new JButton("返回");
	public JButton btncz3 = new JButton("重置");
	public JButton btncz2 = new JButton("重置");
	
	public JComboBox jcb = new JComboBox();

	public JPanel p1 = new JPanel();
	public JPanel p1_2 = new JPanel();
	public JPanel p2 = new JPanel();
	public JPanel p3 = new JPanel();
	public JPanel p4 = new JPanel();
	public JPanel p5 = new JPanel();
	public JPanel p6 = new JPanel();
	
	
	ImageIcon icon  =new  ImageIcon("f:\\book\\001.jpg");
	
	
	JPanel p0 = new JPanel();
	
	String path2 = "c:\\Data\\Account";
    String path3 = "c:\\Data\\Account2";
	public Login() {

		fun();

	}

	public void fun() {
		File f3 = new File(path3);
		f3.mkdirs();
		JFrame jframe = new JFrame();
		Container con = jframe.getContentPane();
		con.setLayout(null);
		CardLayout card = new CardLayout();
		jframe.setResizable(false);
		p3.setLayout(null);
		p4.setLayout(null);
		p1.setSize(700, 100);
		p1_2.setSize(700, 100);
		p2.setSize(700, 500);
		p3.setSize(700, 500);
		p4.setSize(700, 500);
		
		jcb.addItem("学生登录");
		jcb.addItem("教师登录");

		lbltitle.setForeground(Color.black);
		lbltitle.setFont(new Font("隶书", Font.BOLD, 40));
		lbltitle2.setForeground(Color.black);
		lbltitle2.setFont(new Font("隶书", Font.BOLD, 40));

		lblname.setForeground(Color.black);
		lblname.setFont(new Font("隶书", Font.BOLD, 30));
		txtname.setFont(new Font("隶书", Font.BOLD, 30));

		lblpw.setForeground(Color.black);
		lblpw.setFont(new Font("隶书", Font.BOLD, 30));
		txtpw.setFont(new Font("", Font.BOLD, 30));

		
		
		lblname2.setForeground(Color.black);
		lblname2.setFont(new Font("隶书", Font.BOLD, 30));
		txtname2.setFont(new Font("隶书", Font.BOLD, 30));
		
		lblxx2.setForeground(Color.black);
		lblxx2.setFont(new Font("隶书", Font.BOLD, 30));
		
		txtxx2.setForeground(Color.black);
		txtxx2.setFont(new Font("隶书", Font.BOLD, 30));
		
		

		lblpw2.setForeground(Color.black);
		lblpw2.setFont(new Font("隶书", Font.BOLD, 30));
		txtpw2.setFont(new Font("", Font.BOLD, 30));

		lblname.setBounds(180, 60, 500, 200);
		lblpw.setBounds(180, 110, 500, 200);
		txtname.setBounds(290, 150, 220, 32);
		txtpw.setBounds(290, 200, 220, 32);
		jcb.setBounds(200, 260, 80, 32);
		btndl.setBounds(300, 260, 60, 32);
		btnzc.setBounds(375, 260, 60, 32);
		btncz2.setBounds(450, 260, 60, 32);

		
		lblxx2.setBounds(120, 60, 230, 200);
		txtxx2.setBounds(330, 150, 230, 32);
		lblname2.setBounds(120, 110, 500, 200);
		lblpw2.setBounds(120, 160, 500, 200);
		txtname2.setBounds(330, 200, 230, 32);
		txtpw2.setBounds(330, 240, 230, 32);
		btnqd.setBounds(180, 300, 60, 35);
		btnfh.setBounds(300, 300, 60, 35);
		btncz3.setBounds(430, 300, 60, 35);
		
		p1.add(lbltitle);
		p1_2.add(lbltitle2);
		con.add(p2);
		p3.add(p1);
		p3.add(jcb);
		p4.add(p1_2);
		p2.setLayout(card);
		p2.add("dl", p3);
		p2.add("zc", p4);
		p2.add("zy", p5);
		p2.add("xs6",p6);
        
		p3.setBackground(Color.orange);
		p1.setBackground(Color.orange);

		p4.setBackground(Color.green);
		p1_2.setBackground(Color.green);

		btndl.setForeground(Color.RED);
		btnzc.setForeground(Color.red);
		btnqd.setForeground(Color.red);
		btnfh.setForeground(Color.red);
		// btndl.setBackground(Color.yellow);
		// btnzc.setBackground(Color.yellow);
        
		p3.add(lblname);
		p3.add(lblpw);
		p3.add(txtname);
		p3.add(txtpw);
		p3.add(btndl);
		p3.add(btnzc);
		p3.add(btncz2);
		
		
		
		p4.add(btncz3);
		p4.add(lblname2);
		p4.add(lblpw2);
		p4.add(txtname2);
		p4.add(txtpw2);
		p4.add(btnqd);
		p4.add(btnfh);
		p4.add(lblxx2);
		p4.add(txtxx2);
		
		
		jframe.setDefaultCloseOperation(jframe.DISPOSE_ON_CLOSE);
		jframe.setBounds(310, 130, 700, 500);

		jframe.setVisible(true);
		jframe.validate();

		btncz2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtname.setText("");
				txtpw.setText("");
			}
		});
btncz3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtname2.setText("");
				txtpw2.setText("");
				txtxx2.setText("");
			}
		});
		btnzc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(p2, "zc");
				txtname2.requestFocus();
				
			}
		});

		btnqd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				File f = new File(path2);
				f.mkdirs();
				String pw2 = txtpw2.getText();
				String name2 = txtname2.getText();
				String xx2  =txtxx2.getText();
				if (pw2.length() > 0 && name2.length() > 0&&xx2.length()>0) {
                     File ff = new File("c:\\Data\\"+xx2);
                     ff.mkdir();
					try {
						fw = new FileWriter(f + "\\" + name2 + ".txt");
						bw = new BufferedWriter(fw);
						bw.write(name2+" "+pw2+" "+xx2);
						bw.close();
						fw.close();
						JOptionPane.showMessageDialog(null, "注册成功");
						card.show(p2, "dl");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				else {
					JOptionPane.showMessageDialog(null, "请输入用户名或密码");
					
				}

			}
		});
		btnfh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(p2, "dl");
				txtname.requestFocus();

			}
		});
		btndl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s1[];
				FileReader fr = null;
				BufferedReader br = null;
               // StringBuffer ss =new StringBuffer(); 
              //  ss.append(jcb.getSelectedItem().toString());
				String pw = txtpw.getText();
				String name = txtname.getText();
				File f = new File(path2 + "\\" + name + ".txt");
				String s6 =path2 + "\\" + name + ".txt";
				
				File f2 = new File(path3 + "\\" + name + ".txt");
				
				// File[] f1 = f.listFiles();
if(name.length()>0&&pw.length()>0){
	if(jcb.getSelectedItem().toString().equals("学生登录")){
				if (f.exists()) {
					try {
						br = new BufferedReader(new FileReader(f));
						String s = br.readLine();
						String s2[]= s.split(" ");
						if (s2[1].equals(pw)) {
							card.show(p2, "xs6");
							 Student2.cc(s6);
						} else {
							JOptionPane.showMessageDialog(null, "密码不正确");
							txtpw.setText(null);
							txtpw.requestFocus();
						}
						br.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					int ok = JOptionPane.showConfirmDialog(p5, "不存在此账号，是否注册", "确定框", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {
					card.show(p2, "zc");
					}
				 }
		
	}
				
	else if(jcb.getSelectedItem().toString().equals("教师登录")){
				if (f2.exists()) {
					try {
						br = new BufferedReader(new FileReader(f2));
						String s = br.readLine();
						if (s.equals(pw)) {
							card.show(p2, "zy");
						} else {
							JOptionPane.showMessageDialog(null, "密码不正确");
							txtpw.setText(null);
							txtpw.requestFocus();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				 else
				 {
					 JOptionPane.showMessageDialog(null, "不存在此账号");
				 }
				}
				 
}
				else{
					JOptionPane.showMessageDialog(null, "请输入密码或账号");
					if (name.length() <= 0 && pw.length() <= 0) {
						txtname.requestFocus();
					} else if (name.length() <= 0) {
						txtname.requestFocus();
					} else if (pw.length() <= 0) {
						txtpw.requestFocus();
					}
				}
				

			}
		});

		btnfh2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(p2, "dl");
				Student2.qingchu();
			}
		});
		
btnfh3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(p2, "dl");
				Student2.qingchu();

			}
		});
	}
	/*
	 * public void setCenter(){ Dimension
	 * screenSize=Toolkit.getDefaultToolkit().getScreenSize(); int
	 * screenWidth=screenSize.width; int screenHeight=screenSize.height;
	 * Dimension frameSize=getSize(); int x=(screenWidth-frameSize.width)/2; int
	 * y=(screenHeight-frameSize.height)/2; setLocation(x,y); }
	 */
	

	public static void main(String[] args) {

		//Manager h = new Manager();
		Student2 s = new Student2();
		

	}

	
}
