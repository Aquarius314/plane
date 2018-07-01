package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Movable
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.player.Plane

class Bonus constructor(x: Float, y: Float) : Movable(x, y) {

    override var xSpeed = -2.5f
    override var ySpeed = -0.5f

    private var isCollected = false
    private val type : BonusType = BonusType.random()

    override fun display(renderer: Renderer) {
        renderer.image(type.image, x, y)
    }

    override fun isExpired(): Boolean {
        return super.isExpired() || isCollected
    }

    override fun isVisible(): Boolean {
        return super.isVisible() && y + 200 > 0
    }

    override fun actions(game: GdxGame) {
        move()
        detectCollisions(game.plane)
    }

    private fun detectCollisions(plane: Plane) {
        if (plane.collidesWith(this, radiusScale = 1 / Renderer.scaling)) {
            isCollected = true
            type.affectPlayer(plane)
        }
    }

}
