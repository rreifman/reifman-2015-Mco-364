package multichat;

import java.net.Socket;

public interface ReaderListener {
	
	void onLineRead(String line); // adds line to queue
	
	void onCloseSocket(Socket socket); //close the current socket

}
