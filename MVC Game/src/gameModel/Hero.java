package gameModel;

public abstract class Hero implements Move{
	private PlayerType pType;
	private RoleType rType;
	private int startX;
	private int startY;

	protected int[] validX;
	protected int[] validY;

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
