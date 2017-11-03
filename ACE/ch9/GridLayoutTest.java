package ch9;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest extends JFrame {
	  private JButton[] button=new JButton[20];  //对象数组
	  public GridLayoutTest(){
	     super("GridLayout布局管理器的展示效果");
	    this.setLayout(new GridLayout(3,2,10,20));
	    for(int i=0;i<20;i++){                       //10个按钮放3行里
	        button[i]=new JButton(String.valueOf(i)); //i转换成字符串
	        add(button[i]);
	     }
	}
	  public static void main(String[] args) {
		  GridLayoutTest frame=new GridLayoutTest();
		   frame.setSize(400,300);
		   frame.setVisible(true);
		   }
		}

