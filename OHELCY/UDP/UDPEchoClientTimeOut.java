package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPEchoClientTimeOut {
	private static final int TIMEOUT =3000;
	private static final int MAXTRIES =5;
	

	public UDPEchoClientTimeOut() {
	
	}
	public static void main(String []args) throws UnknownHostException, SocketException{
		/*if((args.length<2)||(args.length>3)){
			throw new IllegalArgumentException("Parameter(s):<Server><word>[<Port>]");
		}*/
		InetAddress serverAddress = InetAddress.getByName("59.110.155.28");
		//System.out.println(args[0]);
		byte[] bytesToSend = "hly".getBytes();
		//System.out.println(args[1].getBytes());
		int servPort = 3332;
		//System.out.println(args[2]);
		DatagramSocket socket = new DatagramSocket();
		
		socket.setSoTimeout(TIMEOUT);
		DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, serverAddress, servPort);
		//System.out.println(socket.getLocalAddress().toString()+" "+socket.getPort());
		DatagramPacket receivePack = new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);
		int tries =0;
		boolean receivedResponse = false ;
		do{
			try {
				socket.send(sendPacket);
				//System.out.println(receivePack.getAddress().toString()+"  "+serverAddress);
				if(!receivePack.getAddress().equals(serverAddress)){//check source
					
					throw new IOException("receive packet from an unknow resource ");
				}
				receivedResponse = true;
			} catch (IOException e) {
				tries+=1;
				System.out.println("timeout,"+(MAXTRIES-tries)+"tries");
				e.printStackTrace();
			}
			
		}while((!receivedResponse)&&(tries<MAXTRIES));
		
		if(receivedResponse){
			System.out.println("receive"+new String(receivePack.getData()));
		}
		else{
			System.out.println("no response give up");
		}
		socket.close();
		
	}
}
