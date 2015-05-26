package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RectangleListener extends BrushListener{
	
	Canvas canvas;
	
	public RectangleListener(Canvas canvas){
		super(canvas);
		this.canvas = canvas;
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(startX, startY, lastX - startX, lastY - startY);		
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
	@Override
	public void mouseDragged(MouseEvent event) {
		
		//Graphics graphics = canvas.getImage().getGraphics();
		//graphics.setColor(color);
		int x = event.getX();
		int y = event.getY();
		
		Graphics graphics = canvas.getImage().getGraphics();
		//graphics.setColor(color);
		graphics.drawRect(lastX, lastY, x-lastX, y-lastY);
		
		lastX = x;
		lastY = y;
		
		canvas.repaint();
	}
//		
//
//		
	//}
//	@Override
//	public void mouseMoved(MouseEvent event) {
//		
//		
//	}
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		lastX = e.getX();
//		lastY = e.getY();
//		
//	}
//	@Override
//	public void mousePressed(MouseEvent e) {
//		lastX = e.getX();
//		lastY = e.getY();
//	}
//	
//	@Override
//	public void mouseReleased(MouseEvent event) {
//		int x = event.getX();
//		int y = event.getY();
//		
//		Graphics graphics = canvas.getImage().getGraphics();
//		graphics.setColor(color);
//		graphics.drawRect(lastX, lastY, x-lastX, y-lastY);
//			
//		canvas.repaint();
//		
//	}
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	public void changeColor(Color color){
//		this.color = color;
//	}

}
