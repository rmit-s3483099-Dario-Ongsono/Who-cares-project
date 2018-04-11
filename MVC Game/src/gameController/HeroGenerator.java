package gameController;

import java.util.ArrayList;

import gameModel.Hero;
import gameModel.PlayerType;
import gameModel.Ranger;
import gameModel.Support;
import gameModel.Warrior;
import gameView.HeroView;
import gameView.TileView;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class HeroGenerator {
//	private Group heroGroup;
	private int width, height, tilesize;
//	private PlayerType playT;
//	private HeroView heroView;

//	private ArrayList<Hero> heros = new ArrayList<Hero>();


	public HeroGenerator(int width, int height, int tilesize) {
		this.width = width;
		this.height = height;
		this.tilesize = tilesize;
//		this.playT = playT;
	}
	public Group createHeros(ArrayList<HeroView> heroArray,TileView[][] tileArray){
		Group group = new Group();
		ArrayList<Hero> r = new ArrayList<Hero>();
		r.add(new Warrior(width, height, PlayerType.BLUE));
		r.add(new Warrior(width, height, PlayerType.RED));

		r.add(new Support(width, height, PlayerType.BLUE));
		r.add(new Support(width, height, PlayerType.RED));

		r.add(new Ranger(width, height, PlayerType.BLUE));
		r.add(new Ranger(width, height, PlayerType.RED));

		for(Hero a : r){
			HeroView heroView = new HeroView(a.getStartX(), a.getStartY(),a.getPlayerType(), a.getRoleType(), tilesize);
			heroArray.add(heroView);

			tileArray[a.getStartX()][a.getStartY()].setHero(heroView); // ******* for future developing

			TurnChecker t = new TurnChecker();

			heroView.setOnMouseClicked(e ->{
				if(t.isTurn() && a.getPlayerType() == PlayerType.RED){

					heroView.selecetedChanges();
					a.move(heroView.getLocX(), heroView.getLocY());

					for(int i = 0; i < a.getValidX().length; i++){
						showValidTiles(tileArray, a.getValidX()[i], a.getValidY()[i]);
					}
				}

				if(!t.isTurn() && a.getPlayerType() == PlayerType.BLUE){
					heroView.selecetedChanges();
					a.move(heroView.getLocX(), heroView.getLocY());

					for(int i = 0; i < a.getValidX().length; i++){
						showValidTiles(tileArray, a.getValidX()[i], a.getValidY()[i]);
					}
				}


			});
			group.getChildren().add(heroView);
		}

		return group;
	}

	private void showValidTiles(TileView[][] tile, int x, int y){
		tile[x][y].setFill(Color.GREEN);
		tile[x][y].setReady(true);
	}
}
