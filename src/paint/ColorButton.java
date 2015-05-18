package paint;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.LineBorder;


public class ColorButton extends JButton{
	
	private Color color;
	
	public ColorButton(Color color){
		this.color = color;
		setPreferredSize(new Dimension(40, 40));
		setBackground(color);
		setOpaque(true);
		setBorderPainted(false);
		setVisible(true);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		setBackground(color);
	}

}
