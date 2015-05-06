package reifman.connectfour;

import java.awt.Color;
import java.awt.Component;

public class Piece extends Component{

	private Color color;
	
	public Piece(Color color){
		this.color = color;
	}
	

	public Color getColor() {
		return color;
	}

}
