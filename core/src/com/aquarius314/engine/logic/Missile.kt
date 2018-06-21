package com.aquarius314.plane.main.weapons

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Movable

class Bullet constructor(x: Float, y: Float, var rotation: Float): Movable(x, y) {

    override var xSpeed: Float = 0f
    override var ySpeed: Float = 0f

    init {
        xSpeed = 0f
        ySpeed = 0f
    }

    override fun display(renderer: Renderer) {
        renderer.image("bullet.png", x, y, rotation = rotation)
    }

}
