package com.aquarius314.engine.logic

abstract class Movable constructor(x: Float = 0f, y: Float = 0f) : GameObject(x, y) {

    abstract var xSpeed: Float
    abstract var ySpeed: Float

    open fun move(x: Float, y: Float) {
        this.x += x
        this.y += y
    }

    fun move() {
        this.x += xSpeed
        this.y += ySpeed
    }

    fun moveTo(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

}