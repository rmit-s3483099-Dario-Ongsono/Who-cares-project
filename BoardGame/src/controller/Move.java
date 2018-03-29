package controller;

import javafx.scene.paint.Color;
import model.TestRole;
import view.Square;

/*
 * same design logic with Location.java
 *
 * function of class:
 * 1) highlight squares that pieces can move to
 * 2) move pieces to a selected square
 * 3) deny a move when a selected piece cannot move to
 *
 * late function:
 * 1) remove a piece from the board
 *
 */
public class Move{
	private static TestRole roleSelected;
	private static Square[][] moveBoard;

	public static void detectValidSquare(TestRole hero, Square[][] board){
		roleSelected  = hero;
		moveBoard = board;
		int x = hero.getX();
		int y = hero.getY();

		switch(hero.getDX()){
		case 1:

			break;
		case 2:
			board[x-1][y].setFill(Color.GREEN);
			board[x+1][y].setFill(Color.GREEN);
			board[x][y-1].setFill(Color.GREEN);
			board[x][y+1].setFill(Color.GREEN);
			break;
		}


	}
}