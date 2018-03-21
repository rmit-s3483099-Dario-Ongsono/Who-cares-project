package view;

import model.TestRole;

public class Location {
	private static int newX;
	private static int newY;
	private static int index = 0;
	private static TestRole h;

	public static void setNewLocation(int x, int y){
		newX = x;
		newY = y;
		index = 1;
	}

	public static int getNewX(){

		index += 1;
		return newX;
	}

	public static int getNewY(){
		index += 1;
		return newY;
	}

	public static int getIndex(){
		return index;
	}

	public static void selectPiece(TestRole hero){
		h = hero;
	}
	
	
	public static void movePiece(int x, int y){
		h.relocate(x, y);
	}
	
	public static TestRole pieceSelected(){
		return h;
	}
}
