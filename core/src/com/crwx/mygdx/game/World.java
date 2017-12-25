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
	private Baby baby;
	private Insects insects;
	public List<Insects> listInsects;
	public List<Integer> direction;
	private int score;
	public int  cursorx;
	public int  cursory;
	public int level = 1;
	private Random random;
	private Rectangle recMouse;
	public int status = 0; // 0start 1game 2score
	
	public World(BabySisterGame babysisterGame){
		clearScreen();
	}
		
	public void update(float delta) {
		//if(score%20 == 0)
		//{	level += 1;
			System.out.println(level);
		if(status == 1) {
			cursorx = Gdx.input.getX();
			cursory = -Gdx.input.getY();
			recMouse.setPosition(cursorx+9,-cursory+18);
			for (int i=0;i<listInsects.size();i++) {
					listInsects.get(i).update();
				if(Intersector.overlaps(recMouse,listInsects.get(i).getRec())) {
					if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
					listInsects.get(i).setDir(4);
					score += 5;
					System.out.println("1 : " + level);
					continue;}
					}
				if(Intersector.overlaps(baby.rectangle,listInsects.get(i).getRec())) {
					//status = 2;
				}
			}
		}
		if (status == 2) {
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				clearScreen();
				status = 0;}
		}
		else if(status == 0) {
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				status = 1;}
				}
			}
	//	}
	
	Baby getBaby() {
		return baby;
	}
	
	List<Insects> getInsects() {
		return listInsects;
	}
	
	public int getScore() {	
		return score;
	}
	
	public void settingFirst() {
		score = 0;
		baby = new Baby(425,350);
		listInsects = new ArrayList();
		direction= new ArrayList();
	    direction.add(0);
	    direction.add(1);
	    direction.add(2);
	    direction.add(3);
	    cursorx = Gdx.input.getX();
	    cursory = Gdx.input.getY();
	    random = new Random();
	}
	
	 public void generateInsects() {
		for (int i=0;i<level;i++) 
		{
			int tmp = random.nextInt(direction.size());
			insects = new Insects((Integer) direction.get(tmp));
			listInsects.add(insects);
		}
		recMouse = new Rectangle(cursorx,cursory,78,67);
	}
	
	private void clearScreen() {
		settingFirst();
		generateInsects();
	}
}