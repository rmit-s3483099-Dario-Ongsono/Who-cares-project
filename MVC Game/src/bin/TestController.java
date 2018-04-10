package bin;

import java.util.ArrayList;

import gameModel.*;
import gameView.*;
import javafx.scene.Group;

public class TestController {
	private Board board;
	private TileView[][] tileArray;
	private ArrayList<Hero> heroArray;
	private BoardView gameBoard;

	private Group tileGroup;
	private Group heroGroup;

	private static final int TILE_SIZE = 50, WIDTH = 9, HEIGHT = 9;



	public TestController(){
		board = new Board(TILE_SIZE, WIDTH, HEIGHT);

		tileArray = new TileView[WIDTH][HEIGHT];
		heroArray = new ArrayList();
		tileGroup = createTilesView();
		heroGroup = createHeroView();
		//heroGroup = createHerosView();

		gameBoard = new BoardView(board, tileGroup, heroGroup);

	}

	ValidTileDetector detector = new ValidTileDetector(tileArray);

	public Group createTilesView(){
		Group tileGroup = new Group();

		for(int x = 0; x < WIDTH; x++){
			for(int y = 0; y < HEIGHT; y++){
				Tile tile = new Tile(board.getTileSize(), x, y);
				TileView tileView = new TileView(tile);

				addTileEvents(tileView);

				tileArray[x][y] = tileView;

				tileGroup.getChildren().add(tileView);
			}
		}
		return tileGroup;
	}



	public Group createHeroView(){
		Group heroGroup = new Group();

		HeroView h1 = new HeroView(3, 3, PlayerType.BLUE, RoleType.TEST);
		tileArray[3][3].getTile().setHero(h1);

		addEvents(h1);
		heroGroup.getChildren().add(h1);

		return heroGroup;
	}

	public void addEvents(HeroView h){
		h.setOnMouseClicked(e ->{
			TestModel test = new TestModel();

			detector = new ValidTileDetector(tileArray, h);

			System.out.print(h.getLocX()+" " + h.getLocY());

			test.move(h.getLocX(), h.getLocY(), detector);



		});
	}

	private void addTileEvents(TileView tileview){

	}


	public BoardView getGameBoard(){
		return gameBoard;
	}








}
