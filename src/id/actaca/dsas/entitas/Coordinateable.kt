package id.actaca.dsas.entitas

interface Coordinateable {
	var x:Float
	var y:Float


	var   xprevious:Float
	var   xstart:Float

	var   yprevious:Float
	var   ystart:Float
	var   direction:Float
	var   friction:Float
	var   gravity:Float
	var   gravity_direction:Float
	var   hspeed:Float
	var   vspeed:Float
	var   speed:Float

    fun setPos(x:Float,y:Float){
        this.x=x
        this.y=y
    }
}