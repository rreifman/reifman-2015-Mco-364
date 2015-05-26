package paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;


public class PencilListener extends BrushListener{
	
	private Canvas canvas;

	public PencilListener(Canvas canvas){

		super(canvas);
		this.canvas = canvas;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(startX, startY, lastX, lastY);
		
	}

//	private Canvas canvas;
//	private int lastX;
//	private int lastY;
//	private Color color;
//	
//	public PencilListener(Canvas canvas){
//		this.canvas = canvas;
//		color = Color.BLACK;
//	}
//	
	@Override
	public void mouseDragged(MouseEvent event) {
		
		int x = event.getX();
		int y = event.getY();
		
		Graphics graphics = canvas.getImage().getGraphics();
		//graphics.setColor(color);
		graphics.drawLine(lastX, lastY, x, y);
		
		lastX = x;
		lastY = y;
		
		canvas.repaint();
	}
//
//	@Override
//	public void mouseMoved(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent event) {
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent event) {
//
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent event) {
//		int x = event.getX();
//		int y = event.getY();
//		
//		Graphics graphics = canvas.getImage().getGraphics();
//		graphics.setColor(color);
//		graphics.drawLine(x, y, lastX, lastY);
//		
//		lastX = x;
//		lastY = y;
//		
//		canvas.repaint();
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
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
