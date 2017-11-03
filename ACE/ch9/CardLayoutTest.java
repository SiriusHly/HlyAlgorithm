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
	JButton btn1=new JButton("button1");  //��һ�ſ�Ƭ
	JButton btn2=new JButton("button2");  //�ڶ��ſ�Ƭ
	JButton btnNext=new JButton("btnNext");   //����������ʾ��һ�ſ�Ƭ
	JPanel pAll=new JPanel(); //�����ſ�Ƭ������ʢ��2��Label
	JLabel lblName=new JLabel("����");
	JLabel lblAge=new JLabel("20");
	JPanel p=new JPanel();   //����ʢ�Ŷ��ſ�Ƭ
	CardLayout cd=new CardLayout();
	public CardLayoutTest(){
		super("CardLayout ��ʾ");
		this.add(btnNext,BorderLayout.NORTH); p.add(btn1);   p.add(btn2);     //p�з�3�ſ�Ƭ
		pAll.add(lblName);    pAll.add(lblAge);
		p.add(pAll);               
		p.setLayout(cd);  //����岼��ΪCardLayout
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
