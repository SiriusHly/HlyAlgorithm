package 经典代码;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutTest extends JFrame {
JButton btn1 = new JButton("button1");
JButton btn2 = new JButton("button2");
JButton btnNext = new JButton ("Next");
JPanel pAll = new JPanel();
JLabel lblName = new JLabel("tom");
JLabel lblAge  =new JLabel("20");
JPanel  p = new JPanel();
CardLayout cd = new CardLayout();
public  CardLayoutTest(){
	super("Performer");
	this.add(btnNext, BorderLayout.NORTH);//在构造方法里写，放入窗口；
	p.add(btn1);p.add(btn2);
	pAll.add(lblName);
	pAll.add(lblAge);
	p.add(pAll);
	p.setLayout(cd);//设置面板布局为CardLayout；
	this.add(p, BorderLayout.CENTER);
	btnNext.addActionListener(new ActionListener(){
		public  void actionPerformed(ActionEvent e){//notice void
			cd.next(p);//???????????
		}
	});
}
	public static void main(String[] args) {
CardLayoutTest frame = new CardLayoutTest();
frame.setSize(400,300);
frame.setVisible(true);
	}

}
