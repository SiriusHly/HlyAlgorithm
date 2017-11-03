package Class_Address_Book;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Inquest_y extends JDialog implements ActionListener {

	Hashtable im ;//基本信息表
	JTextField txtName,txtNum,txtMajor,txtAdd,txtTel;
	JRadioButton man,woman;
	JButton btnInquest;
	ButtonGroup btngroup;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	File file;
	//public Delete_y(File file)
	public Inquest_y(JFrame f,File file){
		super(f,"查询对话框",false);//????
		this.file=file;
		txtNum = new JTextField(10);
		btnInquest = new JButton("查询");
		txtNum.addActionListener(this);
		btnInquest.addActionListener(this);
		txtName.setEditable(false);//???
		txtMajor.setEditable(false);
		txtAdd.setEditable(false);
		txtTel.setEditable(false);
		txtName = new JTextField(10);
		txtMajor = new JTextField(10);
		txtAdd = new JTextField(10);
		txtTel = new JTextField(10);
		man = new JRadioButton("男",true);
		woman = new JRadioButton("女",false);
		btngroup = new ButtonGroup();
		btngroup.add(man);
		btngroup.add(woman);
		
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("请输入要查询的学号",JLabel.CENTER));
		box1.add(txtNum);
		box1.add(btnInquest);
		
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("查询姓名",JLabel.CENTER));
		box2.add(txtName);
		
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("查询姓别",JLabel.LEFT));
		box3.add(man);
		box3.add(woman);
		
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("所学专业",JLabel.CENTER));
		box4.add(txtMajor);
		
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("家庭住址",JLabel.CENTER));
		box5.add(txtAdd);
		
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("联系电话",JLabel.CENTER));
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
		Container con = getContentPane();
		con.add(p1,BorderLayout.CENTER);
		validate();
		setBounds(500,200,360,270);
		setVisible(true);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		txtName.setText(null);
		txtAdd.setText(null);
		txtMajor.setText(null);
		txtTel.setText(null);
		if(e.getSource()==btnInquest||e.getSource()==txtNum){
			String number ="";
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
			if(stu.getSex().equals("男"))
			{
			man.setSelected(true);
			}
			else
			{
			woman.setSelected(true);
			}
			}
			
			else
			{
			String warning="该学号不存在!";
			JOptionPane.showMessageDialog(this,warning,"警",JOptionPane.WARNING_MESSAGE);
			}
			}
		
			else
			{
			String warning="必须要输入学号!";
			JOptionPane.showMessageDialog(this,warning,"警告",JOptionPane.WARNING_MESSAGE);
		
}
	}
			}
		
	public static void main(String[] args){
	}
	

}
