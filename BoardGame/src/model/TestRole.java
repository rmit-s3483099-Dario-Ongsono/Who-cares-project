package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import view.Location;
import view.Window;




public class TestRole extends HeroTest{
	private double newX, newY;
	private double oldX, oldY;

	public TestRole(int x, int y){

		move(x, y);

		Ellipse bg = new Ellipse(Window.SQUARE_SIZE * 0.3125, Window.SQUARE_SIZE * 0.26);
		bg.setFill(Color.BLACK);

		bg.setStroke(Color.BLACK);
		bg.setStrokeWidth(Window.SQUARE_SIZE * 0.03);

		bg.setTranslateX((Window.SQUARE_SIZE - Window.SQUARE_SIZE * 0.3125 * 2) / 2);
		bg.setTranslateY((Window.SQUARE_SIZE - Window.SQUARE_SIZE * 0.26 * 2) / 2 + Window.SQUARE_SIZE * 0.07);

		getChildren().addAll(bg);

		setOnMousePressed(e ->{
			bg.setFill(Color.GREEN);
		});



	}

	@Override
	public void move(int x, int y) {
		oldX = x * Window.SQUARE_SIZE;
        oldY = y * Window.SQUARE_SIZE;
        relocate(oldX, oldY);

	}

	@Override
	public void abortMove() {


	}
}
