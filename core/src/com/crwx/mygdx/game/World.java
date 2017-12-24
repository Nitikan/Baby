package com.crwx.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class World {
	private BabySisterGame babysisterGame;
	private Babysister babysister;
	private Insects insects;
	public List<Insects> listInsects;
	public List<Integer> direction;
	private int score;
	public int  cursorx;
	public int  cursory;
	private Random random;
	private Rectangle recMouse;
	public int status = 0; // 0start 1game 2score
	
	
	public World(BabySisterGame babysisterGame)
	{
		score = 0;
		this.babysisterGame = babysisterGame;	
		babysister = new Babysister(425,350);
		listInsects = new ArrayList();
		direction= new ArrayList();
	    direction.add(0);
	    direction.add(1);
	    direction.add(2);
	    direction.add(3);
	    cursorx = Gdx.input.getX();
	    cursory = Gdx.input.getY();
	    random = new Random();
		for (int i=0;i<4;i++) 
		{
			int tmp = random.nextInt(direction.size());
			insects = new Insects((Integer) direction.get(tmp));
			listInsects.add(insects);
		}
		recMouse = new Rectangle(cursorx,cursory,78,67);
		
	}
	public void update(float delta) {
		if(status == 1) {
			cursorx = Gdx.input.getX();
			cursory = -Gdx.input.getY();
			recMouse.setPosition(cursorx+9,cursory+18);
			for (Insects object: listInsects) {
				if(object != null) {
				object.update();
				if(Intersector.overlaps(recMouse,object.getRec())) {
					System.out.println("hit");
					//if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
					object = null;
					System.out.println("jj");
					status = 2;
					break;
					}
				if(Intersector.overlaps(babysister.rectangle,object.getRec())) {
				//	status = 2;
				}
			}
			}
		}
		if (status == 2) {
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				//clearScreen();
				status = 0;}
		}
		else if(status == 0) {
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				status = 1;}
		}
	}
	
	Babysister getBabysister() {
		return babysister;
	}
	
	List<Insects> getInsects() {
		return listInsects;
	}
	public int getScore() {
		return score;
	}
	private void clearScreen() {
	}
}