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
		frame.setTitle("祝英台界面");
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
		send = new JButton("发送");
		msg_show = new TextArea();
		msg_send = new TextField();
		JLabel jl = new JLabel("信息显示区");
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
					msg_show.append("数据报目标的主机地址为"+data_pack.getAddress()+"\n");
					msg_show.append("数据报目标端口是"+data_pack.getPort()+"|n");
					msg_show.append("数据报长度为"+data_pack.getLength());
					msg_show.append("祝英台说"+msg_send.getText().trim()+"\n");
					msg_send.setText(null);
					mail_data.send(data_pack);//发送数据报
					
					
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
					msg_show.append("数据报的长度为"+length+"\n");
					msg_show.append("收到的数据来自"+address+"端口"+port);
					msg_show.append("梁山伯说"+message+"\n");
					
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		
	}
	
}