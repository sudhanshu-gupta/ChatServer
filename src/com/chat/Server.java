

import java.io.*;
import java.net.*;

public class Server {
	
	public static void main(String [] args) throws IOException {
		try {
			ServerSocket serverSocket = new ServerSocket(3023);
			System.out.println("Server ready for chatting");
			Socket socket = serverSocket.accept();
							// reading from the keyboard
			BufferedReader readKey = new BufferedReader(new InputStreamReader(System.in));
							// sending to the client
			OutputStream out = socket.getOutputStream();
			PrintWriter pwrite = new PrintWriter(out, true);
							// reading from the server
			InputStream input = socket.getInputStream();
			BufferedReader recievedRead = new BufferedReader(new InputStreamReader(input));
			
			String recievedMsg, sendMsg;
			
			while(true) {
				if( (recievedMsg = recievedRead.readLine()) != null ) {
					System.out.println(recievedMsg);
				}
				sendMsg = readKey.readLine();
				pwrite.println(sendMsg);
				System.out.flush();
			}				
		} catch(IOException e) {
				throw new IOException("Server unable to connect.");
		}
	}
}
