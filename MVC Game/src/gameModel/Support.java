package gameModel;

public class Support extends Hero implements Revive{
	private int move = 1;

	public Support() {
		super.setStartX(3);
		super.setStartY(3);

		super.setRoleType(RoleType.SUPPORT);
	}


	@Override
	public void revive() {
		// TODO Auto-generated method stub

	}


	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.print("i am support move method");
	}



}
