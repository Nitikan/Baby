package com.crwx.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Babysister {
	private Vector2 position;
	public final int WIDTH = 99;
	public final int HEIGH = 80;
	public Rectangle rectangle;
	public Babysister(int x,int y) {
		position = new Vector2(x,y);
		rectangle = new Rectangle(position.x,position.y,WIDTH,HEIGH);
	}
	
	public Vector2 getPosition(){
		return position;}
	
	public void update() {
		rectangle.setPosition(position.x+18,position.y+20);
		
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
	

