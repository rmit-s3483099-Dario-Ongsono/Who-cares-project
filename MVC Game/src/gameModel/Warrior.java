package gameModel;

public class Warrior extends Hero implements Capture{

	public final int SMOVE; //Straight Line move
	public final int DMOVE; //Diagonal Line move 
	
	public Warrior(int x, int y, PlayerType p, RoleType r) {
		super(x, y, p, r);
		SMOVE = 1;
		DMOVE = 0;

	}

	@Override
	public void move(int x, int y) {
		 this.setLocationX(x);
		 this.setLocationY(y);
	}

	@Override
	public void capture() {

	}

}
