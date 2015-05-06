package reifman.connectfour;

import java.awt.Color;
import java.util.ArrayList;

public class Player {

	private ArrayList<Piece> pieces;
	private Color color;
	
	public Player(Color color){
		this.color = color;
		pieces = new ArrayList <Piece>();
		for(int i =0; i<21; i++){
			pieces.add(new Piece(color));
		}
	}
	
	public int getNumPieces(){
		return pieces.size();
	}
	
	public Piece takeTurn(){
		return pieces.remove(0);
	}
	
	public Color getColor(){
		return color;
	}
}
