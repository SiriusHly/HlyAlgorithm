package AD_Book;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TJ_Add extends Home_P {
	JPanel p41 = new JPanel();
	JPanel p42 = new JPanel();
	JPanel p43 = new JPanel();

	JLabel lbltj = new JLabel("添加/删除联系人", JLabel.CENTER);
	JLabel lblxm = new JLabel("姓名    :  ");
	JLabel lbldh = new JLabel("电话    :  ");
	JLabel lblnl = new JLabel("年龄    :  ");
	JLabel lbldw = new JLabel("单位    :  ");
	JLabel lblzz = new JLabel("住址    :  ");
	JLabel lblsr = new JLabel("生日    :  ");
	JLabel lblyj = new JLabel("邮件    :  ");
	JLabel lblqq = new JLabel("扣扣    :  ");
	JLabel lblxh = new JLabel("学号    :  ");
	JLabel lblfz = new JLabel("分组    :  ");
	JTextField txtxm = new JTextField(20);
	JTextField txtdh = new JTextField(20);
	JTextField txtnl = new JTextField(20);
	JTextField txtdw = new JTextField(20);
	JTextField txtzz = new JTextField(20);
	JTextField txtsr = new JTextField(20);
	JTextField txtyj = new JTextField(20);
	JTextField txtqq = new JTextField(20);
	JTextField txtxh = new JTextField(20);
	JTextField txtfz = new JTextField(20);
	JButton btnqd = new JButton("确定");
	JButton btnfh = new JButton("返回");
	JButton btncz = new JButton("重置");
	JComboBox jcb = new JComboBox();
	String path5 = "c:\\Data_T";

	public TJ_Add() {
		init2();
		btncz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtfz.setText("");
				txtxm.setText("");
				txtdh.setText("");
				txtnl.setText("");
				txtdw.setText("");
				txtzz.setText("");
				txtsr.setText("");
				txtyj.setText("");
				txtqq.setText("");
				txtxh.setText("");
			}
		});

		btnfh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtfz.setText("");
				txtxm.setText("");
				txtdh.setText("");
				txtnl.setText("");
				txtdw.setText("");
				txtzz.setText("");
				txtsr.setText("");
				txtyj.setText("");
				txtqq.setText("");
				txtxh.setText("");
				card.show(p1, "cx");
				CX_Query.jcb3.removeAllItems();
				CX_Query.jcb2.removeAllItems();// 重置下拉列表

				CX_Query.init4();
			}
		});

		btnqd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// CX_Query.init4();
				FileWriter fw = null;
				File f2 = new File(path5 + "\\" + txtfz.getText());
				f2.mkdir();
				File f3 = new File(f2 + "\\" + txtxm.getText() + ".txt");
				if (jcb.getSelectedItem().toString().equals("添加")) {
					String fz, xm, dh, nl, dw, zz, sr, qq, yj, xh;
					fz = txtfz.getText();
					xm = txtxm.getText();
					dh = txtdh.getText();
					nl = txtnl.getText();
					dw = txtdw.getText();
					zz = txtzz.getText();
					sr = txtsr.getText();
					yj = txtyj.getText();
					qq = txtqq.getText();
					xh = txtxh.getText();
					String s1 = fz + " " + xm + " " + dh + " " + nl + " " + dw + " " + zz + " " + sr + " " + yj + " "
							+ qq + " " + xh;
					try {
						CX_Query.jcb3.removeAllItems();
						CX_Query.jcb2.removeAllItems();// 重置下拉列表
						CX_Query.init4();
						fw = new FileWriter(f3);
						// bw = new BufferedWriter(fw);加这行写不进去

						fw.write(s1);
						JOptionPane.showMessageDialog(null, "添加成功！");
						// System.out.println(path5 + "\\" + txtfz.getText()+
						// "\\" + txtxm.getText() + ".txt");
						fw.close();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (jcb.getSelectedItem().toString().equals("删除")) {
					// if (f3.exists()) {
					f3.delete();

					txtfz.setText("");
					txtxm.setText("");
					txtdh.setText("");
					txtnl.setText("");
					txtdw.setText("");
					txtzz.setText("");
					txtsr.setText("");
					txtyj.setText("");
					txtqq.setText("");
					txtxh.setText("");
					JOptionPane.showMessageDialog(null, "删除成功");
				} /*
					 * else { JOptionPane.showMessageDialog(null, "不存在此联系人"); }
					 */
				// }
			}

		});
	}
	public void init2() {
		jcb.addItem("添加");
		jcb.addItem("删除");
		p4.setLayout(null);
		lbltj.setForeground(Color.black);
		lbltj.setFont(new Font("隶书", Font.BOLD, 30));
		btnqd.setForeground(Color.GREEN);
		btnfh.setForeground(Color.orange);
		btncz.setForeground(Color.red);

		Box box1 = Box.createHorizontalBox();
		box1.add(lblxm);
		box1.add(txtxm);

		Box box2 = Box.createHorizontalBox();
		box2.add(lbldh);
		box2.add(txtdh);

		Box box3 = Box.createHorizontalBox();
		box3.add(lblnl);
		box3.add(txtnl);

		Box box4 = Box.createHorizontalBox();
		box4.add(lbldw);
		box4.add(txtdw);

		Box box5 = Box.createHorizontalBox();
		box5.add(lblzz);
		box5.add(txtzz);

		Box box6 = Box.createHorizontalBox();
		box6.add(lblsr);
		box6.add(txtsr);

		Box box7 = Box.createHorizontalBox();
		box7.add(lblyj);
		box7.add(txtyj);

		Box box8 = Box.createHorizontalBox();
		box8.add(lblqq);
		box8.add(txtqq);

		Box box9 = Box.createHorizontalBox();
		box9.add(lblxh);
		box9.add(txtxh);

		Box box10 = Box.createHorizontalBox();
		box10.add(lblfz);
		box10.add(txtfz);

		Box boxH = Box.createVerticalBox();
		boxH.add(box10);
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box6);
		boxH.add(box7);
		boxH.add(box8);
		boxH.add(box9);

		p43.setLayout(null);
		p43.add(btnqd);
		p43.add(btnfh);
		p43.add(btncz);
		p43.add(jcb);
		p41.setBounds(0, 0, 330, 80);
		p42.setBounds(0, 80, 330, 270);
		p43.setBounds(0, 350, 330, 230);

		jcb.setBounds(15, 0, 60, 32);
		btnqd.setBounds(85, 0, 60, 32);
		btnfh.setBounds(163, 0, 60, 32);
		btncz.setBounds(240, 0, 60, 32);

		p41.setBackground(Color.ORANGE);
		p42.setBackground(Color.ORANGE);
		p43.setBackground(Color.ORANGE);
		p42.add(boxH);
		p41.add(lbltj);

		p4.add(p41);
		p4.add(p42);
		p4.add(p43);

	}

	public static void main(String[] args) {
		// TJ_Add h = new TJ_Add();
	}

}
