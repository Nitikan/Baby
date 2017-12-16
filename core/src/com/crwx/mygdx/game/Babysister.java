package com.crwx.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Babysister {
	private Vector2 position;
	public Babysister(int x,int y) {
		position = new Vector2(x,y);
	}
	
	public Vector2 getPosition(){
		return position;}
	
	public void update() {
		 if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			position.x -= 10;}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			position.x += 10;}
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			position.y += 10;}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			position.y -= 10;}
		}
	}
	

