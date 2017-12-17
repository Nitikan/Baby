package com.crwx.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
	private BabySisterGame babysisterGame;
	private Babysister babysister;
	private Insects insects;
	private List<Insects> listInsects;
	private List<Integer> direction;
	public World(BabySisterGame babysisterGame)
	{
		this.babysisterGame = babysisterGame;	
		babysister = new Babysister(425,350);
		listInsects = new ArrayList();
		direction= new ArrayList();
	    direction.add(0);
	    direction.add(1);
	    direction.add(2);
	    direction.add(3);
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
	}
	
	Babysister getBabysister() {
		return babysister;
	}
	
	List<Insects> getInsects() {
		return listInsects;
	}
}
