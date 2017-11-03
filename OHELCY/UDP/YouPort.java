package UDP;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YouPort extends JFrame {

	public YouPort()  {
		ChatPanel1 cp = new ChatPanel1();
		getContentPane().add(cp);
		
	}

	public static void main(String[] args) {
		YouPort frame  = new YouPort();
		frame.setTitle("ףӢ̨����");
		frame.setSize(510, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class ChatPanel1 extends JPanel implements Runnable,ActionListener{
	
	JButton send;
	TextArea msg_show ;
	TextField msg_send;
	Thread thread =null;
	public ChatPanel1(){
		setLayout(null);
		send = new JButton("����");
		msg_show = new TextArea();
		msg_send = new TextField();
		JLabel jl = new JLabel("��Ϣ��ʾ��");
		jl.setBounds(0, 0, 500, 20);
		add(jl);
		msg_show.setBounds(0, 20, 500, 300);
		msg_show.setEditable(false);
		add(msg_show);
		JLabel jll = new JLabel();
		jll.setBounds(0, 320, 500, 20);
		add(jll);
		msg_send.setBounds(0, 340, 400, 80);
		add(msg_send);
		msg_send.addActionListener(this);
		thread = new Thread(this);
		thread.start();
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==msg_send||e.getSource()==send){
			if(!msg_send.getText().equals("")){
				byte buffer[] = msg_send.getText().trim().getBytes();
				try {
					InetAddress address = InetAddress.getByName("localhost");
					DatagramPacket data_pack = new DatagramPacket(buffer, buffer.length, address, 3445);
					DatagramSocket mail_data = new DatagramSocket();
					msg_show.append("���ݱ�Ŀ���������ַΪ"+data_pack.getAddress()+"\n");
					msg_show.append("���ݱ�Ŀ��˿���"+data_pack.getPort()+"|n");
					msg_show.append("���ݱ�����Ϊ"+data_pack.getLength());
					msg_show.append("ףӢ̨˵"+msg_send.getText().trim()+"\n");
					msg_send.setText(null);
					mail_data.send(data_pack);//�������ݱ�
					
					
				} catch (UnknownHostException e1) {
					
					e1.printStackTrace();
				} catch (SocketException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void run() {
		DatagramSocket mail_data = null;
		byte data[] = new byte[8192];
		DatagramPacket pack = null;
		
		
		try {
			mail_data = new DatagramSocket(3441);
			pack = new DatagramPacket(data, data.length);
			
		    
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
		
		while(true){
			if(mail_data==null) break;
			else
				try {
					mail_data.receive(pack);
					int length = pack.getLength();
					InetAddress address = pack.getAddress();
					int port = pack.getPort();
					String message = new String (pack.getData(),0,length);
					msg_show.append("���ݱ��ĳ���Ϊ"+length+"\n");
					msg_show.append("�յ�����������"+address+"�˿�"+port);
					msg_show.append("��ɽ��˵"+message+"\n");
					
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		
	}
	
}