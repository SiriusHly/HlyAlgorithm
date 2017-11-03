package TongXunLu;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * ���ߣ�������
 */
public class Denglu extends JFrame implements ActionListener {
	private JTextField id = new JTextField(10);
	private JPasswordField pass = new JPasswordField(10);
	private JButton btndl = new JButton("��¼");
	private JButton btnClose = new JButton("�ر�");
	private JLabel lblpw = new JLabel("����:");
	private JLabel lblName = new JLabel("����:");
	private JLabel lblClass = new JLabel("�༶ͨѶ¼");
	private JPanel p1 = new JPanel();

	public Denglu() {
		setTitle("��ӭ����༶ͨѶϵͳ");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container con = getContentPane();
		con.add(p1);
		p1.setLayout(null);
		p1.add(lblName);
		p1.add(lblpw);
		p1.add(btndl);
		p1.add(btnClose);
		p1.add(id);
		p1.add(pass);
		p1.add(lblClass);
		lblClass.setBounds(160, 10, 400, 40);
		lblName.setBounds(100, 60, 400, 40);
		lblpw.setBounds(100, 90, 400, 40);
		btndl.setBounds(220, 150, 60, 30);
		btnClose.setBounds(120, 150, 60, 30);
		id.setBounds(130, 70, 150, 20);
		pass.setBounds(130, 100, 150, 20);
		validate();

		btndl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlActionPerformed(e);
			}
		});

		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				closeActionPerformed(e);// ?
			}
		});
	}

	private void dlActionPerformed(ActionEvent e) {
		String name = this.id.getText().trim();
		String pw = this.pass.getText().trim();
		if (name.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "�û���Ϊ��");
			return;
		}
		if (pw.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "����Ϊ��");
			return;
		}
		if (!name.equalsIgnoreCase("123") || !pw.equalsIgnoreCase("123")) {
			JOptionPane.showMessageDialog(this, "�û���/�������");
			return;
		}

		if (name.equalsIgnoreCase("123") && pw.equalsIgnoreCase("123")) {
			Classes s = new Classes();
			// s.setVisible(true);
			this.dispose();
		}
	}

	private void closeActionPerformed(ActionEvent e) {
		this.dispose();
	}

	public static void main(String[] args) {
		Denglu dl1 = new Denglu();
		dl1.setVisible(true);
		dl1.setSize(400, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		Dimension frameSize = dl1.getSize();
		int x = (screenWidth - frameSize.width) / 2;
		int y = (screenHeight - frameSize.height) / 2;
		dl1.setLocation(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

}
