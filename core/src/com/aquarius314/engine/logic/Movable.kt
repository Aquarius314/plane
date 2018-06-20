package com.aquarius314.engine.logic

abstract class Movable constructor(x: Float = 0f, y: Float = 0f) : GameObject(x, y) {

    abstract var xSpeed: MeasurableProperty
    abstract var ySpeed: MeasurableProperty

    open fun move(x: Float, y: Float) {
        this.x += x
        this.y += y
    }

    fun moveTo(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

}