
import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(7006);
		
		System.out.println("ServerSocket Awaiting connection...");
		while(true) {
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("connection From"+ connectionSocket);
			BufferedReader inFormClient = new BufferedReader(new InputStreamReader
					(connectionSocket.getInputStream()));
			DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream()); 
			clientSentence = inFormClient.readLine();
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);
			
		}
	}
}
