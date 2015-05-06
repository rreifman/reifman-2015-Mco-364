package reifman.snake;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;

public class Snake {
	
	private ArrayList <Image> snake;
	private ArrayList<Integer> xList;
	private ArrayList<Integer> yList;
	private Image dot;
	
	public Snake(int balls)throws FileNotFoundException{
		snake = new ArrayList <Image>();
		ImageIcon ball = new ImageIcon("dot.png");
		dot = ball.getImage();
		for(int i =0; i<balls; i++){
			addToSnake();
		}
	}
	
	public void addToSnake(){
		snake.add(dot);
	}
	
	public void moveSnake(){
		int tail = snake.size()-1;
		snake.remove(tail);
		snake.add(dot);
		
	}
	
	public ArrayList<Image> getSnake() {
		return snake;
	}
	
	public Image getDot() {
		return dot;
	}
	
	public void setXList(int headX){
		xList = new ArrayList <Integer> ();
	
	}


}
