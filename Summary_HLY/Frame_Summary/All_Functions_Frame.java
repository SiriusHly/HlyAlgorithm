package Frame_Summary;
/*
 * 作者:黄良运
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
		JFrame frame = new JFrame();//创建一个窗口
		frame.setTitle("实现所有的功能");
		frame.setResizable(true);//设置窗口是否可以调整大小；
		boolean b = frame.isResizable();//判断窗口是否可以调整大小；
		String s = frame.getTitle();//获取窗口的标题；
		//frame.setBackground(Color.YELLOW);//设置窗口的背景颜色；
		frame.setSize(700, 700);//设置窗口的大小；
		frame.setVisible(true);//设置窗口是否可见；
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		//frame.validate();//确保窗口组件显示出来，相当于刷新；
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的高度和宽度
		int screenWidth = screen.width;
		int screenHeight = screen.height;
		Dimension frameSize = frame.getSize();//获取框架的大小；
		int x = (screenWidth-frameSize.width)/2;
		int y = (screenHeight-frameSize.height)/2;
		frame.setLocation(x, y);//设置窗口的位置；
		//frame.setBounds(x,y,800,800);//设置窗口的大小和位置
		Container container = frame.getContentPane();//获取窗口的内容窗格；
		container.setLayout(new GridLayout(2,2));//为内容窗格设置布局管理器；
//		GridLayout g1 = new GridLayout(2,2,10,20);//，2行2列水平10，垂直20像素；
		
		
		JPanel p1 = new JPanel();
		FlowLayout f1 = new FlowLayout();
//		FlowLayout f11 = new FlowLayout(FlowLayout.CENTER, 10, 20);//水平10，垂直20；
		f1.setAlignment(FlowLayout.LEFT);//设置对象的对齐方式；
		f1.setHgap(10);//垂直间距的像素；
		f1.setVgap(10);//水平间距的像素；
		p1.setLayout(f1);//为p1设置布局管理器；
		container.add(p1);
		p1.setBackground(Color.BLUE);
		
		
		
		JPanel p2 = new JPanel();
		BorderLayout b1 = new BorderLayout(10,10);//0像素；
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
		p3.add(new JLabel("卡片1",JLabel.CENTER), "card1");//??
		p3.add(new JLabel("卡片2",JLabel.CENTER), "card2");
		p3.add(new JLabel("卡片3",JLabel.CENTER), "card3");
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
