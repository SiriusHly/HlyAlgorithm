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

public class Add3 extends JFrame{
	/*
	 * @param args
	 * ��д�ӷ�����
	 * ��������ʵ���¼�������������Ƽ��ķ�ʽ
	 */
	private JTextField txtNumber1=new JTextField(10);          //����6�����
	private JLabel lblFuHao=new JLabel("+");
	private JTextField txtNumber2=new JTextField(10);
	private JButton btnEqual=new JButton("=");
	private JTextField txtSum=new JTextField(10);
	private JLabel lblErrorMessage=new JLabel("");               //�Ŵ�����ʾ��Ϣ����ֵΪ��
	public Add3(){
		initialize();
	}
	private void initialize(){
		setLayout(new FlowLayout());
		add(txtNumber1);add(lblFuHao);add(txtNumber2);add(btnEqual);add(txtSum);
		add(lblErrorMessage);
	
		//������װ���
		//���濪ʼ�����¼�
		txtNumber1.addFocusListener(new FocusListener(){                  //�������Ӽ�����
			public void focusLost(FocusEvent fe){                        //������뿪���ʱִ�и÷���
				if(txtNumber1.getText().trim().equals(("")))             //�������ǿ�ʱ����
					return;
				if(!isNumber(txtNumber1.getText())){                      //��������������
					lblErrorMessage.setText("���ݸ�ʽ���ԣ����������֣�");         //������ʾ��ǩ��ʾ����
					txtNumber1.setText("");                               //�ı�������Ϊ��
					txtNumber1.requestFocus();                          //�����뽹���������txtNumber1
				}
				else
					lblErrorMessage.setText("");                          //�����������֣�������ʾ��ǩ��գ�����ʾ���ݣ�
			}
			public void focusGained(FocusEvent fe){                       //ʵ���˽ӿڵ���һ������
				//�����������ʱִ�и÷���
			}
		});
		
		txtNumber2.addFocusListener(new FocusListener(){                    //�����Ӽ�������ͬ��������ȫһ��
			public void focusLost(FocusEvent fe){                          //������뿪���ʱִ�и÷���
				if(txtNumber2.getText().trim().equals(("")))
					return;
				if(!isNumber(txtNumber2.getText())){
					lblErrorMessage.setText("���ݸ�ʽ���ԣ����������֣�");
					txtNumber2.setText("");
					txtNumber2.requestFocus();                            //�����뽹���������txtNumber2
				}
				else
					lblErrorMessage.setText("");
			}
			public void focusGained(FocusEvent fe){
				//�����������ʱִ�и÷���
			}
		});
		
		btnEqual.addActionListener(new ActionListener(){                                          //�ȺżӼ�����
			public void actionPerformed(ActionEvent ae){
				if(txtNumber1.getText().trim().equals("")||txtNumber2.getText().trim().equals("")){
					lblErrorMessage.setText("�����뱻�����ͼ�����");                                              //2������֮һΪ��ʱ������ʾ��ǩ��ʾ���ݣ����أ�����ȡ����
					return;
				}
				double a=Double.valueOf(txtNumber1.getText());                                  //������ת��Ϊʵ��
				double b=Double.valueOf(txtNumber2.getText());
				double sum=a+b;
				txtSum.setText(String.valueOf(sum));                                             //��ת��Ϊ�ַ�������ʾ���ı�����
				lblErrorMessage.setText("");
			}
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private boolean isNumber(String s){                                   //�ж��Ƿ����ֵĳ��򣬵�����д�ģ����ڲ��������������ã�����Ȩ����Ϊ˽��
		if(s.length()==0)                                                 //���ַ���������Ҫ��
			return false;
		int dotCount=0;                                                     //����С����ĸ������������һ���Ͳ�����Ҫ��
		char c=s.charAt(0);
		if(c=='.') return false;                                              //��һ���ַ���С���㲻����Ҫ��
		for(int i=0;i<s.length();i++){
			c=s.charAt(i);
			if(c=='.'){ 
				dotCount++;
				if(dotCount>1) return false;
			}
			else if(c>57||c<48){                                              //����0-9��Unicode��48-57
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Add3 add=new Add3();
		add.setSize(500,200);
		add.setVisible(true);
	}
}


/*
 *��������������ȷ���������󣬱���������ĸ����뿪�󣬴�����ʾһ�����������������֣�ִ���˼����Ĵ����ǩΪ�գ�
 * ��������������ȷ���������󣬼�������ĸ���ű������������ڼ����ı��򣬵�������ʾ����ʾ
 * */
