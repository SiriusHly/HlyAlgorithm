package ch9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest1 {

	public JFrameTest1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("�����ҵĵ�һ�����ڳ���");
		JPanel p=new JPanel();
		JButton btnOk=new JButton("ȷ��");
		JButton btnCancel=new JButton("ȡ��");
		p.add(btnOk);p.add(btnCancel);
		frame.add(p,BorderLayout.CENTER);
		frame.setSize(300, 400);
		frame.setVisible(true);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		int x=(width-frame.getWidth())/2;
		int y=(height-frame.getHeight())/2;
		frame.setLocation(x, y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
