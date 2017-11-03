package ch9;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelTest2 extends JFrame {
	JPanel p=new JPanel();
	Container c=this.getContentPane();
	JLabel lblUserName=new JLabel("”√ªß√˚£∫");
	JTextField txtUserName=new JTextField(10);
	JLabel lblPassword=new JLabel("√‹  ¬Î£∫");
	JTextField txtPassword=new JTextField(10);
	public JPanelTest2() {
		
	}

	

	public JPanelTest2(String title) {
		super(title);
		init();
	}
	private void init(){
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.setLayout(null);
		p.add(lblUserName);p.add(txtUserName);
		p.add(lblPassword);p.add(txtPassword);
		p.setPreferredSize(new Dimension(300,200));
		p.setBorder(BorderFactory.createLineBorder(Color.BLUE, 6));
		lblUserName.setBounds(20, 20, 80, 40);
		txtUserName.setBounds(120,20,80,40);
		lblPassword.setBounds(20, 80, 80, 40);
		txtPassword.setBounds(120, 80, 80, 40);
		c.add(p);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		JPanelTest2 frame=new JPanelTest2("JPanel≤‚ ‘");
		frame.setVisible(true);
	}
}
