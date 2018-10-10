package id.actaca.dsas.jagoan

import id.actaca.dsas.entitas.Coordinateable
import id.actaca.dsas.entitas.Entity
import id.actaca.dsas.item.PickableItem

class Jagoan : Entity() {
	override var x=0f
	override var y=0f
    var health = 100
    var item: ArrayList<PickableItem> = arrayListOf()
    init{
       // Array(30,{_})
    }
	fun doActionWithItem(){
		
	}



}

