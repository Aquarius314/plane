package com.aquarius314.engine.graphics

import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.Movable
import com.aquarius314.plane.main.GdxGame

abstract class Decoration(x: Float, y: Float, var imageFileName: String) : Movable(x, y), Active {

    override fun display(renderer: Renderer) {
        renderer.image(imageFileName, x, y)
    }

    override fun actions(game: GdxGame) {
        move(-xSpeed.value, 0f)
    }

    fun isVisible() : Boolean = x + 500 > 0

}