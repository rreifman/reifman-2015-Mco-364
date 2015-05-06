package reifman.connectfour;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Board extends JFrame {

	public Board() {
		setSize(630, 630);
		setTitle("Connect Four");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setFocusable(true);

		Container pane = getContentPane();
		pane.setLayout(new GridLayout(6,7));
		pane.setBackground(Color.YELLOW);
		
		for(int i = 0; i<6; i++){
			for(int j = 0; j<7; j++){
				pane.add(new Cell());
			}
		}

	}

}
