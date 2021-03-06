package controller;

import javafx.scene.paint.Color;
import model.Role;
import model.Tile;
import view.Board;

public class TileDetector extends Detector{

	public TileDetector(Role hero, Tile[][] tile){
		super(hero, tile);
	}

	public void validTile(){
		int x = super.getRoleSelected().getInitX();
		int y = super.getRoleSelected().getInitY();
		int smove = super.getRoleSelected().getRole().SMOVE;
		int dmove = super.getRoleSelected().getRole().DMOVE;

		if(super.getTile()[x][y].hasHero()){
			showStraightLine(x, y, smove);
			showDiagonalLine(x, y, dmove);
		}
	}

	public void moveTo(int x, int y){
		if(super.getTile()[x][y].isReady()){
			super.getRoleSelected().move(x, y);
		}
	}

	public void tileClean(){
		for(int i = 0; i < super.getTile().length; i++){
			for(int j = 0; j < super.getTile().length; j++){
				super.getTile()[i][j].setReady(false);
				super.getTile()[i][j].setFill(Color.valueOf("#feb"));
			}
		}
	}

	private void showDiagonalLine(int x, int y, int d) {

		if(x - d >= 0 && x + d <= Board.WIDTH || y - d >= 0 && y + d <= Board.HEIGHT){
			super.getTile()[x - d][y - d].setFill(Color.GREEN);
			super.getTile()[x - d][y - d].setReady(true);

			super.getTile()[x + d][y - d].setFill(Color.GREEN);
			super.getTile()[x + d][y - d].setReady(true);

			super.getTile()[x + d][y + d].setFill(Color.GREEN);
			super.getTile()[x + d][y + d].setReady(true);

			super.getTile()[x - d][y + d].setFill(Color.GREEN);
			super.getTile()[x - d][y + d].setReady(true);
		}
	}

	private void showStraightLine(int x, int y, int s){
		if(x - s >= 0 || y - s >= 0){
			super.getTile()[x - s][y].setFill(Color.GREEN);
			super.getTile()[x - s][y].setReady(true);

			super.getTile()[x][y - s].setFill(Color.GREEN);
			super.getTile()[x][y - s].setReady(true);
		}

		if(x + s <= Board.WIDTH || y + s <= Board.HEIGHT){
			super.getTile()[x + s][y].setFill(Color.GREEN);
			super.getTile()[x + s][y].setReady(true);

			super.getTile()[x][y + s].setFill(Color.GREEN);
			super.getTile()[x][y + s].setReady(true);
		}
	}


}
