package ¾­µä´úÂë;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {
JButton btnEast = new JButton("EAST");
JButton btnSouth = new JButton("South");
JButton btnWest = new JButton("West");
JButton btnNorth = new JButton("North");
JButton btnCenter = new JButton("Center");
public BorderLayoutTest(){
	super("BorderLayout");
	Container c=getContentPane();
	setLayout(new BorderLayout(10,20));
	this.add(btnEast,BorderLayout.EAST);
	this.add(btnWest,BorderLayout.WEST);
	this.add(btnNorth, BorderLayout.NORTH);
	this.add(btnSouth,BorderLayout.SOUTH);;
	this.add(btnCenter, BorderLayout.CENTER);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String []args){
	BorderLayoutTest frame = new BorderLayoutTest();
	frame.setSize(400,300);
	frame.setVisible(true);
}
}
