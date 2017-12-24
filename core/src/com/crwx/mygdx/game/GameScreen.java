package com.crwx.mygdx.game;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter{
	private BabySisterGame babysisterGame;
	private WorldRenderer worldRenderer;
	private World world;

	 
	public GameScreen(BabySisterGame babysisterGame) {
	        this.babysisterGame = babysisterGame;
	        world = new World(babysisterGame);
	        worldRenderer = new WorldRenderer(babysisterGame, world);
	     
	}
	
	private void update(float delta) {
		world.getBabysister().update();
		world.update(delta);
	}
	
	@Override
	public void render(float delta) {
		update (delta);
		
	    Gdx.gl.glClearColor(210/255f, 239/255f, 255/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      
        
        worldRenderer.render(delta);
        
	}
}