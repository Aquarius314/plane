package com.aquarius314.plane.main.weapons

import com.aquarius314.engine.graphics.Displayable
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.Missile
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.player.Plane

class WeaponManager constructor(var plane: Plane) : Displayable, Active {

    val missiles = arrayListOf<Missile>()

    override fun display(renderer: Renderer) {
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

    fun addBullet() {
        missiles.add(Bullet(plane.x, plane.y, plane.rotation))
    }

}