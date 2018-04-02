package controller;

import javafx.scene.paint.Color;
import model.Role;
import model.Tile;
import view.Board;

public class MoveDetector {
	private Role heroSelected;
	private Tile[][] tile;

	public MoveDetector(Role hero, Tile[][] tile){
		this.heroSelected = hero;
		this.tile = tile;
	}

	public void validTile(){
		int x = heroSelected.getInitX();
		int y = heroSelected.getInitY();
		int smove = heroSelected.getRole().SMOVE;
		int dmove = heroSelected.getRole().DMOVE;

		if(tile[x][y].hasHero()){
			showStraightLine(x, y, smove);
			showDiagonalLine(x, y, dmove);
		}
	}

	private void showDiagonalLine(int x, int y, int d) {

		if(x - d >= 0 && x + d <= Board.WIDTH || y - d >= 0 && y + d <= Board.HEIGHT){
			tile[x - d][y - d].setFill(Color.GREEN);
			tile[x - d][y - d].setReady(true);

			tile[x + d][y - d].setFill(Color.GREEN);
			tile[x + d][y - d].setReady(true);

			tile[x + d][y + d].setFill(Color.GREEN);
			tile[x + d][y + d].setReady(true);

			tile[x - d][y + d].setFill(Color.GREEN);
			tile[x - d][y + d].setReady(true);
		}
	}

	private void showStraightLine(int x, int y, int s){
		if(x - s >= 0 || y - s >= 0){
			tile[x - s][y].setFill(Color.GREEN);
			tile[x - s][y].setReady(true);

			tile[x][y - s].setFill(Color.GREEN);
			tile[x][y - s].setReady(true);
		}

		if(x + s <= Board.WIDTH || y + s <= Board.HEIGHT){
			tile[x + s][y].setFill(Color.GREEN);
			tile[x + s][y].setReady(true);

			tile[x][y + s].setFill(Color.GREEN);
			tile[x][y + s].setReady(true);
		}
	}

}
