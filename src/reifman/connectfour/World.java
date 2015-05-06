package reifman.connectfour;

import java.awt.Color;

public class World {

	private Board board;
	private Player playerOne;
	private Player playerTwo;
	
	public World(){
		board = new Board();
		playerOne = new Player(Color.RED);
		playerTwo = new Player(Color.BLUE);
	}
	
	
}
