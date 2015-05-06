package reifman.connectfour;

import java.awt.Graphics;

import javax.swing.JComponent;

public class WorldComponent extends JComponent{

	private World world;
	
	public WorldComponent(){
		world = new World();
	}
	
	// draws whole board
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
