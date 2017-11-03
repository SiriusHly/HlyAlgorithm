package TongXunLu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ModifyClass extends JFrame implements ActionListener {
	JTextField txtName, txtNum, txtMajor, txtAdd, txtTel, txtcla, txtsex;
	Student xs;
	JRadioButton man, woman;
	JButton inputMo, resetMo;
	ButtonGroup btngroup;
	File file;
	String str;

	public ModifyClass(File file) {
		this.file = file;
		txtNum = new JTextField(10);
		txtsex = new JTextField(10);
		txtName = new JTextField(10);
		txtMajor = new JTextField(10);
		txtAdd = new JTextField(10);
		txtTel = new JTextField(10);
		txtcla = new JTextField(10);
		man = new JRadioButton("男", null);
		woman = new JRadioButton("女", null);
		btngroup = new ButtonGroup();
		/*
		 * btngroup.add(man); btngroup.add(woman);
		 */
		inputMo = new JButton("确定");
		resetMo = new JButton("重置");
		inputMo.addActionListener(this);
		resetMo.addActionListener(this);
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("学号", JLabel.CENTER));
		box1.add(txtNum);
		// box1.add(txtNum);

		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("姓名", JLabel.CENTER));
		box2.add(txtName);

		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("姓别", JLabel.CENTER));
		box3.add(txtsex);
		// box3.add(woman);

		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("专业", JLabel.CENTER));
		box4.add(txtMajor);

		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("住址", JLabel.CENTER));
		box5.add(txtAdd);

		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("电话", JLabel.CENTER));
		box6.add(txtTel);

		Box box7 = Box.createHorizontalBox();
		box7.add(new JLabel("班级", JLabel.CENTER));
		box7.add(txtcla);

		Box boxH = Box.createVerticalBox();
		boxH.add(box7);
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box6);
		boxH.add(Box.createVerticalBox());
		JPanel p1 = new JPanel();
		p1.add(boxH);
		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		JPanel p2 = new JPanel();
		p2.add(inputMo);
		p2.add(resetMo);
		add(p2, BorderLayout.SOUTH);
		setSize(360, 271);
		setLocation(500, 200);
		setVisible(true);

		// String str = xs.getCla()+xs.getNumber()+xs.getName()+"
		// "+xs.getSex()+" "+xs.getBorth()+" "+xs.getDiscipling()+"
		// "+xs.getGrade();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			br.close();
			String[] s = str.split(" ");
			txtcla.setText(s[0]);
			txtNum.setText(s[1]);
			txtName.setText(s[2]);
			txtsex.setText(s[3]);
			/*
			 * if(s[3]=="男"){ man.setSelected(true); man = new JRadioButton("男",
			 * true); woman = new JRadioButton("女",false); } if(s[3]=="女") {
			 * woman.setSelected(true); man = new JRadioButton("男", false);
			 * woman = new JRadioButton("女",true); }
			 */
			txtMajor.setText(s[4]);
			txtAdd.setText(s[5]);
			txtTel.setText(s[6]);

			txtcla.setEnabled(false);
			// txtcla.setEnabled(false);
			txtNum.setEnabled(false);

		} catch (IOException e) {

			e.printStackTrace();
		}

		resetMo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtMajor.setText("");
				txtAdd.setText("");
				txtTel.setText("");

				txtcla.setEnabled(false);
				// txtcla.setEnabled(false);
				txtNum.setEnabled(false);
			}
		});

		inputMo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cla = txtcla.getText();
				String num = txtNum.getText();
				String name = txtName.getText();
				String major = txtMajor.getText();
				String add = txtAdd.getText();
				String tel = txtTel.getText();
				String sex = txtsex.getText();
				/*
				 * if (man.isSelected()) { sex = man.getText(); } else { sex =
				 * woman.getText(); }
				 */
				String ss = cla + " " + num + " " + name + " " + sex + " " + major + " " + add + " " + tel;
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(file));
					bw.write(ss);
					bw.close();
					JOptionPane.showMessageDialog(null, "修改成功");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	public static void main(String[] args) {

	}

}

class ModifyClass1 extends JFrame implements ActionListener {
	File file;
	String path = "f:/TongXunLu/";
	private JLabel cj2 = new JLabel("请输入要修改的班级");
	private JLabel cj3 = new JLabel("请输入要修改的学号");
	private JTextField txtcj2 = new JTextField(10);
	private JTextField txtcj3 = new JTextField(10);
	private JButton btncj = new JButton("确定");
	private JButton btncz = new JButton("重置");
	private JPanel p2 = new JPanel();

	public ModifyClass1() {
		JFrame c2 = new JFrame();
		Container con2 = c2.getContentPane();
		con2.add(p2);
		p2.setLayout(new FlowLayout());
		p2.add(cj2);
		p2.add(txtcj2);
		p2.add(cj3);
		p2.add(txtcj3);
		p2.add(btncj);
		p2.add(btncz);
		c2.setSize(300, 150);
		Classes.center(c2);
		validate();

		btncj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				file = new File(path + "\\" + txtcj2.getText() + "\\" + txtcj3.getText() + ".txt");
				if (file.exists()) {
					ModifyClass o = new ModifyClass(file);

				} else {
					JOptionPane.showMessageDialog(p2, "班级或者学号不存在");
					txtcj2.requestFocus();
					txtcj2.setText("");
					txtcj3.setText("");
				}
			}
		});

		btncz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtcj2.setText("");
				txtcj3.setText("");
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

}
