package id.actaca.dsas.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer
import com.badlogic.gdx.scenes.scene2d.*
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.utils.viewport.FillViewport
import id.actaca.dsas.entitas.Entity
import id.actaca.dsas.game.Assets
import id.actaca.dsas.map.Map
import id.actaca.dsas.renderer.EntityRendererActor
import id.actaca.dsas.screen.Scene1

public class Berry(var screen: Scene1) {
    var map1: Map = Map()
    var stage: Stage = Stage()
    var en: Entity = Entity()
    var en2: Entity = Entity()
    var fbo = FrameBuffer(Pixmap.Format.RGB888,500, 280, false)
    var img:Texture=Texture("a_logo.png")
    var atlas:TextureAtlas = TextureAtlas(Gdx.files.internal("gm8_all.atlas"))
    var tx: TextureRegion = TextureRegion(img,0,0,60,60)
    var ar: TextureAtlas.AtlasRegion = atlas.findRegion("Backgrounds/clouds")
    var spr:Sprite = Sprite(Assets.instance.ball?.tex)
    var ball = object : Actor(){
        init{
            this.setBounds(x,y,spr.width,spr.height)
            addListener(object: InputListener(){
                override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                    super.touchDown(event, x, y, pointer, button)
                    println("ouch")
                    addAction(Actions.rotateBy(90f, 5f))
                    return true
                }
            })
            //

        }
        override fun draw(batch: Batch?, parentAlpha: Float) {
            super.draw(batch, parentAlpha)
            batch?.draw(spr,x,y,originX, originY, width, height,
                    scaleX, scaleY, rotation)
        }


    }
    fun init(){
        stage = Stage(FillViewport(500f,280f,screen.camera))


        Gdx.input.inputProcessor = stage
        stage.addActor(ball)
        ball.touchable = Touchable.enabled

        en.x = 20f
        en.y = 30f
        en2.x=40f
        en.renderer = EntityRendererActor(en.actor)
        en2.renderer = EntityRendererActor(en2.actor)
        //camera.translate(-100f,-40f);
        en2.actor.y=200f
        en2.actor.addListener(object:InputListener(){
            override fun touchDown(event: InputEvent?, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                super.touchDown(event, x, y, pointer, button)
                println("hello")
                return true
            }
        })
    }
    fun render(batch: Batch,delta:Float){
      /*  stage.batch.projectionMatrix = screen.camera.combined

        stage.act(delta)

        stage.draw()*/
        en.render(batch)
        en2.render(batch)
    }
    fun dispose(){
        img.dispose()
        atlas.dispose()
        fbo.dispose()

    }
}
