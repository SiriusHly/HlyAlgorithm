package ch9;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameTest4 extends JFrame {
	JButton btnOk=new JButton("=");
	JTextField txtNum1=new JTextField(20);
	JTextField txtNum2=new JTextField(20);
	JTextField txtSum=new JTextField(20);
	JLabel lblAdd=new JLabel("+");
			
			
	public JFrameTest4() {
		Container c=this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(txtNum1);c.add(lblAdd);c.add(txtNum2);
		c.add(btnOk);c.add(txtSum);
		txtNum1.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtNum1.getText().trim().length()==0)
					return;
				if(!isNumber(txtNum1.getText())){
					txtSum.setText("第一个框输入的不是数字");
					txtNum1.setText("");
					txtNum1.requestFocus();
				}
				
			}
			
		});
		txtNum2.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtNum2.getText().trim().length()==0)
					return;
				if(!isNumber(txtNum2.getText())){
					txtSum.setText("第二个框输入的不是数字");
					txtNum2.setText("");
					txtNum2.requestFocus();
				}
				
			}
			
		});
		btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(!isNumber(txtNum1.getText())){
					txtSum.setText("第一个文本框内输入的不是数字，请重新输入");
					txtNum1.setText("");
					txtNum1.requestFocus();
					return;
				}
				if(!isNumber(txtNum2.getText())){
					txtSum.setText("第二个文本框内输入的不是数字，请重新输入");
					txtNum2.setText("");
					txtNum2.requestFocus();
					return;
				}
				double a=Double.parseDouble(txtNum1.getText());
				double b=Double.parseDouble(txtNum2.getText());
				double c=a+b;
				txtSum.setText(String.valueOf(c));
			}
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		JFrameTest4 frame=new JFrameTest4();
		frame.setSize(500,400);
		frame.setVisible(true);

	}
	private boolean isNumber(String s){//判断是否数字的程序，单独编写的
		if(s.length()==0)//空字符串不符合要求
			return false;
		int dotCount=0;//保存小数点的个数，如果大于一个就不符合要求
		char c=s.charAt(0);
		if(c=='.') return false;//第一个字符是小数点不符合要求
		for(int i=0;i<s.length();i++){
			c=s.charAt(i);
			if(c=='.'){ 
				dotCount++;
				if(dotCount>1) return false;
			}else if(c>57||c<48){
				return false;
			}
		}
		return true;
	}

}
