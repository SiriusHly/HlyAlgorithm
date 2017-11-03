package Class_Address_Book;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Delete_y extends JFrame implements ActionListener {
Hashtable im ;//������Ϣ��
JTextField txtName,txtNum,txtMajor,txtAdd,txtTel;
JRadioButton man,woman;
JButton btnDelete;
ButtonGroup btngroup;
FileInputStream fis;
FileOutputStream fos;
ObjectInputStream ois;
ObjectOutputStream oos;
File file;
public Delete_y(File file){
	this.file=file;
	txtNum = new JTextField(10);
	btnDelete = new JButton("ɾ��");
	txtNum.addActionListener(this);
	btnDelete.addActionListener(this);
	txtName.setEditable(false);//???
	txtMajor.setEditable(false);
	txtAdd.setEditable(false);
	txtTel.setEditable(false);
	txtName = new JTextField(10);
	txtMajor = new JTextField(10);
	txtAdd = new JTextField(10);
	txtTel = new JTextField(10);
	man = new JRadioButton("��",false);
	woman = new JRadioButton("Ů",false);
	btngroup = new ButtonGroup();
	btngroup.add(man);
	btngroup.add(woman);
	
	Box box1 = Box.createHorizontalBox();
	box1.add(new JLabel("������Ҫɾ����ѧ��",JLabel.CENTER));
	box1.add(txtNum);
	box1.add(btnDelete);
	
	Box box2 = Box.createHorizontalBox();
	box2.add(new JLabel("ɾ������",JLabel.CENTER));
	box2.add(txtName);
	
	Box box3 = Box.createHorizontalBox();
	box3.add(new JLabel("ɾ���ձ�",JLabel.LEFT));
	box3.add(man);
	box3.add(woman);
	
	Box box4 = Box.createHorizontalBox();
	box4.add(new JLabel("��ѧרҵ",JLabel.CENTER));
	box4.add(txtMajor);
	
	Box box5 = Box.createHorizontalBox();
	box5.add(new JLabel("��ͥסַ",JLabel.CENTER));
	box5.add(txtAdd);
	
	Box box6 = Box.createHorizontalBox();
	box6.add(new JLabel("��ϵ�绰",JLabel.CENTER));
	box6.add(txtTel);		
	
	Box boxH = Box.createVerticalBox();
	boxH.add(box1);
	boxH.add(box2);
	boxH.add(box3);
	boxH.add(box4);
	boxH.add(box5);
	boxH.add(box6);
	boxH.add(Box.createVerticalBox());
	JPanel p1 = new JPanel();
	p1.add(boxH);
	setLayout(new BorderLayout());
	add(p1,BorderLayout.CENTER);
	
	setSize(500,400);
	setVisible(true);
	setLocation(500, 200);
	validate();
		
}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnDelete||e.getSource()==txtNum){
			String number = "";
			number = txtNum.getText();
			if(number.length()>0){
				try{
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);		
					im = (Hashtable)ois.readObject();
					fis.close();
					ois.close();
				}
				catch(Exception e1){
				}
			
			if(im.containsKey(number)){//????
				Student stu = (Student)im.get(number);
				txtName.setText(stu.getName());
				txtMajor.setText(stu.getDiscipling());
				txtAdd.setText(stu.getGrade());
				txtTel.setText(stu.getBorth());				
			if(stu.getSex().equals("��"))
			{
			man.setSelected(true);
			}
			else
			{
			woman.setSelected(true);
			}
			String m="ȷ��Ҫɾ����ѧ�ż�ȫ����Ϣ��?";
int ok=JOptionPane.showConfirmDialog(this,m,"",JOptionPane.YES_NO_OPTION,
JOptionPane.QUESTION_MESSAGE);
if(ok==JOptionPane.YES_OPTION)
{
im.remove(number);
try
{
fos=new FileOutputStream(file);
oos=new ObjectOutputStream(fos); oos.writeObject(im); fos.close();
oos.close(); 
txtNum.setText(null);
txtName.setText(null); txtMajor.setText(null);
txtAdd.setText(null);
txtTel.setText(null);
}
catch(Exception ee)
{
System.out.println(ee);
}
}
else if(ok==JOptionPane.NO_OPTION)
{
txtNum.setText(null);
txtName.setText(null);
txtMajor.setText(null);
txtAdd.setText(null);
txtTel.setText(null);

			}
			}
			
			else
			{
			String warning="��ѧ�Ų�����!";
			JOptionPane.showMessageDialog(this,warning,"��",JOptionPane.WARNING_MESSAGE);
			}
			}
		
			else
			{
			String warning="����Ҫ����ѧ��!";
			JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);
		
}
	}
		}
	public static void main(String[] args) {
		//Delete_y h = new Delete_y();
		/*h.setSize(500,400);
		h.setVisible(true);
		h.setLocation(500, 200);*/
	}

}
