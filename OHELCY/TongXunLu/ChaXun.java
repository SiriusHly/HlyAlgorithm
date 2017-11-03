package TongXunLu;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChaXun extends JFrame implements ActionListener {
	JTextArea txtarea = new JTextArea(30, 52);
	JPanel p1 = new JPanel();
	File file;

	public ChaXun(File file) {
		// p1.setBackground(Color.blue);
		this.file = file;
		p1.add(txtarea);
		Container con = getContentPane();
		con.add(p1);
		p1.setSize(160, 70);
		setSize(600, 750);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(330, 10);
		BufferedReader br = null;
		File[] f = file.listFiles();

		int j = 0;
		StringBuffer sb = new StringBuffer();

		try {

			String str = null;

			for (int i = 0; i < f.length; i++) {
				FileReader fr = new FileReader(f[i]);
				br = new BufferedReader(fr);
				if (!f[i].exists()) {
					JOptionPane.showMessageDialog(p1, "该文件不存在");
				}

				while ((str = br.readLine()) != null) {
                    txtarea.append((i+1)+": ");
					txtarea.append(str);
					txtarea.append("\n");
				}
				// System.out.println(s[i]);

				fr.close();
				br.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		validate();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	/*public static void main(String[] args) {
		ChaXun1 s = new ChaXun1();
	}
*/
}

class ChaXun1 extends JFrame implements ActionListener {
	File file;
	String path = "f:/TongXunLu/";
	private JLabel cj2 = new JLabel("请输入要查询的班级");

	private JTextField txtcj2 = new JTextField(10);

	private JButton btncj = new JButton("确定");
	private JButton btncz = new JButton("重置");
	private JPanel p2 = new JPanel();

	public ChaXun1() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JFrame c2 = new JFrame();
		Container con2 = c2.getContentPane();
		con2.add(p2);
		p2.setLayout(new FlowLayout());
		p2.add(cj2);
		p2.add(txtcj2);

		p2.add(btncj);
		p2.add(btncz);
		c2.setSize(300, 150);
		Classes.center(c2);
		validate();

		btncj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				file = new File(path + "\\" + txtcj2.getText());
				if (file.exists()) {
					ChaXun o = new ChaXun(file);

				} else {
					JOptionPane.showMessageDialog(p2, "该班级不存在");
					txtcj2.setText("");

				}
			}
		});

		btncz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtcj2.setText("");

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

}
