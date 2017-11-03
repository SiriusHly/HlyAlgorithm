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

public class MePort extends JFrame {

	public MePort() {
		ChatPanel ct =new ChatPanel();
		getContentPane().add(ct);
	}

	public static void main(String[] args) {
		MePort frame = new MePort();
		frame.setTitle("梁山伯界面");
		frame.setSize(510,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class ChatPanel extends JPanel implements Runnable,ActionListener{

	JButton send;
	TextArea msg_show;
	TextField msg_send;
	Thread thread = null;
	 public ChatPanel() {
		setLayout(null);
		send = new JButton("发送");
		msg_send = new TextField();
		msg_show = new TextArea();
		JLabel jl = new JLabel("信息显示区");
		jl.setBounds(0, 0, 500, 20);
		add(jl);
		msg_show.setBounds(0, 20, 500, 300);
		msg_show.setEditable(false);
		add(msg_show);
		JLabel jll = new JLabel("信息发送区");
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
		
		if(e.getSource()==msg_send||e.getSource()==send);
		if(!msg_send.equals("")){
			byte buffer[] = msg_send.getText().trim().getBytes();
			try {
				InetAddress address = InetAddress.getByName("localhost");
				DatagramPacket data_pack = new DatagramPacket(buffer, buffer.length, address, 3441);
				DatagramSocket mail_data = new DatagramSocket();
				msg_show.append("数据报目标主机地址"+data_pack.getAddress()+"\n");
				msg_show.append("数据报目标端口是"+data_pack.getPort()+"\n");
				msg_show.append("数据报长度是"+data_pack.getLength()+"\n");
				msg_show.append("梁山伯说"+msg_send.getText().trim()+"\n");
				msg_send.getText();
				mail_data.send(data_pack);
				
			} catch (UnknownHostException e1) {
				
				e1.printStackTrace();
			} catch (SocketException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}
	}

	@Override
	public void run() { //负责数据报的接收
		DatagramSocket main_data = null; //接收数据包的套接字
		byte [] data = new byte[8192]; //存放接收数据的字节数组
		DatagramPacket pack = null; //接收数据报的对象
		
		try {
			pack  = new DatagramPacket(data, data.length);
			main_data = new DatagramSocket(3445);//对方发来的数据包的目标端口是3445
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
		while(true){//利用循环不断接收数据
			if(main_data==null) break;
			else
				try {
					main_data.receive(pack);
					int length = pack.getLength();
					InetAddress address = pack.getAddress();
					int port = pack.getPort();
					String message = new String(pack.getData(),0,length);
					msg_show.append("收到的数据长度"+length);
					msg_show.append("收到的数据来自"+address+"端口:"+port);
					msg_show.append("祝英台说"+message+"\n");
					
					
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
		}
		
	}
	
}
