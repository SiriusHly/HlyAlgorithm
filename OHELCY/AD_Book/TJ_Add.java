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

	JLabel lbltj = new JLabel("���/ɾ����ϵ��", JLabel.CENTER);
	JLabel lblxm = new JLabel("����    :  ");
	JLabel lbldh = new JLabel("�绰    :  ");
	JLabel lblnl = new JLabel("����    :  ");
	JLabel lbldw = new JLabel("��λ    :  ");
	JLabel lblzz = new JLabel("סַ    :  ");
	JLabel lblsr = new JLabel("����    :  ");
	JLabel lblyj = new JLabel("�ʼ�    :  ");
	JLabel lblqq = new JLabel("�ۿ�    :  ");
	JLabel lblxh = new JLabel("ѧ��    :  ");
	JLabel lblfz = new JLabel("����    :  ");
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
	JButton btnqd = new JButton("ȷ��");
	JButton btnfh = new JButton("����");
	JButton btncz = new JButton("����");
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
				CX_Query.jcb2.removeAllItems();// ���������б�

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
				if (jcb.getSelectedItem().toString().equals("���")) {
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
						CX_Query.jcb2.removeAllItems();// ���������б�
						CX_Query.init4();
						fw = new FileWriter(f3);
						// bw = new BufferedWriter(fw);������д����ȥ

						fw.write(s1);
						JOptionPane.showMessageDialog(null, "��ӳɹ���");
						// System.out.println(path5 + "\\" + txtfz.getText()+
						// "\\" + txtxm.getText() + ".txt");
						fw.close();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (jcb.getSelectedItem().toString().equals("ɾ��")) {
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
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				} /*
					 * else { JOptionPane.showMessageDialog(null, "�����ڴ���ϵ��"); }
					 */
				// }
			}

		});
	}
	public void init2() {
		jcb.addItem("���");
		jcb.addItem("ɾ��");
		p4.setLayout(null);
		lbltj.setForeground(Color.black);
		lbltj.setFont(new Font("����", Font.BOLD, 30));
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
