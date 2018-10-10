package id.actaca.dsas.renderer

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import id.actaca.dsas.entitas.Coordinateable
import id.actaca.dsas.entitas.Entity
import id.actaca.dsas.entitas.Renderable

interface BaseEntityRenderer {

	fun render(renderable:Renderable,batch:Batch,x:Float,y:Float)

}

 class EntityRendererImpl(): BaseEntityRenderer {
	 override fun render(renderable:Renderable,batch:Batch,x:Float,y:Float){
		 batch.draw(renderable.sprite_index ,x,y)
	 }
}
class EntityRendererActor(var actor: Actor):BaseEntityRenderer{

	override fun render(renderable: Renderable, batch: Batch, x: Float, y: Float) {
		actor.draw(batch,1f)
	}
}