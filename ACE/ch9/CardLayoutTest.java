package ch9;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutTest extends JFrame {
	JButton btn1=new JButton("button1");  //第一张卡片
	JButton btn2=new JButton("button2");  //第二张卡片
	JButton btnNext=new JButton("btnNext");   //单击可以显示下一张卡片
	JPanel pAll=new JPanel(); //第三张卡片，里面盛放2个Label
	JLabel lblName=new JLabel("张三");
	JLabel lblAge=new JLabel("20");
	JPanel p=new JPanel();   //用于盛放多张卡片
	CardLayout cd=new CardLayout();
	public CardLayoutTest(){
		super("CardLayout 演示");
		this.add(btnNext,BorderLayout.NORTH); p.add(btn1);   p.add(btn2);     //p中放3张卡片
		pAll.add(lblName);    pAll.add(lblAge);
		p.add(pAll);               
		p.setLayout(cd);  //设面板布局为CardLayout
		this.add(p,BorderLayout.CENTER);
		btnNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cd.next(p);
			}
		});
	}


	public static void main(String[] args) {
		CardLayoutTest frame=new CardLayoutTest();
		frame.setSize(400,300);       
		frame.setVisible(true);
	}

}
