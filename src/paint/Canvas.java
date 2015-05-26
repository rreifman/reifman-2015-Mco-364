package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	
	private BufferedImage image;
	private BrushListener listener;
	Graphics g;

	public Canvas(int width, int height){
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);

		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		this.g = g;
		super.paintComponent(g);
		
		g.drawImage(image, 0, 0, null);
		
		listener.draw(g);
		
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setBrushListener(BrushListener listener2) {
		removeMouseListener(listener);
		removeMouseMotionListener(listener);
		listener = listener2;
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	public Graphics getG() {
		return g;
	}

}
