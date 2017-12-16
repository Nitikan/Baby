package com.crwx.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter{
	private BabySisterGame babysisterGame;
	private WorldRenderer worldRenderer;
	private World world;
	
	/*
	private Texture handImg;
	*/

	 
	public GameScreen(BabySisterGame babysisterGame) {
	        this.babysisterGame = babysisterGame;
	        world = new World(babysisterGame);
	        worldRenderer = new WorldRenderer(babysisterGame, world);
	     
	        /*
	        handImg = new Texture("hand.png");
	        */
	        
	}
	
	private void update(float delta) {
		world.getBabysister().update();
	}
	
	@Override
	public void render(float delta) {
		update (delta);
		
	    Gdx.gl.glClearColor(210/255f, 239/255f, 255/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        worldRenderer.render(delta);
        
	   // batch.draw(handImg, 200, 150);
	}
}