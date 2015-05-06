package reifman.network;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;



public class Client {

	public static void main(String args[]){
		
		Socket socket = null;
		
		try {
			
			 socket = new Socket("10.41.116.197", 3761);
			
			OutputStream out = socket.getOutputStream();
			
			PrintWriter writer = new PrintWriter(out);
			writer.println("Do or do not, there is not try.");
			
	
			writer.println("Hello");
		
			writer.println("Hello again");
			writer.flush();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally{
			IOUtils.closeQuietly(socket);
		}
		
	}
}
