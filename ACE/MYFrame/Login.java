package MYFrame;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {
	JLabel lblUserName = new JLabel("UserName");
	JLabel lblPassword = new JLabel("Password");
	JTextField txtUserName = new JTextField(20);
	JTextField txtPassword = new JTextField(20);
	JButton btnLogin = new JButton("Login");
	JButton btnCancel = new JButton("Cancel");
	JPanel p = new JPanel();
	
	

	public Login() throws HeadlessException {
		super();
		
	}

	public Login(GraphicsConfiguration arg0) {
		super(arg0);
		
	}

	public Login(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		
	}

	public Login(String arg0) throws HeadlessException {
		super(arg0);
		p.add(lblUserName);p.add(txtUserName);
		p.add(lblPassword);p.add(txtPassword);
		p.add(btnLogin);p.add(btnCancel);
		this.add(p);
		this.setSize(350,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
Login frame = new Login("Login");
frame.setLocationRelativeTo(null);
	}

}
