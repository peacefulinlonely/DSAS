package id.actaca.dsas

class Foo{
	
}
fun test(){
	var g= Goo()
	var y= Yaa(g)
	with(y){
		y.doinThing();
	}
}
var yo=12
open class Goo(i:Int): Boo {
	constructor():this(12){
		
	}
}

interface Boo{
	fun doinThing(){
		print("yeah")
	}
}
class Yaa(b: Boo): Boo by b

fun main(args:Array<String>){
	print("love")
	fun Yaa.ye(){
		print("aba")
	}
	Yaa(Goo()).ye()
	var y=1
	print(if(y == 12)13 else 12)
	var x:Int?=null
	if(x!=null)
	print(x jo  3)
	x?.jo(2);
	
	println(when(x){in 2..4->12	 else -> 21})
	println(x?.plus(2))
	print(when{
		y>12 ->print("none")
		y<12->print("half")else->null
	})
	
}
infix fun Int.jo(a:Int?){
	
}
