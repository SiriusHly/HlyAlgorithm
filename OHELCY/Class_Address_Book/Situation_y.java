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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Situation_y extends JPanel implements ActionListener {
	Hashtable im ;//������Ϣ��
	JTextField txtName,txtNum,txtMajor,txtAdd,txtTel;
	Student xs;
	JRadioButton man,woman;
	JButton inputMo,resetMo;
	ButtonGroup btngroup;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	File file;
	public Situation_y(File file){
		//super(f,"��ѯ�Ի���",false);//????
		this.file=file;
		txtName.setEditable(false);//???
		txtMajor.setEditable(false);
		txtAdd.setEditable(false);
		txtTel.setEditable(false);
		txtNum = new JTextField(10);
		txtName = new JTextField(10);
		txtMajor = new JTextField(10);
		txtAdd = new JTextField(10);
		txtTel = new JTextField(10);
		man = new JRadioButton("��",true);
		woman = new JRadioButton("Ů",false);
		btngroup = new ButtonGroup();
		btngroup.add(man);
		btngroup.add(woman);
		inputMo = new JButton("¼���޸�");
		inputMo.setEnabled(false);//???
		resetMo = new JButton("������Ϣ");
		//txtNum.addActionListener(this);
		inputMo.addActionListener(this);
		resetMo.addActionListener(this);
		
		
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("ѧ��",JLabel.CENTER));
		box1.add(txtNum);
		box1.add(txtNum);
		
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("����",JLabel.CENTER));
		box2.add(txtName);
		
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("�ձ�",JLabel.LEFT));
		box3.add(man);
		box3.add(woman);
		
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("רҵ",JLabel.CENTER));
		box4.add(txtMajor);
		
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("סַ",JLabel.CENTER));
		box5.add(txtAdd);
		
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("�绰",JLabel.CENTER));
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
		JPanel p2 = new JPanel();
		p2.add(inputMo);
		p2.add(resetMo);
		add(p2,BorderLayout.SOUTH);
		setSize(360,271);
		setLocation(500,200);
		setVisible(true);
		validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inputMo) {
			String number=""; number=txtNum.getText();
			if(number.length()>0) {
			try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			im=(Hashtable)ois.readObject();
			fis.close(); ois.close();
			} 
			catch(Exception ee) {				
			}
			if(im.containsKey(number)) {
			String warning="����������Ϣ�Ѵ���,�뵽�޸�ҳ���޸�!";
			JOptionPane.showMessageDialog(this,warning,"����",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
			String m="������Ϣ����¼��!";
			int ok=JOptionPane.showConfirmDialog(this,m,"ȷ��",JOptionPane.YES_NO_OPTION,
			JOptionPane.INFORMATION_MESSAGE);
			if(ok==JOptionPane.YES_OPTION)
			{
			String name=txtName.getText();
			String discipling=txtMajor.getText();
			String grade=txtAdd.getText();
			String borth=txtTel.getText();
			String sex=null;
			if(man.isSelected())
			{
			sex=man.getText();
			}
			else
			{
			sex=woman.getText();
			}
			xs=new Student();
			xs.setNumber(number);
			xs.setName(name);
			xs.setDiscipling(discipling);
			xs.setGrade(grade);
			xs.setBorth(borth);
			xs.setSex(sex);
			try{
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			im.put(number,xs);
			oos.writeObject(im);
			oos.close();
			fos.close();
			txtNum.setText(null);
			txtName.setText(null); 
			txtMajor.setText(null);
			txtAdd.setText(null);
			txtTel.setText(null);
			}
			catch(Exception ee)
			{
			System.out.println(ee);
			}
			}
			}
			}
			else
			{
			String warning="����Ҫ����ѧ��!";
			JOptionPane.showMessageDialog(this,warning,"",JOptionPane.WARNING_MESSAGE);
			}
			}
			if(e.getSource()==resetMo)
			{
			txtNum.setText(null);
			txtName.setText(null);
			txtMajor.setText(null);
			txtAdd.setText(null);
			txtTel.setText(null);
			}
			}
	public static void main(String[] args) {

	}

}
