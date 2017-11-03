package Frame_Summary;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayout_hly {

	public FlowLayout_hly() {
	}

	public static void main(String[] args) {
JFrame frame = new JFrame();
Container c = frame.getContentPane();
JPanel p1 = new JPanel();
FlowLayout f1 = new FlowLayout();
f1.setAlignment(FlowLayout.RIGHT);//设置组件之间的对其方式；
p1.setLayout(f1);
f1.setVgap(10);//设置组件的水平间距和垂直间距；
f1.setHgap(10);
frame.setLayout(f1);
p1.setBackground(Color.BLACK);
frame.setVisible(true);
frame.setSize(300, 300);
for(int i=0;i<10;i++){
	p1.add(new JButton(" "+i));
}
c.add(p1);
frame.add(c);
	}

}
