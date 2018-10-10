package id.actaca.dsas.screen

import com.badlogic.gdx.Screen
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.*
import com.badlogic.gdx.scenes.scene2d.*
import com.badlogic.gdx.scenes.scene2d.actions.Actions.*
import com.badlogic.gdx.utils.viewport.FillViewport
import id.actaca.dsas.entitas.Entity
import id.actaca.dsas.game.Assets
import id.actaca.dsas.controller.scene1.WorldController
import id.actaca.dsas.game.WorldRenderer
import id.actaca.dsas.jagoan.Jagoan
import id.actaca.dsas.map.Map
import id.actaca.dsas.renderer.EntityRendererActor
import com.badlogic.gdx.graphics.glutils.FrameBuffer
import id.actaca.dsas.environment.Background
import id.actaca.dsas.item.Pohon
import id.actaca.dsas.test.Berry


class Scene1 : Screen {
	var batch:SpriteBatch=SpriteBatch()
	var worldController: WorldController? = null
	var worldRenderer: WorldRenderer? =  null

	var berry:Berry = Berry(this)
	var background:Background = Background()
	var camera:OrthographicCamera = OrthographicCamera(500f,280f)
	var camera2:OrthographicCamera = OrthographicCamera(500f,280f)
	var jagoan:Jagoan= Jagoan()
	var pohon=Pohon()
	var pohon2=Pohon()
	var worldWidth:Int=background.image.width
	var worldHeight:Int=background.image.height
	fun init(){
		camera.setToOrtho(true, 500f, 280f);
		camera2.setToOrtho(false, 500f, 280f);
		//camera.translate(1500f,500f)
		//camera2.translate(1500f,-500f)
		worldController = WorldController(this)
		//worldController?.init()
		worldRenderer = WorldRenderer(worldController?:return)
		berry.init()
		jagoan.sprite_index = Assets.instance.findTexture("Sanindra")
		jagoan.setPos(180f,100f)
		pohon.sprite_index = Assets.instance.findTexture("Spohon2")
		pohon.setPos(50f,100f)
		pohon2.sprite_index = Assets.instance.findTexture("Spohon2")
		pohon2.setPos(300f,50f)
		//worldController?.cameraHelper?.setTarget(en2)
		//worldController?.cameraHelper?.applyTo(camera);
	}
	override fun render(delta:Float){
		worldController?.update()
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
	    renderWorld(delta)

	}
	fun renderWorld(delta: Float){


		//worldController?.cameraHelper?.update(delta)
		camera.update()
		//camera2.update()
        batch.projectionMatrix = camera.combined
		//map1.map1Renderer.setView(camera2);
		//map1.render()
		//fbo.begin()
		batch.begin();
		background.render(batch)
		//worldController.level.render(batch);
		//berry.render(batch,delta)
		jagoan.render(batch)
		pohon.render(batch)
		pohon2.render(batch)
		batch.end();



		/*fbo.end()
		var tex:Texture = fbo.colorBufferTexture
		batch.begin()
		batch.draw(tex,0f,0f,100f,100f)
		batch.end()*/

	}
	override fun pause(){
		
	}
	override fun resume(){
		
	}
	override fun hide(){}
	override fun show(){}
	override fun resize(w:Int,h:Int){
		
	}
	override fun dispose(){
		batch.dispose()
	}
}