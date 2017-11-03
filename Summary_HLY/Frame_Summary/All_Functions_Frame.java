package Frame_Summary;
/*
 * ����:������
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class All_Functions_Frame {

	public All_Functions_Frame() {
		
	}
	public void hly(){
		JFrame frame = new JFrame();//����һ������
		frame.setTitle("ʵ�����еĹ���");
		frame.setResizable(true);//���ô����Ƿ���Ե�����С��
		boolean b = frame.isResizable();//�жϴ����Ƿ���Ե�����С��
		String s = frame.getTitle();//��ȡ���ڵı��⣻
		//frame.setBackground(Color.YELLOW);//���ô��ڵı�����ɫ��
		frame.setSize(700, 700);//���ô��ڵĴ�С��
		frame.setVisible(true);//���ô����Ƿ�ɼ���
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		//frame.validate();//ȷ�����������ʾ�������൱��ˢ�£�
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ�ĸ߶ȺͿ��
		int screenWidth = screen.width;
		int screenHeight = screen.height;
		Dimension frameSize = frame.getSize();//��ȡ��ܵĴ�С��
		int x = (screenWidth-frameSize.width)/2;
		int y = (screenHeight-frameSize.height)/2;
		frame.setLocation(x, y);//���ô��ڵ�λ�ã�
		//frame.setBounds(x,y,800,800);//���ô��ڵĴ�С��λ��
		Container container = frame.getContentPane();//��ȡ���ڵ����ݴ���
		container.setLayout(new GridLayout(2,2));//Ϊ���ݴ������ò��ֹ�������
//		GridLayout g1 = new GridLayout(2,2,10,20);//��2��2��ˮƽ10����ֱ20���أ�
		
		
		JPanel p1 = new JPanel();
		FlowLayout f1 = new FlowLayout();
//		FlowLayout f11 = new FlowLayout(FlowLayout.CENTER, 10, 20);//ˮƽ10����ֱ20��
		f1.setAlignment(FlowLayout.LEFT);//���ö���Ķ��뷽ʽ��
		f1.setHgap(10);//��ֱ�������أ�
		f1.setVgap(10);//ˮƽ�������أ�
		p1.setLayout(f1);//Ϊp1���ò��ֹ�������
		container.add(p1);
		p1.setBackground(Color.BLUE);
		
		
		
		JPanel p2 = new JPanel();
		BorderLayout b1 = new BorderLayout(10,10);//0���أ�
//		BorderLayout b2 = new BorderLayout(2,2);
		p2.setLayout(b1);
		p2.setBackground(Color.green);
		container.add(p2);
//		JPanel p21 = new JPanel();
		p2.add(new JButton("South"),BorderLayout.SOUTH);
		
		
		
		JPanel p3 = new JPanel();
		CardLayout c1 = new CardLayout();
		p3.setLayout(c1);
		p3.setBorder(new LineBorder(Color.black));//??
		p3.add(new JLabel("��Ƭ1",JLabel.CENTER), "card1");//??
		p3.add(new JLabel("��Ƭ2",JLabel.CENTER), "card2");
		p3.add(new JLabel("��Ƭ3",JLabel.CENTER), "card3");
		JPanel p31 = new JPanel();
		JPanel p32 = new JPanel();
		JPanel p33 = new JPanel();
		p31.setLayout(new GridLayout(2,2));
		JButton btn1= new JButton("NBT");
		JButton btn2 = new JButton("PBT");
		p32.add(btn1);
		p32.add(p3);
		p32.add(btn2);
		container.add(p31);
		p31.add(p32);
		p31.add(p33);
		p33.setBackground(Color.pink);
		
	  class ActionResponse implements ActionListener{
		public void actionPerformed(ActionEvent e){
	 if(e.getActionCommand().equals("NBT"))
		 c1.next(p3);
		 else
			 c1.previous(p3); 
		}
	}
	  ActionListener listenter = new ActionResponse();
	    btn1.addActionListener(listenter);
	    btn2.addActionListener(listenter);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame.validate();
	}

	public static void main(String[] hly) {
		All_Functions_Frame y = new All_Functions_Frame();
		y.hly();
		
		
	}

}
