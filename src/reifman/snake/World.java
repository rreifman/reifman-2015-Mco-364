package reifman.snake;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class World {

	private Snake snake;
	private Food food;
	private Image[][] board;
	private Random rand;
	private ArrayList<Image> balls;
	private static int snakeHeadX;
	private static int snakeHeadY;
	private Image blank;

	public World() {
		try {
			snake = new Snake(3);
			food = new Food();
			board = new Image[25][25];
			rand = new Random();
			snakeHeadX = rand.nextInt(24);
			snakeHeadY = rand.nextInt(24);
			// fillBoard();
			locateApple();
			locateSnake();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

//	public void fillBoard() {
//		ImageIcon box = new ImageIcon(
//				"/reifman-2015-Mco-364/20px-Blacksquare.png");
//		blank = box.getImage();
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				board[i][j] = blank;
//			}
//		}
//	}

	public void locateApple() {
		int x = rand.nextInt(24);
		int y = rand.nextInt(24);
		food.setFoodX(x);
		food.setFoodY(y);
		board[x][y] = food.getFood();

	}

	public void locateSnake() {
		try {
			//snake.moveSnake();
			board = new Image[25][25];
			balls = snake.getSnake();
			board[food.getFoodX()][food.getFoodY()] = (food.getFood());
			int counter = 0;
			for (Image x : balls) {
				board[snakeHeadX++][snakeHeadY] = x;
			}
			snake.setXList(snakeHeadX);

		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}

	public Snake getSnake() {
		return snake;
	}

	public Food getFood() {
		return food;
	}

	public Image[][] getBoard() {
		return board;
	}

	public Random getRand() {
		return rand;
	}

	public void setSnakeHeadX(int snakeHeadX) {
		this.snakeHeadX = snakeHeadX;
	}

	public void setSnakeHeadY(int snakeHeadY) {
		this.snakeHeadY = snakeHeadY;
	}

	public static int getSnakeHeadX() {
		return snakeHeadX;
	}

	public static int getSnakeHeadY() {
		return snakeHeadY;
	}

}
