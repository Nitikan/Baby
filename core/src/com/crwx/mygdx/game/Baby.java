package com.crwx.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Baby {
	private Vector2 position;
	public final int WIDTH = 99;
	public final int HEIGH = 80;
	public Rectangle rectangle;
	
	public Baby(int x,int y) {
		position = new Vector2(x,y);
		rectangle = new Rectangle(position.x,position.y,WIDTH,HEIGH);
	}
	
	public Vector2 getPosition(){
		
		return position;
	}
	
	public void update() {
		rectangle.setPosition(position.x+18,position.y+20);
		if (position.x == -100){
			position.x = 1000;
			position.y = 325;
		}
		else if (position.y == 550){
			Move_Left();
		}
		else if(position.y == 500) {
			Move_Left();
		}
		else if (position.x == 800){
			Move_Up();
		}
		else if(position.y == 125) {
			Move_Right();
		}
		else if(position.x > 120) {
			Move_Left();
			Move_Down();
		}
	}
			
	public void Move_Left() {
		position.x -= 1;
	}
	
	public void Move_Right() {
		position.x += 1;
	}
	
	public void Move_Up() {
		position.y += 1;
	}
	
	public void Move_Down() {
		position.y -= 1;
	}
}
	

