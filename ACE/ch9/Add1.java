package ch9;

import java.awt.FlowLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Add1 extends JFrame {
	/**
	 * @param args
	 * 编写加法程序
	 * 用单独编写类来实现事件处理程序，通过继承FocusAdapter和实现ActionListener接口
	 */
	
	private JTextField txtNumber1=new JTextField(10);
	private JLabel lblFuHao=new JLabel("+");
	private JTextField txtNumber2=new JTextField(10);
	private JButton btnEqual=new JButton("=");
	private JTextField txtSum=new JTextField(10);
	private JLabel lblErrorMessage1=new JLabel("");
	private JLabel lblErrorMessage2=new JLabel("");
	public Add1(){
		initialize();
	}
	private void initialize(){
		setLayout(new FlowLayout());
		add(txtNumber1);add(lblFuHao);add(txtNumber2);add(btnEqual);add(txtSum);
		add(lblErrorMessage1);add(lblErrorMessage2);
	
		//窗口组装完毕
		//下面开始处理事件
		ProcessEvent pe=new ProcessEvent();
		txtNumber1.addFocusListener(pe);
		txtNumber2.addFocusListener(pe);
		btnEqual.addActionListener(pe);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	public static void main(String[] args) {
		Add1 add=new Add1();
		add.setSize(500,200);
		add.setVisible(true);
	}
	//通过定义内部类来处理各组件的事件，以下两种方法都可以
	//class ProcessEvent extends FocusAdapter implements ActionListener{
	class ProcessEvent  implements FocusListener,ActionListener{
		
		public void focusGained(FocusEvent e) {//当鼠标进入组件时执行该方法
			if(e.getSource()==txtNumber2)
				lblErrorMessage1.setText("焦点到我这了");
		}
		public void focusLost(FocusEvent e) {//当鼠标离开组件时执行该方法
			if(e.getSource()==txtNumber1){
				if(txtNumber1.getText().trim().equals(("")))
					return;
				if(!isNumber(txtNumber1.getText())){
					lblErrorMessage1.setText("数据格式不对，请输入数字！");
					txtNumber1.requestFocus();//让输入焦点继续留在txtNumber1
				}
				else
					lblErrorMessage1.setText("");
			}else if(e.getSource()==txtNumber2){
				if(txtNumber2.getText().trim().equals(("")))
					return;
				if(!isNumber(txtNumber2.getText())){
					lblErrorMessage2.setText("数据格式不对，请输入数字！");
					txtNumber2.requestFocus();//让输入焦点继续留在txtNumber2
				}
				else
					lblErrorMessage2.setText("");
			}
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("=")){
				JOptionPane.showMessageDialog(null, "你选择的是等号按钮","提示",JOptionPane.WARNING_MESSAGE);
			}
			if(e.getSource()==btnEqual){//当单击了“等号”按钮时执行该方法
				if(txtNumber1.getText().trim().equals("")||txtNumber2.getText().trim().equals("")){
					lblErrorMessage1.setText("请输入被加数和加数！");
					return;
				}
				double a=Double.valueOf(txtNumber1.getText());
				double b=Double.valueOf(txtNumber2.getText());
				double sum=a+b;
				txtSum.setText(String.valueOf(sum));
				lblErrorMessage1.setText("");
			}
		}
	}
}
