package com.aquarius314.engine.logic

import com.badlogic.gdx.Gdx

abstract class Missile constructor(x: Float, y: Float, var rotation: Float): Movable(x, y) {

     var unitSpeed = 20f
     override var xSpeed = (Math.cos(Math.toRadians(rotation.toDouble())) * unitSpeed).toFloat()
     override var ySpeed = (Math.sin(Math.toRadians(rotation.toDouble())) * unitSpeed).toFloat()

     fun isVisible(): Boolean = x + 100 > 0 && x - 100 < Gdx.graphics.width
 }
