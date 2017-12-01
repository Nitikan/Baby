package com.crwx.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private BabySisterGame babysisterGame;
	private Texture babyImg;
	private Texture handImg;
	private Texture antImg;
	private Texture spiderImg;
	private Texture beeImg;
	private Texture centipedeImg;
	private Texture cockroachImg;
	private int x; // adapt here from this point
	private int y;
	 
	public GameScreen(BabySisterGame babysisterGame) {
	        this.babysisterGame = babysisterGame;
	        babyImg = new Texture("baby.png");
	        handImg = new Texture("hand.png");
	        antImg = new Texture("ant.png");
	        spiderImg = new Texture("spider.png");
	        beeImg = new Texture("bee.png");
	        centipedeImg = new Texture("centipede.png");
	        cockroachImg = new Texture("cockroach.png");
	        x = 100; //adapt here from this point
	        y = 100; 
	}

	@Override
	public void render(float delta) {
	    SpriteBatch batch = babysisterGame.batch;
	    Gdx.gl.glClearColor(210/255f, 239/255f, 255/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    batch.begin();
	    batch.draw(babyImg, 440, 350);
	    batch.draw(handImg, 200, 150);
	    batch.draw(antImg, 750, x);
	    batch.draw(spiderImg, y+x, 380);
	    batch.draw(beeImg, y, x);
	    batch.draw(centipedeImg, 100, x);
	    batch.draw(cockroachImg, x, y);
	    batch.end();
	    y +=  5;
	    x +=  2; // adapt here from this point
	}
}