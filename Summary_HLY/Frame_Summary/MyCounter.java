package Frame_Summary;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCounter extends JFrame {
JButton btn1 = new JButton("1");
JButton btn2 = new JButton("2");
JButton btn3 = new JButton("3");
JButton btn4 = new JButton("4");
JButton btn5 = new JButton("5");
JButton btn6 = new JButton("6");
JButton btn7 = new JButton("7");
JButton btn8 = new JButton("8");
JButton btn9 = new JButton("9");
JButton btn0 = new JButton("0");
JButton btnQing = new JButton("C");
JButton btnShan = new JButton("<-");
JButton btnJia = new JButton("+");
JButton btnJian = new JButton("-");
JButton btnCheng = new JButton("*");
JButton btnChu = new JButton("%");
JButton btnDian = new JButton(".");
JButton btnDeng = new JButton("=");
JTextField  SX= new JTextField(16);

public void JS(){
	JFrame frame = new JFrame();
	frame.setTitle("Counter_hly");
	frame.setSize(240, 200);
	Dimension screenSize = getToolkit().getDefaultToolkit().getScreenSize();//获取屏幕的高 度和宽度
	int screenWidth = screenSize.width;//获取屏幕的宽度
	int screenHeight = screenSize.height;//获取屏幕高度；
	
	Dimension frameSize = frame.getSize();//获取框架的大小
	int x = (screenWidth-frameSize.width)/2;
	int y = (screenWidth-frameSize.height)/2;
	frame.setLocation(580, 280);//设置框架在屏幕的位置；
	
	frame.setVisible(true);
	Container container = frame.getContentPane();//获取容器的内容窗格；
	container.setLayout(new BorderLayout());//为内容窗格设置布局管理器；
	JPanel p1 = new JPanel();
	p1.setLayout(new GridLayout(5,4));//为面板设置网格布局管理器；
	JPanel p2 = new JPanel();
	p2.setLayout(new BorderLayout());
	p2.add(p1,BorderLayout.CENTER);
	container.add(p2, BorderLayout.SOUTH);
	container.add(SX, BorderLayout.CENTER);
	/*
	 * for(int i=0;i<9;i++){
	 * p1.add(new JButton(" "+i);
	 * }
	 */
	
	p1.add(btnQing);
	p1.add(btnShan);
	p1.add(btnChu);
	p1.add(btnCheng);
	p1.add(btn1);
	p1.add(btn2);
	p1.add(btn3);
	p1.add(btnJian);
	p1.add(btn4);
	p1.add(btn5);
	p1.add(btn6);
	p1.add(btnJia);
	p1.add(btn7);
	p1.add(btn8);
	p1.add(btn9);
	p1.add(btnDeng);
	p1.add(btn0);
	p1.add(btnDian);
	ProcessEvent pe = new ProcessEvent();
	btn1.addActionListener(pe);
	btn2.addActionListener(pe);
	btn3.addActionListener(pe);
	btn4.addActionListener(pe);
	btn5.addActionListener(pe);
	btn6.addActionListener(pe);
	btn7.addActionListener(pe);
	btn8.addActionListener(pe);
	btn9.addActionListener(pe);
	btn0.addActionListener(pe);
	
}
StringBuffer f = new StringBuffer();
class ProcessEvent implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1){
			SX.setText(SX.getText()+"1");
		}
		if(e.getSource()==btn2){
			SX.setText(SX.getText()+"2");
		}
		if(e.getSource()==btn3){
			SX.setText(SX.getText()+"3");
		}
		if(e.getSource()==btn4){
			SX.setText(SX.getText()+"4");
		}
		if(e.getSource()==btn5){
			SX.setText(SX.getText()+"5");
		}
		if(e.getSource()==btn6){
			SX.setText(SX.getText()+"6");
		}
		if(e.getSource()==btn7){
			SX.setText(SX.getText()+"7");
		}
		if(e.getSource()==btn8){
			SX.setText(SX.getText()+"8");
		}
		if(e.getSource()==btn9){
			SX.setText(SX.getText()+"9");
		}
		if(e.getSource()==btn0){
			SX.setText(SX.getText()+"0");
		}
		if(e.getActionCommand().equals("*")){
			double s = Double.valueOf(SX.getText());
		}
	}
}


 


	public MyCounter() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	public MyCounter(String str){
	
	
	}

	public static void main(String[] args) {
MyCounter y = new MyCounter();
		y.JS();



	}
	

}
