package model;

import javafx.scene.layout.StackPane;
import view.Board;

public abstract class Role extends StackPane implements Move{
	private PlayerType player;
	private RoleType role;
	private int initX, initY;
	private boolean select;

	public Role(PlayerType p, RoleType r, int x, int y){
		this.player = p;
		this.role = r;
		this.select = false;

		this.initX = x * Board.TILE_SIZE;
		this.initY = y * Board.TILE_SIZE;

		relocate(initX, initY);
	}

	public abstract void drawShape(PlayerType p);

	public void selected(){
		select = true;
	}

	public boolean isSelected(){
		return select;
	}
}
