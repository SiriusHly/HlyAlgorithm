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
	//����Ҫ�ڴ�������ʾ�����ԣ������
	JLabel lblName=new JLabel("    ������");
	JTextField txtName=new JTextField(10);
	JLabel lblAge =new JLabel("    ���䣺");
	JTextField txtAge=new JTextField(10);
	JLabel lblSex =new JLabel("    �Ա�");
	ButtonGroup group=new ButtonGroup();
	JRadioButton rbtMale=new JRadioButton("��",true);
	JRadioButton rbtFeMale=new JRadioButton("Ů",false);
	JLabel lblDepartment =new JLabel("    ѧԺ��");
	JComboBox jbxDepartment=new JComboBox();
	JLabel lblHobby =new JLabel("    ���ã�");
	JCheckBox cbxBasketball=new JCheckBox("����");
	JCheckBox cbxFootball=new JCheckBox("����");
	JCheckBox cbxDance=new JCheckBox("�赸");
	
	JLabel lblJianLi =new JLabel("    ������");
	JTextArea jtaJianLi=new JTextArea(6,20);
	
	JButton btnOk=new JButton("ȷ��");
	JButton btnReset=new JButton("����");
	
	JLabel lblResult =new JLabel("    ��������ǣ�");
	JTextArea jtaResult=new JTextArea(6,20);
	JPanel p=new JPanel();JPanel pJbxx=new JPanel();
	JPanel pJianLi=new JPanel();
	public ZuJianDemo(){
		//��������봰���У�������Ϣ�����ϱߵ����pJbxx�У����������±ߵ����pJianLi��
		pJbxx.setLayout(new GridLayout(0,4));//ÿ�з�4�����
		//����������ռһ��
		pJbxx.add(lblName);pJbxx.add(txtName);
		pJbxx.add(lblAge);pJbxx.add(txtAge);
		//�Ա�ռһ�У�����4������һ���ÿյ�JLabel���
		pJbxx.add(lblSex);pJbxx.add(rbtMale);pJbxx.add(rbtFeMale);
		pJbxx.add(new JLabel());
		//����Ů��ѡ��ť�ŵ�һ�����ʵ�ֻ���
		group.add(rbtMale);group.add(rbtFeMale);
		//ѧԺռһ�У����в���4������2���յ�JLabel���
		pJbxx.add(lblDepartment);pJbxx.add(jbxDepartment);
		pJbxx.add(new JLabel());pJbxx.add(new JLabel());//
		jbxDepartment.addItem("�����ѧԺ");//�������ѡ����
		jbxDepartment.addItem("����ѧԺ");
		jbxDepartment.addItem("��ľѧԺ");
		//����ռһ��
		pJbxx.add(lblHobby);pJbxx.add(cbxBasketball);
		pJbxx.add(cbxFootball);pJbxx.add(cbxDance);cbxDance.setEnabled(false);
		
		//ȷ�������ð�ťռһ�У����в���4������2���յ�JLabel���
		pJbxx.add(new JLabel());pJbxx.add(btnOk);pJbxx.add(btnReset);
		pJbxx.add(new JLabel());
		//�Ѵ������ŵ���������pJianLi��,��������������Ľ��
		pJianLi.setLayout(new GridLayout(0,2,2,10));
		pJianLi.add(lblJianLi);pJianLi.add(jtaJianLi);
		pJianLi.add(lblResult);pJianLi.add(jtaResult);
		p.add(pJbxx);p.add(pJianLi);
		add(p,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����¼�����������ѡ��ť���С�ʱ��������������ѡ���赸����ѡ��ͬʱ���赸Ϊδѡ��״̬
		rbtMale.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cbxBasketball.setEnabled(true);
				cbxFootball.setEnabled(true);
				cbxDance.setEnabled(false);
				cbxDance.setSelected(false);
				cbxDance.setVisible(false);
			}
		});
		//����¼�����������ѡ��ť��Ů��ʱ������������򲻿�ѡ���赸��ѡ��ͬʱ�����������Ϊδѡ��״̬
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
					sex="��";
				else
					sex="Ů";
				String department=jbxDepartment.getSelectedItem().toString();
				String hobby="";
				if(cbxBasketball.isSelected())
					hobby="����; ";
				if(cbxFootball.isSelected())
					hobby=hobby+"����; ";
				if(cbxDance.isSelected())
					hobby=hobby+"����";
				String jianLi=jtaJianLi.getText();
				//jtaResult.setText("������"+name+"\n"+"���䣺"+age+"\n");
				
				jtaResult.append("������"+name+"\n");
				jtaResult.append("���䣺"+age+"\n");
				jtaResult.append("�Ա�"+sex+"\n");
				jtaResult.append("ѧԺ��"+department+"\n");
				jtaResult.append("���ã�"+hobby+"\n");
				jtaResult.append("������"+jianLi+"\n");
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
