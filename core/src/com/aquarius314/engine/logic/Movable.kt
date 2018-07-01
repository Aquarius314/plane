package com.aquarius314.engine.logic

import com.aquarius314.plane.main.GdxGame

abstract class Movable constructor(x: Float = 0f, y: Float = 0f) : GameObject(x, y), ActiveFragment {

    abstract var xSpeed: Float
    abstract var ySpeed: Float

    override fun actions(game: GdxGame) {
        move()
    }

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

    override fun isExpired() : Boolean = !isVisible()

    open fun isVisible(): Boolean = x + 500 > 0

}