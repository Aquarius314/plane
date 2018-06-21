package com.aquarius314.plane.main.player

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.MeasurableProperty
import com.aquarius314.engine.logic.Movable
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.effects.SmokeManager

class Plane constructor(x: Float, y: Float) : Movable(x, y), Active {

    val frozen = true

    override var xSpeed = MeasurableProperty(0f, 0f)
    override var ySpeed = MeasurableProperty(-10f, 10f, 0f)
    val smokeManager = SmokeManager(this)

    override fun display(renderer: Renderer) {
        smokeManager.display(renderer)
        val rotation = ySpeed.value * 10f
        renderer.image("plane.png", x, y, rotation = rotation)
    }

    override fun actions(game: GdxGame) {
        if (!frozen) {
            ySpeed.value -= 0.1f
            move(0f, ySpeed.value)
        }
        smokeManager.actions(game)
    }

    fun jump(game: GdxGame) {
        ySpeed.value = 4f
        game.soundManager!!.playSound("fly.mp3", 1.5f)
    }

}