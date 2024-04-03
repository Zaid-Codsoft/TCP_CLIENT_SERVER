package lab51;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UDPserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);
            System.out.println("Server started now Waiting for client");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receiveP = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receiveP);

                
                InetAddress clientAdd = receiveP.getAddress();
                int clientPort = receiveP.getPort();

                String serverT = new Date().toString();
                byte[] sendD = serverT.getBytes();

                DatagramPacket sendPac = new DatagramPacket(sendD, sendD.length, clientAdd, clientPort);
                socket.send(sendPac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        finally {
            if (socket != null) {
                socket.close();
            }
        }
	}

}
