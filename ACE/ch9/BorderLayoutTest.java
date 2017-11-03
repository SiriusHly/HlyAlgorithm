package ch9;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {

	JButton btnEast=new JButton("东");JButton btnWest=new JButton("西");
	JButton btnSouth=new JButton("南");JButton btnNorth=new JButton("北");
	   JButton btnCenter=new JButton("中");
	    public BorderLayoutTest(){                                  //构造方法
	        super("BorderLayout布局管理器的展示效果");
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