package model;

public enum RoleType {
	WARRIOR(1), SUPPORT(2), GUNNER(4);

	final int moveDir;
	RoleType(int moveDir){
		this.moveDir = moveDir;
	}

}