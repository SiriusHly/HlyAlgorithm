package ch9;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {

	JButton btnEast=new JButton("��");JButton btnWest=new JButton("��");
	JButton btnSouth=new JButton("��");JButton btnNorth=new JButton("��");
	   JButton btnCenter=new JButton("��");
	    public BorderLayoutTest(){                                  //���췽��
	        super("BorderLayout���ֹ�������չʾЧ��");
	        //Container c=getContentPane();
	        setLayout(new BorderLayout(10,20));
	        this.add(btnEast,BorderLayout.EAST);
	        this.add(btnWest,BorderLayout.WEST);  
	        add(btnSouth,BorderLayout.SOUTH);
	        add(btnNorth,BorderLayout.CENTER);
	        add(btnCenter,BorderLayout.NORTH);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		BorderLayoutTest frame=new BorderLayoutTest();
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
}