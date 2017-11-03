package ch9;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add2 extends JFrame implements FocusListener,ActionListener{
	/**
	 * @param args
	 * 编写加法程序
	 * 用直接实现FocusAListener和实现ActionListener接口的方式， 实现事件处理程序
	 */
	
	private JTextField txtNumber1=new JTextField(10);
	private JLabel lblFuHao=new JLabel("+");
	private JTextField txtNumber2=new JTextField(10);
	private JButton btnEqual=new JButton("=");
	private JTextField txtSum=new JTextField(10);
	private JLabel lblErrorMessage=new JLabel("");
	public Add2(){
		initialize();
	}
	private void initialize(){
		setLayout(new FlowLayout());
		add(txtNumber1);add(lblFuHao);add(txtNumber2);add(btnEqual);add(txtSum);
		add(lblErrorMessage);
	
		//窗口组装完毕
		//下面开始处理事件

		txtNumber1.addFocusListener(this);
		txtNumber2.addFocusListener(this);
		btnEqual.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void focusGained(FocusEvent e) {//当鼠标进入组件时执行该方法
	}
	public void focusLost(FocusEvent e) {//当鼠标离开组件时执行该方法
		if(e.getSource()==txtNumber1){
			if(txtNumber1.getText().trim().equals(("")))
				return;
			if(!isNumber(txtNumber1.getText())){
				lblErrorMessage.setText("数据格式不对，请输入数字！");
				txtNumber1.setText("");
				txtNumber1.requestFocus();//让输入焦点继续留在txtNumber1
			}
			else
				lblErrorMessage.setText("");
		}else if(e.getSource()==txtNumber2){
			if(txtNumber2.getText().trim().equals(("")))
				return;
			if(!isNumber(txtNumber2.getText())){
				lblErrorMessage.setText("数据格式不对，请输入数字！");
				txtNumber2.setText("");
				txtNumber2.requestFocus();//让输入焦点继续留在txtNumber2
			}
			else
				lblErrorMessage.setText("");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEqual){//当单击了“等号”按钮时执行该方法
			if(txtNumber1.getText().trim().equals("")||txtNumber2.getText().trim().equals("")){
				lblErrorMessage.setText("请输入被加数和加数！");
				return;
			}
			double a=Double.valueOf(txtNumber1.getText());
			double b=Double.valueOf(txtNumber2.getText());
			double sum=a+b;
			txtSum.setText(String.valueOf(sum));
			lblErrorMessage.setText("");
		}
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
		Add2 add=new Add2();
		add.setSize(500,200);
		add.setVisible(true);
	}
}
