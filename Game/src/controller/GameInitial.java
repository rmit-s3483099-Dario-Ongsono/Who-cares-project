package controller;

import javafx.scene.Group;
import model.PlayerType;
import model.Role;
import model.RoleType;
import model.Tile;
import model.Warrior;
import view.Board;

public class GameInitial {

	private Group tileGroup = new Group();
	private Group heroGroup = new Group();

	private Tile[][] tileArray = new Tile[Board.WIDTH][Board.HEIGHT];
	private Role[] heroArray = new Role[6];

	public Group tileInitialize(){
		for(int y = 0 ; y < Board.HEIGHT; y++){
			for(int x = 0; x < Board.WIDTH; x++){
				Tile tile = new Tile(x, y);
				tileArray[x][y] = tile;
				tileGroup.getChildren().add(tile);
			}
		}
		return tileGroup;
	}

	public Group heroInitialize(){

		for(int x = 0; x < Board.WIDTH; x ++){
			heroArray[0] = new Warrior(PlayerType.RED, RoleType.WARRIOR, 4, 2);
			//TOD
		}
		for(int i = 0; i < heroArray.length; i++){
			heroGroup.getChildren().add(heroArray[i]);
		}

		return heroGroup;
	}

	public Tile[][] getTileArray(){
		return tileArray;
	}

	public Role[] getHeroArray(){
		return heroArray;
	}

}
