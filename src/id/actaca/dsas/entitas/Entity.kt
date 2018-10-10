package id.actaca.dsas.entitas

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.Actor
import id.actaca.dsas.renderer.BaseEntityRenderer
import id.actaca.dsas.renderer.EntityRendererImpl
open class Entity : Coordinateable , Renderable, Graphable {
    var   id:Long = 100
    var   depth:Int = 0
    var   alarm:Int = 0
    var   visible:Boolean = true
    var   persistent:Boolean = false
    var   object_index:Int = 1

    override var x:Float = 0f
    override var y:Float = 0f


    override var   xprevious:Float = 0f
    override var   xstart:Float = 0f

    override var   yprevious:Float = 0f
    override var   ystart:Float = 0f
    override var   direction:Float= 0f
    override var   friction:Float = 0f
    override var   gravity:Float = 0f
    override var   gravity_direction:Float = 0f
    override var   hspeed:Float = 0f
    override var   vspeed:Float = 0f
    override var   speed:Float = 0f
    
    override   var   image_alpha:Int = 0
    override   var   image_angle:Int = 0
    override   var   image_blend:Int = 0
    override   var   image_index:Int = 0
    override   var   image_number:Int = 0
    override   var   image_single:Int = 0
    override   var   image_speed:Int = 0
    override   var   image_xscale:Int = 0
    override   var   image_yscale:Int = 0
    override   var   mask_index:Int = 0
    
    override   var   sprite_height:Int = 0
    override   var   sprite_index:TextureAtlas.AtlasRegion = TextureAtlas.AtlasRegion(Texture("noimg.png"),0,0,16,16)
    override   var   sprite_width:Int = 0
    override   var   sprite_xoffset:Int = 0
    override   var   sprite_yoffset:Int = 0

    override var renderer: BaseEntityRenderer= EntityRendererImpl()

    override var actor:Actor = object:Actor(){
        init{
            setBounds(x, y, sprite_index.regionX.toFloat(), sprite_index.regionY.toFloat())
        }
        override fun draw(batch: Batch?, parentAlpha: Float) {
            super.draw(batch, parentAlpha)
            batch?.draw(sprite_index,x,y)
        }

        override fun setX(x:Float){
            this@Entity.x = x

        }

        override fun getX(): Float {
            return this@Entity.x
        }
        override fun setY(y:Float){
            this@Entity.y = y

        }

        override fun getY(): Float {
            return this@Entity.y
        }

       /* override fun setBounds(x: Float, y: Float, width: Float, height: Float) {
            super.setBounds(x, y, sprite_index.width.toFloat(), sprite_index.height.toFloat())
        }*/
    }

    override fun render(batch: Batch) {
        renderer.render(this,batch, x, y)
    }

}