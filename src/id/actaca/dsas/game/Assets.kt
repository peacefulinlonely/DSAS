package id.actaca.dsas.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetErrorListener
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.utils.Disposable
import id.actaca.dsas.Constants
import com.badlogic.gdx.maps.tiled.TmxMapLoader



class Assets private constructor (): Disposable, AssetErrorListener {
    companion object {
        val  TAG:String = this::class.java.name
        public val  instance:Assets = Assets()
    }

    private  var assetManager:AssetManager?=null
    var lastMapLoaded:TiledMap?=null

    var ball:Ball? = null
// singleton: prevent instantiation from other classes

    fun init ( assetManager:AssetManager) {
        this.assetManager = assetManager;
// set asset manager error handler
        assetManager.setErrorListener(this);
// load texture atlas
        assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS,TextureAtlas::class.java);
        assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS2,TextureAtlas::class.java);
// start loading assets and wait until finished
        assetManager.finishLoading();
        Gdx.app.debug(TAG, "# of assets loaded: "
                + assetManager.getAssetNames().size);
        for ( a:String in assetManager.getAssetNames())
        Gdx.app.debug(TAG, "asset: " + a);
        var atlas:TextureAtlas =   assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);
        var atlas2:TextureAtlas =   assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS2);
// enable texture filtering for pixel smoothing
        for ( t:Texture in atlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        for ( t:Texture in atlas2.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }


   ;
        ball = Ball(atlas.findRegion("Sprites/Tutorial1/strawberry"))
    }
    override fun dispose () {
        assetManager?.dispose()
    }
    fun error ( filename:String,  type:Class<Any>, throwable:Throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '"
                + filename + "'", if (throwable is Exception) throwable else null);
    }
    fun loadMap(name:String):TiledMap?{
        val parameters = TmxMapLoader.Parameters()
        parameters.flipY = true

        lastMapLoaded = TmxMapLoader()?.load(name, parameters)
        return lastMapLoaded
    }
    fun findTexture(str:String):TextureAtlas.AtlasRegion{
        var atlas:TextureAtlas =   assetManager!!.get(Constants.TEXTURE_ATLAS_OBJECTS2)
        var r=atlas.findRegion(str)
        if(!r.isFlipY)
        r.flip(false,true)
        return r
    }
    fun getBackground(str:String):Texture{
        return Texture(str)
    }
    override fun error( asset:AssetDescriptor<Any>,  throwable:Throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" +
                asset.fileName + "'", if (throwable is Exception) throwable else null);
    }

    class Ball(var tex:TextureRegion){
        init{
            tex.flip(false,true)
        }
    }
}