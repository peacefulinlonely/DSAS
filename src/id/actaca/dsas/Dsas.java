package id.actaca.dsas;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import id.actaca.dsas.game.Assets;
import id.actaca.dsas.screen.Scene1;

public class Dsas extends Game {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	Scene1 s1;

	boolean paused = false;
	public void create () {

		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		Assets.Companion.getInstance().init(new AssetManager());

		font = new BitmapFont();
		batch = new SpriteBatch();
		s1 = new Scene1();
		// Initialize controller and renderer
		s1.init();
		this.setScreen(s1);
	
	}

	@Override
	public void render () {
		super.render();

		batch.begin();
		font.draw(batch, Integer.toString(Gdx.graphics.getFramesPerSecond()), 10F, 10F);
		batch.end();
	}
	@Override
	public void resume () {
		Assets.Companion.getInstance().init(new AssetManager());
		paused = false;
	}
	@Override
	public void dispose () {
		font.dispose();
		batch.dispose();
		s1.dispose();
		Assets.Companion.getInstance().dispose();
	}

}
