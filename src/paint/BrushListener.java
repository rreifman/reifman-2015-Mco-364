package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class BrushListener implements MouseListener, MouseMotionListener{
	
	private Canvas canvas;
	protected int startX;
	protected int startY;
	protected int lastX;
	protected int lastY;
	private Color color;
	private int width;
	
	public BrushListener(Canvas canvas){
		this.canvas = canvas;
		color = Color.BLACK;
		width = 1;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();
		
		Graphics g = canvas.getG();
		g.setColor(color);
		draw(g);
		
		canvas.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
		g.setColor(color);
		g.setStroke(new BasicStroke(width));
		draw(g);
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
	
	public void changeColor(Color newColor){
		this.color = newColor;
	}
	
	public void changeWidth(int num){
		width = num;
	}

	public abstract void draw(Graphics g);


}
