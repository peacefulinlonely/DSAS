package id.actaca.dsas.map

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer
import id.actaca.dsas.game.Assets

class Map() {
    var map1Renderer:IsometricTiledMapRenderer = IsometricTiledMapRenderer(Assets.instance.loadMap("hogra.tmx"))
    fun render(){
        map1Renderer.render()


    }
}