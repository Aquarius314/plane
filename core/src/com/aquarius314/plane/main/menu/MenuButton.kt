package com.aquarius314.plane.main.menu

import com.aquarius314.engine.application.GameScreen
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.ui.RectangularButton
import com.badlogic.gdx.graphics.Color

abstract class MenuButton constructor(
        x: Float, y: Float, width: Float, height: Float, var text: String, var parent: GameScreen
) : RectangularButton(x, y, width, height, "") {

    override fun display(renderer: Renderer) {
        renderer.frame(x, y, width, height, 10f, Color.GRAY, Color.LIGHT_GRAY)
        renderer.text(text, x, x + width, y, y + height)
    }

    override fun playClickSound() {
        parent.soundManager.playSound("click.mp3")
    }
}