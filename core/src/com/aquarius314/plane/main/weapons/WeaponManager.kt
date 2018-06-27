package com.aquarius314.plane.main.weapons

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.MeasurableProperty
import com.aquarius314.engine.logic.Missile
import com.aquarius314.engine.ui.UIFragment
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.player.Plane
import com.badlogic.gdx.Gdx

class WeaponManager constructor(var plane: Plane) : UIFragment {

    val missiles = arrayListOf<Missile>()

    private val maxAmmunition = 20f
    var ammunition = MeasurableProperty(0f, maxAmmunition, maxAmmunition)

    private val maxRockets = 6f
    var rockets = MeasurableProperty(0f, maxRockets, 2f)

    override fun display(renderer: Renderer) {
        missiles.forEach { m -> m.display(renderer) }
        displayWeaponBar(renderer)
    }

    override fun actions(game: GdxGame) {
        missiles.forEach { m -> m.move() }
        removeOldMissiles()
    }

    private fun displayWeaponBar(renderer: Renderer) {
        val scaling = 1 / Renderer.scaling
        val distance = 100 * scaling
        renderer.image("uibullets.png", distance / 2f, Gdx.graphics.height - distance * 0.5f)
        renderer.image("uirocket.png", distance / 2f, Gdx.graphics.height - distance * 1.5f)
        renderer.text(ammunition.toString(), distance, Gdx.graphics.height - distance * 0.3f)
        renderer.text(rockets.toString(), distance, Gdx.graphics.height - distance * 1.3f)
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