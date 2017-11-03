package ch9;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameTest3 extends JFrame {

	public JFrameTest3(){
        this.setLayout(new   
               FlowLayout(FlowLayout.TRAILING,80,20));
        this.add(new JButton("button1"));
        this.add(new JButton("button2"));
        this.add(new JButton("button3"));
        this.add(new JButton("button4"));
    }
    public static void main(String[] args) {
    	JFrameTest3 frame=new JFrameTest3();
         frame.setSize(350,200);   frame.setVisible(true);
    }
}

