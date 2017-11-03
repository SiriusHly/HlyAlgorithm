package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	private static  final int ECHOMAX = 255;
	public UDPEchoServer() {
		
		
		
		
	}

	public static void main(String[]args){
		int servPort = 3332;
		try {
			DatagramSocket socket = new DatagramSocket(servPort);
			DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX],ECHOMAX);
			while(true){
				try {
					socket.receive(packet);
					System.out.println("Hander Client at"+packet.getAddress().getHostAddress()+"on port"+packet.getPort());
					socket.send(packet);
					packet.setLength(ECHOMAX);
					
					
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
			
			
			
			
			
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
		
	}
}
