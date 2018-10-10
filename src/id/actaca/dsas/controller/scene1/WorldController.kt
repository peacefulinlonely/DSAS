package id.actaca.dsas.controller.scene1
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import id.actaca.dsas.game.Assets
import id.actaca.dsas.game.CameraHelper
import id.actaca.dsas.screen.Scene1

class WorldController(var screen:Scene1) : InputAdapter(){
    var testSprites:Array<Sprite>  = Array<Sprite>(10)
    var cameraHelper: CameraHelper = CameraHelper()
    var camOnBorder:Boolean = false

    private fun initTestObjects ()
    {
// Create new array for 5 sprites
        testSprites =  Array<Sprite>(5)
// Create a list of texture regions
        var  regions:Array<TextureRegion> =  Array<TextureRegion>(10)
        regions.add(Assets.instance.ball?.tex);

    }
    fun init(screen:Scene1){
        Gdx.input.inputProcessor = this
    }
    fun update(){
        if( Gdx.input.isTouched()) {
            if (Gdx.input.getX() > Gdx.graphics.getWidth() - 40  && (screen.camera.position.x+screen.camera.viewportWidth/2)< screen.worldWidth) {
                screen.camera.translate(5f, 0f);
                screen.camera2.translate(5f, 0f);
                camOnBorder = false
            }
            if (Gdx.input.getX() < 20 && (screen.camera.position.x-screen.camera.viewportWidth/2) > 0 ) {
                screen.camera.translate(-5f, 0f);
                screen.camera2.translate(-5f, 0f);
               /* if( screen.camera.position.x > 0 && !camOnBorder) {
                    screen.camera.translate(-5f, 0f);
                    screen.camera2.translate(-5f, 0f);
                }
                else{
                camOnBorder = true
                    if(Gdx.input.y > 280/2){
                        screen.camera.translate(5f, 5f);
                        screen.camera2.translate(5f, -5f)
                    }
                    else{
                        screen.camera.translate(5f, -5f);
                        screen.camera2.translate(5f, 5f)
                    }
                }*/
            }
            if (Gdx.input.y > Gdx.graphics.height - 20  && (screen.camera.position.y+screen.camera.viewportHeight/2) < screen.worldHeight) {
                screen.camera.translate(0f, 5f);
                screen.camera2.translate(0f, -5f);
            }
            if (Gdx.input.y < 20 && (screen.camera.position.y-screen.camera.viewportHeight/2) > 0) {
                screen.camera.translate(0f, -5f);
                screen.camera2.translate(0f, 5f);
            }
        }else{
            camOnBorder = false
        }

    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        super.touchDown(screenX, screenY, pointer, button)
       // screen.stage.touchDown(screenX, screenY, pointer, button)
        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        println("test")
        if (keycode == Input.Keys.LEFT) {
            screen.camera.translate(-32f, 0f)
            screen.camera2.translate(-32f, 0f)
        }
        if (keycode == Input.Keys.RIGHT) {
            screen.camera.translate(32f, 0f)
            screen.camera2.translate(32f, 0f)
        }
        if (keycode == Input.Keys.UP) {
            screen.camera.translate(0f, -32f)
            screen.camera2.translate(0f, 32f)
        }
        if (keycode == Input.Keys.DOWN) {
            screen.camera.translate(0f, 32f)
            screen.camera2.translate(0f, -32f)
        }

        return true

    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        super.touchDragged(screenX, screenY, pointer)



        return true
    }


}