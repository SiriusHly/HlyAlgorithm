package ch9;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest2 extends JFrame {
	JButton btnOk=new JButton("确定");
	JButton btnCancel=new JButton("取消");
	JPanel p=new JPanel();
	
	public JFrameTest2() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public JFrameTest2(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public JFrameTest2(String title) throws HeadlessException {
		super(title);
		p.add(btnOk);p.add(btnCancel);
		this.add(p);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,400);
		this.setVisible(true);
		
	}

	public JFrameTest2(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]){
		JFrameTest2 frame=new JFrameTest2("这是有一个窗口");
		frame.setSize(800,400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
