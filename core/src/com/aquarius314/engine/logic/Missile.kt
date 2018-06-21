package com.aquarius314.engine.logic

 abstract class Missile constructor(x: Float, y: Float, var rotation: Float): Movable(x, y) {

     var unitSpeed = 10f
     override var xSpeed = (Math.cos(Math.toRadians(rotation.toDouble())) * unitSpeed).toFloat()
     override var ySpeed = (Math.sin(Math.toRadians(rotation.toDouble())) * unitSpeed).toFloat()

}
