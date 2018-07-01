package com.aquarius314.plane.main.effects

/** covered */
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.Movable
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.elements.Smoke
import java.util.*

class SmokeManager constructor(var parent: Movable) : Active {

    private var smokeCounter = 0
    val smokesPeriod = 5
    val smokes = arrayListOf<Smoke>()
    val maxNumberOfSmokes = 10
    val delta = 20

    fun display(renderer: Renderer) {
        smokes.forEach { s -> s.display(renderer) }
    }

    override fun actions(game: GdxGame) {
        addSmoke()
        smokes.forEach { s -> s.actions(game) }
    }

    private fun addSmoke() {
        smokeCounter++
        if (smokeCounter == smokesPeriod) {
            smokeCounter = 0
            smokes.add(Smoke(parent.x - delta, parent.y, Math.abs(Random().nextInt()%4)))
            if (smokes.size > maxNumberOfSmokes) {
                smokes.removeAt(0)
            }
        }
    }

}
