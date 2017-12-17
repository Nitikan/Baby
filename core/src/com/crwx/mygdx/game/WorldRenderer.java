package com.crwx.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	private BabySisterGame babysisterGame;
	private World world;
	private Texture babyImg;
	private List<Texture> insectsImg;
	private List<Texture> randomInsect;
	SpriteBatch batch;

	public WorldRenderer(BabySisterGame babysisterGame, World world) {
		batch = babysisterGame.batch; 
		this.babysisterGame = babysisterGame;
	    this.world = world;	 
	    babyImg = new Texture("baby.png");
	    insectsImg = new ArrayList();
	    randomInsect = new ArrayList();
	    randomInsect.add(new Texture("ant.png"));
	    randomInsect.add(new Texture("spider.png"));
	    randomInsect.add(new Texture("bee.png"));
	    randomInsect.add(new Texture("centipede.png"));
	    randomInsect.add(new Texture("cockroach.png"));
	    
	    Random random = new Random();
	    for(int i=0;i<10;i++) 
	    {
	    	int tmp = random.nextInt(5);
	    	insectsImg.add(randomInsect.get(tmp));
	    }
	}
	
	public void render(float delta) {
		batch = babysisterGame.batch;
	    batch.begin();
        batch.draw(babyImg, world.getBabysister().getPosition().x, world.getBabysister().getPosition().y);
        for(int i =0;i<world.getInsects().size();i++)
        	batch.draw(insectsImg.get(i), world.getInsects().get(i).getPosition().x, world.getInsects().get(i).getPosition().y);
        batch.end();
		
		}
	}

