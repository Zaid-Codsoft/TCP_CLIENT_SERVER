package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            Socket socket = new Socket("localhost", 6666);

	            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	            System.out.print("Enter a message: ");
	            String message = userInput.readLine();
	            out.println(message);

	            int vowelCount = Integer.parseInt(in.readLine());
	            System.out.println("Server respnd:  The message  have " + vowelCount + " no of  vowels.");

	            in.close();
	            out.close();
	            userInput.close();
	            socket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


