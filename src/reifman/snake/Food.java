package reifman.snake;

import java.awt.Image;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;

public class Food {
	
	private Image food;
	private int foodX;
	private int foodY;
	
	public Food() throws FileNotFoundException{
		ImageIcon apple = new ImageIcon("Apple Smile.png");
		food = apple.getImage();
		
	}
	
	public Image getFood(){
		return food;
	}
	
	public void setFoodX(int x){
		foodX = x;
	}
	
	public void setFoodY(int y){
		foodY = y;
	}

	public int getFoodX() {
		return foodX;
	}

	public int getFoodY() {
		return foodY;
	}
}
