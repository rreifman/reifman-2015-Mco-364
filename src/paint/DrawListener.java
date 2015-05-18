package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseListener, MouseMotionListener{

	private Canvas canvas;
	private int lastX;
	private int lastY;
	private Color color;
	
	public DrawListener(Canvas canvas){
		this.canvas = canvas;
		color = Color.BLACK;
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		
		int x = event.getX();
		int y = event.getY();
		
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		graphics.drawLine(lastX, lastY, x, y);
		
		lastX = x;
		lastY = y;
		
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {

	}

	@Override
	public void mousePressed(MouseEvent event) {

		
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		graphics.drawLine(x, y, lastX, lastY);
		
		lastX = x;
		lastY = y;
		
		canvas.repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void changeColor(Color color){
		this.color = color;
	}

}
