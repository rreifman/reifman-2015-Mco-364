package reifman.snake;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class WorldComponent extends JComponent {
	
	private World world;
	private Image[][] board;
	
	public WorldComponent(){
		world = new World();
		board = world.getBoard();
	}

	// draws whole board
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw
		doDrawing(g);
	}

	private void doDrawing(Graphics g) {
		// TODO Auto-generated method stub
 
		
		world.locateSnake();
		int x = 0;
		int y = 0;
		for(int i=0; i<25; i++){
			for(int j=0; j<25; j++){
				g.drawImage(board[i][j], x, y, 15, 15, this);
				x++;
			}
		}
		
		

	}
}
