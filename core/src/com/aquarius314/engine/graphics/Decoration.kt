package com.aquarius314.engine.graphics

import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.GameObject
import com.aquarius314.plane.main.GdxGame

abstract class Decoration(x: Float, y: Float, var imageFileName: String) : GameObject(x, y), Active {

    abstract val speed: Int

    override fun display(renderer: Renderer) {
        renderer.image(imageFileName, x, y)
    }

    override fun actions(game: GdxGame) {
        move()
    }

    fun isVisible() : Boolean = x + 500 < 0

    fun move() {
        x -= speed
    }

}