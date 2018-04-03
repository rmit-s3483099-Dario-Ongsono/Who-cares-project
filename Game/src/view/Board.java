package view;

import controller.Driver;
import controller.GameInitial;
import javafx.scene.layout.Pane;

public class Board {

	public static final int TILE_SIZE = 50;
	public static final int WIDTH = 12;
	public static final int HEIGHT = 14;

	public Pane displayBoard(){
		Pane gameBoard = new Pane();
		gameBoard.setPrefSize(TILE_SIZE * WIDTH, TILE_SIZE * HEIGHT);



		gameBoard.getChildren().addAll(Driver.getGame().tileInitialize(),Driver.getGame().heroInitialize());
		return gameBoard;
	}




}
