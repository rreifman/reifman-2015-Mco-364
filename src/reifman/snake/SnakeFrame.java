package reifman.snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class SnakeFrame extends JFrame implements KeyListener {

	public SnakeFrame() {
		setSize(630, 630);
		setTitle("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setFocusable(true);
		
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.setBackground(Color.GRAY);
	

		WorldComponent snake = new WorldComponent();
		//GameLoopThread game = new GameLoopThread(snake);
		snake.addKeyListener(this);
		snake.setFocusable(true);
		pane.add(snake);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 4 or left arrow then turn to left
		// 6 or right arrow then turn to right
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
