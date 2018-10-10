package id.actaca.dsas.game

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import id.actaca.dsas.entitas.Entity

class CameraHelper {
    private val  TAG:String = CameraHelper::class.java.name;
    private val  MAX_ZOOM_IN:Float = 0.25f;
    private val  MAX_ZOOM_OUT:Float = 10.0f;
    private var position:Vector2=Vector2();
    private var zoom:Float = 0f

    private var target:Entity?=null;
    constructor()  {
        position = Vector2()
        zoom = 1.0f;
    }
    fun  update ( deltaTime:Float) {
        if (target != null) {
            position.x = target!!.x//?.plus( target!!.originX)
            position.y = target!!.y//?.plus( target!!.originY)
        }
    }
    fun  setPosition ( x:Float,  y:Float) {
        this.position.set(x, y);
    }
    fun  getPosition ():Vector2 { return position; }
    fun addZoom ( amount:Float) { setZoom(zoom + amount); }
    fun  setZoom ( zoom:Float):Unit {
        this.zoom = MathUtils.clamp(zoom, MAX_ZOOM_IN, MAX_ZOOM_OUT);
    }
    fun getZoom ():Float { return zoom; }

    fun setTarget ( target:Entity) { this.target = target; }

    fun  getTarget ():Entity { return target?:Entity(); }

    fun  hasTarget ():Boolean { return target != null; }

    fun  hasTarget ( target:Sprite):Boolean {
        return hasTarget() && this.target?.equals(target)?:false;
    }
    fun applyTo ( camera:OrthographicCamera) {
        camera.position.x = position.x;
        camera.position.y = position.y;
        camera.zoom = zoom;
        camera.update();
    }
}
