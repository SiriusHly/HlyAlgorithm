package TongXunLu;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShanChu extends JFrame implements ActionListener {
	JTextField stuNum, stucla;
	JLabel tip, lblcla, lblNum;
	JButton ok, qx;
	JPanel p1 = new JPanel();
	String deal;

	ShanChu(String deal) {
		this.deal = deal;
		Container con = getContentPane();
		setTitle(deal + "��Ϣ");
		p1.setLayout(new FlowLayout());
		stuNum = new JTextField(15);
		stucla = new JTextField(15);
		lblNum = new JLabel("ѧ��");
		lblcla = new JLabel("�༶");
		ok = new JButton("ȷ��");
		qx = new JButton("����");
		con.add(p1);

		p1.add(lblcla);
		p1.add(stucla);
		p1.add(lblNum);
		p1.add(stuNum);
		p1.add(ok);
		p1.add(qx);
		setSize(240, 240);
		validate();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		qx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stuNum.setText("");
				stucla.setText("");
			}
		});

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (deal.equals("ɾ��")) {
					Delete(stucla.getText() + "//" + stuNum.getText());
					dispose();
				}
			}
		});

	}

	public void Delete(String stu) {
		File f = new File("f:\\TongXunLu\\" + stu + ".txt");
		if (f.exists()) {
			f.delete();
			JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
		} else
			JOptionPane.showMessageDialog(null, "�޸�ѧ����Ϣ!");
		ShanChu t = new ShanChu("ɾ��");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	public static void main(String[] h) {

	}

}
