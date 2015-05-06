package reifman.snake;

public class GameLoopThread extends Thread {
	
	private WorldComponent component;

	public GameLoopThread(WorldComponent component){
		this.component = component;
		component.repaint();
	}
	

}
