package com.aquarius314.plane.main.weapons

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Missile

class Bullet constructor(x: Float, y: Float, rotation: Float) : Missile(x, y, rotation) {

    val scaleRate = 0.5f
    override var colliderR = 15f

    override fun display(renderer: Renderer) {
        renderer.scaledImage("bulletsmoke.png", x, y, scaleRate = scaleRate, rotation = rotation)
        renderer.scaledImage("bullet.png", x, y, scaleRate = scaleRate, rotation = rotation)
    }

}