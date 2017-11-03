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
					txtSum.setText("��һ��������Ĳ�������");
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
					txtSum.setText("�ڶ���������Ĳ�������");
					txtNum2.setText("");
					txtNum2.requestFocus();
				}
				
			}
			
		});
		btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(!isNumber(txtNum1.getText())){
					txtSum.setText("��һ���ı���������Ĳ������֣�����������");
					txtNum1.setText("");
					txtNum1.requestFocus();
					return;
				}
				if(!isNumber(txtNum2.getText())){
					txtSum.setText("�ڶ����ı���������Ĳ������֣�����������");
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
	private boolean isNumber(String s){//�ж��Ƿ����ֵĳ��򣬵�����д��
		if(s.length()==0)//���ַ���������Ҫ��
			return false;
		int dotCount=0;//����С����ĸ������������һ���Ͳ�����Ҫ��
		char c=s.charAt(0);
		if(c=='.') return false;//��һ���ַ���С���㲻����Ҫ��
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
