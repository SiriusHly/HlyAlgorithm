package MYFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;//用来存储数据用的
//import java.awt.list  是前台显示用的一个序列，只做显示用
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComboxDemo extends JFrame {
JButton btnAdd = new JButton("实验八Add");
JLabel lblName = new JLabel("Name");
JTextField txtName = new JTextField(5);
JLabel lblDepatrment  = new JLabel("Department");
JComboBox cbxDepartment = new JComboBox();
//List<String> listDepartment = new ArrayList<String>();
List<String> listDepartment=new ArrayList<String>();
JTextArea jtaContent = new JTextArea(5,20);
JPanel p = new JPanel();
public ComboxDemo(){
	p.add(btnAdd);
	p.add(lblName);p.add(txtName);
	p.add(lblDepatrment);p.add(cbxDepartment);
	p.add(jtaContent);
	listDepartment.add("computer college");
	listDepartment.add("Build college");
	listDepartment.add("Mechanical college");
	for(int i =0;i<listDepartment.size();i++){
		cbxDepartment.addItem(listDepartment.get(i));
	}
	this.add(p, BorderLayout.CENTER);
	btnAdd.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String name = txtName.getText();
			String department  = cbxDepartment.getSelectedItem().toString();
			jtaContent.setText("Name:"+name+"\nDepartment:"+department);
		}
	});
		this.setSize(300,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
}

	public static void main(String[] args) {
ComboxDemo frame  =new ComboxDemo();

	}

}
