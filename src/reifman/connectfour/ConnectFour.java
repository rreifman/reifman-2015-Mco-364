package reifman.connectfour;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ConnectFour extends JFrame {

	private Player playerOne;
	private Player playerTwo;
	private boolean gameOver;
	private Cell[][] cells;
	private Player currentPlayer;
	private Color winner;

	public ConnectFour() {

		playerOne = new Player(Color.RED);
		playerTwo = new Player(Color.BLUE);
		gameOver = false;
		cells = new Cell[6][7];

		setSize(630, 630);
		setTitle("Connect Four");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setFocusable(true);

		Container pane = getContentPane();
		pane.setLayout(new GridLayout(6, 7));
		pane.setBackground(Color.YELLOW);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				Cell cell = new Cell();
				cell.setBorderPainted(true);

				pane.add(cell);
				cells[i][j] = cell;

			}
		}

	}

	ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				Cell cell = (Cell) event.getSource();
				if (!cell.hasPiece()) {
					Color color = currentPlayer.getColor();
					Piece piece = new Piece(color);
					cell.addPiece(piece);
					
					cell.setBackground(color);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	};

	public void takeTurn(Player player) {
		currentPlayer = player;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				Cell cell = cells[i][j];
				cell.addActionListener(listener);
			}

		}

	}

	public void checkStatus() {
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				try{
				// straight line
				if (cells[i][j].getPiece().getColor() == cells[i + 1][j]
						.getPiece().getColor()
						&& cells[i][j].getPiece().getColor() == cells[i + 2][j]
								.getPiece().getColor()
						&& cells[i][j].getPiece().getColor() == cells[i + 3][j]
								.getPiece().getColor()) {
					gameOver = true;
					winner = cells[i][j].getPiece().getColor();
				}
				
				}catch(NullPointerException ex){
					
				}

			}
		}
	}

	public void play() {
		while (!gameOver) {
			takeTurn(playerOne);
			takeTurn(playerTwo);
		}
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		ConnectFour c4 = new ConnectFour();
		c4.setVisible(true);
		c4.play();

	}

}
