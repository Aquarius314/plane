package com.aquarius314.plane.main.player

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.MeasurableProperty
import com.aquarius314.engine.logic.Movable
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.effects.SmokeManager
import com.aquarius314.plane.main.weapons.WeaponManager

class Plane constructor(x: Float, y: Float) : Movable(x, y), Active {

    var frozen = true
    var game: GdxGame? = null

    override var xSpeed = 0f
    override var ySpeed = 0.1f
    private var maxHealth = 100f
    var points = 0
    var health = MeasurableProperty(0f, maxHealth, maxHealth)
    var gravity = MeasurableProperty(-8f, 8f, 0f)
    val smokeManager = SmokeManager(this)
    val weaponManager = WeaponManager(this)
    var rotation: Float = gravity.value * 10f
        get() = gravity.value * 10f

    override fun display(renderer: Renderer) {
        smokeManager.display(renderer)
        weaponManager.display(renderer)
        renderer.image("plane.png", x, y, rotation = rotation)
    }

    override fun actions(game: GdxGame) {
        if (!frozen) {
            gravity.value -= 0.1f
            move(0f, gravity.value)
        }
        smokeManager.actions(game)
        weaponManager.actions(game)
    }

    fun jump() {
        gravity.value = 4f
        game!!.soundManager.playSound("fly.mp3", 1.5f)
    }

    fun shoot() {
        if (weaponManager.addBullet()) {
            game!!.soundManager.playSound("shoot.mp3")
        }
    }

    fun releaseRocket() {
        // TODO
        game!!.soundManager.playSound("shoot.mp3")
        game!!.soundManager.playSound("rocket.mp3", 1.5f)
    }

}