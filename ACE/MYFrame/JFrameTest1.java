package MYFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest1 {

	public JFrameTest1() {
	}
	public static void main(String []yun){
		JFrame frame = new JFrame("this is my first frame");
		JPanel p = new JPanel();
		JButton btnOk = new JButton("Ok");
		JButton btnCancel = new JButton("Cancle");
		p.add(btnOk);
		p.add(btnCancel);
		frame.add(p,BorderLayout.CENTER);
		frame.setSize(300, 400);
		frame.setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screenSize.width;
		int h = screenSize.height;
		int x = (w-frame.getWidth())/2;
		int y =(h-frame.getHeight())/2;
		frame.setLocation(x,y);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//DISPOSE_CLOSE���ڹرջ�dispose������ڣ������еĴ��ڱ�dispose֮�󣬻��˳�jvm,���ز��ͷ�
//        EXIT_on_CLOSE���ڱ��رյ�ʱ����˳�jvm��
//		JFrame.DO_NOTHING_ON_CLOSE��ִ���κβ������ز���
//		HIDE_ON_CLOSEӰ�ش��ڣ���㻹��
	}

}
