package ¾­µä´úÂë;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColorTest extends JFrame {

	JPanel p = new JPanel();
	JLabel lblName = new JLabel("Name");
	JTextField txtName = new JTextField(10);
	JButton btnOk = new JButton("OK");
	public ColorTest(){
		super("Color use mention");
		Color color1 = new Color(200,20,30);
		Color color2 = new Color(0,0,255);
		lblName.setForeground(color1);
		btnOk.setForeground(Color.BLUE);
		p.setBackground(Color.LIGHT_GRAY);
		p.add(lblName);
		p.add(txtName);
		p.add(btnOk);
		this.add(p, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
ColorTest frame = new ColorTest();
frame.setSize(400,300);
frame.setVisible(true);
	}

}
