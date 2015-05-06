package multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderThread extends Thread {

	private Socket socket;
	private ReaderListener listener;

	public ReaderThread(Socket socket, ReaderListener listener) {
		this.socket = socket;
		this.listener = listener;
	}

	public void run() {

		try {
			InputStream input = socket.getInputStream();

			BufferedReader read = new BufferedReader(new InputStreamReader(
					input));
			
			String line;
			
			while((line = read.readLine()) != null){
				listener.onLineRead(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		listener.onCloseSocket(socket);
	}
}
