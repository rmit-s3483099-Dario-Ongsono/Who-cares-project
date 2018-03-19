package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Rectangle{
	private Piece piece;

	public boolean hasPiece(){
		return piece != null;
	}
	public Piece getPiece(){
		return piece;
	}

	public Square(int x, int y){
		setWidth(Window.SQUARE_SIZE);
		setHeight(Window.SQUARE_SIZE);

		relocate(x * Window.SQUARE_SIZE, y * Window.SQUARE_SIZE);
		
		setFill(Color.valueOf("#feb"));
		setStroke(Color.valueOf("Black"));
	}
}