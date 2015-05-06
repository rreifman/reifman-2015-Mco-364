package multichat;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import org.apache.commons.io.IOUtils;

public class ChatServer extends JFrame implements ReaderListener {

	private List<Socket> clients;
	private LinkedBlockingQueue<String> queue;
	private ServerSocket server;

	public ChatServer() {
		try {
			
			setSize(400,500);
			setTitle("Chat Server");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel label = new JLabel("Server is running");
			add(label, BorderLayout.NORTH);
			
			clients = new ArrayList<Socket>();
			queue = new LinkedBlockingQueue<String>();
			server = new ServerSocket(6000);
			
			WriterThread writer = new WriterThread(clients, queue);
			writer.start();
			
			JList<String> addedClients = new JList<String>();
			JLabel listComponent = new JLabel();
			add(addedClients);
			
			while(true){
				Socket current = server.accept();
				String string = "Client " + (clients.size()+1) + " has joined.";
				listComponent.setText(string);
				addedClients.add(listComponent);
				clients.add(current);
				ReaderThread reader = new ReaderThread(current, this);
				reader.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onLineRead(String line) {
		queue.add(line);

	}

	@Override
	public void onCloseSocket(Socket socket) {
		IOUtils.closeQuietly(socket);
	}

	public static void main(String args[]) {
		ChatServer server = new ChatServer();
		server.setVisible(true);
	}

}
