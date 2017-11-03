package AD_Book;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CX_Query extends TJ_Add {
	// 转到匹配花括号ctrl+shift+P
	JPanel p31 = new JPanel();
	JPanel p32 = new JPanel();
	JPanel p33 = new JPanel();
	static JComboBox jcb2 = new JComboBox();
	static JComboBox jcb3 = new JComboBox();
	JLabel lblcx = new JLabel("查询联系人");
	JButton btnqd2 = new JButton("确定");
	JButton btnfh2 = new JButton("返回");
	JLabel lblfz2 = new JLabel("请确定分组:");
	JLabel lblpp = new JLabel("请确定好友:");
	static String path3 = "c:\\Data_T";// 格式！

	public CX_Query() {

		init3();
		btnqd2.setForeground(Color.green);
		btnfh2.setForeground(Color.blue);

	}

	public void init3() {
		p3.setLayout(null);
		p32.setLayout(null);
		lblcx.setForeground(Color.black);
		lblcx.setFont(new Font("隶书", Font.BOLD, 40));

		lblfz2.setForeground(Color.black);
		lblfz2.setFont(new Font("宋体", Font.BOLD, 15));

		lblpp.setForeground(Color.black);
		lblpp.setFont(new Font("宋体", Font.BOLD, 15));

		p31.add(lblcx);

		p31.setBackground(Color.blue);
		p32.setBackground(Color.BLUE);
		// p3.setBackground(Color.orange);

		p32.add(lblfz2);
		p32.add(lblpp);
		p32.add(jcb2);
		p32.add(jcb3);
		p32.add(btnqd2);
		p32.add(btnfh2);

		p31.setBounds(0, 0, 330, 80);
		p32.setBounds(0, 80, 330, 580);

		lblfz2.setBounds(40, 20, 100, 32);
		lblpp.setBounds(185, 20, 100, 32);
		jcb2.setBounds(40, 60, 85, 32);
		jcb3.setBounds(185, 60, 85, 32);

		btnqd2.setBounds(40, 400, 85, 32);
		btnfh2.setBounds(185, 400, 85, 32);

		p3.add(p31);
		p3.add(p32);

		btnfh2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CX_Query.jcb2.removeAllItems();// 重置下拉列表
				CX_Query.jcb3.removeAllItems();
				CX_Query.init4();
				card.show(p1, "zy");
			}
		});
		// CX_Query.jcb2.removeAllItems();//重置下拉列表
		// CX_Query.jcb3.removeAllItems();
		init4();// 重置下拉列表
		// CX_Query.jcb3.removeAllItems();
		jcb2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {
					// jcb2.removeAllItems();//重置下拉列表
					jcb3.removeAllItems();
					String s3 = (String) jcb2.getSelectedItem();
					File ff6 = new File(path3 + "\\" + s3);
					String[] s4 = ff6.list();
					for (int j = 0; j < s4.length; j++) {
						String s5 = s4[j].substring(0, s4[j].length() - 4);
						jcb3.addItem(s5);
					}
				}
			}
		});

		btnqd2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(p1, "lu");

				String s6 = (String) jcb2.getSelectedItem();
				String s7 = (String) jcb3.getSelectedItem();
				String s8 = "";
				File ff5 = new File(path3 + "\\" + s6 + "\\" + s7 + ".txt");
				String fz2, xm2, dh2, nl2, dw2, zz2, sr2, qq2, yj2, xh2;
				FileReader fr;
				BufferedReader br;
				try {
					fr = new FileReader(ff5);
					br = new BufferedReader(fr);
					s8 = br.readLine();
					fr.close();
					br.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String s9[] = s8.split(" ");
				txtfz.setText(s9[0]);
				txtxm.setText(s9[1]);
				txtdh.setText(s9[2]);
				txtnl.setText(s9[3]);
				txtdw.setText(s9[4]);
				txtzz.setText(s9[5]);
				txtsr.setText(s9[6]);
				txtyj.setText(s9[7]);
				txtqq.setText(s9[8]);
				txtxh.setText(s9[9]);
				// card.show(p1, "lu");
			}

		});

	}

	public static void init4() {
		File ff2 = new File(path3);
		String[] s2 = ff2.list();
		int i;
		for (i = 0; i < s2.length; i++) {
			jcb2.addItem(s2[i]);
		}

		/*
		 * String s3 = (String) jcb2.getSelectedItem(); File ff3 = new
		 * File(path3 + "\\" + s3); String[] s4 = ff3.list(); 加上这一块第一个分组内容初始时会重复
		 * for (int j = 0; j < s4.length; j++) { String s5 = s4[j].substring(0,
		 * s4[j].length() - 4); jcb3.addItem(s5);
		 * 
		 * }
		 */
	}

	public static void main(String[] args) {
		CX_Query c = new CX_Query();
	}

}
