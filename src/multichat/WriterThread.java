package multichat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread{
	
	private List <Socket> sockets;
	private LinkedBlockingQueue<String> queue;
	
	public WriterThread(List<Socket> sockets, LinkedBlockingQueue queue){
		this.sockets = sockets;
		this.queue = queue;
	}
	
	public void run(){
		
		while(true){
			String message;
			try {
				message = queue.take();
				writeToSockets(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}

	private void writeToSockets(String message) {
		synchronized(sockets){
			Iterator<Socket> iter = sockets.iterator();
			while(iter.hasNext()){
				Socket s = iter.next();
				try {
					PrintWriter out = new PrintWriter(s.getOutputStream());
					out.println(message);
					out.flush();
				} catch (IOException e) {
					iter.remove();
					e.printStackTrace();
				}
			}
		}
		
	}

}
