

import java.net.*;
import java.io.*;

public class Client {

		public static void main(String [] args) throws IOException{
			try {
				Socket socket = new Socket("localhost", 3023);
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
					sendMsg = readKey.readLine();
					System.out.println("Client: ");
					pwrite.println(sendMsg);
					
					if( (recievedMsg = recievedRead.readLine())!= null) {
						System.out.println("Server: " + recievedMsg);
					}
					System.out.flush();
				}
				
			} catch(IOException e) {
				throw new IOException("Client unable to connect.");
			}
		}
}
