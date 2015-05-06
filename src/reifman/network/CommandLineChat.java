package reifman.network;

import java.net.Socket;

public class CommandLineChat implements ReaderListener{
	
	public CommandLineChat(){
		Socket socket = null;
		ReaderThread thread = new ReaderThread(socket, this);
		new Thread(thread).start();
	}
	
	public static void main (String args[]){
		new CommandLineChat();
	}

	@Override
	public void onLineRead(String line) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCloseSocket(Socket socket) {
		// TODO Auto-generated method stub
		
	}

}
