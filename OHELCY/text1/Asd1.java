package text1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Asd1 extends JFrame implements ActionListener {
	JTextField id=null;
	JPasswordField pass = null;
	public void init(){
		setTitle("欢迎进入班级通讯系统");
		 id = new JTextField(10);
		JTabbedPane p1 = new JTabbedPane();//?
		 pass = new JPasswordField(10);
		JButton btndl = new JButton();
		JButton btnClose = new JButton();
		JLabel lblpw = new JLabel();
		JLabel lblName = new JLabel();
		JLabel lblClass = new JLabel();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		lblClass.setText("班级通讯录");
		lblpw.setText("密码");
		lblName.setText("用户名");
		btndl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlActionPerformed(e);
			}
		});
		btnClose.setText("关闭");
		btndl.setText("登錄");
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeActionPerformed(e);//?
			}
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());//??
		getContentPane().setLayout(layout);
		/*layout.setHorizontalGroup(
				layout.createSequentialGroup());*/
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
				.addGap(0, 0, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblName)
				.addComponent(lblpw))
				.addGap(236, 236, 236))
				.addGroup(layout.createSequentialGroup()
				.addGap(51, 51, 51)
				.addComponent(btnClose)
				.addGap(95, 95, 95)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(btndl)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				.addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
				.addComponent(pass)))
				.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE)
				.addComponent(lblClass, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(56, 56, 56))
				);
				layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				.addGap(32, 32, 32) .addComponent(lblClass)
				.addGap(55, 55, 55)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(lblName)
				.addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) .addGap(47, 47, 47)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(lblpw)
				.addComponent(pass,
				javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(btnClose)
				.addComponent(btndl))
				.addGap(42, 42, 42))
				);
				validate();		
	}
	private void dlActionPerformed(ActionEvent e) { 
	String name = this.id.getText().trim();
	String pw = this.pass.getText().trim();
	if (name.equalsIgnoreCase("")) {
	JOptionPane.showMessageDialog(this, "用户名为空");
	return;
	}
	if (pw.equalsIgnoreCase("")) {
	JOptionPane.showMessageDialog(this, "密码为空");
	return;
	}
	if (!name.equalsIgnoreCase("123") || !pw.equalsIgnoreCase("123")) { JOptionPane.showMessageDialog(this, "用户名/密码错误！"); return;
	}
	if (name.equalsIgnoreCase("123") && pw.equalsIgnoreCase("123")) {
		Student_Manager_hly1 y = new Student_Manager_hly1();
	     y.setVisible(true);
	this.dispose();
	}
	}


	private void closeActionPerformed(java.awt.event.ActionEvent e) { 
		this.dispose();
		}
	
	public static void main(String[] args) {
	Asd1 as=	new Asd1();
	as.init();
	as.setVisible(true);
	as.setSize(400,400);
	as.setLocation(500, 200);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
	

}












