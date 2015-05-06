package reifman.connectfour;

import javax.swing.JButton;

public class Cell extends JButton {

	private boolean hasPiece;
	private Piece piece;
	
	public Cell(){
		hasPiece = false;
	}
	
	public void addPiece(Piece piece) throws Exception{
		this.piece = piece;
		if(!hasPiece){
		add(piece);
		hasPiece = true;
		//setBackground(piece.getColor());
		}
		else{
			throw new Exception("Please pick a different cell");
		}
	}
	
	public boolean hasPiece(){
		return hasPiece;
	}
	
	public Piece getPiece(){
		return piece;
	}
}
