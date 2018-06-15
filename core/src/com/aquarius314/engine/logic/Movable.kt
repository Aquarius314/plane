package com.aquarius314.engine.logic

import com.aquarius314.engine.logic.GameObject
import com.aquarius314.engine.logic.MeasurableProperty

abstract class Movable constructor(x: Float = 0f, y: Float = 0f) : GameObject(x, y) {

    protected open val maxSpeed = 4f

    var xSpeed = MeasurableProperty(-maxSpeed, maxSpeed, 0f)
    var ySpeed = MeasurableProperty(-maxSpeed, maxSpeed, 0f)

    open fun move(x: Float, y: Float) {
        this.x += x
        this.y += y
    }

    fun moveTo(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

}