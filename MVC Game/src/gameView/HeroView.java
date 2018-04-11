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
	private int size;
	private PlayerType p;

	public HeroView(int x, int y, PlayerType p, RoleType r, int size){
		relocate(x * size, y * size);
		this.size = size;
		this.x = x;
		this.y = y;
		drawShape(p);
		this.alive = true;
		this.p = p;

	}

	public void selecetedChanges(){
		shape.setStroke(Color.WHITE);
		this.selected = true;
	}
	private void drawShape(PlayerType p){
		shape = new Ellipse(size * 0.3125, size * 0.26);

		shape.setFill(p == PlayerType.BLUE? Color.BLUE:Color.RED);

		shape.setStrokeWidth(size * 0.05);
		shape.setStroke(Color.BLACK);

		shape.setTranslateX((size - size * 0.3125 * 2 ) / 2);
		shape.setTranslateY((size - size * 0.26 * 2) / 2 + size * 0.07);
		getChildren().addAll(shape);
	}

	public PlayerType getPlayerType(){
		return p;
	}


	public void move(int x, int y){
		this.x = x;
		this.y = y;
		this.relocate(x * size , y * size );

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
