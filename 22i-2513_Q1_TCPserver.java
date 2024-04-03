package lab5;
import java.io.*;
import java.net.*;

public class TCPserver {
	

	
	    public static void main(String[] args) {
	        try (ServerSocket serverSocket = new ServerSocket(6666)) {
	            System.out.println("Server started. Waiting for client");

	            while (true) {
	                Socket sockt = serverSocket.accept();
	                System.out.println("Client is now connected ..");

	                BufferedReader in = new BufferedReader(new InputStreamReader(sockt.getInputStream()));
	                PrintWriter out = new PrintWriter(sockt.getOutputStream(), true);

	                String msg = in.readLine();
	                System.out.println("Received message from client: " + msg);

	                int vowelCnt = countvo(msg);
	                out.println(vowelCnt);

	                in.close();
	                out.close();
	                sockt.close();
	            }
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    }

	    private static int countvo(String message) {
	        int countno = 0;
	        for (char c : message.toCharArray()) {
	            if ("AEIOUaeiou".indexOf(c) != -1) {
	                countno++;
	            }
	        }
	        return countno;
	    
	}
	
}
