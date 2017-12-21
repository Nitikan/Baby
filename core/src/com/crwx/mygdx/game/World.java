package com.crwx.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
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
	
	//private Fighter_Plane cursor; 

	
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
		recMouse = new Rectangle(cursorx,cursory,100,100);
		
	}
	public void update(float delta) {
		//System.out.println(delta);
		if(delta>=0.017) {
			 score++;}
		cursorx = Gdx.input.getX();
	    cursory = -Gdx.input.getY();
	    recMouse.setPosition(cursorx+50,cursory+50);
		for(int i = 0;i<listInsects.size();i++) {
			listInsects.get(i).update();
			//if(recMouse.overlaps(listInsects.get(i).getRec())) {
				//System.out.println("hit"+i);
			//}
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
}
