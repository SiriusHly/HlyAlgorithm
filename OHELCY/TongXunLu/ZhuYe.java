package TongXunLu;

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
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ZhuYe extends JFrame implements ActionListener {
	JMenuItem in, mo, inq, de, ex;
	Container con = null;
	File file = null;
	Hashtable ht = null;// 散列表设置为空
	CardLayout card = null;
	JMenuBar bar;
	JMenu fileMenu;
	JLabel lbl;
	JPanel p1;

	public ZhuYe() {
		in = new JMenuItem("录入基本信息");
		mo = new JMenuItem("修改基本信息");
		inq = new JMenuItem("查询基本信息");
		de = new JMenuItem("删除基本信息");
		ex = new JMenuItem("退出");
		fileMenu = new JMenu("Menu");
		bar = new JMenuBar();
		fileMenu.add(in);
		fileMenu.addSeparator();
		fileMenu.add(mo);
		fileMenu.addSeparator();
		fileMenu.add(inq);
		fileMenu.addSeparator();
		fileMenu.add(de);
		fileMenu.addSeparator();
		fileMenu.add(ex);
		bar.add(fileMenu);
		setJMenuBar(bar);
		lbl = new JLabel("欢迎使用班级通讯录", lbl.CENTER);
		lbl.setFont(new Font("隶书", Font.BOLD, 30));
		lbl.setForeground(Color.blue);
		con = getContentPane();
		p1 = new JPanel();
		con.add(p1);
		p1.setLayout(new CardLayout());
		p1.add(lbl);
		lbl.setBounds(500, 200, 400, 40);
		setVisible(true);
		setBounds(500, 200, 420, 380);// 设置窗口的大小
		setDefaultCloseOperation(ZhuYe.DISPOSE_ON_CLOSE);
		validate();

		File file = new File("f:\\book\\StudentData");
		// FileOutputStream out = null;
		if (!file.isDirectory() && !file.exists()) {
			// file.createNewFile();
			file.mkdir();
		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		ex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		in.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZhengTian se = new ZhengTian();
			}
		});

		mo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ModifyClass1 g = new ModifyClass1();
			}
		});

		inq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChaXun1 s = new ChaXun1();
			}
		});

		de.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShanChu t = new ShanChu("删除");
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	/*
	 * public static void main(String []args){ ZhuYe r = new ZhuYe(); }
	 */
}
