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
	 
	public GameScreen(BabySisterGame babysisterGame) {
	        this.babysisterGame = babysisterGame;
	        babyImg = new Texture("baby.png");
	        handImg = new Texture("hand.png");
	 }

	@Override
	public void render(float delta) {
	    SpriteBatch batch = babysisterGame.batch;
	    Gdx.gl.glClearColor(210/255f, 239/255f, 255/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    batch.begin();
	    batch.draw(babyImg, 440, 350);
	    batch.draw(handImg, 200, 150);
	    batch.end();
	}
}