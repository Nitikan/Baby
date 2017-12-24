package com.crwx.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	private BabySisterGame babysisterGame;
	private World world;
	private Texture babyImg;
	private Texture handImg;
	private Texture startImg;
	private Texture overImg;
	private List<Texture> insectsImg;
	private List<Texture> randomInsect;
	private BitmapFont font;
	private BitmapFont gameOverScore;
	private Random random;
	SpriteBatch batch;
	
	
	public WorldRenderer(BabySisterGame babysisterGame, World world) {
		batch = babysisterGame.batch; 
		this.babysisterGame = babysisterGame;
	    this.world = world;	 
	    babyImg = new Texture("baby.png");
	    handImg = new Texture("hand.png");
	    startImg = new Texture("start.jpg");
	    overImg = new Texture("gameover.jpg");
	    insectsImg = new ArrayList();
	    randomInsect = new ArrayList();
	    randomInsect.add(new Texture("ant.png"));
	    randomInsect.add(new Texture("spider.png"));
	    randomInsect.add(new Texture("bee.png"));
	    randomInsect.add(new Texture("centipede.png"));
	    randomInsect.add(new Texture("cockroach.png"));
	    
	   random = new Random();
	    for(int i=0;i<world.listInsects.size();i++) 
	    {
	    	int tmp = random.nextInt(5);
	    	insectsImg.add(randomInsect.get(tmp));
	    }
	    font = new BitmapFont();
        font.getData().setScale(3);
        gameOverScore = new BitmapFont();
        gameOverScore.getData().setScale(2);
        gameOverScore.setColor(Color.BLACK);
	}
	private void update() {
		for(int i = 0;i<world.listInsects.size();i++) {
	    	if(world.listInsects.get(i)!=null) {
			int tmp = random.nextInt(world.direction.size());
	    	Insects insects = new Insects((Integer) world.direction.get(tmp));
			//listInsects.add(insects);
	    	if(world.listInsects.get(i).getDir() == 0) {
	    		if(world.listInsects.get(i).getPosition().x<-100) {
	    			
	    			world.listInsects.remove(i);
	    			world.listInsects.add(insects);
	    			insectsImg.remove(i);
	    			int tmp1 = random.nextInt(5);
	    	    	insectsImg.add(randomInsect.get(tmp1));
	    		}
	    		
	    	}
	    	else if(world.listInsects.get(i).getDir() == 1) {
	    		if(world.listInsects.get(i).getPosition().x>900) {
	    			
	    			world.listInsects.remove(i);
	    			world.listInsects.add(insects);
	    			insectsImg.remove(i);
	    			int tmp1 = random.nextInt(5);
	    	    	insectsImg.add(randomInsect.get(tmp1));
	    			
	    		}
	    	}
	    	else if(world.listInsects.get(i).getDir() == 2) {
	    		if(world.listInsects.get(i).getPosition().y<-100) {
	    			
	    			world.listInsects.remove(i);
	    			world.listInsects.add(insects);
	    			insectsImg.remove(i);
	    			int tmp1 = random.nextInt(5);
	    	    	insectsImg.add(randomInsect.get(tmp1));
	    			
	    		}
	    		
	    	}
	    	else if(world.listInsects.get(i).getDir() == 3) {
	    		if(world.listInsects.get(i).getPosition().y>700) {
	    			
	    			world.listInsects.remove(i);
	    			world.listInsects.add(insects);
	    			insectsImg.remove(i);
	    			int tmp1 = random.nextInt(5);
	    	    	insectsImg.add(randomInsect.get(tmp1));
	    			
	    		}
	    	}
		}
	}
	}
	public void render(float delta) {
		update();
		batch = babysisterGame.batch;
	    batch.begin();
	    if(world.status == 0){ 
	    	batch.draw(startImg,0,0);
	    }
	    else if (world.status == 1) { 
		    batch.draw(babyImg, world.getBabysister().getPosition().x,world.getBabysister().getPosition().y);
		    for(int i =0;i<world.getInsects().size();i++) {
		    if(world.listInsects.get(i)!=null) {
		    	batch.draw(insectsImg.get(i), world.getInsects().get(i).getPosition().x, world.getInsects().get(i).getPosition().y);}}
	        batch.draw(handImg, world.cursorx-50, world.cursory+750);
	        font.draw(batch, "" + world.getScore(), 870, 770);
	    }
	    else if (world.status == 2) {
	    	batch.draw(overImg,0,0);
	    }
        batch.end();
	
		}
	}

