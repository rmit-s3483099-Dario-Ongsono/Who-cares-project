package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.TestRole;
/**
 *
 * @author Yu Liu makes GUI
 * @version 0.01
 *
 */
public class Window extends Application{
	public static final int SQUARE_SIZE = 100;
	public static final int WIDTH = 8;
	public static final int HEIGHT = 6;

	private Square[][] board = new Square[WIDTH][HEIGHT];

	private Group squareGroup = new Group();
	private Group pieceGroup = new Group();

	private Pane getBoard(){
		Pane root = new Pane();
		root.setPrefSize(SQUARE_SIZE * WIDTH, SQUARE_SIZE * HEIGHT);



		for (int y = 0; y < HEIGHT; y++){
			for (int x = 0; x < WIDTH; x++){
				Square square = new Square(x, y);
				board[x][y] = square;

				squareGroup.getChildren().add(square);

				TestRole role = null;

				if(y == 0 && x % 2 == 0){
					role = makeHero(true, x, y);

				}
				else if(y == 5 && x % 2 == 0){
					role = makeHero(false, x, y);
				}

				if (role != null) {
	                   square.setPiece(role);
	                   pieceGroup.getChildren().add(role);
	            }
			}
		}
		root.getChildren().addAll(squareGroup, pieceGroup);
		return root;
	}


	public TestRole makeHero(boolean type, int x, int y){
		TestRole hero = new TestRole(type ,x, y);

		hero.setOnMouseClicked(e ->{
			if(Location.getTurn() % 2 == 0 && hero.getType()){
				Location.selectPiece(hero);
			}else if(Location.getTurn() % 2 != 0 && !hero.getType()){
				Location.selectPiece(hero);
			}else{
				Alarm.display();
				hero.getBg().setStroke(Color.BLACK);
			}
				
		});
		return hero;
	}



	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(getBoard());
		primaryStage.setTitle("Panda Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String[] args){
		launch();
	}
}
