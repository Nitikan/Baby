package com.crwx.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;

public class World {
	private BabySisterGame babysisterGame;
	private Babysister babysister;
	private Insects insects;
	private List<Insects> listInsects;
	private List<Integer> direction;
	public int  cursorx;
	public int  cursory;
	
	//private Fighter_Plane cursor; 

	
	public World(BabySisterGame babysisterGame)
	{
		this.babysisterGame = babysisterGame;	
		babysister = new Babysister(425,350);
		listInsects = new ArrayList();
		//cursor = new Fighter_Plane();
		direction= new ArrayList();
	    direction.add(0);
	    direction.add(1);
	    direction.add(2);
	    direction.add(3);
	    cursorx = Gdx.input.getX();
	    cursory = Gdx.input.getY();
	    Random random = new Random();
		for (int i=0;i<10;i++) 
		{
			int tmp = random.nextInt(direction.size());
			insects = new Insects((Integer) direction.get(tmp));
			listInsects.add(insects);
		}
		
		
		
	}
	public void update(float delta) {
		for(int i = 0;i<listInsects.size();i++) {
			listInsects.get(i).update();
		}
		cursorx = Gdx.input.getX();
	    cursory = -Gdx.input.getY();
	}
	
	Babysister getBabysister() {
		return babysister;
	}
	
	List<Insects> getInsects() {
		return listInsects;
	}
}
