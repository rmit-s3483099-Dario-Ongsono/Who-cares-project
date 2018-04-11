package gameModel;

/**
 *
 * @author 		Yu Liu
 * @version 	1.3
 * @since 		1.0
 *
 * @purpose		an abstract class which implements move interface
 *
 * @return
 */
public abstract class Hero implements Move{
	private PlayerType pType;
	private RoleType rType;
	private int startX;
	private int startY;

	protected int[] validX; //store every number of x of valid tiles to this hero
	protected int[] validY; //store every number of y of valid tiles to this hero

	public Hero(){
	}

	public int[] getValidX(){
		return validX;
	}

	public int[] getValidY(){
		return validY;
	}
	public void setPlayerType(PlayerType pType) {
		this.pType = pType;
	}

	public void setRoleType(RoleType rType) {
		this.rType = rType;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public PlayerType getPlayerType(){
		return pType;
	}

	public RoleType getRoleType(){
		return rType;
	}

	public int getStartX(){
		return startX;
	}

	public int getStartY(){
		return startY;
	}
}
