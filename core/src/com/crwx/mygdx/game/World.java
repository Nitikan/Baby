package com.crwx.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class World {
	private BabySisterGame babysisterGame;
	private Babysister babysister;
	private Insects insects;
	private List<Insects> listInsects;
	
	public World(BabySisterGame babysisterGame)
	{
		this.babysisterGame = babysisterGame;	
		babysister = new Babysister(425,350);
		listInsects = new ArrayList();
		for (int i=0;i<10;i++) 
		{
			insects = new Insects();
			listInsects.add(insects);
		}
	}
	
	Babysister getBabysister() {
		return babysister;
	}
	
	List<Insects> getInsects() {
		return listInsects;
	}
}
