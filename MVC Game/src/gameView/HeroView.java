package gameView;

import gameController.Controller;
import gameModel.PlayerType;
import gameModel.RoleType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class HeroView extends StackPane{
	private Shape shape;

	public HeroView(int x, int y, PlayerType p, RoleType r){
		relocate(x * Controller.TILE_SIZE, y * Controller.TILE_SIZE);
		drawShape(p);
	}


	private void drawShape(PlayerType p){
		shape = new Ellipse(Controller.TILE_SIZE * 0.3125, Controller.TILE_SIZE * 0.26);

		shape.setFill(p == PlayerType.BLUE? Color.BLUE:Color.RED);

		shape.setStrokeWidth(Controller.TILE_SIZE * 0.03);
		shape.setStroke(Color.BLACK);

		shape.setTranslateX((Controller.TILE_SIZE - Controller.TILE_SIZE * 0.3125 * 2 ) / 2);
		shape.setTranslateY((Controller.TILE_SIZE - Controller.TILE_SIZE * 0.26 * 2) / 2 + Controller.TILE_SIZE * 0.07);
		getChildren().addAll(shape);
	}
}