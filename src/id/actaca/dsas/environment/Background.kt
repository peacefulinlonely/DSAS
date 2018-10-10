package id.actaca.dsas.environment

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import id.actaca.dsas.game.Assets

class Background {
    var image:Texture= Assets.instance.getBackground("background1.png")
    fun render(batch: Batch){
        batch.draw(image,0f,0f)
    }
}