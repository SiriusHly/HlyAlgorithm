package ch9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JPanelTest1 extends JFrame{
	JPanel pAll=new JPanel(); //放p1,p2,p3,p4
	JPanel p1=new JPanel();   //p1蓝边框，放姓名 密码 性别
	JPanel p2=new JPanel();   //p2浮雕边框
	JPanel p3=new JPanel();   //p3绿边框
	JPanel p4=new JPanel();   //p4红边框，放爱好 学历

	JLabel lblName=new JLabel("姓名");
	JTextField txtName=new JTextField(5);
	JLabel lblPassword=new JLabel("密码");
	JPasswordField pPass=new JPasswordField(5); //输入时显示点
	
	JLabel lblSex=new JLabel("性别");
	ButtonGroup bg=new ButtonGroup();                    
	JRadioButton rdNan=new JRadioButton("男",true); //单选按钮，默认时选中
	JRadioButton rdNv=new JRadioButton("女");
	
	JLabel lblHobby=new JLabel("爱好");
	JCheckBox cbxBasketball=new JCheckBox("篮球"); //多选按钮      
	JCheckBox cbxFootball=new JCheckBox("足球");
	
	JLabel lblXueLi=new JLabel("学历");         
	JComboBox combxXueLi=new JComboBox();  //下拉列表框
	
	public JPanelTest1(){     //构造方法
		super("JPanel演示");
		init();  //本类的方法
	}
	private void init(){
		this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));  //设置frame的布局为FlowLayout，此句可不要，后面放pAll时设置frame的布局为BorderLayout且居中
		pAll.setBorder(BorderFactory.createLineBorder(Color.YELLOW,5));//设置pAll的边界线黄色,5像素粗
		pAll.setPreferredSize(new Dimension(500,400));//设置pAll的大小
		
		pAll.setBackground(Color.GRAY);
		
		
		
		p1.setBorder(BorderFactory.createLineBorder(Color.BLUE)); //设置蓝色JPanel
		p1.setPreferredSize(new Dimension(200,180));
		
		p2.setBorder(BorderFactory.createEtchedBorder()); //创建一个具有“浮雕化”外观效果的边框，将组件的当前背景色用于高亮显示和阴影显示。
		p2.setPreferredSize(new Dimension(180,180));
		
		p3.setBorder(BorderFactory.createLineBorder(Color.GREEN,4)); //设置绿色 JPanel             
		p3.setPreferredSize(new Dimension(200,180));
		
		p4.setBorder(BorderFactory.createLineBorder(Color.red, 4));//设置红色 JPanel
		p4.setPreferredSize(new Dimension(180,180));
	
		bg.add(rdNan);bg.add(rdNv); //bg是ButtonGroup，把“男 ”“女”单选按钮组织在一起
		p1.add(lblName);p1.add(txtName);
		p1.add(lblPassword);p1.add(pPass);                       
		p1.add(lblSex);p1.add(rdNan);p1.add(rdNv);  //rdNan rdNv是JRadioButton
		
		p4.add(lblHobby);p4.add(cbxBasketball);p4.add(cbxFootball);//cbxBasketball  cbxFootball是JCheckBox
		p4.add(lblXueLi);p4.add(combxXueLi); //combxXueLi是JComboBox	
		combxXueLi.addItem("专科");combxXueLi.addItem("本科");
		combxXueLi.addItem("硕士研究生");combxXueLi.addItem("博士研究生"); 
		
		//this.add(p1);this.add(p2);this.add(p3);this.add(p4);
		pAll.add(p1);pAll.add(p2);pAll.add(p3);pAll.add(p4);//4个小panel加到大panel中
		//this.add(pAll);
		
		this.add(pAll,BorderLayout.CENTER);//把大panel放入Frame中并居中
		//this.add(pAll); //效果同上，默认放中间位置
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550,480);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JPanelTest1 frame=new JPanelTest1();
		
		//frame.setSize(600,600); //init()方法中有相同的语句，此处就不需要了
		//frame.setVisible(true);
		//frame.setResizable(false); //有此句运行后的窗口不可拖动改变大小
	}
}
