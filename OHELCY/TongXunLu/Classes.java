package TongXunLu;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * ���ߣ�������
 */
public class Classes extends JFrame implements ActionListener {
	private JButton xg = new JButton("������Ϣ");
	private JButton cj = new JButton("�����༶");
	private JPanel p1 = new JPanel();
	private JLabel lbl1 = new JLabel("��ӭʹ�ð༶ͨѶ¼");

	public Classes() {
		JFrame c = new JFrame();
		Container con = c.getContentPane();
		con.add(p1);
		p1.setLayout(null);
		p1.add(xg);
		p1.add(cj);
		p1.add(lbl1);
		lbl1.setBounds(80, 20, 120, 50);
		xg.setBounds(30, 90, 90, 30);
		cj.setBounds(160, 90, 90, 30);
		c.setSize(300, 200);
		center(c);
		validate();

		xg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ZhuYe y = new ZhuYe();
			}
		});

		cj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chuangJian cjb = new chuangJian();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public static void main(String[] args) {

	}

	public static void center(JFrame jf) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		Dimension frameSize = jf.getSize();
		int x = (screenWidth - frameSize.width) / 2;
		int y = (screenHeight - frameSize.height) / 2;
		jf.setLocation(x, y);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

class chuangJian {
	File file;
	String path = "f:/TongXunLu/";
	private JLabel cj2 = new JLabel("������Ҫ�����İ༶");
	private JTextField txtcj2 = new JTextField(10);
	private JButton btncj = new JButton("ȷ��");
	private JButton btncz = new JButton("����");
	private JPanel p2 = new JPanel();

	public chuangJian() {
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

		btncj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				file = new File(path + "\\" + txtcj2.getText());
				if (!file.exists()) {
					file.mkdir();
					JOptionPane.showMessageDialog(p2, "�����ɹ�");
				} else {
					JOptionPane.showMessageDialog(p2, "�༶�Ѵ��ڣ������´���");
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

}

/*
 * class xiugai extends JFrame { File file; String path = "f:/TongXunLu/";
 * private JLabel cj2 = new JLabel("������Ҫ�����İ༶"); private JTextField txtcj2 = new
 * JTextField(10); private JButton btncj = new JButton("ȷ��"); private JButton
 * btncz = new JButton("����"); private JPanel p2 = new JPanel();
 * 
 * public xiugai() { JFrame c2 = new JFrame(); Container con2 =
 * c2.getContentPane(); con2.add(p2); p2.setLayout(new FlowLayout());
 * p2.add(cj2); p2.add(txtcj2); p2.add(btncj); p2.add(btncz); c2.setSize(300,
 * 150); Classes.center(c2); validate();
 * 
 * btncj.addActionListener(new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) { file = new File(path +
 * "\\" + txtcj2.getText()); if (!file.exists()) {
 * JOptionPane.showMessageDialog(p2, "�༶�����ڣ����ȴ���"); } else { Functions ft = new
 * Functions(file); } } });
 * 
 * btncz.addActionListener(new ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) { txtcj2.setText(""); }
 * });
 * 
 * 
 * 
 * }
 * 
 * }
 */