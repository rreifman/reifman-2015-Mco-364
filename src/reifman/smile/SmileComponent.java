package reifman.smile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private static int wink = 80;
	private static int down = 200;
	private static int face = 400;
	private static int eye = 75;
	private static int smileOne = 200;
	private static int smileTwo = 100;


	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		double width = getWidth();
		double percent = (width - 800.0) / 800.0;
		down = (int) (200 + (200 * percent));
		face = (int) (400 + (400 * percent));
		eye = (int) (75 + (75 * percent));
		smileOne = (int) (200 + (200 * percent));
		smileTwo = (int) (100 + (100 * percent));
		
		
		wink = wink - 5;
		down = down + 3;
		if (wink == -5) {
			wink = 75;
			down = 200;
		}

		g.fillOval((int) (200 + (200 * percent)), (int)(100 + (100*percent)), face, face);
		g.setColor(Color.YELLOW);
		g.drawOval((int)(300 + 300*percent), (int) (200 + (200 * percent)), eye, eye);
		g.drawOval((int)(430 + (430 *percent)), down, eye, (int)(wink + (wink * percent)));
		g.drawArc((int)(300 + (300*percent)), (int)(300 + (300*percent)), smileOne, smileTwo, 190, 200);

	}

}
