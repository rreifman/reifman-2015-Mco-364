package reifman.smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private static int wink = 80;
	private static int down = 200;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		wink = wink - 5;
		down = down + 3;
		if (wink == -5) {
			wink = 75;
			down = 200;
		}
		
		
		g.fillOval(200, 100, 400, 400);
		g.setColor(Color.YELLOW);
		g.drawOval(300, 200, 75, 75);
		g.drawOval(430, down, 75, wink);
		g.drawArc(300, 300, 200, 100, 190, 200);

	}

}
