package com.aquarius314.plane.main.player

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.GameObject
import com.aquarius314.engine.logic.MeasurableProperty
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.elements.Smoke
import java.util.*

class Plane constructor(x: Float, y: Float) : GameObject(x, y), Active {

    val ySpeed = MeasurableProperty(-10f, 4f, 0f)
    val smoke = arrayListOf<Smoke>()
    var smokeCounter = 0

    override fun display(renderer: Renderer) {
        smoke.forEach { s -> s.display(renderer) }
        val rotation = ySpeed.value * 10f
        renderer.image("plane.png", x, y, rotation)
    }

    override fun actions(game: GdxGame) {
        ySpeed.value -= 0.1f
        y += ySpeed.value
        addSmoke()
        smoke.forEach { s -> s.actions(game) }
    }

    private fun addSmoke() {
        smokeCounter++
        if (smokeCounter == 5) {
            smokeCounter = 0
            smoke.add(Smoke(x, y, Math.abs(Random().nextInt()%4)))
            if (smoke.size > 10) {
                smoke.removeAt(0)
            }
        }
    }

    fun jump(game: GdxGame) {
        ySpeed.value = 4f
        game.soundManager!!.playSound("fly.mp3", 1.5f)
    }

}