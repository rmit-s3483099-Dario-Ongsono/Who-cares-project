package gameView;

import gameController.Controller;

import gameModel.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class HeroView extends StackPane{
	private Shape shape;

	private int x;
	private int y;
	private boolean alive;
	private boolean selected;

	public HeroView(int x, int y, PlayerType p, RoleType r){
		relocate(x * Controller.TILE_SIZE, y * Controller.TILE_SIZE);
		this.x = x;
		this.y = y;
		drawShape(p);
		this.alive = true;

		this.setOnMousePressed(e ->{
			shape.setStroke(Color.WHITE);
			this.selected = true;

		});

	}


	private void drawShape(PlayerType p){
		shape = new Ellipse(Controller.TILE_SIZE * 0.3125, Controller.TILE_SIZE * 0.26);

		shape.setFill(p == PlayerType.BLUE? Color.BLUE:Color.RED);

		shape.setStrokeWidth(Controller.TILE_SIZE * 0.05);
		shape.setStroke(Color.BLACK);

		shape.setTranslateX((Controller.TILE_SIZE - Controller.TILE_SIZE * 0.3125 * 2 ) / 2);
		shape.setTranslateY((Controller.TILE_SIZE - Controller.TILE_SIZE * 0.26 * 2) / 2 + Controller.TILE_SIZE * 0.07);
		getChildren().addAll(shape);
	}



	public void move(int x, int y){
		this.x = x;
		this.y = y;
		this.relocate(x * Controller.TILE_SIZE , y * Controller.TILE_SIZE );

	}

	public boolean isSelected(){
		return selected;
	}

	public void setDefault(){
		shape.setStroke(Color.BLACK);
		this.selected = false;
	}

	public void setlife(boolean life){
		this.alive = life;
	}

	public boolean isAlive(){
		return alive;
	}

	public int getLocX(){
		return x;
	}

	public int getLocY(){
		return y;
	}
}
