package paint;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ModeButton extends JButton{
	
	private BrushListener listener;
	private String imageName;

	public ModeButton(BrushListener listener, String imageName) {
		this.listener = listener;
		this.imageName = imageName;
		ImageIcon image = new ImageIcon(imageName);
		setSize(new Dimension(60, 60));
		setOpaque(true);
		setIcon(image);
		setVisible(true);
		
	}
	
	public BrushListener getListener(){
		return listener;
	}

	public String getImageName() {
		return imageName;
	}
	
	

}
