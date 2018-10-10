package id.actaca.dsas.entitas

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import id.actaca.dsas.renderer.BaseEntityRenderer

interface Renderable {
    var   image_alpha:Int
    var   image_angle:Int
    var   image_blend:Int
    var   image_index:Int
    var   image_number:Int
    var   image_single:Int
    var   image_speed:Int
    var   image_xscale:Int
    var   image_yscale:Int
    var   mask_index:Int

    var   sprite_height:Int
    var   sprite_index:TextureAtlas.AtlasRegion
    var   sprite_width:Int
    var   sprite_xoffset:Int
    var   sprite_yoffset:Int

    var renderer:BaseEntityRenderer
    fun render(batch:Batch)

}