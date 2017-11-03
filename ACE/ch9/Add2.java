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
	 * ��д�ӷ�����
	 * ��ֱ��ʵ��FocusAListener��ʵ��ActionListener�ӿڵķ�ʽ�� ʵ���¼��������
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
	
		//������װ���
		//���濪ʼ�����¼�

		txtNumber1.addFocusListener(this);
		txtNumber2.addFocusListener(this);
		btnEqual.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void focusGained(FocusEvent e) {//�����������ʱִ�и÷���
	}
	public void focusLost(FocusEvent e) {//������뿪���ʱִ�и÷���
		if(e.getSource()==txtNumber1){
			if(txtNumber1.getText().trim().equals(("")))
				return;
			if(!isNumber(txtNumber1.getText())){
				lblErrorMessage.setText("���ݸ�ʽ���ԣ����������֣�");
				txtNumber1.setText("");
				txtNumber1.requestFocus();//�����뽹���������txtNumber1
			}
			else
				lblErrorMessage.setText("");
		}else if(e.getSource()==txtNumber2){
			if(txtNumber2.getText().trim().equals(("")))
				return;
			if(!isNumber(txtNumber2.getText())){
				lblErrorMessage.setText("���ݸ�ʽ���ԣ����������֣�");
				txtNumber2.setText("");
				txtNumber2.requestFocus();//�����뽹���������txtNumber2
			}
			else
				lblErrorMessage.setText("");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEqual){//�������ˡ��Ⱥš���ťʱִ�и÷���
			if(txtNumber1.getText().trim().equals("")||txtNumber2.getText().trim().equals("")){
				lblErrorMessage.setText("�����뱻�����ͼ�����");
				return;
			}
			double a=Double.valueOf(txtNumber1.getText());
			double b=Double.valueOf(txtNumber2.getText());
			double sum=a+b;
			txtSum.setText(String.valueOf(sum));
			lblErrorMessage.setText("");
		}
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
	public static void main(String[] args) {
		Add2 add=new Add2();
		add.setSize(500,200);
		add.setVisible(true);
	}
}
