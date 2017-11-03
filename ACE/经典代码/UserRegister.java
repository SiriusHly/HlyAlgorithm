package ¾­µä´úÂë;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserRegister extends JFrame {
private JLabel lblName = new JLabel(" your Name");
private JLabel lblEmail = new JLabel(" your Email");
private JLabel lblCareer = new JLabel(" your Career");
private JTextField txtName = new JTextField(16);
private JTextField txtEmail = new JTextField(16);
private JTextField txtCareer = new JTextField(16);
private JButton btnResiger = new JButton("Resiger");
private JButton btnCancel = new JButton("Cancel");
//private Box baseBox,bocH1;
private void init(){
	setLayout(null);
	add(lblName);
	//lblName.setBounds(20, 10, 80, 20);
	lblName.setBounds(20, 10, 80, 20);
	add(txtName);
	txtName.setBounds(110,10,140,20);
	add(lblEmail);
	lblEmail.setBounds(20, 40, 80, 20);
	add(txtEmail);
	txtEmail.setBounds(110,40,140,20);
	add(lblCareer);
	lblCareer.setBounds(20, 70, 80, 20);
	add(txtCareer);
	txtCareer.setBounds(110,70,140,20);
	add(btnResiger);
	btnResiger.setBounds(50,110,80,20);
	add(btnCancel);
	btnCancel.setBounds(140,110,90,20);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
public UserRegister(){
	super("Register");
	init();
	
}

	public static void main(String[] args) {
UserRegister frame = new UserRegister();
frame.setSize(300,200);
int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
frame.setLocation((screenWidth-300)/2,(screenHeight-200)/2);
frame.setVisible(true);
	}

}
