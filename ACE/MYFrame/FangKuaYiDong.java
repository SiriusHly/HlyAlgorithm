package MYFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class FangKuaYiDong extends JFrame {
private JButton up = new JButton("up");
private JButton down = new JButton("down");
private JButton left = new JButton("left");
private JButton right =  new JButton("right");
private JButton center  = new JButton("center");
private JPanel kongzhi = new JPanel();
private FangKuai fangkuai = new FangKuai();
public FangKuaYiDong(){
	super("ÊµÑéËÄTriangle move");
	kongzhi.setLayout(new BorderLayout());
	kongzhi.add(up,BorderLayout.NORTH);
	kongzhi.add(down, BorderLayout.SOUTH);
	kongzhi.add(right, BorderLayout.EAST);
	kongzhi.add(left, BorderLayout.WEST);
	kongzhi.add(center,BorderLayout.CENTER);
	setLayout(new BorderLayout());
	add(kongzhi,BorderLayout.EAST);
	add(fangkuai,BorderLayout.CENTER);
	up.addActionListener(new Up());
	down.addActionListener(new Down());
	left.addActionListener(new Left());
	right.addActionListener(new Right());
	center.addActionListener(new Center());	
	
	
}
	public static void main(String[] args) {
FangKuaYiDong fang = new FangKuaYiDong();
fang.setSize(500,400);
fang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
fang.setLocationRelativeTo(null);
fang.setVisible(true);

	}
class Up implements ActionListener{
	public void actionPerformed(ActionEvent e){
		fangkuai.up();
	}
}
class Down implements ActionListener{
	public void actionPerformed(ActionEvent e){
		fangkuai.down();
		
	}
}
class Left implements ActionListener{
	public void actionPerformed(ActionEvent e){
		fangkuai.left();
	}
}
class Right implements ActionListener{
	public void actionPerformed(ActionEvent e){
		fangkuai.right();
	}
}
class Center implements ActionListener{
	public void actionPerformed(ActionEvent e){
		fangkuai.center();
		
	}
}
class FangKuai extends JPanel{
	private int x =50;
	private int y = 50;
	private int w=55;
	private int h =55;
	public void up(){
		y-=10;
		repaint();
	}
	public void down(){
y+=10;
repaint();
	}
	public void left(){
	x-=10;
	repaint();
	}
	public void right(){
		x+=10;
		repaint();
		
	}
	public void center (){
		x=y=50;
		w=h=55;
		repaint();
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, w, h);
		
		
	}
}

	
}
