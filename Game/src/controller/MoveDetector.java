package controller;

import model.Role;
import model.Tile;

public class MoveDetector {
	private Role heroSeleted;
	private Tile[][] tile;

	public void MoveDetector(Role hero, Tile[][] tile){
		this.heroSeleted = hero;
		this.tile = tile;

	}




}