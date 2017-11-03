package MYFrame;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame1 extends JFrame {
JButton btnOk = new JButton("OK");
JButton btnCancle = new JButton("Cancel");
JPanel p = new JPanel();

	public MyFrame1() throws HeadlessException {
	super();
	
}

public MyFrame1(GraphicsConfiguration gc) {
	super(gc);
	
}

public MyFrame1(String title, GraphicsConfiguration gc) {
	super(title, gc);
	
}

public MyFrame1(String title) throws HeadlessException {
	super(title);
	p.add(btnOk);
	p.add(btnCancle);
	this.add(p);//把面板放入框架中
	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	this.setSize(300, 400);
	this.setVisible(true);
	
	
}

	public static void main(String[] args) {
MyFrame1 frame = new MyFrame1("this is my frame");
frame.setSize(800, 400);
frame.setLocationRelativeTo(null);//null窗口置于屏幕间
frame.setVisible(true);

	}

}
