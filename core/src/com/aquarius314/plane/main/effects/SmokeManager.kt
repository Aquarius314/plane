package com.aquarius314.plane.main.effects

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.Movable
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.elements.Smoke
import java.util.*

class SmokeManager constructor(var parent: Movable) : Active {

    private val smoke = arrayListOf<Smoke>()
    private var smokeCounter = 0

    fun display(renderer: Renderer) {
        smoke.forEach { s -> s.display(renderer) }
    }

    override fun actions(game: GdxGame) {
        addSmoke()
        smoke.forEach { s -> s.actions(game) }
    }

    private fun addSmoke() {
        smokeCounter++
        if (smokeCounter == 5) {
            smokeCounter = 0
            smoke.add(Smoke(parent.x - 20, parent.y, Math.abs(Random().nextInt()%4)))
            if (smoke.size > 10) {
                smoke.removeAt(0)
            }
        }
    }

}
