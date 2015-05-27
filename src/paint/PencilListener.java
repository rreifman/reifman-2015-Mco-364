package paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;


public class PencilListener extends BrushListener{
	
	private Canvas canvas;

	public PencilListener(Canvas canvas){

		super(canvas);
		this.canvas = canvas;
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(width));
		g2.drawLine(startX, startY, lastX, lastY);
		startX = lastX;
		startY = lastY;
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

	@Override
	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		g2.setColor(color);
		g2.setStroke(new BasicStroke(width));
		g2.drawLine(startX, startY, lastX, lastY);
		startX = lastX;
		startY = lastY;
	}

}
