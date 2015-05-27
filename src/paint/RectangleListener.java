package paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;


public class RectangleListener extends BrushListener{
	
	Canvas canvas;
	
	public RectangleListener(Canvas canvas){
		super(canvas);
		this.canvas = canvas;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(width));
		g2.drawRect(startX, startY, lastX - startX, lastY - startY);		
	}
//	
//	private Canvas canvas;
//	private int lastX;
//	private int lastY;
//	private Color color;
//	
//	public DrawRectangle(Canvas canvas){
//		this.canvas = canvas;
//		color = Color.BLACK;
//	}
//	
//	@Override
//	public void mouseDragged(MouseEvent event) {
//		
//		//Graphics graphics = canvas.getImage().getGraphics();
//		//graphics.setColor(color);
//		int x = event.getX();
//		int y = event.getY();
//		
//		Graphics graphics = canvas.getImage().getGraphics();
//		//graphics.setColor(color);
//		graphics.drawRect(lastX, lastY, x-lastX, y-lastY);
//		
//		lastX = x;
//		lastY = y;
//		
//		canvas.repaint();
//	}


	@Override
	public void drawPreview(Graphics g) {
		draw(g);		
	}

}
