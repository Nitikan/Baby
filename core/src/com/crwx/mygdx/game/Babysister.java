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
		if(position.x <= 600)
		{
			
		}
	}
	
	public void Move_Left() {
		position.x -= 10;}
	public void Move_Right() {
		position.x += 10;}
	public void Move_Up() {
		position.y += 10;}
	public void Left() {
		position.y -= 10;}
	}
	

