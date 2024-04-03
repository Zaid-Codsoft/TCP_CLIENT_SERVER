package lab51;
import java.net.*;

public class UDPclient {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            
            socket = new DatagramSocket();
            
            
            InetAddress serverAdd = InetAddress.getByName("localhost");
            int serverPort = 9876;

            
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

           
            DatagramPacket sendPac = new DatagramPacket(sendData, sendData.length, serverAdd, serverPort);
            
           
            socket.send(sendPac);

           
            DatagramPacket receivePac = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePac);

           
            String serverT = new String(receivePac.getData(), 0, receivePac.getLength());
            System.out.println("Server time: " + serverT);
        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
           
            if (socket != null) {
                socket.close();
            }
        }
    }
}
