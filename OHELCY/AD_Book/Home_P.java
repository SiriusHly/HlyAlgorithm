package AD_Book;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Home_P extends JFrame {

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	CardLayout card = new CardLayout();
	JLabel lblzy = new JLabel("欢迎使用个人通讯录", JLabel.CENTER);
	JLabel lblzz = new JLabel("--------------作者：黄良运", JLabel.RIGHT);
	JMenu jm = new JMenu("Menu");
	JMenuItem lu = new JMenuItem("操作");
	JMenuItem cx = new JMenuItem("查询");
	JMenuItem zy = new JMenuItem("主页");
	// JMenuItem xg= new JMenuItem("修改");*/
	JMenuItem tc = new JMenuItem("退出");
	JMenuBar jb = new JMenuBar();
	String path = "c:\\Data_T";

	public Home_P() {
		File f1 = new File(path);
		f1.mkdirs();
		init1();

	}

	public void init1() {
		jm.add(cx);
		jm.addSeparator();
		jm.add(lu);
		jm.addSeparator();
		jm.add(zy);
		jm.addSeparator();
		jm.add(tc);
		jb.add(jm);
		lblzy.setForeground(Color.black);
		lblzy.setFont(new Font("隶书", Font.BOLD, 30));
		JFrame jf = new JFrame();
		Container con = jf.getContentPane();
		jf.setJMenuBar(jb);

		p1.setLayout(card);
		con.add(p1);
		p2.add(lblzy);
		p2.add(lblzz);
		p2.setBackground(Color.blue);
		p1.add("zy", p2);
		p1.add("cx", p3);
		p1.add("lu", p4);
		jf.setVisible(true);
		jf.setBounds(500, 100, 330, 580);
		jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 jf.setResizable(false);
		jf.validate();

		zy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(p1, "zy");
			}
		});
		cx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(p1, "cx");
				CX_Query.jcb2.removeAllItems();//重置下拉列表
				CX_Query.jcb3.removeAllItems();
				CX_Query.init4();
				
			}
		});

		lu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(p1, "lu");
			}
		});
		tc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	/*
	 * public static void main(String[] args) { TJ_Add h = new TJ_Add(); }
	 */

}
