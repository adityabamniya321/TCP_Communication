import java.io.*;
import java.net.*;

public class TCPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	throws Exception{
		String set;
		String  modifiedSentence;
		Socket clientSocket=new Socket("localhost",7006);
		BufferedReader inFromUser=
			   new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream()); 
		BufferedReader  inFromServer= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		set=inFromUser.readLine();
		outToServer.writeBytes(set + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("From Server:" + modifiedSentence);
		clientSocket.close();
	}

}
