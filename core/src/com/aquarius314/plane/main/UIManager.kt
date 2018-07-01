package com.aquarius314.plane.main

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.ui.RoundButton
import com.aquarius314.engine.ui.UIFragment
import com.badlogic.gdx.Gdx

class UIManager constructor(var game: GdxGame) : UIFragment {
    val buttons = arrayListOf<RoundButton>()

    init {
        val radius = 50f
        val distance = 20f
        val right = Gdx.graphics.width
        val up = Gdx.graphics.height
        buttons.addAll(listOf(
            object : RoundButton(radius + distance, radius + distance, radius, "buttonfly.png") {
                override fun onClick(x: Float, y: Float) {
                    game.plane.jump()
                }
            },
            object : RoundButton(right - radius - distance, radius + distance, radius, "buttonshoot.png") {
                override fun onClick(x: Float, y: Float) {
                    game.plane.shoot()
                }
            },
            object : RoundButton(right - radius*3 - distance*2, radius + distance, radius, "buttonrocket.png") {
                override fun onClick(x: Float, y: Float) {
                    game.plane.releaseRocket()
                }
            },
            object : RoundButton(right - radius - distance, up - radius - distance, radius, "buttonmenu.png") {
                override fun onClick(x: Float, y: Float) {
                    game.openMenu()
                }
            }
        ))
    }

    override fun display(renderer: Renderer) {
        buttons.forEach { b -> b.display(renderer) }
    }

    fun anyButtonClicked(x: Float, y: Float) : Boolean {
        var anyButtonClicked = false
        for (b in buttons) {
            anyButtonClicked = anyButtonClicked || b.checkClick(x, y)
        }
        return anyButtonClicked
    }

    override fun actions(game: GdxGame) {}

}
