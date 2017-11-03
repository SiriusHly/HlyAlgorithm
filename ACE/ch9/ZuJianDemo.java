package ch9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ZuJianDemo extends JFrame {
	//定义要在窗口中显示的属性，即组件
	JLabel lblName=new JLabel("    姓名：");
	JTextField txtName=new JTextField(10);
	JLabel lblAge =new JLabel("    年龄：");
	JTextField txtAge=new JTextField(10);
	JLabel lblSex =new JLabel("    性别：");
	ButtonGroup group=new ButtonGroup();
	JRadioButton rbtMale=new JRadioButton("男",true);
	JRadioButton rbtFeMale=new JRadioButton("女",false);
	JLabel lblDepartment =new JLabel("    学院：");
	JComboBox jbxDepartment=new JComboBox();
	JLabel lblHobby =new JLabel("    爱好：");
	JCheckBox cbxBasketball=new JCheckBox("篮球");
	JCheckBox cbxFootball=new JCheckBox("足球");
	JCheckBox cbxDance=new JCheckBox("舞蹈");
	
	JLabel lblJianLi =new JLabel("    简历：");
	JTextArea jtaJianLi=new JTextArea(6,20);
	
	JButton btnOk=new JButton("确定");
	JButton btnReset=new JButton("重置");
	
	JLabel lblResult =new JLabel("    你输入的是：");
	JTextArea jtaResult=new JTextArea(6,20);
	JPanel p=new JPanel();JPanel pJbxx=new JPanel();
	JPanel pJianLi=new JPanel();
	public ZuJianDemo(){
		//将组件放入窗口中，基本信息放在上边的面板pJbxx中，简历放在下边的面板pJianLi中
		pJbxx.setLayout(new GridLayout(0,4));//每行放4个组件
		//姓名和年龄占一行
		pJbxx.add(lblName);pJbxx.add(txtName);
		pJbxx.add(lblAge);pJbxx.add(txtAge);
		//性别占一行，不够4个，用一个用空的JLabel填充
		pJbxx.add(lblSex);pJbxx.add(rbtMale);pJbxx.add(rbtFeMale);
		pJbxx.add(new JLabel());
		//把男女单选按钮放到一个组里，实现互斥
		group.add(rbtMale);group.add(rbtFeMale);
		//学院占一行，该行不够4个，用2个空的JLabel填充
		pJbxx.add(lblDepartment);pJbxx.add(jbxDepartment);
		pJbxx.add(new JLabel());pJbxx.add(new JLabel());//
		jbxDepartment.addItem("计算机学院");//添加下拉选择项
		jbxDepartment.addItem("管理学院");
		jbxDepartment.addItem("土木学院");
		//爱好占一行
		pJbxx.add(lblHobby);pJbxx.add(cbxBasketball);
		pJbxx.add(cbxFootball);pJbxx.add(cbxDance);cbxDance.setEnabled(false);
		
		//确定和重置按钮占一行，该行不够4个，用2个空的JLabel填充
		pJbxx.add(new JLabel());pJbxx.add(btnOk);pJbxx.add(btnReset);
		pJbxx.add(new JLabel());
		//把大的组件放到下面的面板pJianLi中,包括简历、输入的结果
		pJianLi.setLayout(new GridLayout(0,2,2,10));
		pJianLi.add(lblJianLi);pJianLi.add(jtaJianLi);
		pJianLi.add(lblResult);pJianLi.add(jtaResult);
		p.add(pJbxx);p.add(pJianLi);
		add(p,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//添加事件处理，单击单选按钮“男”时，让篮球和足球可选，舞蹈不可选，同时让舞蹈为未选中状态
		rbtMale.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cbxBasketball.setEnabled(true);
				cbxFootball.setEnabled(true);
				cbxDance.setEnabled(false);
				cbxDance.setSelected(false);
				cbxDance.setVisible(false);
			}
		});
		//添加事件处理，单击单选按钮“女”时，让篮球和足球不可选，舞蹈可选，同时让篮球和组曲为未选中状态
		rbtFeMale.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cbxBasketball.setEnabled(false);
				cbxFootball.setEnabled(false);
				cbxDance.setEnabled(true);
				cbxBasketball.setSelected(false);
				cbxFootball.setSelected(false);
				cbxDance.setVisible(true);
			}
		});
		btnOk.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jtaResult.setText("");
				String name=txtName.getText();
				String age=txtAge.getText();
				String sex="";
				if(rbtMale.isSelected())
					sex="男";
				else
					sex="女";
				String department=jbxDepartment.getSelectedItem().toString();
				String hobby="";
				if(cbxBasketball.isSelected())
					hobby="篮球; ";
				if(cbxFootball.isSelected())
					hobby=hobby+"足球; ";
				if(cbxDance.isSelected())
					hobby=hobby+"跳舞";
				String jianLi=jtaJianLi.getText();
				//jtaResult.setText("姓名："+name+"\n"+"年龄："+age+"\n");
				
				jtaResult.append("姓名："+name+"\n");
				jtaResult.append("年龄："+age+"\n");
				jtaResult.append("性别："+sex+"\n");
				jtaResult.append("学院："+department+"\n");
				jtaResult.append("爱好："+hobby+"\n");
				jtaResult.append("简历："+jianLi+"\n");
			}
		});
		btnReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				txtName.setText("");txtAge.setText("");
				rbtMale.setSelected(true);
				jbxDepartment.setSelectedIndex(0);
				cbxBasketball.setEnabled(true);
				cbxBasketball.setSelected(false);
				cbxFootball.setEnabled(true);
				cbxFootball.setSelected(false);
				cbxDance.setEnabled(false);
				cbxDance.setSelected(false);
				jtaJianLi.setText("");
				jtaResult.setText("");
			}
		});
	}
	public static void main(String[] args) {
		ZuJianDemo frame=new ZuJianDemo();
		frame.setSize(500,400);
		frame.setVisible(true);
	}

}
