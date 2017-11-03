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
	 * 编写加法程序
	 * 用匿名类实现事件处理程序，这是推荐的方式
	 */
	private JTextField txtNumber1=new JTextField(10);          //产生6个组件
	private JLabel lblFuHao=new JLabel("+");
	private JTextField txtNumber2=new JTextField(10);
	private JButton btnEqual=new JButton("=");
	private JTextField txtSum=new JTextField(10);
	private JLabel lblErrorMessage=new JLabel("");               //放错误提示信息，初值为空
	public Add3(){
		initialize();
	}
	private void initialize(){
		setLayout(new FlowLayout());
		add(txtNumber1);add(lblFuHao);add(txtNumber2);add(btnEqual);add(txtSum);
		add(lblErrorMessage);
	
		//窗口组装完毕
		//下面开始处理事件
		txtNumber1.addFocusListener(new FocusListener(){                  //被加数加监听器
			public void focusLost(FocusEvent fe){                        //当鼠标离开组件时执行该方法
				if(txtNumber1.getText().trim().equals(("")))             //被加数是空时返回
					return;
				if(!isNumber(txtNumber1.getText())){                      //被加数不是数字
					lblErrorMessage.setText("数据格式不对，请输入数字！");         //错误提示标签显示内容
					txtNumber1.setText("");                               //文本框设置为空
					txtNumber1.requestFocus();                          //让输入焦点继续留在txtNumber1
				}
				else
					lblErrorMessage.setText("");                          //被加数是数字，错误提示标签清空（不显示内容）
			}
			public void focusGained(FocusEvent fe){                       //实现了接口的另一个方法
				//当鼠标进入组件时执行该方法
			}
		});
		
		txtNumber2.addFocusListener(new FocusListener(){                    //加数加监听器，同被加数完全一样
			public void focusLost(FocusEvent fe){                          //当鼠标离开组件时执行该方法
				if(txtNumber2.getText().trim().equals(("")))
					return;
				if(!isNumber(txtNumber2.getText())){
					lblErrorMessage.setText("数据格式不对，请输入数字！");
					txtNumber2.setText("");
					txtNumber2.requestFocus();                            //让输入焦点继续留在txtNumber2
				}
				else
					lblErrorMessage.setText("");
			}
			public void focusGained(FocusEvent fe){
				//当鼠标进入组件时执行该方法
			}
		});
		
		btnEqual.addActionListener(new ActionListener(){                                          //等号加监听器
			public void actionPerformed(ActionEvent ae){
				if(txtNumber1.getText().trim().equals("")||txtNumber2.getText().trim().equals("")){
					lblErrorMessage.setText("请输入被加数和加数！");                                              //2个数或之一为空时错误提示标签显示内容，返回，不获取焦点
					return;
				}
				double a=Double.valueOf(txtNumber1.getText());                                  //被加数转换为实数
				double b=Double.valueOf(txtNumber2.getText());
				double sum=a+b;
				txtSum.setText(String.valueOf(sum));                                             //和转换为字符串，显示在文本框中
				lblErrorMessage.setText("");
			}
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private boolean isNumber(String s){                                   //判断是否数字的程序，单独编写的，类内部的其它方法调用，访问权限设为私有
		if(s.length()==0)                                                 //空字符串不符合要求
			return false;
		int dotCount=0;                                                     //保存小数点的个数，如果大于一个就不符合要求
		char c=s.charAt(0);
		if(c=='.') return false;                                              //第一个字符是小数点不符合要求
		for(int i=0;i<s.length();i++){
			c=s.charAt(i);
			if(c=='.'){ 
				dotCount++;
				if(dotCount>1) return false;
			}
			else if(c>57||c<48){                                              //数字0-9的Unicode是48-57
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
 *被加数，加数正确，计算结果后，被加数放字母光标离开后，错误提示一闪而过：加数是数字，执行了加数的错误标签为空；
 * 被加数，加数正确，计算结果后，加数放字母光标放被加数，焦点在加数文本框，但错误提示不显示
 * */
