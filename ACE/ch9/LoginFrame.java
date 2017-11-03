package ch9;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
	JLabel lblUserName=new JLabel("用户名：");
	JLabel lblPassword=new JLabel("密    码：");
	JTextField txtUserName=new JTextField(20);
	JTextField txtPassword=new JTextField(20);
	JButton btnLogin=new JButton("登录");
	JButton btnCancel=new JButton("取消");
	JPanel p=new JPanel();
	public LoginFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public LoginFrame(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public LoginFrame(String title) throws HeadlessException {
		super(title);
		p.add(lblUserName);p.add(txtUserName);
		p.add(lblPassword);p.add(txtPassword);
		p.add(btnLogin);p.add(btnCancel);
		this.add(p);
		this.setSize(350,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public LoginFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginFrame frame=new LoginFrame("登录窗口");
		frame.setLocationRelativeTo(null);
	}

}
