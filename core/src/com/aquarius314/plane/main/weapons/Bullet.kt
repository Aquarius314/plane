package com.aquarius314.plane.main.weapons

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Missile

class Bullet constructor(x: Float, y: Float, rotation: Float) : Missile(x, y, rotation) {

    override var colliderR = 15f

    override fun display(renderer: Renderer) {
        renderer.image("bulletsmoke.png", x, y, rotation = rotation)
        renderer.image("bullet.png", x, y, rotation = rotation)
    }

}