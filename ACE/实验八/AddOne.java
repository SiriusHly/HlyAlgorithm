package 实验八;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddOne extends JFrame {
private JTextField txtNum1 = new JTextField(10);
private JLabel lblJia = new JLabel("+");
private JTextField txtNum2 = new JTextField(10);
private JButton btnEqu = new JButton("=");
private JTextField txtSum = new JTextField(10);
private JLabel lblErrorMessage= new JLabel("");

	public AddOne() {
		initialize();
	}
	private void initialize(){
		setLayout(new FlowLayout());
		add(txtNum1);
		add(lblJia);
		add(txtNum2);
		add(btnEqu);
		add(txtSum);
		add(lblErrorMessage);
		ProcessEvent pe = new ProcessEvent();
		txtNum1.addFocusListener(pe);
		txtNum2.addFocusListener(pe);
		btnEqu.addActionListener(pe);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class ProcessEvent  implements FocusListener,ActionListener{


		@Override
		public void focusGained(FocusEvent arg0) {
		}

		@Override
		public void focusLost(FocusEvent e) {
			if(e.getSource()==txtNum1){
				if(txtNum1.getText().trim().equals(""))
					return;
				if(!isNumber(txtNum1.getText())){
					lblErrorMessage.setText("输入格式不对，请输入数字");
					txtNum1.requestFocus();
				}
				else
					lblErrorMessage.setText("");
				
			}
			else if(e.getSource()==txtNum2){
				if(txtNum2.getText().trim().equals(""))
					return;
				if(!isNumber(txtNum2.getText())){
					lblErrorMessage.setText("");
					txtNum2.requestFocus();
				}
				
				else
					lblErrorMessage.setText("");
			}
		}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==btnEqu){
				if(txtNum1.getText().trim().equals("")||txtNum2.getText().trim().equals("")){
					lblErrorMessage.setText("请输入加数和被加数");
					return;
				}
				double a = Double.valueOf(txtNum1.getText());
				double b = Double.valueOf(txtNum2.getText());
				double sum = a+b;
				txtSum.setText(String.valueOf(sum));
				lblErrorMessage.setText("");
			}
		}
	}
private boolean isNumber(String s){
	if(s.length()==0){
		return false;
	}
	int dotCout=0;
	char c = s.charAt(0);
	if(c=='.'){
		return false;
	}
	for(int i=0;i<s.length();i++){
		c=s.charAt(i);
		if(c=='.'){
			dotCout++;
			if(dotCout>1){
				return false;
			}
			else if(c>57||c<48){
				return false;
			}
		}
		
	}
	return true;
}
public static void main(String[] args) {
	AddOne add=new AddOne();
	add.setSize(500,200);
	add.setVisible(true);
}
}

