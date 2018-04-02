package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.Board;

public class Tile extends Rectangle {
	private int newX, newY;
	private Role hero = null;

	public Tile(int x, int y){
		super(Board.TILE_SIZE, Board.TILE_SIZE);
		newX = x * Board.TILE_SIZE;
		newY = y * Board.TILE_SIZE;

		createTile();
	}

	public void createTile(){
		relocate(newX, newY);
		setFill(Color.valueOf("#feb"));
		setStroke(Color.BLACK);
	}

	public void putHero(Role r){
		this.hero = r;
	}

	public boolean hasHero(){
		return hero != null;
	}

	public void heroLeave(){
		this.hero = null;
	}
}