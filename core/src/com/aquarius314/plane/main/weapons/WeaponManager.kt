package com.aquarius314.plane.main.weapons

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.MeasurableProperty
import com.aquarius314.engine.logic.Missile
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.player.Plane

class WeaponManager constructor(var plane: Plane) : Active {

    val missiles = arrayListOf<Missile>()

    private val maxAmmunition = 20f
    var ammunition = MeasurableProperty(0f, maxAmmunition, maxAmmunition)

    private val maxRockets = 6f
    var rockets = MeasurableProperty(0f, maxRockets, 2f)

    fun display(renderer: Renderer) {
        missiles.forEach { m -> m.display(renderer) }
    }

    override fun actions(game: GdxGame) {
        missiles.forEach { m -> m.move() }
        removeOldMissiles()
    }

    private fun removeOldMissiles() {
        val oldMissiles = missiles.filter { m -> !m.isVisible() }
        missiles.removeAll(oldMissiles)
    }

    fun addBullet() : Boolean {
        if (ammunition.value > 0) {
            missiles.add(Bullet(plane.x, plane.y, plane.rotation))
            ammunition.value--
            return true
        }
        return false
    }

}