package bin;

import gameController.Controller;
import gameModel.RoleType;
import gameView.*;
import javafx.scene.paint.Color;


public class ValidTileDetector {
	private TileView[][] tileArray;
	private HeroView hero;


	public ValidTileDetector(TileView[][] tileArray, HeroView hero){
		this.tileArray = tileArray;
		this.hero = hero;

		//showValidTile();
	}

	public ValidTileDetector(TileView[][] tileArray){
		this.tileArray = tileArray;
	}

	public void showValidTile(){

		int curX = hero.getLocX();
		int curY = hero.getLocY();
		int smove = .SMOVE;
		int dmove = r.DMOVE;
		System.out.print("yes i am");
		if(tileArray[x][y].getTile().hasHero()){
			System.out.print("i am if ");
			showStraightLine(x, y, smove);
			showDiagonalLine(x, y, dmove);
		}
	}

	private void showDiagonalLine(int x, int y, int d) {

		if(x - d >= 0 && y + d < Controller.HEIGHT){
			tileArray[x - d][y + d].setFill(Color.GREEN);
			tileArray[x - d][y + d].getTile().setReady(true);
		}

		if(x - d >= 0 && y - d >= 0){
			tileArray[x - d][y - d].setFill(Color.GREEN);
			tileArray[x - d][y - d].getTile().setReady(true);
		}

		if(x + d < Controller.WIDTH && y - d >= 0){
			tileArray[x + d][y - d].setFill(Color.GREEN);
			tileArray[x + d][y - d].getTile().setReady(true);
		}

		if(x + d < Controller.WIDTH && y + d < Controller.HEIGHT){
			tileArray[x + d][y + d].setFill(Color.GREEN);
			tileArray[x + d][y + d].getTile().setReady(true);
		}
	}

	private void showStraightLine(int x, int y, int s){
		if(x - s >= 0){
			tileArray[x - s][y].setFill(Color.GREEN);
			tileArray[x - s][y].getTile().setReady(true);
		}

		if(y - s >= 0){

			tileArray[x][y - s].setFill(Color.GREEN);
			tileArray[x][y - s].getTile().setReady(true);
		}
		if(x + s < Controller.WIDTH){
			tileArray[x + s][y].setFill(Color.GREEN);
			tileArray[x + s][y].getTile().setReady(true);

		}

		if(y + s < Controller.HEIGHT){
			tileArray[x][y + s].setFill(Color.GREEN);
			tileArray[x][y + s].getTile().setReady(true);
		}
	}
}
