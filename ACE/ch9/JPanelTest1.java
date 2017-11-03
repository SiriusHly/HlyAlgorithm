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
	JPanel pAll=new JPanel(); //��p1,p2,p3,p4
	JPanel p1=new JPanel();   //p1���߿򣬷����� ���� �Ա�
	JPanel p2=new JPanel();   //p2����߿�
	JPanel p3=new JPanel();   //p3�̱߿�
	JPanel p4=new JPanel();   //p4��߿򣬷Ű��� ѧ��

	JLabel lblName=new JLabel("����");
	JTextField txtName=new JTextField(5);
	JLabel lblPassword=new JLabel("����");
	JPasswordField pPass=new JPasswordField(5); //����ʱ��ʾ��
	
	JLabel lblSex=new JLabel("�Ա�");
	ButtonGroup bg=new ButtonGroup();                    
	JRadioButton rdNan=new JRadioButton("��",true); //��ѡ��ť��Ĭ��ʱѡ��
	JRadioButton rdNv=new JRadioButton("Ů");
	
	JLabel lblHobby=new JLabel("����");
	JCheckBox cbxBasketball=new JCheckBox("����"); //��ѡ��ť      
	JCheckBox cbxFootball=new JCheckBox("����");
	
	JLabel lblXueLi=new JLabel("ѧ��");         
	JComboBox combxXueLi=new JComboBox();  //�����б��
	
	public JPanelTest1(){     //���췽��
		super("JPanel��ʾ");
		init();  //����ķ���
	}
	private void init(){
		this.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));  //����frame�Ĳ���ΪFlowLayout���˾�ɲ�Ҫ�������pAllʱ����frame�Ĳ���ΪBorderLayout�Ҿ���
		pAll.setBorder(BorderFactory.createLineBorder(Color.YELLOW,5));//����pAll�ı߽��߻�ɫ,5���ش�
		pAll.setPreferredSize(new Dimension(500,400));//����pAll�Ĵ�С
		
		pAll.setBackground(Color.GRAY);
		
		
		
		p1.setBorder(BorderFactory.createLineBorder(Color.BLUE)); //������ɫJPanel
		p1.setPreferredSize(new Dimension(200,180));
		
		p2.setBorder(BorderFactory.createEtchedBorder()); //����һ�����С����񻯡����Ч���ı߿򣬽�����ĵ�ǰ����ɫ���ڸ�����ʾ����Ӱ��ʾ��
		p2.setPreferredSize(new Dimension(180,180));
		
		p3.setBorder(BorderFactory.createLineBorder(Color.GREEN,4)); //������ɫ JPanel             
		p3.setPreferredSize(new Dimension(200,180));
		
		p4.setBorder(BorderFactory.createLineBorder(Color.red, 4));//���ú�ɫ JPanel
		p4.setPreferredSize(new Dimension(180,180));
	
		bg.add(rdNan);bg.add(rdNv); //bg��ButtonGroup���ѡ��� ����Ů����ѡ��ť��֯��һ��
		p1.add(lblName);p1.add(txtName);
		p1.add(lblPassword);p1.add(pPass);                       
		p1.add(lblSex);p1.add(rdNan);p1.add(rdNv);  //rdNan rdNv��JRadioButton
		
		p4.add(lblHobby);p4.add(cbxBasketball);p4.add(cbxFootball);//cbxBasketball  cbxFootball��JCheckBox
		p4.add(lblXueLi);p4.add(combxXueLi); //combxXueLi��JComboBox	
		combxXueLi.addItem("ר��");combxXueLi.addItem("����");
		combxXueLi.addItem("˶ʿ�о���");combxXueLi.addItem("��ʿ�о���"); 
		
		//this.add(p1);this.add(p2);this.add(p3);this.add(p4);
		pAll.add(p1);pAll.add(p2);pAll.add(p3);pAll.add(p4);//4��Сpanel�ӵ���panel��
		//this.add(pAll);
		
		this.add(pAll,BorderLayout.CENTER);//�Ѵ�panel����Frame�в�����
		//this.add(pAll); //Ч��ͬ�ϣ�Ĭ�Ϸ��м�λ��
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550,480);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JPanelTest1 frame=new JPanelTest1();
		
		//frame.setSize(600,600); //init()����������ͬ����䣬�˴��Ͳ���Ҫ��
		//frame.setVisible(true);
		//frame.setResizable(false); //�д˾����к�Ĵ��ڲ����϶��ı��С
	}
}
