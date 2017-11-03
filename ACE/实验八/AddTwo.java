package 实验八;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddTwo extends JFrame implements FocusListener,ActionListener{
private JTextField txtNum1 = new JTextField(10);
private JLabel lblJia = new JLabel ("+");
private JTextField txtNum2 = new JTextField(10);
private JTextField TxtSum = new JTextField(10);
private JButton btnEqu = new JButton("=");
private JLabel lblErrorMessage = new JLabel("");

	public AddTwo() {
		initialize();
	}
	private void initialize(){
		setLayout(new FlowLayout());
		add(txtNum1);
		add(lblJia);
		add(txtNum2);
		add(btnEqu);
		add(TxtSum);
		add(lblErrorMessage);
		txtNum1.addFocusListener(this);
		txtNum2.addFocusListener(this);
		btnEqu.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public boolean isNumber(String s){
		if(s.length()==0)
			return false;
		char c =s.charAt(0);
		if(c=='.')
			return false;
		int dotCount=0;
		for(int i=0;i<s.length();i++){
			 c =s.charAt(i);
			if(c=='.'){//注意括号位置
				dotCount++;
				if(dotCount>1)
					return false;
			}
			
		else if(c>57||c<48){
			return false;
		}
		}
		return true;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnEqu){
			if(txtNum1.getText().trim().equals("")||txtNum2.getText().trim().equals("")){
				System.out.println("请输入数和被加数");
			}
			double a = Double.parseDouble(txtNum1.getText());
			double b = Double.parseDouble(txtNum2.getText());
			double sum = a+b;
			TxtSum.setText(String.valueOf(sum));
			lblErrorMessage.setText("");
		}
	}
	@Override
	public void focusGained(FocusEvent arg0) {
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==txtNum1){
			if(txtNum1.getText().trim().equals("")){
				return;
			}
			if(!isNumber(txtNum1.getText())){
				System.out.println("你输入的格式不对，请重新输入");
				txtNum1.setText("");
				txtNum1.requestFocus();
			}
			else{
				lblErrorMessage.setText("");
			}
		}
		else if(e.getSource()==txtNum2){
			if(txtNum2.getText().trim().equals("")){
				return;
			}
			if(!isNumber(txtNum2.getText())){
				System.out.println("你输入的格式不对，请重新输入");
				txtNum2.setText("");
				txtNum2.requestFocus();
			}
			else{
				lblErrorMessage.setText("");
			}
		}
	}
	
	public static void main(String[] args) {
		AddTwo add3=new AddTwo();
		add3.setSize(500,200);
		add3.setVisible(true);
	}
	
	

}
