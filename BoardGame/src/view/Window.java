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

		TestRole role = null;

		for (int y = 0; y < HEIGHT; y++){
			for (int x = 0; x < WIDTH; x++){
				Square square = new Square(x, y);
				board[x][y] = square;

				if(role == null && Location.getIndex() == 0){
					role = makeHero(x, y);
					square.setPiece(role);
				}


				squareGroup.getChildren().add(square);
			}
		}



		pieceGroup.getChildren().add(role);
		root.getChildren().addAll(squareGroup, pieceGroup);
		return root;
	}


	public TestRole makeHero(int x, int y){
		TestRole hero = new TestRole(x, y);

		hero.setOnMouseClicked(e ->{
			Location.selectPiece(hero);
		});

//		hero.setOnMouseClicked(e->{
//			if(Location.getIndex() != 0){
//				hero.relocate(Location.getNewX(), Location.getNewY());
//				System.out.print("321");
//			}
//		});


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
