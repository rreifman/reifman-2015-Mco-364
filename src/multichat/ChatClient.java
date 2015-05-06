package multichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.io.IOUtils;

public class ChatClient extends JFrame implements ReaderListener {

	Socket socket;
	PrintWriter writer;
	JTextArea text;
	JTextArea convo;

	public ChatClient() {

		try {
			setSize(450, 600);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Chat");

			convo = new JTextArea();
			convo.setBackground(Color.GRAY);
			convo.setEditable(false);
			JScrollPane pane = new JScrollPane(convo);
			add(pane, BorderLayout.CENTER);

			text = new JTextArea();
			add(text, BorderLayout.SOUTH);
			text.setSize(100, 350);

			text.addKeyListener(new KeyListener() {

				public void keyPressed(KeyEvent e) {

					if (e.getKeyChar() == KeyEvent.VK_ENTER) {

						postMessage();
					}
				}

				@Override
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == KeyEvent.VK_ENTER) {

						postMessage();
					}

				}

				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyChar() == KeyEvent.VK_ENTER) {

						postMessage();
					}
				}
			});

			socket = new Socket("localhost", 6000);
			writer = new PrintWriter(socket.getOutputStream());
			ReaderThread reader = new ReaderThread(socket, this);
			reader.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void postMessage() {
		String line = text.getText();
		writer.println(line);
		writer.println();
		writer.flush();
		text.setText("");
		onLineRead(line);

	}

	@Override
	public void onLineRead(String line) {
		convo.append(line);
		
	}

	@Override
	public void onCloseSocket(Socket socket) {
		IOUtils.closeQuietly(socket);

	}

	public static void main(String args[]) {
		
		ChatClient client = new ChatClient();
		client.setVisible(true);

	}

}
