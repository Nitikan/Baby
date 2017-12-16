package com.crwx.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Insects {
	private Vector2 position;
	public Insects() {
		Random random = new Random();
		int x = random.nextInt(600);
		int y = random.nextInt(800);
		position = new Vector2(x,y);
		
	}
	
	public Vector2 getPosition(){
		return position;}
	}
